package net.blay09.mods.waystones.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class WarpPlateBlock extends Block {

    private static final VoxelShape SHAPE = VoxelShapes.or(
            makeCuboidShape(0.0, 0.0, 0.0, 16.0, 1.0, 16.0),
            makeCuboidShape(3.0, 1.0, 3.0, 13.0, 2.0, 13.0)
    ).simplify();

    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public WarpPlateBlock() {
        super(Properties.create(Material.ROCK).sound(SoundType.STONE).hardnessAndResistance(5f, 2000f));
        this.setDefaultState(this.stateContainer.getBaseState().with(WATERLOGGED, false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}