package keletu.pvzmod.items;

import keletu.pvzmod.entities.SuperGatlingPea;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemEnergyBean extends Item {
    public ItemEnergyBean(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
        if (!(entity instanceof SuperGatlingPea target)) {
            return InteractionResult.PASS;
        }

        if (!target.canUseEnergyBean(player)) {
            return InteractionResult.FAIL;
        }

        if (entity.level().isClientSide) {
            return InteractionResult.SUCCESS;
        }

        if (!target.activateEnergyBean(player)) {
            return InteractionResult.FAIL;
        }

        if (!player.getAbilities().instabuild) {
            stack.shrink(1);
        }

        return InteractionResult.CONSUME;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return true;
    }
}
