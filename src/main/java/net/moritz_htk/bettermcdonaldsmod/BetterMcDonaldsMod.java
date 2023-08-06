package net.moritz_htk.bettermcdonaldsmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.moritz_htk.bettermcdonaldsmod.block.BMMBlocks;
import net.moritz_htk.bettermcdonaldsmod.item.BMMCreativeModeTabs;
import net.moritz_htk.bettermcdonaldsmod.item.BMMItems;

@Mod(BetterMcDonaldsMod.MOD_ID)
public class BetterMcDonaldsMod {
    public static final String MOD_ID = "bettermcdonaldsmod";

    public BetterMcDonaldsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BMMCreativeModeTabs.register(modEventBus);
        BMMBlocks.register(modEventBus);
        BMMItems.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == BMMCreativeModeTabs.BETTER_MCDONALDS_MOD_TAB.get()) {
            event.accept(BMMBlocks.SALT_BLOCK);
            event.accept(BMMItems.SALT);
            event.accept(BMMItems.CHEESE);
            event.accept(BMMItems.BEEF_PATTY);
            event.accept(BMMItems.COOKED_BEEF_PATTY);
            event.accept(BMMItems.MAYONNAISE);
            event.accept(BMMItems.SWEET_SOUR_SAUCE);
            event.accept(BMMItems.KETCHUP);
            event.accept(BMMItems.HAMBURGER);
            event.accept(BMMItems.CHEESEBURGER);
            event.accept(BMMItems.BIG_MAC);
            event.accept(BMMItems.CHICKENBURGER);
            event.accept(BMMItems.MCCHICKEN);
            event.accept(BMMItems.FILET_O_FISH);
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