
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.boss.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.boss.block.entity.TvBlockTileEntity;
import net.mcreator.boss.BossMod;

public class BossModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BossMod.MODID);
	public static final RegistryObject<BlockEntityType<TvBlockTileEntity>> TV_BLOCK = REGISTRY.register("tv_block", () -> BlockEntityType.Builder.of(TvBlockTileEntity::new, BossModBlocks.TV_BLOCK.get()).build(null));

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
