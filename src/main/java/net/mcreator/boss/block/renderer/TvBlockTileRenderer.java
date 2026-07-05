package net.mcreator.boss.block.renderer;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.boss.block.model.TvBlockBlockModel;
import net.mcreator.boss.block.entity.TvBlockTileEntity;

public class TvBlockTileRenderer extends GeoBlockRenderer<TvBlockTileEntity> {
	public TvBlockTileRenderer() {
		super(new TvBlockBlockModel());
	}

	@Override
	public RenderType getRenderType(TvBlockTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
