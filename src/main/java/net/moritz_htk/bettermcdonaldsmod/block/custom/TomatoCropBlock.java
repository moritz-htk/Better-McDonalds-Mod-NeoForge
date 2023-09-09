// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.block.custom;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.moritz_htk.bettermcdonaldsmod.item.BMMItems;

public class TomatoCropBlock extends CropBlock {
    // Define the maximum age of the tomato crop
    public static final int MAX_AGE = 3;

    // Define a property to represent the age of the crop
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 3);

    public TomatoCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        // Return the seed item for this crop
        return BMMItems.TOMATO_SEEDS.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        // Return the property that represents the age of the crop
        return AGE;
    }

    @Override
    public int getMaxAge() {
        // Return the maximum age the crop can reach
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockStateBuilder) {
        // Define the block's state properties
        blockStateBuilder.add(AGE);
    }
}