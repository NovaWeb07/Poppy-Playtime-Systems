
package com.poppyplaytime.systems.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import com.poppyplaytime.systems.client.renderer.YarnaByRenderer;
import com.poppyplaytime.systems.client.renderer.PrototypeRenderer;
import com.poppyplaytime.systems.client.renderer.MommyRenderer;
import com.poppyplaytime.systems.client.renderer.KissyMissyRenderer;
import com.poppyplaytime.systems.client.renderer.HuggyWuggyRenderer;
import com.poppyplaytime.systems.client.renderer.DollPoppyRenderer;
import com.poppyplaytime.systems.client.renderer.DogdayRenderer;
import com.poppyplaytime.systems.client.renderer.CatnapRenderer;
import com.poppyplaytime.systems.client.renderer.CarrotWolfRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ModEntities.CARROT_WOLF.get(), CarrotWolfRenderer::new);
		event.registerEntityRenderer(ModEntities.DOLL_POPPY.get(), DollPoppyRenderer::new);
		event.registerEntityRenderer(ModEntities.CATNAP.get(), CatnapRenderer::new);
		event.registerEntityRenderer(ModEntities.DOGDAY.get(), DogdayRenderer::new);
		event.registerEntityRenderer(ModEntities.HUGGY_WUGGY.get(), HuggyWuggyRenderer::new);
		event.registerEntityRenderer(ModEntities.KISSY_MISSY.get(), KissyMissyRenderer::new);
		event.registerEntityRenderer(ModEntities.MOMMY.get(), MommyRenderer::new);
		event.registerEntityRenderer(ModEntities.PROTOTYPE.get(), PrototypeRenderer::new);
		event.registerEntityRenderer(ModEntities.YARNA_BY.get(), YarnaByRenderer::new);
	}
}
