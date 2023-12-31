// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;
import net.moritz_htk.bettermcdonaldsmod.worldgen.BMMConfiguredFeatures;
import net.moritz_htk.bettermcdonaldsmod.worldgen.BMMPlacedFeatures;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

// Definition of the WorldGenProvider class for world generation data
public class BMMWorldGenProvider extends DatapackBuiltinEntriesProvider {
    // Definition of a registry set builder for configured and placed features
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, BMMConfiguredFeatures::bootstrap).add(Registries.PLACED_FEATURE, BMMPlacedFeatures::bootstrap);

    // Constructor for the WorldGenProvider class
    public BMMWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        // Calling the constructor of the parent class with relevant parameters
        super(output, registries, BUILDER, Set.of(BetterMcDonaldsMod.MOD_ID));
    }
}