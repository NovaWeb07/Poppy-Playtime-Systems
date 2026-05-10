package net.mcreator.boss.abilities.consume_system;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "boss")
public class ConsumeEvent {

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.EntityInteract event) {

        if (!(event.getTarget() instanceof LivingEntity target)) return;

        Player player = event.getEntity();
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        ItemStack stack = player.getMainHandItem();

        if (!stack.getItem().toString().contains("mommyitem")) return;

        Level level = player.level();
        if (level.isClientSide) return;

        event.setCanceled(true);

        ServerLevel server = (ServerLevel) level;

        server.sendParticles(
                ParticleTypes.SCULK_SOUL,
                target.getX(),
                target.getY() + 1,
                target.getZ(),
                60,
                0.5, 0.8, 0.5,
                0.1
        );

        server.playSound(
                null,
                target.blockPosition(),
                SoundEvents.WARDEN_DEATH,
                SoundSource.HOSTILE,
                3f,
                0.8f
        );

        if (target instanceof ServerPlayer sp) {
            sp.hurt(server.damageSources().magic(), Float.MAX_VALUE);
        } else {
            target.discard();
        }

        if (player instanceof ServerPlayer sp) {

            if (target instanceof Pillager) {
                ConsumeProgress.reset(sp);
            } else {
                ConsumeProgress.addProgress(sp, 0.1f);
            }
        }
    }
}