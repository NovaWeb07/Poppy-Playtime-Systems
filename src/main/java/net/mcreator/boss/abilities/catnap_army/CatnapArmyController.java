package net.mcreator.boss.abilities.catnap_army;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

@Mod.EventBusSubscriber(modid = "boss")
public class CatnapArmyController {

    private static final int GRID_X = 4;
    private static final int GRID_Z = 6;
    private static final int SPACING = 2;
    private static final int TARGET_RADIUS = 30;

    private static final Map<UUID, List<Mob>> activeArmy = new HashMap<>();

    @SubscribeEvent
    public static void onSpawnEggUse(PlayerInteractEvent.RightClickBlock event) {

        Player player = event.getEntity();
        if (player.level().isClientSide) return;

        if (!player.getMainHandItem().toString().contains("catnap_spawn_egg"))
            return;

        ServerLevel level = (ServerLevel) player.level();
        BlockPos center = event.getPos().above();

        List<Mob> army = new ArrayList<>();

        for (int x = 0; x < GRID_X; x++) {
            for (int z = 0; z < GRID_Z; z++) {

                double spawnX = center.getX() + (x - GRID_X/2) * SPACING;
                double spawnZ = center.getZ() + (z - GRID_Z/2) * SPACING;
                double spawnY = center.getY();

                Entity entity = EntityType.byString("boss:catnap").orElse(null)
                        .create(level);

                if (entity instanceof Mob mob) {

                    mob.moveTo(spawnX, spawnY, spawnZ, 0,0);
                    mob.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.35);
                    mob.setPersistenceRequired();

                    level.addFreshEntity(mob);
                    army.add(mob);
                }
            }
        }

        level.playSound(
                null,
                center,
                SoundEvents.RAID_HORN.get(),
                SoundSource.HOSTILE,
                3f,
                0.8f
        );

        activeArmy.put(player.getUUID(), army);
    }

    @SubscribeEvent
    public static void serverTick(TickEvent.ServerTickEvent event) {

        if (event.phase != TickEvent.Phase.END) return;

        for (UUID ownerId : new HashSet<>(activeArmy.keySet())) {

            ServerPlayer owner =
                    event.getServer().getPlayerList().getPlayer(ownerId);

            if (owner == null) continue;

            List<Mob> army = activeArmy.get(ownerId);
            if (army == null) continue;

            Player target = null;

            for (ServerPlayer p :
                    event.getServer().getPlayerList().getPlayers()) {

                if (p.distanceTo(owner) <= TARGET_RADIUS &&
                    p.getMainHandItem().is(Items.SALMON)) {

                    target = p;
                    break;
                }
            }

            Iterator<Mob> it = army.iterator();

            while (it.hasNext()) {

                Mob mob = it.next();

                if (!mob.isAlive()) {
                    it.remove();
                    continue;
                }

                ServerLevel lvl = (ServerLevel) mob.level();
                BlockPos pos = mob.blockPosition();

                boolean touchingBedrock =
                        lvl.getBlockState(pos).is(Blocks.BEDROCK) ||
                        lvl.getBlockState(pos.above()).is(Blocks.BEDROCK) ||
                        lvl.getBlockState(pos.below()).is(Blocks.BEDROCK) ||
                        lvl.getBlockState(pos.north()).is(Blocks.BEDROCK) ||
                        lvl.getBlockState(pos.south()).is(Blocks.BEDROCK) ||
                        lvl.getBlockState(pos.east()).is(Blocks.BEDROCK) ||
                        lvl.getBlockState(pos.west()).is(Blocks.BEDROCK);

                if (touchingBedrock) {

                    lvl.sendParticles(
                            ParticleTypes.PORTAL,
                            mob.getX(),
                            mob.getY() + 1,
                            mob.getZ(),
                            60,
                            0.8, 1, 0.8,
                            0.3
                    );

                    lvl.sendParticles(
                            ParticleTypes.SMOKE,
                            mob.getX(),
                            mob.getY() + 1,
                            mob.getZ(),
                            40,
                            0.5, 0.7, 0.5,
                            0.05
                    );

                    lvl.playSound(
                            null,
                            mob.blockPosition(),
                            SoundEvents.FIRE_EXTINGUISH,
                            SoundSource.HOSTILE,
                            1.8f,
                            0.9f
                    );

                    mob.discard();
                    it.remove();
                    continue;
                }

                if (target != null) {
                    mob.setTarget(target);
                    mob.getNavigation().moveTo(target, 1.2);
                }
            }

            if (army.isEmpty())
                activeArmy.remove(ownerId);
        }
    }
}