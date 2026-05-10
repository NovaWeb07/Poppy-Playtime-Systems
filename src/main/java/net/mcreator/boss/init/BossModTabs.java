
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.boss.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.boss.BossMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BossModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BossMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(BossModItems.CARROT_WOLF_SPAWN_EGG.get());
			tabData.accept(BossModItems.DOLL_POPPY_SPAWN_EGG.get());
			tabData.accept(BossModItems.CATNAP_SPAWN_EGG.get());
			tabData.accept(BossModItems.DOGDAY_SPAWN_EGG.get());
			tabData.accept(BossModItems.HUGGY_WUGGY_SPAWN_EGG.get());
			tabData.accept(BossModItems.MOMMYITEM.get());
			tabData.accept(BossModItems.KISSY_MISSY_SPAWN_EGG.get());
			tabData.accept(BossModItems.MOMMY_SPAWN_EGG.get());
			tabData.accept(BossModItems.PROTOTYPE_SPAWN_EGG.get());
			tabData.accept(BossModItems.PROTOTYPEITEM.get());
			tabData.accept(BossModItems.PLAYER_HAND.get());
			tabData.accept(BossModBlocks.TV_BLOCK.get().asItem());
			tabData.accept(BossModItems.YARNA_BY_SPAWN_EGG.get());
		}
	}
}
