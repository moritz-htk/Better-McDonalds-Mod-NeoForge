// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.moritz_htk.bettermcdonaldsmod.block.BMMBlocks;
import net.moritz_htk.bettermcdonaldsmod.block.custom.LettuceCropBlock;
import net.moritz_htk.bettermcdonaldsmod.block.custom.TomatoCropBlock;
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

        // Define the loot conditions for fully grown TOMATO_CROP
        LootItemCondition.Builder tomatoConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BMMBlocks.TOMATO_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(TomatoCropBlock.AGE, 3));

        // Add loot drops for fully grown TOMATO_CROP
        add(BMMBlocks.TOMATO_CROP.get(), createCropDrops(BMMBlocks.TOMATO_CROP.get(), BMMItems.TOMATO.get(), BMMItems.TOMATO_SEEDS.get(), tomatoConditionBuilder));

        // Define the loot conditions for fully grown LETTUCE_CROP
        LootItemCondition.Builder lettuceConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(BMMBlocks.LETTUCE_CROP.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LettuceCropBlock.AGE, 3));

        // Add loot drops for fully grown LETTUCE_CROP
        add(BMMBlocks.LETTUCE_CROP.get(), createCropDrops(BMMBlocks.LETTUCE_CROP.get(), BMMItems.LETTUCE.get(), BMMItems.LETTUCE_SEEDS.get(), lettuceConditionBuilder));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        // Retrieve all blocks registered in the BMMBlocks.BLOCKS deferred register
        return BMMBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}