package net.kaupenjoe.onedaymod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.world.World;

public class FakeLoveCreeperEntity extends CreeperEntity {
    public FakeLoveCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }
}
