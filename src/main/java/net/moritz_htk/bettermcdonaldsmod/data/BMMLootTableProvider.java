// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.data;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.moritz_htk.bettermcdonaldsmod.loot.BMMBlockLootTables;

import java.util.List;
import java.util.Set;

public class BMMLootTableProvider {
    // Create a method to create a LootTableProvider instance
    public static LootTableProvider create(PackOutput output) {
        // Return a new instance of LootTableProvider with defined subproviders
        return new LootTableProvider(
                output, // Pack output location
                Set.of(), // A set of namespace prefixes
                List.of(new LootTableProvider.SubProviderEntry(
                        BMMBlockLootTables::new, // The subprovider class for block loot tables
                        LootContextParamSets.BLOCK // The context parameter set (in this case, for blocks)
                        )));
    }
}