package net.moritz_htk.bettermcdonaldsmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(BetterMcDonaldsMod.MOD_ID)
public class BetterMcDonaldsMod {
    public static final String MOD_ID = "bettermcdonaldsmod";

    public BetterMcDonaldsMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}