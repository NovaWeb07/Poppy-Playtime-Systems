package net.mcreator.boss.abilities.prototype_arena;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;

public class PrototypeArenaHandler {

    private static final int RADIUS = 30;
    private static final int HEIGHT = 20;

    private static BlockPos arenaCenter = null;

    public static void createArena(ServerLevel level, BlockPos center) {

        arenaCenter = center;

        level.playSound(null, center,
                SoundEvents.WITHER_SPAWN,
                SoundSource.HOSTILE,
                6f, 0.6f);

        level.sendParticles(
                ParticleTypes.EXPLOSION_EMITTER,
                center.getX(),
                center.getY(),
                center.getZ(),
                30,
                2,2,2,0
        );

        for (int layer = 0; layer < 2; layer++) {

            double offset = layer == 0 ? 0 : 3;

            for (int angle = 0; angle < 360; angle += 6) {

                double rad = Math.toRadians(angle + offset);

                int x = center.getX() + (int)(RADIUS * Math.cos(rad));
                int z = center.getZ() + (int)(RADIUS * Math.sin(rad));

                for (int y = 0; y <= HEIGHT; y += 3) {

                    spawnHuggy(level, x, center.getY() + y, z);
                }
            }
        }

        for (int x = -RADIUS; x <= RADIUS; x++) {
            for (int z = -RADIUS; z <= RADIUS; z++) {

                if (x*x + z*z <= RADIUS * RADIUS) {

                    BlockPos pos = center.offset(x, HEIGHT, z);
                    level.setBlock(pos, Blocks.BARRIER.defaultBlockState(), 3);
                }
            }
        }
    }

    private static void spawnHuggy(ServerLevel level, int x, int y, int z) {

        Entity huggy = ForgeRegistries.ENTITY_TYPES
                .getValue(new ResourceLocation("boss:huggy_wuggy"))
                .create(level);

        if (huggy == null) return;

        huggy.moveTo(x + 0.5, y, z + 0.5, 0, 0);

        if (huggy instanceof Mob mob) {
            mob.setNoAi(true);
            mob.setInvulnerable(true);
            mob.setSilent(true);
            mob.setPersistenceRequired();
        }

        level.addFreshEntity(huggy);
    }

    public static void applyBoundaryPush(Player player) {

        if (arenaCenter == null) return;

        double dx = player.getX() - arenaCenter.getX();
        double dz = player.getZ() - arenaCenter.getZ();

        double dist = Math.sqrt(dx*dx + dz*dz);

        if (dist > RADIUS - 1) {

            double pushX = -dx / dist * 1.5;
            double pushZ = -dz / dist * 1.5;

            player.setDeltaMovement(pushX, 0.5, pushZ);
            player.hurtMarked = true;
        }
    }
}