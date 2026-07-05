package net.mcreator.boss.block.model;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.boss.block.entity.TvBlockTileEntity;

public class TvBlockBlockModel extends GeoModel<TvBlockTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(TvBlockTileEntity animatable) {
		return new ResourceLocation("boss", "animations/kissy_missy_poppy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TvBlockTileEntity animatable) {
		return new ResourceLocation("boss", "geo/kissy_missy_poppy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TvBlockTileEntity animatable) {
		return new ResourceLocation("boss", "textures/block/kissy_missy_poppy.png");
	}
}
