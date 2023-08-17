// Import necessary classes and packages
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

// Custom provider for defining block loot tables
public class BMMBlockLootTables extends BlockLootSubProvider {
    public BMMBlockLootTables() {
        // Initialize the provider with an empty set of known blocks and all feature flags
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        // Define the loot drop for the SALT_BLOCK
        add(BMMBlocks.SALT_BLOCK.get(), (block) ->
                // Create an ore drop with the specified items and set item count function
                createOreDrop(BMMBlocks.SALT_BLOCK.get(), BMMItems.SALT.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        // Retrieve all blocks registered in the BMMBlocks.BLOCKS deferred register
        return BMMBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}