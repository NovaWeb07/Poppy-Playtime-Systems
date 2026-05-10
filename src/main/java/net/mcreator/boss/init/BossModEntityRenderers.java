
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.boss.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.boss.client.renderer.YarnaByRenderer;
import net.mcreator.boss.client.renderer.PrototypeRenderer;
import net.mcreator.boss.client.renderer.MommyRenderer;
import net.mcreator.boss.client.renderer.KissyMissyRenderer;
import net.mcreator.boss.client.renderer.HuggyWuggyRenderer;
import net.mcreator.boss.client.renderer.DollPoppyRenderer;
import net.mcreator.boss.client.renderer.DogdayRenderer;
import net.mcreator.boss.client.renderer.CatnapRenderer;
import net.mcreator.boss.client.renderer.CarrotWolfRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BossModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(BossModEntities.CARROT_WOLF.get(), CarrotWolfRenderer::new);
		event.registerEntityRenderer(BossModEntities.DOLL_POPPY.get(), DollPoppyRenderer::new);
		event.registerEntityRenderer(BossModEntities.CATNAP.get(), CatnapRenderer::new);
		event.registerEntityRenderer(BossModEntities.DOGDAY.get(), DogdayRenderer::new);
		event.registerEntityRenderer(BossModEntities.HUGGY_WUGGY.get(), HuggyWuggyRenderer::new);
		event.registerEntityRenderer(BossModEntities.KISSY_MISSY.get(), KissyMissyRenderer::new);
		event.registerEntityRenderer(BossModEntities.MOMMY.get(), MommyRenderer::new);
		event.registerEntityRenderer(BossModEntities.PROTOTYPE.get(), PrototypeRenderer::new);
		event.registerEntityRenderer(BossModEntities.YARNA_BY.get(), YarnaByRenderer::new);
	}
}
