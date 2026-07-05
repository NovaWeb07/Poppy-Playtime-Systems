
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.boss.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.boss.block.TvBlockBlock;
import net.mcreator.boss.BossMod;

public class BossModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, BossMod.MODID);
	public static final RegistryObject<Block> TV_BLOCK = REGISTRY.register("tv_block", () -> new TvBlockBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
