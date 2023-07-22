package net.moritz_htk.bettermcdonaldsmod.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;

import java.util.List;

public class BMMPlacedFeatures {
    public static final ResourceKey<PlacedFeature> SALT_BLOCK_PLACED_KEY = createKey();

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, configuredFeatures.getOrThrow(BMMConfiguredFeatures.SALT_BLOCK_KEY), BMMDiskPlacement.modifiers(CountPlacement.of(2), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.OCEAN_FLOOR_WG), BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)), BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> createKey() {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "salt_block_placed"));
    }

    private static void register(BootstapContext<PlacedFeature> context, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(BMMPlacedFeatures.SALT_BLOCK_PLACED_KEY, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}