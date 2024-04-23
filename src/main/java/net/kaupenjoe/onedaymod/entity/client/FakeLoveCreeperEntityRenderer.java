package net.kaupenjoe.onedaymod.entity.client;

import net.kaupenjoe.onedaymod.OneDayMod;
import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.util.Identifier;

public class FakeLoveCreeperEntityRenderer extends CreeperEntityRenderer {
    private static final Identifier FAKE_TEXTURE = new Identifier(OneDayMod.MOD_ID, "textures/entity/fake_love_creeper.png");
    private static final Identifier TEXTURE = new Identifier("textures/entity/creeper/creeper.png");

    public FakeLoveCreeperEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    public Identifier getTexture(CreeperEntity creeperEntity) {
        if(creeperEntity.currentFuseTime > 15) {
            return TEXTURE;
        } else {
            return FAKE_TEXTURE;
        }
    }
}
