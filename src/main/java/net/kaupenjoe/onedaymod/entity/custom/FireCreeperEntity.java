package net.kaupenjoe.onedaymod.entity.custom;

import net.kaupenjoe.onedaymod.sound.ModSounds;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

public class FireCreeperEntity extends CreeperEntity {
    private int explosionRadius = 4;

    public FireCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void explode() {
        if (!this.getWorld().isClient) {
            float f = this.shouldRenderOverlay() ? 2.0F : 1.0F;
            this.dead = true;
            Iterator<BlockPos> blockPosToChange =
                    BlockPos.iterateOutwards(this.getBlockPos(),
                            (int)(explosionRadius * f), 1, (int)(explosionRadius * f)).iterator();
            for (Iterator<BlockPos> it = blockPosToChange; it.hasNext(); ) {
                BlockPos position = it.next();
                if(this.getWorld().getBlockState(position).isAir() ||
                        this.getWorld().getBlockState(position).isOf(Blocks.TALL_GRASS) ||
                        this.getWorld().getBlockState(position).isOf(Blocks.GRASS)) {
                    this.getWorld().setBlockState(position, Blocks.FIRE.getDefaultState());
                }
            }

            // Adds Explosion Particles!
            ServerWorld world = ((ServerWorld) this.getWorld());
            world.spawnParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 1, 0.0, 1.0, 0.0, 1);
            world.spawnParticles(ParticleTypes.EXPLOSION_EMITTER, this.getX(), this.getY(), this.getZ(), 1, 0.0, 1.0, 0.0, 1);

            spawnParticleCircle(this.getBlockPos(), ParticleTypes.SMOKE, 1, 1f);
            spawnParticleCircle(this.getBlockPos(), ParticleTypes.FLAME, 2, 2f);

            // Adds Explosion Sound!
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 1F,
                     (1.0F + (this.getWorld().random.nextFloat() - this.getWorld().random.nextFloat()) * 0.2F) * 0.7F);
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.FLAME_CREEPER, SoundCategory.BLOCKS, 12f,
                    (1.0F + (this.getWorld().random.nextFloat() - this.getWorld().random.nextFloat()) * 0.2F) * 0.7F);

            this.discard();
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

    private void spawnParticleCircle(BlockPos positionClicked, ParticleEffect type, int count, float speed) {
        for(int i = 0; i < 20; i++) {
            ServerWorld world = ((ServerWorld) this.getWorld());

            world.spawnParticles(type,
                    positionClicked.getX() + 0.5d, positionClicked.getY() + 1, positionClicked.getZ() + 0.5d, count + 1,
                    Math.cos(i * 18) * 0.25d, Math.cos(i * 18) * 0.25d, Math.sin(i * 18) * 0.25d, speed);
        }
    }

    private void spawnParticleBlanket(BlockPos positionClicked, ParticleEffect type, int count) {
        for(int i = 0; i < 20; i++) {
            ServerWorld world = ((ServerWorld) this.getWorld());

            world.spawnParticles(type,
                    positionClicked.getX() + 0.5d, positionClicked.getY() + 1, positionClicked.getZ() + 0.5d, count + 1,
                    Math.cos(i * 18) * 0.25d, 1d, Math.sin(i * 18) * 0.25d, 1f);
        }
    }
}
