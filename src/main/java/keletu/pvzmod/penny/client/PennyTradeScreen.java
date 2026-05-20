package keletu.pvzmod.penny.client;

import com.mojang.math.Axis;
import keletu.pvzmod.PVZMod;
import keletu.pvzmod.init.PVZItems;
import keletu.pvzmod.network.BuyPennyTradePacket;
import keletu.pvzmod.network.PVZNetworking;
import keletu.pvzmod.network.RefreshPennyTradesPacket;
import keletu.pvzmod.penny.PennyTradeMenu;
import keletu.pvzmod.penny.PennyTradeOffer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PennyTradeScreen extends AbstractContainerScreen<PennyTradeMenu> {
    private static final ResourceLocation BACKGROUND = new ResourceLocation(PVZMod.MODID, "textures/gui/penny_trade.png");
    private static final int TEXTURE_WIDTH = 240;
    private static final int TEXTURE_HEIGHT = 240;
    private static final int GUI_WIDTH = 240;
    private static final int GUI_HEIGHT = 240;
    private static final int OFFER_SIZE = 24;
    private static final int REFRESH_BUTTON_X = 188;
    private static final int REFRESH_BUTTON_Y = 126;
    private static final int REFRESH_BUTTON_WIDTH = 42;
    private static final int REFRESH_BUTTON_HEIGHT = 18;
    private static final int BUY_ANIMATION_TICKS = 18;
    private static final int PRESS_ANIMATION_TICKS = 5;
    private static final int DENIED_SHAKE_TICKS = 12;
    private static final int REFRESH_ANIMATION_TICKS = 16;
    private static final int REFRESH_WAIT_TICKS = 60;

    private static final int[][] OFFER_CENTERS = {
            {76, 60},
            {110, 60},
            {144, 60},
            {66, 121},
            {110, 121},
            {154, 121}
    };

    private Button refreshButton;
    private int screenTicks;
    private int refreshTicks = REFRESH_ANIMATION_TICKS;
    private int refreshWaitTicks;
    private final int[] pressTicks = new int[OFFER_CENTERS.length];
    private final int[] deniedTicks = new int[OFFER_CENTERS.length];
    private final List<FlyingItem> flyingItems = new ArrayList<>();
    private List<PennyTradeOffer> refreshOldOffers = List.of();
    private List<PennyTradeOffer> refreshNewOffers = List.of();

    public PennyTradeScreen(PennyTradeMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.imageWidth = GUI_WIDTH;
        this.imageHeight = GUI_HEIGHT;
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
    }

    @Override
    protected void init() {
        super.init();
        this.refreshButton = this.addRenderableWidget(Button.builder(
                        Component.translatable("gui.pvz_myh.penny.refresh"),
                        button -> requestRefresh())
                .bounds(this.leftPos + REFRESH_BUTTON_X, this.topPos + REFRESH_BUTTON_Y, REFRESH_BUTTON_WIDTH, REFRESH_BUTTON_HEIGHT)
                .build());
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);
        super.render(graphics, mouseX, mouseY, partialTick);
        renderOffers(graphics, mouseX, mouseY, partialTick);
        renderFlyingItems(graphics, partialTick);
        renderOfferTooltip(graphics, mouseX, mouseY);
        renderRefreshTooltip(graphics, mouseX, mouseY);
        this.renderTooltip(graphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float partialTick, int mouseX, int mouseY) {
        graphics.blit(BACKGROUND, this.leftPos, this.topPos, 0.0F, 0.0F,
                GUI_WIDTH, GUI_HEIGHT, TEXTURE_WIDTH, TEXTURE_HEIGHT);
    }

    @Override
    protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            int hovered = hoveredOffer(mouseX, mouseY);
            if (hovered >= 0 && !isRefreshing()) {
                List<PennyTradeOffer> offers = this.menu.getOffers();
                if (hovered >= offers.size()) {
                    return true;
                }
                PennyTradeOffer offer = offers.get(hovered);
                if (offer.stack().isEmpty()) {
                    return true;
                }
                if (!canPay(offer.price())) {
                    this.deniedTicks[hovered] = DENIED_SHAKE_TICKS;
                    return true;
                }

                this.pressTicks[hovered] = PRESS_ANIMATION_TICKS;
                this.flyingItems.add(new FlyingItem(offer.stack().copy(), hovered, predictTargetPoint(offer.stack())));
                PVZNetworking.sendToServer(new BuyPennyTradePacket(hovered));
                return true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    protected void containerTick() {
        super.containerTick();
        this.screenTicks++;

        for (int i = 0; i < OFFER_CENTERS.length; i++) {
            if (this.pressTicks[i] > 0) {
                this.pressTicks[i]--;
            }
            if (this.deniedTicks[i] > 0) {
                this.deniedTicks[i]--;
            }
        }

        if (this.refreshTicks < REFRESH_ANIMATION_TICKS) {
            this.refreshTicks++;
            if (this.refreshTicks >= REFRESH_ANIMATION_TICKS) {
                this.refreshOldOffers = List.of();
                this.refreshNewOffers = List.of();
            }
        }

        if (this.refreshWaitTicks > 0) {
            this.refreshWaitTicks--;
            if (this.refreshWaitTicks == 0 && this.refreshButton != null) {
                this.refreshButton.active = true;
            }
        }

        Iterator<FlyingItem> iterator = this.flyingItems.iterator();
        while (iterator.hasNext()) {
            FlyingItem item = iterator.next();
            item.age++;
            if (item.age > BUY_ANIMATION_TICKS) {
                iterator.remove();
            }
        }
    }

    public void startRefreshAnimation(List<PennyTradeOffer> offers) {
        this.refreshOldOffers = copyOffers(this.menu.getOffers());
        this.refreshNewOffers = copyOffers(offers);
        this.menu.replaceOffers(offers);
        this.refreshTicks = 0;
        this.refreshWaitTicks = 0;
        if (this.refreshButton != null) {
            this.refreshButton.active = true;
        }
    }

    public void applyOfferUpdate(List<PennyTradeOffer> offers) {
        this.menu.replaceOffers(offers);
        this.refreshTicks = REFRESH_ANIMATION_TICKS;
        this.refreshOldOffers = List.of();
        this.refreshNewOffers = List.of();
        this.refreshWaitTicks = 0;
        if (this.refreshButton != null) {
            this.refreshButton.active = true;
        }
    }

    private void renderOffers(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        if (isRefreshing()) {
            renderRefreshOffers(graphics, partialTick);
            return;
        }

        List<PennyTradeOffer> offers = this.menu.getOffers();
        int hovered = hoveredOffer(mouseX, mouseY);
        for (int i = 0; i < offers.size() && i < OFFER_CENTERS.length; i++) {
            ItemStack stack = offers.get(i).stack();
            if (stack.isEmpty()) {
                continue;
            }
            renderShelfItem(graphics, stack, i, 0.0F, 0.0F, 1.0F, i == hovered, partialTick, 0.0F);
        }
    }

    private void renderRefreshOffers(GuiGraphics graphics, float partialTick) {
        float time = this.refreshTicks + partialTick;
        float oldPhase = Mth.clamp(time / 11.0F, 0.0F, 1.0F);
        float newPhaseBase = Mth.clamp((time - 7.0F) / 14.0F, 0.0F, 1.0F);

        for (int i = 0; i < this.refreshOldOffers.size() && i < OFFER_CENTERS.length; i++) {
            ItemStack stack = this.refreshOldOffers.get(i).stack();
            if (stack.isEmpty()) {
                continue;
            }
            float stagger = Mth.clamp((time - i * 0.65F) / 10.0F, 0.0F, 1.0F);
            float xOffset = (i % 2 == 0 ? -10.0F : 10.0F) * easeOut(stagger);
            float yOffset = 18.0F * easeOut(stagger);
            float scale = 1.0F - 0.52F * easeOut(oldPhase);
            float angle = (i % 2 == 0 ? -1.0F : 1.0F) * 24.0F * easeOut(stagger);
            renderShelfItem(graphics, stack, i, xOffset, yOffset, scale, false, partialTick, angle);
        }

        for (int i = 0; i < this.refreshNewOffers.size() && i < OFFER_CENTERS.length; i++) {
            ItemStack stack = this.refreshNewOffers.get(i).stack();
            if (stack.isEmpty()) {
                continue;
            }
            float stagger = Mth.clamp((newPhaseBase * 14.0F - i * 0.8F) / 10.0F, 0.0F, 1.0F);
            float eased = easeOutBack(stagger);
            float xOffset = (i % 2 == 0 ? 8.0F : -8.0F) * (1.0F - eased);
            float yOffset = -28.0F * (1.0F - eased);
            float scale = 0.65F + 0.35F * eased;
            float angle = (i % 2 == 0 ? 1.0F : -1.0F) * 12.0F * (1.0F - eased);
            renderShelfItem(graphics, stack, i, xOffset, yOffset, scale, false, partialTick, angle);
        }
    }

    private void renderShelfItem(GuiGraphics graphics, ItemStack stack, int index, float xOffset, float yOffset, float baseScale, boolean hovered, float partialTick, float extraAngle) {
        int centerX = this.leftPos + OFFER_CENTERS[index][0];
        int centerY = this.topPos + OFFER_CENTERS[index][1];
        float time = this.screenTicks + partialTick + index * 5.0F;
        float hoverLift = hovered ? -4.0F + Mth.sin(time * 0.32F) * 0.65F : 0.0F;
        float hoverSway = hovered ? Mth.sin(time * 0.45F) * 1.5F : 0.0F;
        float deniedShake = this.deniedTicks[index] > 0 ? Mth.sin((DENIED_SHAKE_TICKS - this.deniedTicks[index]) * 2.4F) * 2.5F : 0.0F;
        float press = this.pressTicks[index] / (float) PRESS_ANIMATION_TICKS;
        float pressDrop = press > 0.0F ? 2.0F * press : 0.0F;
        float scale = baseScale * (hovered ? 1.13F : 1.0F) * (1.0F - press * 0.05F);
        float angle = extraAngle + (hovered ? Mth.sin(time * 0.28F) * 5.0F : 0.0F);

        graphics.pose().pushPose();
        graphics.pose().translate(centerX + xOffset + hoverSway + deniedShake, centerY + yOffset + hoverLift + pressDrop, 260.0F);
        graphics.pose().mulPose(Axis.ZP.rotationDegrees(angle));
        graphics.pose().scale(scale, scale, 1.0F);
        graphics.renderItem(stack, -8, -8);
        graphics.renderItemDecorations(this.font, stack, -8, -8);
        graphics.pose().popPose();
    }

    private void renderFlyingItems(GuiGraphics graphics, float partialTick) {
        for (FlyingItem flyingItem : this.flyingItems) {
            if (flyingItem.offerIndex < 0 || flyingItem.offerIndex >= OFFER_CENTERS.length) {
                continue;
            }

            float progress = Mth.clamp((flyingItem.age + partialTick) / BUY_ANIMATION_TICKS, 0.0F, 1.0F);
            float eased = easeOut(progress);
            int startX = this.leftPos + OFFER_CENTERS[flyingItem.offerIndex][0];
            int startY = this.topPos + OFFER_CENTERS[flyingItem.offerIndex][1];
            float x = Mth.lerp(eased, startX, flyingItem.targetX);
            float y = Mth.lerp(eased, startY, flyingItem.targetY) - Mth.sin(progress * Mth.PI) * 18.0F;
            float scale = 1.12F - 0.32F * eased;

            graphics.pose().pushPose();
            graphics.pose().translate(x, y, 360.0F);
            graphics.pose().scale(scale, scale, 1.0F);
            graphics.renderItem(flyingItem.stack, -8, -8);
            graphics.renderItemDecorations(this.font, flyingItem.stack, -8, -8);
            graphics.pose().popPose();
        }
    }

    private void renderOfferTooltip(GuiGraphics graphics, int mouseX, int mouseY) {
        if (isRefreshing()) {
            return;
        }

        int index = hoveredOffer(mouseX, mouseY);
        if (index < 0 || index >= this.menu.getOffers().size()) {
            return;
        }

        PennyTradeOffer offer = this.menu.getOffers().get(index);
        List<Component> tooltip = new ArrayList<>();
        tooltip.add(offer.stack().getHoverName());
        tooltip.add(Component.translatable("tooltip.pvz_myh.penny.price", offer.price(), new ItemStack(PVZItems.DIAMOND.get()).getHoverName()));
        int tooltipX = offerTooltipX(index);
        int tooltipY = offerTooltipY(index);
        graphics.renderComponentTooltip(this.font, tooltip, tooltipX, tooltipY);
    }

    private void renderRefreshTooltip(GuiGraphics graphics, int mouseX, int mouseY) {
        if (this.refreshButton == null || !this.refreshButton.isMouseOver(mouseX, mouseY)) {
            return;
        }

        List<Component> tooltip = List.of(Component.translatable(
                "tooltip.pvz_myh.penny.refresh",
                PennyTradeMenu.REFRESH_PRICE,
                new ItemStack(PVZItems.DIAMOND.get()).getHoverName()
        ));
        graphics.renderComponentTooltip(this.font, tooltip, mouseX, mouseY);
    }

    private void requestRefresh() {
        if (isRefreshing() || this.refreshWaitTicks > 0) {
            return;
        }

        if (!canPay(PennyTradeMenu.REFRESH_PRICE)) {
            for (int i = 0; i < this.deniedTicks.length; i++) {
                this.deniedTicks[i] = DENIED_SHAKE_TICKS;
            }
            return;
        }

        this.refreshWaitTicks = REFRESH_WAIT_TICKS;
        if (this.refreshButton != null) {
            this.refreshButton.active = false;
        }
        PVZNetworking.sendToServer(new RefreshPennyTradesPacket());
    }

    private boolean canPay(int price) {
        if (this.minecraft == null || this.minecraft.player == null) {
            return false;
        }
        if (this.minecraft.player.getAbilities().instabuild) {
            return true;
        }

        int count = 0;
        Inventory inventory = this.minecraft.player.getInventory();
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack stack = inventory.getItem(i);
            if (stack.is(PVZItems.DIAMOND.get())) {
                count += stack.getCount();
                if (count >= price) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isRefreshing() {
        return this.refreshTicks < REFRESH_ANIMATION_TICKS;
    }

    private float easeOut(float progress) {
        float p = Mth.clamp(progress, 0.0F, 1.0F);
        return 1.0F - (1.0F - p) * (1.0F - p);
    }

    private float easeOutBack(float progress) {
        float p = Mth.clamp(progress, 0.0F, 1.0F) - 1.0F;
        float s = 1.70158F;
        return 1.0F + (s + 1.0F) * p * p * p + s * p * p;
    }

    private List<PennyTradeOffer> copyOffers(List<PennyTradeOffer> offers) {
        List<PennyTradeOffer> copy = new ArrayList<>();
        for (PennyTradeOffer offer : offers) {
            copy.add(new PennyTradeOffer(offer.stack(), offer.price()));
        }
        return copy;
    }

    private int hoveredOffer(double mouseX, double mouseY) {
        for (int i = 0; i < OFFER_CENTERS.length; i++) {
            if (i < this.menu.getOffers().size() && !this.menu.getOffers().get(i).stack().isEmpty() && isInOffer(mouseX, mouseY, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isInOffer(double mouseX, double mouseY, int index) {
        int centerX = this.leftPos + OFFER_CENTERS[index][0];
        int centerY = this.topPos + OFFER_CENTERS[index][1];
        return mouseX >= centerX - OFFER_SIZE / 2.0D
                && mouseX < centerX + OFFER_SIZE / 2.0D
                && mouseY >= centerY - OFFER_SIZE / 2.0D
                && mouseY < centerY + OFFER_SIZE / 2.0D;
    }

    private float[] predictTargetPoint(ItemStack stack) {
        if (this.minecraft == null || this.minecraft.player == null) {
            return fallbackTargetPoint();
        }

        Inventory inventory = this.minecraft.player.getInventory();
        int targetSlot = findTargetInventorySlot(inventory, stack);
        if (targetSlot == 40) {
            return fallbackTargetPoint();
        }
        if (targetSlot < 0) {
            targetSlot = inventory.getFreeSlot();
        }
        if (targetSlot < 0) {
            return fallbackTargetPoint();
        }

        return inventorySlotCenter(targetSlot);
    }

    private int findTargetInventorySlot(Inventory inventory, ItemStack stack) {
        int selected = inventory.selected;
        if (hasRemainingSpaceForItem(inventory.getItem(selected), stack)) {
            return selected;
        }
        if (hasRemainingSpaceForItem(inventory.getItem(40), stack)) {
            return 40;
        }
        for (int i = 0; i < 36; i++) {
            if (hasRemainingSpaceForItem(inventory.getItem(i), stack)) {
                return i;
            }
        }
        return inventory.getFreeSlot();
    }

    private boolean hasRemainingSpaceForItem(ItemStack existing, ItemStack incoming) {
        return !existing.isEmpty()
                && ItemStack.isSameItemSameTags(existing, incoming)
                && existing.isStackable()
                && existing.getCount() < existing.getMaxStackSize();
    }

    private float[] inventorySlotCenter(int inventorySlot) {
        if (inventorySlot >= 9 && inventorySlot < 36) {
            int relative = inventorySlot - 9;
            int row = relative / 9;
            int col = relative % 9;
            return new float[]{
                    this.leftPos + PennyTradeMenu.INVENTORY_X + col * 18 + 8,
                    this.topPos + PennyTradeMenu.INVENTORY_Y + row * 18 + 8
            };
        }
        if (inventorySlot >= 0 && inventorySlot < 9) {
            return new float[]{
                    this.leftPos + PennyTradeMenu.INVENTORY_X + inventorySlot * 18 + 8,
                    this.topPos + PennyTradeMenu.HOTBAR_Y + 8
            };
        }
        return fallbackTargetPoint();
    }

    private float[] fallbackTargetPoint() {
        return new float[]{
                this.leftPos + PennyTradeMenu.INVENTORY_X + 8,
                this.topPos + PennyTradeMenu.HOTBAR_Y + 8
        };
    }

    private int offerTooltipX(int index) {
        int centerX = this.leftPos + OFFER_CENTERS[index][0];
        if (centerX > this.leftPos + GUI_WIDTH / 2) {
            return Math.max(8, centerX - 132);
        }
        return Math.min(this.width - 100, centerX + 18);
    }

    private int offerTooltipY(int index) {
        int centerY = this.topPos + OFFER_CENTERS[index][1];
        if (index < 3) {
            return Math.min(this.height - 36, centerY + 18);
        }
        return Math.max(8, centerY - 34);
    }

    private static class FlyingItem {
        private final ItemStack stack;
        private final int offerIndex;
        private final float targetX;
        private final float targetY;
        private int age;

        private FlyingItem(ItemStack stack, int offerIndex, float[] target) {
            this.stack = stack;
            this.offerIndex = offerIndex;
            this.targetX = target[0];
            this.targetY = target[1];
        }
    }
}
