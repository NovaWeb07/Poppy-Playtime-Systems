package net.mcreator.boss.block.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.boss.init.BossModBlockEntities;
import net.mcreator.boss.block.renderer.TvBlockTileRenderer;
import net.mcreator.boss.BossMod;

@Mod.EventBusSubscriber(modid = BossMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(BossModBlockEntities.TV_BLOCK.get(), context -> new TvBlockTileRenderer());
	}
}
