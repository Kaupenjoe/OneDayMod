package net.kaupenjoe.onedaymod.entity.client;

import net.kaupenjoe.onedaymod.OneDayMod;
import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;

public class WaterCreeperEntityRenderer extends CreeperEntityRenderer {
    private static final Identifier TEXTURE = new Identifier(OneDayMod.MOD_ID, "textures/entity/water_creeper.png");

    public WaterCreeperEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }


    public Identifier getTexture(CreeperEntity creeperEntity) {
        return TEXTURE;
    }
}
