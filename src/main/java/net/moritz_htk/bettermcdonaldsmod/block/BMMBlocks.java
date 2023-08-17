// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;
import net.moritz_htk.bettermcdonaldsmod.item.BMMItems;

import java.util.function.Supplier;

// Class for registering custom blocks using DeferredRegister
public class BMMBlocks {
    // Create a DeferredRegister for Block instances
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BetterMcDonaldsMod.MOD_ID);

    // Define a custom FallingBlock as a salt block
    public static final RegistryObject<Block> SALT_BLOCK = registerBlock(() -> new FallingBlock(BlockBehaviour.Properties.copy(Blocks.SAND).sound(SoundType.SAND).strength(0.5f)));

    // Method to register a custom block and its associated BlockItem
    private static <T extends Block> RegistryObject<T> registerBlock(Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register("salt_block", block);
        registerBlockItem(toReturn); // Register a BlockItem for the block
        return toReturn;
    }

    // Method to register a BlockItem for a custom block
    private static <T extends Block> void registerBlockItem(RegistryObject<T> block) {
        // Register a BlockItem with default properties
        BMMItems.ITEMS.register("salt_block", () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Method to register the blocks to the event bus
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}