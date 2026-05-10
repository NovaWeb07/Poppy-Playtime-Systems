
package net.mcreator.boss.abilities.quicksand;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class QuicksandRegistry {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, "boss");

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "boss");

    public static final RegistryObject<Block> QUICKSAND_YELLOW =
            BLOCKS.register("quicksand_yellow", QuicksandConcreteBlock::new);

    public static final RegistryObject<Block> QUICKSAND_RED =
            BLOCKS.register("quicksand_red", QuicksandConcreteBlock::new);

    public static final RegistryObject<Block> QUICKSAND_BLUE =
            BLOCKS.register("quicksand_blue", QuicksandConcreteBlock::new);

    public static final RegistryObject<Block> QUICKSAND_LIGHT_BLUE =
            BLOCKS.register("quicksand_light_blue", QuicksandConcreteBlock::new);

    public static final RegistryObject<Item> QUICKSAND_YELLOW_ITEM =
            ITEMS.register("quicksand_yellow",
                    () -> new BlockItem(QUICKSAND_YELLOW.get(), new Item.Properties()));

    public static final RegistryObject<Item> QUICKSAND_RED_ITEM =
            ITEMS.register("quicksand_red",
                    () -> new BlockItem(QUICKSAND_RED.get(), new Item.Properties()));

    public static final RegistryObject<Item> QUICKSAND_BLUE_ITEM =
            ITEMS.register("quicksand_blue",
                    () -> new BlockItem(QUICKSAND_BLUE.get(), new Item.Properties()));

    public static final RegistryObject<Item> QUICKSAND_LIGHT_BLUE_ITEM =
            ITEMS.register("quicksand_light_blue",
                    () -> new BlockItem(QUICKSAND_LIGHT_BLUE.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}
