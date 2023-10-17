// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
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
        // Define loot modifiers for seeds obtained from grass and fern blocks
        addLootModifier("tomato_seeds_from_grass", Blocks.GRASS, BMMItems.TOMATO_SEEDS.get());
        addLootModifier("tomato_seeds_from_fern", Blocks.FERN, BMMItems.TOMATO_SEEDS.get());
        addLootModifier("lettuce_seeds_from_grass", Blocks.GRASS, BMMItems.LETTUCE_SEEDS.get());
        addLootModifier("lettuce_seeds_from_fern", Blocks.FERN, BMMItems.LETTUCE_SEEDS.get());
    }

    private void addLootModifier(String name, Block block, Item item) {
        // Define loot conditions to trigger the loot modifier
        LootItemCondition[] conditions = new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).build(),
                LootItemRandomChanceCondition.randomChance(0.15f).build()
        };

        // Define loot conditions to trigger the loot modifier
        add(name, new AddItemModifier(conditions, item));
    }
}