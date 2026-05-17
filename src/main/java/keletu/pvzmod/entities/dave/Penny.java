package keletu.pvzmod.entities.dave;

import keletu.pvzmod.entities.IPlantWontHurt;
import keletu.pvzmod.init.PVZSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.npc.Npc;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

public class Penny extends PathfinderMob implements Npc, Merchant, IPlantWontHurt {


    private MerchantOffers trades;
    private @Nullable Player customer;
    private int pennyXp;

    public Penny(EntityType<? extends PathfinderMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    @Override
    protected void registerGoals() {
        this.getNavigation().setCanFloat(false);
        //this.goalSelector.addGoal(3, new DaveTradeGoal(this));
        //this.goalSelector.addGoal(3, new DaveLookAtTradePlayer(this));
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public void setTradingPlayer(@Nullable Player player) {
        this.customer = player;
    }

    @Nullable
    @Override
    public Player getTradingPlayer() {
        return this.customer;
    }

    public boolean isTrading() {
        return this.getTradingPlayer() != null;
    }

    @Override
    public MerchantOffers getOffers() {
        if (this.trades == null) {
            this.trades = new MerchantOffers();
        }

        return this.trades;
    }

    @Override
    public void overrideOffers(MerchantOffers offers) {
        this.trades = offers;
    }

    @Override
    public void notifyTrade(MerchantOffer merchantOffer) {
        this.playSound(PVZSounds.PENNY_SPEAK.get(), this.getSoundVolume(), this.getVoicePitch());
    }

    @Override
    public void notifyTradeUpdated(ItemStack itemStack) {

    }

    @Override
    public int getVillagerXp() {
        return this.pennyXp;
    }

    @Override
    public void overrideXp(int i) {
        this.pennyXp = i;
    }

    @Override
    public boolean showProgressBar() {
        return false;
    }

    @Override
    public boolean canRestock() {
        return true;
    }

    @Override
    public SoundEvent getNotifyTradeSound() {
        return PVZSounds.PENNY_SPEAK.get();
    }

    @Override
    public boolean isClientSide() {
        return this.level().isClientSide;
    }

    @Nullable
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return PVZSounds.PENNY_HURT.get();
    }

    @Nullable
    protected SoundEvent getDeathSound() {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    @Override
    protected AABB makeBoundingBox() {
        double xSize = 3.2D;
        double ySize = 4.0D;
        double zSize = 8.0D;

        return new AABB(
                this.getX() - xSize / 2.0D,
                this.getY(),
                this.getZ() - zSize / 2.0D,
                this.getX() + xSize / 2.0D,
                this.getY() + ySize,
                this.getZ() + zSize / 2.0D
        );
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 10.0F)
                .add(Attributes.MAX_HEALTH, 100.0F);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (this.isAlive() && !this.isTrading() && !player.isShiftKeyDown() && this.getTarget() != player) {
            if (!this.level().isClientSide) {
                this.setTradingPlayer(player);
                this.openTradingScreen(player, this.getDisplayName(), 0);
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.FAIL;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }
}
