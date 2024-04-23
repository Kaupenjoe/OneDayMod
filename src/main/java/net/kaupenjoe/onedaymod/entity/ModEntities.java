package net.kaupenjoe.onedaymod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.kaupenjoe.onedaymod.OneDayMod;
import net.kaupenjoe.onedaymod.entity.custom.*;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<FakeLoveCreeperEntity> FAKE_LOVE_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(OneDayMod.MOD_ID, "fake_love_creeper"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FakeLoveCreeperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<FireCreeperEntity> FIRE_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(OneDayMod.MOD_ID, "fire_creeper"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FireCreeperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<FlattenCreeperEntity> FLATTEN_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(OneDayMod.MOD_ID, "flatten_creeper"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FlattenCreeperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<KnockbackCreeperEntity> KNOCKBACK_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(OneDayMod.MOD_ID, "knockback_creeper"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, KnockbackCreeperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<LavaCreeperEntity> LAVA_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(OneDayMod.MOD_ID, "lava_creeper"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, LavaCreeperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<LoveCreeperEntity> LOVE_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(OneDayMod.MOD_ID, "love_creeper"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, LoveCreeperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<SnowCreeperEntity> SNOW_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(OneDayMod.MOD_ID, "snow_creeper"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SnowCreeperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());

    public static final EntityType<WaterCreeperEntity> WATER_CREEPER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(OneDayMod.MOD_ID, "water_creeper"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WaterCreeperEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6F, 1.7F)).build());


    public static void registerModEntities() {
        OneDayMod.LOGGER.info("Registering Mod Entities for " + OneDayMod.MOD_ID);
    }
}
