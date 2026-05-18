package keletu.pvzmod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Sofa extends HorizontalDirectionalBlock {
    protected static final VoxelShape BASE_AABB = Block.box(0.0D, 4.0D, 0.0D, 16.0D, 10.0D, 16.0D);

    protected static final VoxelShape UP_WEST_AABB = Block.box(0.0D, 10.0D, 10.0D, 16.0D, 21.0D, 16.0D);

    protected static final VoxelShape UP_EAST_AABB = Block.box(0.0D, 10.0D, 0.0D, 16.0D, 21.0D, 6.0D);

    protected static final VoxelShape UP_NORTH_AABB = Block.box(10.0D, 10.0D, 0.0D, 16.0D, 21.0D, 16.0D);

    protected static final VoxelShape UP_SOUTH_AABB = Block.box(0.0D, 10.0D, 0.0D, 6.0D, 21.0D, 16.0D);

    public Sofa(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(FACING) == Direction.SOUTH ? Shapes.or(UP_EAST_AABB, BASE_AABB) :
                pState.getValue(FACING) == Direction.EAST ? Shapes.or(UP_SOUTH_AABB, BASE_AABB) :
                        pState.getValue(FACING) == Direction.WEST ? Shapes.or(UP_NORTH_AABB, BASE_AABB) :
                                Shapes.or(UP_WEST_AABB, BASE_AABB);
    }

    @Override
    public BlockState getStateForPlacement(net.minecraft.world.item.context.BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }
}
