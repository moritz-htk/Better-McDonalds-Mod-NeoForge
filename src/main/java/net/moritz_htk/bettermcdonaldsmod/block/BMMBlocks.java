// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;
import net.moritz_htk.bettermcdonaldsmod.block.custom.LettuceCropBlock;
import net.moritz_htk.bettermcdonaldsmod.block.custom.TomatoCropBlock;
import net.moritz_htk.bettermcdonaldsmod.item.BMMItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

// Class for registering custom blocks using DeferredRegister
public class BMMBlocks {
    // Create a DeferredRegister for Block instances
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BetterMcDonaldsMod.MOD_ID);

    // Register each custom block using a DeferredBlock
    public static final DeferredBlock<FallingBlock> SALT_BLOCK = registerBlock(() -> new FallingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SAND).sound(SoundType.SAND).strength(0.5f)) {
        @Override
        protected MapCodec<? extends FallingBlock> codec() {
            return null;
        }
    });
    public static final DeferredBlock<TomatoCropBlock> TOMATO_CROP = registerCropBlock("tomato_crop", () -> new TomatoCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollission().noOcclusion()));
    public static final DeferredBlock<LettuceCropBlock> LETTUCE_CROP = registerCropBlock("lettuce_crop", () -> new LettuceCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).noCollission().noOcclusion()));

    // Method to register a custom block and its associated BlockItem
    public static <T extends Block> DeferredBlock<T> registerBlock(Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register("salt_block", block);
        BMMItems.ITEMS.register("salt_block", () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }

    // Method to register a custom crop block
    private static <T extends Block> DeferredBlock<T> registerCropBlock(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}