package net.mcreator.boss.abilities.doll_switch;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = "boss")
public class DollSwitchEvent {

    private static final String[] SPIN_ORDER = {
            "boss:catnap",
            "boss:dogday",
            "boss:huggy_wuggy",
            "boss:kissy_missy",
            "boss:mommy",
            "boss:yarna_by"
    };

    private static UUID activeUUID = null;
    private static ServerLevel activeLevel = null;
    private static int tick = 0;
    private static int index = 0;
    private static boolean spinning = false;

    private static final int TOTAL_SPIN_TICKS = 300;

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.EntityInteract event) {

        if (spinning) return;
        if (!(event.getTarget() instanceof Mob target)) return;

        Player player = event.getEntity();
        if (!player.isShiftKeyDown()) return;
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        ResourceLocation id = ForgeRegistries.ENTITY_TYPES.getKey(target.getType());
        if (id == null || !id.toString().equals("boss:doll_poppy")) return;

        Level level = player.level();
        if (level.isClientSide) return;

        event.setCanceled(true);

        target.setNoAi(true);
        target.setInvulnerable(true);

        activeUUID = target.getUUID();
        activeLevel = (ServerLevel) level;
        tick = 0;
        index = 0;
        spinning = true;

        activeLevel.playSound(null, target.blockPosition(),
                SoundEvents.LEVER_CLICK,
                SoundSource.HOSTILE,
                3f, 0.7f);
    }

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {

        if (!spinning || activeLevel == null || activeUUID == null) return;
        if (event.phase != TickEvent.Phase.END) return;

        tick++;

        Entity current = activeLevel.getEntity(activeUUID);
        if (current == null) {
            spinning = false;
            return;
        }

        float progress = (float) tick / TOTAL_SPIN_TICKS;
        int interval = (int)(10 - (progress * 9)); 
        if (interval < 1) interval = 1;

        if (tick < TOTAL_SPIN_TICKS && tick % interval == 0) {

            String mobId = SPIN_ORDER[index % SPIN_ORDER.length];
            index++;

            Entity newEntity = ForgeRegistries.ENTITY_TYPES
                    .getValue(new ResourceLocation(mobId))
                    .create(activeLevel);

            if (newEntity == null) return;

            newEntity.moveTo(current.getX(), current.getY(), current.getZ(),
                    current.getYRot(), current.getXRot());

            newEntity.setInvulnerable(true);

            activeLevel.addFreshEntity(newEntity);
            current.discard();
            activeUUID = newEntity.getUUID();

            int particleCount = 10 + (int)(progress * 60);

            activeLevel.sendParticles(
                    ParticleTypes.END_ROD,
                    newEntity.getX(),
                    newEntity.getY() + 1,
                    newEntity.getZ(),
                    particleCount,
                    0.6, 0.8, 0.6,
                    0.2
            );

            float pitch = 0.8f + (progress * 1.5f);

            activeLevel.playSound(
                    null,
                    newEntity.blockPosition(),
                    SoundEvents.NOTE_BLOCK_BIT.value(),
                    SoundSource.HOSTILE,
                    1.5f,
                    pitch
            );
        }

        if (tick == TOTAL_SPIN_TICKS + 20) {

            Entity prototype = ForgeRegistries.ENTITY_TYPES
                    .getValue(new ResourceLocation("boss:prototype"))
                    .create(activeLevel);

            if (prototype != null) {

                prototype.moveTo(current.getX(), current.getY(), current.getZ(),
                        current.getYRot(), current.getXRot());

                prototype.setInvulnerable(true);
                activeLevel.addFreshEntity(prototype);

                current.discard();
                activeUUID = prototype.getUUID();

                activeLevel.sendParticles(
                        ParticleTypes.FLASH,
                        prototype.getX(),
                        prototype.getY() + 1,
                        prototype.getZ(),
                        5,
                        0,0,0,0
                );

                activeLevel.playSound(
                        null,
                        prototype.blockPosition(),
                        SoundEvents.WITHER_SPAWN,
                        SoundSource.HOSTILE,
                        6f,
                        0.5f
                );
            }
        }

        if (tick == TOTAL_SPIN_TICKS + 40) {

            Entity prototype = activeLevel.getEntity(activeUUID);
            if (prototype != null) {

                PrototypeExplosionHandler.trigger(activeLevel, prototype.blockPosition());
                prototype.setInvulnerable(false);
            }

            spinning = false;
            activeUUID = null;
            activeLevel = null;
        }
    }
}