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

@Mod.EventBusSubscriber(modid = BetterMcDonaldsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BMMDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new BMMItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(true, new BMMBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(true, new BMMTagProvider.Blocks(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(true, new BMMTagProvider.Items(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(true, new BMMRecipeProvider(packOutput));
        generator.addProvider(true, BMMLootTableProvider.create(packOutput));
        generator.addProvider(true, new BMMWorldGenProvider(packOutput, lookupProvider));
    }
}