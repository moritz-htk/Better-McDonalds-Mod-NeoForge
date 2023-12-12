// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;

import java.util.concurrent.CompletableFuture;

// Class for gathering data during mod data generation
@Mod.EventBusSubscriber(modid = BetterMcDonaldsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BMMDataGenerators {
    // Method to gather data during data generation
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        // Obtain required instances from the GatherDataEvent
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Add various data providers to the generator
        generator.addProvider(true, new BMMItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(true, new BMMBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(true, new BMMTagProvider.Blocks(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(true, new BMMTagProvider.Items(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(true, new BMMRecipeProvider(packOutput));
        generator.addProvider(true, BMMLootTableProvider.create(packOutput));
        generator.addProvider(true, new BMMWorldGenProvider(packOutput, lookupProvider));
        generator.addProvider(true, new BMMAdvancementProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(true, new BMMGlobalLootModifierProvider(packOutput));
    }
}