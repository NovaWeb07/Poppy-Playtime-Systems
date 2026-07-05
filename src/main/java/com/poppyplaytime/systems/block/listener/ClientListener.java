package com.poppyplaytime.systems.block.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import com.poppyplaytime.systems.init.ModBlockEntities;
import com.poppyplaytime.systems.block.renderer.TvBlockEntityRenderer;
import com.poppyplaytime.systems.PoppyPlaytimeSystems;

@Mod.EventBusSubscriber(modid = PoppyPlaytimeSystems.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ModBlockEntities.TV_BLOCK.get(), context -> new TvBlockEntityRenderer());
	}
}
