package net.mcreator.boss.abilities.prototype_arena;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.*;

@Mod.EventBusSubscriber(modid = "boss")
public class PrototypeBlockAbsorbEvent {

    private static final int RADIUS = 6;
    private static final int BLOCKS_PER_TICK = 18;

    private static final Map<UUID, Queue<BlockPos>> absorbQueue = new HashMap<>();
    private static final Map<UUID, List<FallingBlockEntity>> activeBlocks = new HashMap<>();

    @SubscribeEvent
    public static void rightClickAir(PlayerInteractEvent.RightClickEmpty e) {
        trigger(e.getEntity());
    }

    @SubscribeEvent
    public static void rightClickBlock(PlayerInteractEvent.RightClickBlock e) {
        trigger(e.getEntity());
    }

    private static void trigger(Player player) {

        if (player.level().isClientSide) return;

        ItemStack stack = player.getMainHandItem();
        if (!stack.getItem().toString().contains("prototypeitem")) return;

        HitResult ray = player.pick(80, 0f, false);
        if (!(ray instanceof BlockHitResult hit)) return;

        ServerLevel level = (ServerLevel) player.level();

        level.playSound(null, player.blockPosition(),
                SoundEvents.WARDEN_SONIC_BOOM,
                SoundSource.HOSTILE,
                1.4f, 1.6f);

        level.playSound(null, player.blockPosition(),
                SoundEvents.ENDERMAN_TELEPORT,
                SoundSource.HOSTILE,
                0.8f, 0.5f);

        Queue<BlockPos> queue = new LinkedList<>();

        for (int x=-RADIUS;x<=RADIUS;x++)
            for (int y=-RADIUS;y<=RADIUS;y++)
                for (int z=-RADIUS;z<=RADIUS;z++) {

                    BlockPos pos = hit.getBlockPos().offset(x,y,z);
                    BlockState state = level.getBlockState(pos);

                    if (!state.isAir() && !state.is(Blocks.BEDROCK))
                        queue.add(pos);
                }

        absorbQueue.put(player.getUUID(), queue);
    }

    @SubscribeEvent
    public static void serverTick(TickEvent.ServerTickEvent event) {

        if (event.phase != TickEvent.Phase.END) return;

        for (UUID id : new HashSet<>(absorbQueue.keySet())) {

            ServerPlayer player =
                    event.getServer().getPlayerList().getPlayer(id);
            if (player == null) continue;

            ServerLevel level = player.serverLevel();
            Queue<BlockPos> queue = absorbQueue.get(id);

            for (int i=0;i<BLOCKS_PER_TICK && queue!=null && !queue.isEmpty();i++) {

                BlockPos pos = queue.poll();
                BlockState state = level.getBlockState(pos);

                if (state.isAir()) continue;

                level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);

                FallingBlockEntity fb =
                        FallingBlockEntity.fall(level, pos, state);

                fb.setNoGravity(true);
                fb.dropItem = false;
                fb.time = 1;
                fb.setDeltaMovement(0,0,0);

                activeBlocks
                        .computeIfAbsent(id,k->new ArrayList<>())
                        .add(fb);

                level.sendParticles(
                        ParticleTypes.SCULK_SOUL,
                        pos.getX()+0.5,
                        pos.getY()+0.5,
                        pos.getZ()+0.5,
                        1,
                        0.05,0.05,0.05,
                        0
                );
            }

            if (queue==null || queue.isEmpty())
                absorbQueue.remove(id);
        }

        for (UUID id : new HashSet<>(activeBlocks.keySet())) {

            ServerPlayer player =
                    event.getServer().getPlayerList().getPlayer(id);
            if (player == null) continue;

            ServerLevel level = player.serverLevel();
            List<FallingBlockEntity> list = activeBlocks.get(id);
            Iterator<FallingBlockEntity> it = list.iterator();

            while (it.hasNext()) {

                FallingBlockEntity fb = it.next();

                if (!fb.isAlive()) {
                    it.remove();
                    continue;
                }

                double dx = player.getX() - fb.getX();
                double dy = (player.getY()+1.2) - fb.getY();
                double dz = player.getZ() - fb.getZ();

                double dist = Math.sqrt(dx*dx + dy*dy + dz*dz);

                if (dist < 1.3) {

                    level.sendParticles(
                            ParticleTypes.ENCHANT,
                            player.getX(),
                            player.getY()+1,
                            player.getZ(),
                            6,
                            0.2,0.2,0.2,
                            0
                    );

                    fb.discard();
                    it.remove();
                    continue;
                }

                double speed = 0.9;

                fb.setDeltaMovement(
                        dx/dist * speed,
                        dy/dist * speed,
                        dz/dist * speed
                );
            }

            if (list.isEmpty())
                activeBlocks.remove(id);
        }
    }
}