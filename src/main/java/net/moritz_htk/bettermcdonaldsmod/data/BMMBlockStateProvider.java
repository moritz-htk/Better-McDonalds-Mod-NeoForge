// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;
import net.moritz_htk.bettermcdonaldsmod.block.BMMBlocks;

// Custom block state provider for defining block states and models
public class BMMBlockStateProvider extends BlockStateProvider {
    public BMMBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        // Initialize the block state provider with the output location, mod ID, and existing file helper
        super(output, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Define the block state and model for the SALT_BLOCK
        simpleBlockWithItem(BMMBlocks.SALT_BLOCK.get(), cubeAll(BMMBlocks.SALT_BLOCK.get()));
    }
}