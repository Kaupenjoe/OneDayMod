package net.kaupenjoe.onedaymod.entity.client;

import net.kaupenjoe.onedaymod.OneDayMod;
import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;

public class SnowCreeperEntityRenderer extends CreeperEntityRenderer {
    private static final Identifier TEXTURE = new Identifier(OneDayMod.MOD_ID, "textures/entity/snow_creeper.png");

    public SnowCreeperEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }


    public Identifier getTexture(CreeperEntity creeperEntity) {
        return TEXTURE;
    }
}
