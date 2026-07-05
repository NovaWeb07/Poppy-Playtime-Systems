package com.poppyplaytime.systems.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.poppyplaytime.systems.block.model.TvBlockModel;
import com.poppyplaytime.systems.block.entity.TvBlockEntity;

public class TvBlockEntityRenderer extends GeoBlockRenderer<TvBlockEntity> {
	public TvBlockEntityRenderer() {
		super(new TvBlockModel());
	}

	@Override
	public RenderType getRenderType(TvBlockEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
