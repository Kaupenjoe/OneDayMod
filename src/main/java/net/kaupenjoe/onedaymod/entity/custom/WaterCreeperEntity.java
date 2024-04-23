package net.kaupenjoe.onedaymod.entity.custom;

import net.kaupenjoe.onedaymod.sound.ModSounds;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.*;
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

public class WaterCreeperEntity extends CreeperEntity {
    private int explosionRadius = 4;

    public WaterCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void explode() {
        if (!this.getWorld().isClient) {
            float f = this.shouldRenderOverlay() ? 2.0F : 1.0F;
            this.dead = true;
            Iterator<BlockPos> blockPosToChange =
                    BlockPos.iterateOutwards(this.getBlockPos(),
                            (int)(explosionRadius * f), 0, (int)(explosionRadius * f)).iterator();
            for (Iterator<BlockPos> it = blockPosToChange; it.hasNext(); ) {
                BlockPos position = it.next();
                if(this.getWorld().getBlockState(position).isAir() ||
                        this.getWorld().getBlockState(position).isOf(Blocks.TALL_GRASS) ||
                        this.getWorld().getBlockState(position).isOf(Blocks.GRASS)) {
                    this.getWorld().setBlockState(position, Blocks.WATER.getDefaultState());
                }
            }

            // Adds Explosion Particles!
            ServerWorld world = ((ServerWorld) this.getWorld());
            world.spawnParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 1, 0.0, 1.0, 0.0, 1);
            world.spawnParticles(ParticleTypes.EXPLOSION_EMITTER, this.getX(), this.getY(), this.getZ(), 1, 0.0, 1.0, 0.0, 1);

            spawnParticleBlanketWater(blockPosToChange, 3);

            // Adds Explosion Sound!
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 1.5F,
                    (1.0F + (this.getWorld().random.nextFloat() - this.getWorld().random.nextFloat()) * 0.2F) * 0.7F);
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), ModSounds.WATER_CREEPER, SoundCategory.BLOCKS, 4.0F,
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

    private void spawnParticleBlanketWater(Iterator<BlockPos> blockPosToChange, int count) {
        ServerWorld world = ((ServerWorld) this.getWorld());
        for (Iterator<BlockPos> it = blockPosToChange; it.hasNext(); ) {
            BlockPos position = it.next();
            world.spawnParticles(ParticleTypes.DRIPPING_WATER,
                    position.getX() + 0.5d, position.getY() + 2.5d, position.getZ() + 0.5d, count + 1,
                    0, 0, 0, 1f);
        }
    }
}
