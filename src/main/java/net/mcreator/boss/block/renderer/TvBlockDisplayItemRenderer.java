package net.mcreator.boss.block.renderer;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.boss.block.model.TvBlockDisplayModel;
import net.mcreator.boss.block.display.TvBlockDisplayItem;

public class TvBlockDisplayItemRenderer extends GeoItemRenderer<TvBlockDisplayItem> {
	public TvBlockDisplayItemRenderer() {
		super(new TvBlockDisplayModel());
	}

	@Override
	public RenderType getRenderType(TvBlockDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
