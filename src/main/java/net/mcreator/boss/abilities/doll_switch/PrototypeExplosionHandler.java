package net.mcreator.boss.abilities.doll_switch;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;

import java.util.Random;

public class PrototypeExplosionHandler {

    private static final int RADIUS = 20;
    private static final Random RANDOM = new Random();

    public static void trigger(ServerLevel level, BlockPos center) {

        level.sendParticles(
                ParticleTypes.EXPLOSION_EMITTER,
                center.getX(),
                center.getY(),
                center.getZ(),
                40,
                2, 2, 2,
                0
        );

        level.sendParticles(
                ParticleTypes.LARGE_SMOKE,
                center.getX(),
                center.getY(),
                center.getZ(),
                100,
                3, 3, 3,
                0.05
        );

        level.playSound(
                null,
                center,
                SoundEvents.GENERIC_EXPLODE,
                SoundSource.HOSTILE,
                8f,
                0.6f
        );

        level.explode(
                null,
                center.getX(),
                center.getY(),
                center.getZ(),
                RADIUS,
                false,
                Level.ExplosionInteraction.BLOCK
        );

        int launched = 0;
        int maxLaunch = 300;

        for (int x = -RADIUS; x <= RADIUS; x++) {
            for (int y = -RADIUS; y <= RADIUS; y++) {
                for (int z = -RADIUS; z <= RADIUS; z++) {

                    if (launched >= maxLaunch) return;

                    BlockPos pos = center.offset(x, y, z);

                    if (pos.getY() <= -55) continue;

                    BlockState state = level.getBlockState(pos);
                    if (state.isAir()) continue;

                    if (RANDOM.nextFloat() > 0.08f) continue;

                    FallingBlockEntity falling = FallingBlockEntity.fall(level, pos, state);

                    falling.setDeltaMovement(
                            (RANDOM.nextDouble() - 0.5) * 1.8,
                            1.5 + RANDOM.nextDouble(),
                            (RANDOM.nextDouble() - 0.5) * 1.8
                    );

                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());

                    launched++;
                }
            }
        }
    }
}