package net.kaupenjoe.onedaymod.entity.custom;

import net.kaupenjoe.onedaymod.sound.ModSounds;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class LoveCreeperEntity extends CreeperEntity {
    private int explosionRadius = 4;

    public LoveCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void explode() {
        if (!this.getWorld().isClient) {
            float f = this.shouldRenderOverlay() ? 2.0F : 1.0F;
            this.dead = true;
            Box boundingBox = this.getBoundingBox().expand(explosionRadius * f);
            List<PlayerEntity> entitiesInRadius = this.getWorld().getEntitiesByClass(PlayerEntity.class, boundingBox, x -> true);

            for (PlayerEntity player : entitiesInRadius) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200));
            }

            // Adds Explosion Particles!
            ServerWorld world = ((ServerWorld) this.getWorld());
            world.spawnParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 1, 0.0, 1.0, 0.0, 1);
            world.spawnParticles(ParticleTypes.EXPLOSION_EMITTER, this.getX(), this.getY(), this.getZ(), 1, 0.0, 1.0, 0.0, 1);

            // Adds Explosion Sound!
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 1F,
                     (1.0F + (this.getWorld().random.nextFloat() - this.getWorld().random.nextFloat()) * 0.2F) * 0.7F);
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.LOVE_CREEPER, SoundCategory.BLOCKS, 12f,
                    (1.0F + (this.getWorld().random.nextFloat() - this.getWorld().random.nextFloat()) * 0.2F) * 0.7F);

            this.discard();
            this.spawnEffectsCloud(f);
        }
    }

    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        if(player.isSneaking() && !this.getWorld().isClient()) {
            ServerWorld world = ((ServerWorld) this.getWorld());
            EntityType.LIGHTNING_BOLT.spawn(world, this.getBlockPos(), SpawnReason.TRIGGERED);
        }

        return super.interactMob(player, hand);
    }

    private void spawnEffectsCloud(float additional) {
        // Adding Regen
        this.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION));
        Collection<StatusEffectInstance> collection = this.getStatusEffects();

        if (!collection.isEmpty()) {
            AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(this.getWorld(), this.getX(), this.getY(), this.getZ());
            areaEffectCloudEntity.setRadius(explosionRadius * additional);
            areaEffectCloudEntity.setRadiusOnUse(-0.5F);
            areaEffectCloudEntity.setWaitTime(10);
            areaEffectCloudEntity.setDuration(areaEffectCloudEntity.getDuration() / 2);
            areaEffectCloudEntity.setRadiusGrowth(-areaEffectCloudEntity.getRadius() / (float)areaEffectCloudEntity.getDuration());
            Iterator var3 = collection.iterator();

            while(var3.hasNext()) {
                StatusEffectInstance statusEffectInstance = (StatusEffectInstance)var3.next();
                areaEffectCloudEntity.addEffect(new StatusEffectInstance(statusEffectInstance));
            }

            this.getWorld().spawnEntity(areaEffectCloudEntity);
        }
    }
}
