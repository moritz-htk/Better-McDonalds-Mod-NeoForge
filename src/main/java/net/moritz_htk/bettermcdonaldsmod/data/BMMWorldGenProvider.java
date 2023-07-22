package net.moritz_htk.bettermcdonaldsmod.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;
import net.moritz_htk.bettermcdonaldsmod.worldgen.BMMConfiguredFeatures;
import net.moritz_htk.bettermcdonaldsmod.worldgen.BMMPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class BMMWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, BMMConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, BMMPlacedFeatures::bootstrap);

    public BMMWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(BetterMcDonaldsMod.MOD_ID));
    }
}