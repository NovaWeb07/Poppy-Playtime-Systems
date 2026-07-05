
package com.poppyplaytime.systems.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import com.poppyplaytime.systems.block.entity.TvBlockEntity;
import com.poppyplaytime.systems.PoppyPlaytimeSystems;

public class ModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, PoppyPlaytimeSystems.MODID);
	public static final RegistryObject<BlockEntityType<TvBlockEntity>> TV_BLOCK = REGISTRY.register("tv_block", () -> BlockEntityType.Builder.of(TvBlockEntity::new, ModBlocks.TV_BLOCK.get()).build(null));

			private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
