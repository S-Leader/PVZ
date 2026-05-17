package keletu.pvzmod.entities;

import keletu.pvzmod.entities.projectile.ElectricPeaProjectile;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;

public class SuperElectricGatlingPea extends SuperGatlingPea {
    public SuperElectricGatlingPea(EntityType<? extends SuperElectricGatlingPea> type, Level level) {
        super(type, level);
    }

    @Override
    public ThrowableProjectile entitySelect(Level world) {
        ElectricPeaProjectile ent = new ElectricPeaProjectile(world, this, 2);
        return ent;
    }
}