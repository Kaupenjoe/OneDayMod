package net.kaupenjoe.onedaymod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.kaupenjoe.onedaymod.entity.ModEntities;
import net.kaupenjoe.onedaymod.item.ModItems;
import net.kaupenjoe.onedaymod.sound.ModSounds;
import net.minecraft.entity.mob.CreeperEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OneDayMod implements ModInitializer {
	public static final String MOD_ID = "onedaymod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();

		registerAttributes();

		ModEntities.registerModEntities();
		ModSounds.registerSounds();
	}

	private static void registerAttributes() {
		FabricDefaultAttributeRegistry.register(ModEntities.FAKE_LOVE_CREEPER, CreeperEntity.createCreeperAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.FIRE_CREEPER, CreeperEntity.createCreeperAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.FLATTEN_CREEPER, CreeperEntity.createCreeperAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.KNOCKBACK_CREEPER, CreeperEntity.createCreeperAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.LAVA_CREEPER, CreeperEntity.createCreeperAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.LOVE_CREEPER, CreeperEntity.createCreeperAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SNOW_CREEPER, CreeperEntity.createCreeperAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.WATER_CREEPER, CreeperEntity.createCreeperAttributes());
	}
}