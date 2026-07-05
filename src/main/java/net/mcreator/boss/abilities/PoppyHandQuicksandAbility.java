package net.mcreator.boss.abilities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.mcreator.boss.abilities.quicksand.QuicksandRegistry;

import java.util.Random;

@Mod.EventBusSubscriber(modid = "boss", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PoppyHandQuicksandAbility {

    private static final Random random = new Random();
    private static final int RADIUS = 4;

    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickBlock event) {

        Player player = event.getEntity();
        Level level = player.level();
        ItemStack stack = player.getItemInHand(event.getHand());

        if (level.isClientSide) return;

        if (!BuiltInRegistries.ITEM.getKey(stack.getItem())
                .equals(new ResourceLocation("boss", "player_hand"))) return;

        BlockPos center = event.getPos();

        for (int x = -RADIUS; x <= RADIUS; x++) {
            for (int z = -RADIUS; z <= RADIUS; z++) {

                BlockPos pos = center.offset(x, 0, z);

                int r = random.nextInt(4);

                switch (r) {
                    case 0 -> level.setBlock(pos,
                            QuicksandRegistry.QUICKSAND_YELLOW.get().defaultBlockState(), 3);
                    case 1 -> level.setBlock(pos,
                            QuicksandRegistry.QUICKSAND_RED.get().defaultBlockState(), 3);
                    case 2 -> level.setBlock(pos,
                            QuicksandRegistry.QUICKSAND_BLUE.get().defaultBlockState(), 3);
                    case 3 -> level.setBlock(pos,
                            QuicksandRegistry.QUICKSAND_LIGHT_BLUE.get().defaultBlockState(), 3);
                }

                if (Math.abs(x) <= 1 && Math.abs(z) <= 1) {

                    BlockPos posBelow = pos.below();

                    switch (r) {
                        case 0 -> level.setBlock(posBelow,
                                QuicksandRegistry.QUICKSAND_YELLOW.get().defaultBlockState(), 3);
                        case 1 -> level.setBlock(posBelow,
                                QuicksandRegistry.QUICKSAND_RED.get().defaultBlockState(), 3);
                        case 2 -> level.setBlock(posBelow,
                                QuicksandRegistry.QUICKSAND_BLUE.get().defaultBlockState(), 3);
                        case 3 -> level.setBlock(posBelow,
                                QuicksandRegistry.QUICKSAND_LIGHT_BLUE.get().defaultBlockState(), 3);
                    }
                }
            }
        }
    }
}