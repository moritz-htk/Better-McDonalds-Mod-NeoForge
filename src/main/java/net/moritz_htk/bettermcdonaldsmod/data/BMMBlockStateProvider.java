package net.moritz_htk.bettermcdonaldsmod.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;
import net.moritz_htk.bettermcdonaldsmod.block.BMMBlocks;

public class BMMBlockStateProvider extends BlockStateProvider {
    public BMMBlockStateProvider(PackOutput output,  ExistingFileHelper exFileHelper) {
        super(output, BetterMcDonaldsMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(BMMBlocks.SALT_BLOCK.get(), cubeAll(BMMBlocks.SALT_BLOCK.get()));
    }
}