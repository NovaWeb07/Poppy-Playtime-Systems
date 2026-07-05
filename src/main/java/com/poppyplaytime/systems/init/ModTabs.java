
package com.poppyplaytime.systems.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import com.poppyplaytime.systems.PoppyPlaytimeSystems;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PoppyPlaytimeSystems.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(ModItems.CARROT_WOLF_SPAWN_EGG.get());
			tabData.accept(ModItems.DOLL_POPPY_SPAWN_EGG.get());
			tabData.accept(ModItems.CATNAP_SPAWN_EGG.get());
			tabData.accept(ModItems.DOGDAY_SPAWN_EGG.get());
			tabData.accept(ModItems.HUGGY_WUGGY_SPAWN_EGG.get());
			tabData.accept(ModItems.MOMMYITEM.get());
			tabData.accept(ModItems.KISSY_MISSY_SPAWN_EGG.get());
			tabData.accept(ModItems.MOMMY_SPAWN_EGG.get());
			tabData.accept(ModItems.PROTOTYPE_SPAWN_EGG.get());
			tabData.accept(ModItems.PROTOTYPEITEM.get());
			tabData.accept(ModItems.PLAYER_HAND.get());
			tabData.accept(ModBlocks.TV_BLOCK.get().asItem());
			tabData.accept(ModItems.YARNA_BY_SPAWN_EGG.get());
		}
	}
}
