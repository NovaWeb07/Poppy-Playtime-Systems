package net.mcreator.boss.abilities.quicksand;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.PowderSnowBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;

public class QuicksandConcreteBlock extends PowderSnowBlock {

    public QuicksandConcreteBlock() {
        super(Properties.copy(Blocks.POWDER_SNOW));
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {

        entity.setDeltaMovement(entity.getDeltaMovement().multiply(0.1, 0.0, 0.1));

        if (!level.isClientSide) {

            double ultraUltraSlow = -0.00000000001;

            entity.setDeltaMovement(
                    entity.getDeltaMovement().x,
                    ultraUltraSlow,
                    entity.getDeltaMovement().z
            );
        }

        if (entity instanceof Player player) {
            player.setTicksFrozen(0);
            player.fallDistance = 0;
        }
    }
}