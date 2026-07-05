package net.mcreator.boss.abilities.prototype_arena;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.UUID;

@Mod.EventBusSubscriber(modid = "boss")
public class PrototypeReachHandler {

    private static final UUID BLOCK_REACH_UUID =
            UUID.fromString("b2c8a4f0-3d6e-4b9a-8d12-9a1122334455");

    private static final UUID ENTITY_REACH_UUID =
            UUID.fromString("c3d9a5e1-4f7a-5c8b-9e21-8b2233445566");

    private static final double BONUS_REACH = 20.0;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        if (event.phase != TickEvent.Phase.END) return;

        Player player = event.player;
        if (player.level().isClientSide) return;

        ItemStack stack = player.getMainHandItem();
        boolean holding = stack.getItem().toString().contains("prototypeitem");

        AttributeInstance blockReach =
                player.getAttribute(ForgeMod.BLOCK_REACH.get());

        AttributeInstance entityReach =
                player.getAttribute(ForgeMod.ENTITY_REACH.get());

        if (blockReach == null || entityReach == null) return;

        if (holding) {

            if (blockReach.getModifier(BLOCK_REACH_UUID) == null) {
                blockReach.addPermanentModifier(new AttributeModifier(
                        BLOCK_REACH_UUID,
                        "prototype_block_reach",
                        BONUS_REACH,
                        AttributeModifier.Operation.ADDITION
                ));
            }

            if (entityReach.getModifier(ENTITY_REACH_UUID) == null) {
                entityReach.addPermanentModifier(new AttributeModifier(
                        ENTITY_REACH_UUID,
                        "prototype_entity_reach",
                        BONUS_REACH,
                        AttributeModifier.Operation.ADDITION
                ));
            }

        } else {

            if (blockReach.getModifier(BLOCK_REACH_UUID) != null) {
                blockReach.removeModifier(BLOCK_REACH_UUID);
            }

            if (entityReach.getModifier(ENTITY_REACH_UUID) != null) {
                entityReach.removeModifier(ENTITY_REACH_UUID);
            }
        }
    }
}