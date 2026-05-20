package keletu.pvzmod.penny;

import keletu.pvzmod.entities.dave.Penny;
import keletu.pvzmod.init.PVZItems;
import keletu.pvzmod.init.PVZMenus;
import keletu.pvzmod.init.PVZSounds;
import keletu.pvzmod.network.PVZNetworking;
import keletu.pvzmod.network.SyncPennyTradeOffersPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class PennyTradeMenu extends AbstractContainerMenu {
    public static final int INVENTORY_X = 28;
    public static final int INVENTORY_Y = 158;
    public static final int HOTBAR_Y = 216;
    public static final int REFRESH_PRICE = 2;

    private static final int MAX_INTERACTION_DISTANCE_SQR = 64;

    private final Penny penny;
    private final List<PennyTradeOffer> offers;
    private List<PennyTradeOffer> lastStockedOffers;

    public PennyTradeMenu(int containerId, Inventory playerInventory, FriendlyByteBuf data) {
        this(containerId, playerInventory, readPenny(playerInventory, data), PennyTradeOffer.decodeList(data));
    }

    public PennyTradeMenu(int containerId, Inventory playerInventory, Penny penny, List<PennyTradeOffer> offers) {
        super(PVZMenus.PENNY_TRADE.get(), containerId);
        this.penny = penny;
        this.offers = copyOffers(offers);
        this.lastStockedOffers = copyOffers(offers);
        addPlayerInventory(playerInventory);
    }

    public List<PennyTradeOffer> getOffers() {
        return this.offers;
    }

    public void replaceOffers(List<PennyTradeOffer> offers) {
        this.offers.clear();
        this.offers.addAll(copyOffers(offers));
    }

    private void restockOffers(List<PennyTradeOffer> offers) {
        replaceOffers(offers);
        this.lastStockedOffers = copyOffers(offers);
    }

    public boolean buy(ServerPlayer player, int index) {
        if (index < 0 || index >= this.offers.size()) {
            return false;
        }

        if (!canUse(player)) {
            return false;
        }

        PennyTradeOffer offer = this.offers.get(index);
        if (offer.stack().isEmpty()) {
            return false;
        }

        if (!player.getAbilities().instabuild && !consumeDiamond(player, offer.price())) {
            player.displayClientMessage(Component.translatable("message.pvz_myh.penny.not_enough_diamond", offer.price()), true);
            return false;
        }

        ItemStack result = offer.stack().copy();
        if (!player.getInventory().add(result)) {
            player.drop(result, false);
        }

        this.offers.set(index, new PennyTradeOffer(ItemStack.EMPTY, offer.price()));

        if (allOffersSold()) {
            restockOffers(PennyTradeOffers.roll(this.penny.getRandom(), this.lastStockedOffers));
            PVZNetworking.sendToPlayer(new SyncPennyTradeOffersPacket(this.offers, SyncPennyTradeOffersPacket.MODE_REFRESH), player);
        } else {
            PVZNetworking.sendToPlayer(new SyncPennyTradeOffersPacket(this.offers, SyncPennyTradeOffersPacket.MODE_REPLACE), player);
        }

        player.level().playSound(null, player.blockPosition(), PVZSounds.PENNY_SPEAK.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
        return true;
    }

    public boolean refresh(ServerPlayer player) {
        if (!canUse(player)) {
            return false;
        }

        if (!player.getAbilities().instabuild && !consumeDiamond(player, REFRESH_PRICE)) {
            player.displayClientMessage(Component.translatable("message.pvz_myh.penny.not_enough_diamond", REFRESH_PRICE), true);
            return false;
        }

        restockOffers(PennyTradeOffers.roll(this.penny.getRandom(), this.lastStockedOffers));
        PVZNetworking.sendToPlayer(new SyncPennyTradeOffersPacket(this.offers, SyncPennyTradeOffersPacket.MODE_REFRESH), player);
        player.level().playSound(null, player.blockPosition(), PVZSounds.PENNY_SPEAK.get(), SoundSource.PLAYERS, 0.85F, 1.12F);
        return true;
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack source = slot.getItem();
            result = source.copy();

            if (index < 27) {
                if (!this.moveItemStackTo(source, 27, 36, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(source, 0, 27, false)) {
                return ItemStack.EMPTY;
            }

            if (source.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return result;
    }

    @Override
    public boolean stillValid(Player player) {
        return this.penny == null || this.penny.isAlive() && player.distanceToSqr(this.penny) <= MAX_INTERACTION_DISTANCE_SQR;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        if (this.penny != null && this.penny.getTradingPlayer() == player) {
            this.penny.setTradingPlayer(null);
        }
    }

    private void addPlayerInventory(Inventory inventory) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(inventory, col + row * 9 + 9, INVENTORY_X + col * 18, INVENTORY_Y + row * 18));
            }
        }

        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(inventory, col, INVENTORY_X + col * 18, HOTBAR_Y));
        }
    }

    private static Penny readPenny(Inventory playerInventory, FriendlyByteBuf data) {
        int entityId = data.readVarInt();
        Entity entity = playerInventory.player.level().getEntity(entityId);
        return entity instanceof Penny penny ? penny : null;
    }

    private static List<PennyTradeOffer> copyOffers(List<PennyTradeOffer> offers) {
        List<PennyTradeOffer> copy = new ArrayList<>();
        for (PennyTradeOffer offer : offers) {
            copy.add(new PennyTradeOffer(offer.stack(), offer.price()));
        }
        return copy;
    }

    private boolean allOffersSold() {
        for (PennyTradeOffer offer : this.offers) {
            if (!offer.stack().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private boolean canUse(Player player) {
        return this.penny != null && this.penny.isAlive() && player.distanceToSqr(this.penny) <= MAX_INTERACTION_DISTANCE_SQR;
    }

    private static boolean consumeDiamond(Player player, int amount) {
        if (amount <= 0) {
            return true;
        }

        if (countDiamond(player) < amount) {
            return false;
        }

        int remaining = amount;
        Inventory inventory = player.getInventory();
        for (int i = 0; i < inventory.getContainerSize() && remaining > 0; i++) {
            ItemStack stack = inventory.getItem(i);
            if (!stack.is(PVZItems.DIAMOND.get())) {
                continue;
            }

            int consumed = Math.min(remaining, stack.getCount());
            stack.shrink(consumed);
            remaining -= consumed;
        }

        inventory.setChanged();
        return true;
    }

    private static int countDiamond(Player player) {
        int count = 0;
        Inventory inventory = player.getInventory();
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack stack = inventory.getItem(i);
            if (stack.is(PVZItems.DIAMOND.get())) {
                count += stack.getCount();
            }
        }
        return count;
    }
}
