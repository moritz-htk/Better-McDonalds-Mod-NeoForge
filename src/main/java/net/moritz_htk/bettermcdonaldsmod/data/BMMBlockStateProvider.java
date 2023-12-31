// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;
import net.moritz_htk.bettermcdonaldsmod.block.BMMBlocks;
import net.moritz_htk.bettermcdonaldsmod.block.custom.LettuceCropBlock;
import net.moritz_htk.bettermcdonaldsmod.block.custom.TomatoCropBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.function.Function;

// Custom block state provider for defining block states and models
public class BMMBlockStateProvider extends BlockStateProvider {
    public BMMBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        // Initialize the block state provider with the output location, mod ID, and existing file helper
        super(output, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Define block states and models for the custom blocks
        simpleBlockWithItem(BMMBlocks.SALT_BLOCK.get(), cubeAll(BMMBlocks.SALT_BLOCK.get()));
        makeTomatoCrop((TomatoCropBlock) BMMBlocks.TOMATO_CROP.get(), "tomato_stage", "tomato_stage");
        makeLettuceCrop((LettuceCropBlock) BMMBlocks.LETTUCE_CROP.get(), "lettuce_stage", "lettuce_stage");
    }

    public void makeTomatoCrop(CropBlock block, String modelName, String textureName) {
        // Define block states and models for the tomato crop block
        Function<BlockState, ConfiguredModel[]> function = state -> tomatoCropStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] tomatoCropStates(BlockState state, CropBlock block, String modelName, String textureName) {
        // Define configured models for different growth stages of the tomato crop
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((TomatoCropBlock) block).getAgeProperty()), new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "block/" + textureName + state.getValue(((TomatoCropBlock) block).getAgeProperty()))).renderType("cutout"));
        return models;
    }

    public void makeLettuceCrop(CropBlock block, String modelName, String textureName) {
        // Define block states and models for the lettuce crop block
        Function<BlockState, ConfiguredModel[]> function = state -> lettuceCropStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] lettuceCropStates(BlockState state, CropBlock block, String modelName, String textureName) {
        // Define configured models for different growth stages of the lettuce crop
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((LettuceCropBlock) block).getAgeProperty()), new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "block/" + textureName + state.getValue(((LettuceCropBlock) block).getAgeProperty()))).renderType("cutout"));
        return models;
    }
}