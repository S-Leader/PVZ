package keletu.pvzmod.entities;

import keletu.pvzmod.entities.projectile.SnowPeaProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

public class SuperSnowGatlingPea extends SuperGatlingPea {
    public SuperSnowGatlingPea(EntityType<? extends SuperSnowGatlingPea> type, Level level) {
        super(type, level);
    }

    @Override
    public ThrowableProjectile entitySelect(Level world) {
        SnowPeaProjectile ent = new SnowPeaProjectile(world, this, 3);
        return ent;
    }
}