package net.mcreator.boss.abilities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = "boss", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class KissyMissyBlockBreakAbility {

    private static final UUID HEART_STEAL_UUID = UUID.fromString("9e7c7a4e-4d7b-4b92-9f7e-123456789001");

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {

        Player player = event.getPlayer();
        if (player == null) return;

        Level level = (Level) event.getLevel();
        if (level.isClientSide) return;

        Block brokenBlock = event.getState().getBlock();

        if (!BuiltInRegistries.BLOCK.getKey(brokenBlock)
                .equals(new ResourceLocation("boss", "tv_block"))) return;

        BlockPos pos = event.getPos();

        player.sendSystemMessage(
                Component.literal("LOOK UP")
                        .setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xFF0000)).withBold(true))
        );

        LargeFireball fireball = new LargeFireball(level, player, 0, -1, 0, 4);
        fireball.setPos(pos.getX() + 0.5, pos.getY() + 30, pos.getZ() + 0.5);
        level.addFreshEntity(fireball);

        AttributeInstance maxHealth = player.getAttribute(Attributes.MAX_HEALTH);
        if (maxHealth != null) {

            if (maxHealth.getModifier(HEART_STEAL_UUID) != null) {
                maxHealth.removeModifier(HEART_STEAL_UUID);
            }

            AttributeModifier modifier = new AttributeModifier(
                    HEART_STEAL_UUID,
                    "kissy_missy_heart_steal",
                    -2.0,
                    AttributeModifier.Operation.ADDITION
            );

            maxHealth.addPermanentModifier(modifier);

            if (player.getHealth() > player.getMaxHealth()) {
                player.setHealth(player.getMaxHealth());
            }
        }
    }
}