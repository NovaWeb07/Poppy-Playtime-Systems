package net.mcreator.boss.abilities.consume_system;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.ChatFormatting;
import net.minecraft.world.BossEvent;
import net.minecraft.server.level.ServerBossEvent;

import java.util.HashMap;
import java.util.UUID;

public class ConsumeProgress {

    private static final HashMap<UUID, ServerBossEvent> BARS = new HashMap<>();
    private static final HashMap<UUID, Float> PROGRESS = new HashMap<>();

    public static void addProgress(ServerPlayer player, float amount) {

        UUID id = player.getUUID();

        ServerBossEvent bar = BARS.computeIfAbsent(id, uuid -> {

            Component title = Component.literal("BECOME ")
                    .withStyle(ChatFormatting.BOLD, ChatFormatting.WHITE)
                    .append(
                            Component.literal("PROTOTYPE")
                                    .withStyle(
                                            Style.EMPTY
                                                    .withBold(true)
                                                    .withColor(TextColor.fromRgb(0x8A2BE2))
                                    )
                    );

            ServerBossEvent bossBar = new ServerBossEvent(
                    title,
                    BossEvent.BossBarColor.PURPLE,
                    BossEvent.BossBarOverlay.NOTCHED_20
            );

            bossBar.addPlayer(player);
            return bossBar;
        });

        float newValue = PROGRESS.getOrDefault(id, 0f) + amount;
        if (newValue > 1f) newValue = 1f;

        PROGRESS.put(id, newValue);
        bar.setProgress(newValue);
    }

    public static void reset(ServerPlayer player) {

        UUID id = player.getUUID();

        if (BARS.containsKey(id)) {
            BARS.get(id).setProgress(0f);
        }

        PROGRESS.put(id, 0f);
    }
}