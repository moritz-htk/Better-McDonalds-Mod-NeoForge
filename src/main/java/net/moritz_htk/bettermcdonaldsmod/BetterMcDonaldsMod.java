// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod;

import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.moritz_htk.bettermcdonaldsmod.block.BMMBlocks;
import net.moritz_htk.bettermcdonaldsmod.item.BMMCreativeModeTabs;
import net.moritz_htk.bettermcdonaldsmod.item.BMMItems;
import net.moritz_htk.bettermcdonaldsmod.loot.BMMLootModifiers;

// Declare the mod as a NeoForge mod with the specified mod ID
@Mod(BetterMcDonaldsMod.MOD_ID)
public class BetterMcDonaldsMod {
    public static final String MOD_ID = "bettermcdonaldsmod";

    // Constructor for the mod class
    public BetterMcDonaldsMod() {
        // Get the mod event bus
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register creative mode tab, blocks, and items on the event bus
        BMMCreativeModeTabs.register(modEventBus);
        BMMBlocks.register(modEventBus);
        BMMItems.register(modEventBus);
        BMMLootModifiers.register(modEventBus);

        // Register this mod class as a listener for MinecraftForge events
        MinecraftForge.EVENT_BUS.register(this);

        // Add a listener for the FMLCommonSetupEvent and BuildCreativeModeTabContentsEvent
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
    }

    // Event listener method to configure some aspects of the mod
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // Configure ComposterBlock to accept certain items for composting
            ComposterBlock.COMPOSTABLES.put(BMMItems.TOMATO.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(BMMItems.TOMATO_SEEDS.get(), 0.2f);
            ComposterBlock.COMPOSTABLES.put(BMMItems.LETTUCE.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(BMMItems.LETTUCE_SEEDS.get(), 0.2f);
        });
    }

    // Event listener method for adding items to creative mode tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Check if the event corresponds to the custom creative mode tab
        if (event.getTab() == BMMCreativeModeTabs.BETTER_MCDONALDS_MOD_TAB.get()) {
            // Add various items to the creative mode tab
            event.accept(BMMBlocks.SALT_BLOCK);
            event.accept(BMMItems.SALT);
            event.accept(BMMItems.TOMATO);
            event.accept(BMMItems.TOMATO_SEEDS);
            event.accept(BMMItems.LETTUCE);
            event.accept(BMMItems.LETTUCE_SEEDS);
            event.accept(BMMItems.CHEESE);
            event.accept(BMMItems.TORTILLA);
            event.accept(BMMItems.BEEF_PATTY);
            event.accept(BMMItems.COOKED_BEEF_PATTY);
            event.accept(BMMItems.RAW_BACON);
            event.accept(BMMItems.COOKED_BACON);
            event.accept(BMMItems.MAYONNAISE);
            event.accept(BMMItems.SWEET_SOUR_SAUCE);
            event.accept(BMMItems.KETCHUP);
            event.accept(BMMItems.MUSTARD);
            event.accept(BMMItems.HAMBURGER);
            event.accept(BMMItems.CHEESEBURGER);
            event.accept(BMMItems.MCBACON);
            event.accept(BMMItems.BIG_MAC);
            event.accept(BMMItems.CHICKENBURGER);
            event.accept(BMMItems.MCCHICKEN);
            event.accept(BMMItems.FILET_O_FISH);
            event.accept(BMMItems.MCWRAP);
            event.accept(BMMItems.SNACK_SALAD);
            event.accept(BMMItems.CHICKEN_MCNUGGETS);
            event.accept(BMMItems.FRIES);
            event.accept(BMMItems.HAPPY_MEAL);
            event.accept(BMMItems.COCA_COLA);
            event.accept(BMMItems.FANTA);
            event.accept(BMMItems.SPRITE);
            event.accept(BMMItems.LIPTON_ICE_TEA_PEACH);
            event.accept(BMMItems.MCFLURRY);
            event.accept(BMMItems.KNIFE);
        }
    }
}