
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.boss.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.item.Item;

import net.mcreator.boss.item.PrototypeitemItem;
import net.mcreator.boss.item.PlayerHandItem;
import net.mcreator.boss.item.MommyitemItem;
import net.mcreator.boss.block.display.TvBlockDisplayItem;
import net.mcreator.boss.BossMod;

public class BossModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BossMod.MODID);
	public static final RegistryObject<Item> CARROT_WOLF_SPAWN_EGG = REGISTRY.register("carrot_wolf_spawn_egg", () -> new ForgeSpawnEggItem(BossModEntities.CARROT_WOLF, -16711732, -13261, new Item.Properties()));
	public static final RegistryObject<Item> DOLL_POPPY_SPAWN_EGG = REGISTRY.register("doll_poppy_spawn_egg", () -> new ForgeSpawnEggItem(BossModEntities.DOLL_POPPY, -65434, -16776961, new Item.Properties()));
	public static final RegistryObject<Item> CATNAP_SPAWN_EGG = REGISTRY.register("catnap_spawn_egg", () -> new ForgeSpawnEggItem(BossModEntities.CATNAP, -3381505, -10092340, new Item.Properties()));
	public static final RegistryObject<Item> DOGDAY_SPAWN_EGG = REGISTRY.register("dogday_spawn_egg", () -> new ForgeSpawnEggItem(BossModEntities.DOGDAY, -10092544, -6737152, new Item.Properties()));
	public static final RegistryObject<Item> HUGGY_WUGGY_SPAWN_EGG = REGISTRY.register("huggy_wuggy_spawn_egg", () -> new ForgeSpawnEggItem(BossModEntities.HUGGY_WUGGY, -16737844, -16724737, new Item.Properties()));
	public static final RegistryObject<Item> MOMMYITEM = REGISTRY.register("mommyitem", () -> new MommyitemItem());
	public static final RegistryObject<Item> KISSY_MISSY_SPAWN_EGG = REGISTRY.register("kissy_missy_spawn_egg", () -> new ForgeSpawnEggItem(BossModEntities.KISSY_MISSY, -3407668, -52225, new Item.Properties()));
	public static final RegistryObject<Item> MOMMY_SPAWN_EGG = REGISTRY.register("mommy_spawn_egg", () -> new ForgeSpawnEggItem(BossModEntities.MOMMY, -3407668, -26113, new Item.Properties()));
	public static final RegistryObject<Item> PROTOTYPE_SPAWN_EGG = REGISTRY.register("prototype_spawn_egg", () -> new ForgeSpawnEggItem(BossModEntities.PROTOTYPE, -16763905, -6710887, new Item.Properties()));
	public static final RegistryObject<Item> PROTOTYPEITEM = REGISTRY.register("prototypeitem", () -> new PrototypeitemItem());
	public static final RegistryObject<Item> PLAYER_HAND = REGISTRY.register("player_hand", () -> new PlayerHandItem());
	public static final RegistryObject<Item> TV_BLOCK = REGISTRY.register(BossModBlocks.TV_BLOCK.getId().getPath(), () -> new TvBlockDisplayItem(BossModBlocks.TV_BLOCK.get(), new Item.Properties()));
	public static final RegistryObject<Item> YARNA_BY_SPAWN_EGG = REGISTRY.register("yarna_by_spawn_egg", () -> new ForgeSpawnEggItem(BossModEntities.YARNA_BY, -26317, -39424, new Item.Properties()));
	// Start of user code block custom items
	// End of user code block custom items
}
