package net.moritz_htk.bettermcdonaldsmod.data;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.moritz_htk.bettermcdonaldsmod.block.BMMBlocks;
import net.moritz_htk.bettermcdonaldsmod.item.BMMItems;

import java.util.Set;

public class BMMBlockLootTables extends BlockLootSubProvider {
    public BMMBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        add(BMMBlocks.SALT_BLOCK.get(), (block) -> createOreDrop(BMMBlocks.SALT_BLOCK.get(), BMMItems.SALT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BMMBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}