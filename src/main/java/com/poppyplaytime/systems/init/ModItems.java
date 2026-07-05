
package com.poppyplaytime.systems.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import com.poppyplaytime.systems.item.PrototypeItem;
import com.poppyplaytime.systems.item.PlayerHandItem;
import com.poppyplaytime.systems.item.MommyItem;
import com.poppyplaytime.systems.block.display.TvBlockDisplayItem;
import com.poppyplaytime.systems.PoppyPlaytimeSystems;

public class ModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, PoppyPlaytimeSystems.MODID);
	public static final RegistryObject<Item> CARROT_WOLF_SPAWN_EGG = REGISTRY.register("carrot_wolf_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.CARROT_WOLF, -16711732, -13261, new Item.Properties()));
	public static final RegistryObject<Item> DOLL_POPPY_SPAWN_EGG = REGISTRY.register("doll_poppy_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.DOLL_POPPY, -65434, -16776961, new Item.Properties()));
	public static final RegistryObject<Item> CATNAP_SPAWN_EGG = REGISTRY.register("catnap_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.CATNAP, -3381505, -10092340, new Item.Properties()));
	public static final RegistryObject<Item> DOGDAY_SPAWN_EGG = REGISTRY.register("dogday_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.DOGDAY, -10092544, -6737152, new Item.Properties()));
	public static final RegistryObject<Item> HUGGY_WUGGY_SPAWN_EGG = REGISTRY.register("huggy_wuggy_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.HUGGY_WUGGY, -16737844, -16724737, new Item.Properties()));
	public static final RegistryObject<Item> MOMMYITEM = REGISTRY.register("mommyitem", () -> new MommyItem());
	public static final RegistryObject<Item> KISSY_MISSY_SPAWN_EGG = REGISTRY.register("kissy_missy_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.KISSY_MISSY, -3407668, -52225, new Item.Properties()));
	public static final RegistryObject<Item> MOMMY_SPAWN_EGG = REGISTRY.register("mommy_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.MOMMY, -3407668, -26113, new Item.Properties()));
	public static final RegistryObject<Item> PROTOTYPE_SPAWN_EGG = REGISTRY.register("prototype_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.PROTOTYPE, -16763905, -6710887, new Item.Properties()));
	public static final RegistryObject<Item> PROTOTYPEITEM = REGISTRY.register("prototypeitem", () -> new PrototypeItem());
	public static final RegistryObject<Item> PLAYER_HAND = REGISTRY.register("player_hand", () -> new PlayerHandItem());
	public static final RegistryObject<Item> TV_BLOCK = REGISTRY.register(ModBlocks.TV_BLOCK.getId().getPath(), () -> new TvBlockDisplayItem(ModBlocks.TV_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> YARNA_BY_SPAWN_EGG = REGISTRY.register("yarna_by_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.YARNA_BY, -26317, -39424, new Item.Properties()));
		}
