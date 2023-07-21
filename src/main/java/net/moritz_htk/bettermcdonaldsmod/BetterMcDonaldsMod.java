package net.moritz_htk.bettermcdonaldsmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.moritz_htk.bettermcdonaldsmod.block.BMMBlocks;
import net.moritz_htk.bettermcdonaldsmod.item.BMMItems;

@Mod(BetterMcDonaldsMod.MOD_ID)
public class BetterMcDonaldsMod {
    public static final String MOD_ID = "bettermcdonaldsmod";

    public BetterMcDonaldsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BMMItems.register(modEventBus);
        BMMBlocks.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}