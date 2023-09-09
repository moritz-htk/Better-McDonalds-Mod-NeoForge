// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;
import net.moritz_htk.bettermcdonaldsmod.item.BMMItems;
import net.moritz_htk.bettermcdonaldsmod.loot.AddItemModifier;

// Custom global loot modifier provider for generating loot modifiers
public class BMMGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public BMMGlobalLootModifierProvider(PackOutput output) {
        // Initialize the global loot modifier provider with the mod's output and ID
        super(output, BetterMcDonaldsMod.MOD_ID);
    }

    @Override
    protected void start() {
        // Define loot modifiers for tomato seeds dropping from grass and fern blocks
        add("tomato_seeds_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()
        }, BMMItems.TOMATO_SEEDS.get()));

        add("tomato_seeds_from_fern", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.FERN).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()
        }, BMMItems.TOMATO_SEEDS.get()));

        // Define loot modifiers for lettuce seeds dropping from grass and fern blocks
        add("lettuce_seeds_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()
        }, BMMItems.LETTUCE_SEEDS.get()));

        add("lettuce_seeds_from_fern", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.FERN).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()
        }, BMMItems.LETTUCE_SEEDS.get()));
    }
}