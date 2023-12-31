// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.loot;

import com.mojang.serialization.Codec;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class BMMLootModifiers {
    // Create a DeferredRegister for loot modifier serializers
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, BetterMcDonaldsMod.MOD_ID);

    // Register the ADD_ITEM loot modifier using its Codec
    public static final Supplier<Codec<? extends IGlobalLootModifier>> ADD_ITEM = LOOT_MODIFIER_SERIALIZERS.register("add_item", AddItemModifier.CODEC);

    // Method to register the loot modifiers to the event bus
    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }
}