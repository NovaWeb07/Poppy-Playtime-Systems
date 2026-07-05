package net.mcreator.boss.abilities.morph;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.InteractionHand;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModList;

@Mod.EventBusSubscriber(modid = "boss")
public class MorphAltAbility {

    @SubscribeEvent
    public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {

        Player player = event.getEntity();
        Entity target = event.getTarget();

        if (player.level().isClientSide) return;
        if (!(player instanceof ServerPlayer sp)) return;

        if (!sp.isShiftKeyDown()) return;

        ItemStack stack = sp.getItemInHand(InteractionHand.MAIN_HAND);
        if (!stack.isEmpty()) return;

        if (!(target instanceof Mob)) return;

        ResourceLocation id = target.getType().builtInRegistryHolder().key().location();

        if (!"boss".equals(id.getNamespace())) return;

        if (!ModList.get().isLoaded("walkers")) return;

        ServerLevel level = sp.serverLevel();

        String command = "walkers switchShape @s " + id.toString();

        sp.getServer().getCommands().performPrefixedCommand(
                sp.createCommandSourceStack().withSuppressedOutput(),
                command
        );

        level.sendParticles(
                ParticleTypes.PORTAL,
                target.getX(),
                target.getY() + 1,
                target.getZ(),
                120,
                1.2,1.2,1.2,
                0.5
        );

        level.sendParticles(
                ParticleTypes.REVERSE_PORTAL,
                sp.getX(),
                sp.getY() + 1,
                sp.getZ(),
                80,
                0.8,0.8,0.8,
                0.3
        );

        level.sendParticles(
                ParticleTypes.ENCHANT,
                sp.getX(),
                sp.getY() + 1,
                sp.getZ(),
                100,
                1,1,1,
                0.1
        );

        level.playSound(
                null,
                sp.blockPosition(),
                SoundEvents.ENDERMAN_TELEPORT,
                SoundSource.HOSTILE,
                2.5f,
                0.5f
        );

        level.playSound(
                null,
                sp.blockPosition(),
                SoundEvents.WARDEN_SONIC_BOOM,
                SoundSource.HOSTILE,
                2f,
                1.6f
        );

        level.playSound(
                null,
                sp.blockPosition(),
                SoundEvents.WITHER_SPAWN,
                SoundSource.HOSTILE,
                1.5f,
                1.2f
        );

        target.discard();
    }
}