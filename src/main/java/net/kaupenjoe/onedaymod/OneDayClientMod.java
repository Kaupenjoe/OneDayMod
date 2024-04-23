package net.kaupenjoe.onedaymod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.kaupenjoe.onedaymod.entity.ModEntities;
import net.kaupenjoe.onedaymod.entity.client.*;

public class OneDayClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.FAKE_LOVE_CREEPER, FakeLoveCreeperEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.FIRE_CREEPER, FireCreeperEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.FLATTEN_CREEPER, FlattenCreeperEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.KNOCKBACK_CREEPER, KnockbackCreeperEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.LAVA_CREEPER, LavaCreeperEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.LOVE_CREEPER, LoveCreeperEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.SNOW_CREEPER, SnowCreeperEntityRenderer::new);
        EntityRendererRegistry.register(ModEntities.WATER_CREEPER, WaterCreeperEntityRenderer::new);
    }
}
