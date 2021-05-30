package io.pluto.endupdate.entities.enderslime;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.world.World;

public class EnderSlime extends PathAwareEntity {

    public EnderSlime(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }

}
