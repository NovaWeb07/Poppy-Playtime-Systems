package net.mcreator.boss.abilities;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = "boss", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DollPoppyRightClickAbility {

    private static final Map<UUID, Long> cooldownMap = new HashMap<>();
    private static final long COOLDOWN_TICKS = 20;

    @SubscribeEvent
    public static void onEntityRightClick(PlayerInteractEvent.EntityInteract event) {
        handle(event.getTarget(), event.getEntity());
    }

    @SubscribeEvent
    public static void onEntityRightClickSpecific(PlayerInteractEvent.EntityInteractSpecific event) {
        handle(event.getTarget(), event.getEntity());
    }

    private static void handle(Entity target, Player player) {

        Level level = player.level();
        if (level.isClientSide) return;

        if (!target.getType().builtInRegistryHolder().key().location()
                .equals(new ResourceLocation("boss", "doll_poppy"))) return;

        long currentTick = level.getGameTime();
        UUID playerId = player.getUUID();

        if (cooldownMap.containsKey(playerId)) {
            long lastUse = cooldownMap.get(playerId);
            if (currentTick - lastUse < COOLDOWN_TICKS) return;
        }

        cooldownMap.put(playerId, currentTick);

        Component message =
                Component.literal("I miss my father... Prototype.\n")
                        .setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xFF4DA6)).withBold(true))
                .append(Component.literal("Please... I just want to leave this place.\n")
                        .setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xFF99CC)).withItalic(true)))
                .append(Component.literal("Just... let me go.")
                        .setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xFFFFFF)).withUnderlined(true)));

        player.sendSystemMessage(message);

        SoundEvent cave = BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("minecraft", "ambient.cave"));
        SoundEvent ghast = BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("minecraft", "entity.ghast.ambient"));

        if (cave != null) {
            level.playSound(null, target.blockPosition(), cave, SoundSource.HOSTILE, 1.2F, 0.7F);
        }

        if (ghast != null) {
            level.playSound(null, target.blockPosition(), ghast, SoundSource.HOSTILE, 1.5F, 0.8F);
        }
    }
}