// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;
import net.moritz_htk.bettermcdonaldsmod.block.BMMBlocks;
import net.moritz_htk.bettermcdonaldsmod.item.BMMItems;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

// Definition of the main class for tag generation
public class BMMTagProvider {
    // Definition of the Items class for item tag generation
    public static class Items extends TagsProvider<Item> {
        // Definition of various tag keys for items
        public static final TagKey<Item> SALT = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("forge", "dusts/salt"));
        public static final TagKey<Item> DUSTS = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("forge", "dusts"));
        public static final TagKey<Item> TOMATO = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("forge", "crops/tomato"));
        public static final TagKey<Item> LETTUCE = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("forge", "crops/lettuce"));
        public static final TagKey<Item> TOMATO_SEEDS = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("forge", "seeds/tomato"));
        public static final TagKey<Item> LETTUCE_SEEDS = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("forge", "seeds/lettuce"));
        public static final TagKey<Item> CROPS = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("forge", "crops"));
        public static final TagKey<Item> SEEDS = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("forge", "seeds"));
        public static final TagKey<Item> BURGERS = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "burgers"));
        public static final TagKey<Item> DRINKS = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "drinks"));
        public static final TagKey<Item> SIDE_DISHES = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "side_dishes"));
        public static final TagKey<Item> SAUCES = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "sauces"));

        // Constructor for the Items class
        public Items(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, Registries.ITEM, registries, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
        }

        // Method to add tags to items
        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(SALT).add(BMMItems.SALT.getKey());
            tag(DUSTS).addTag(Items.SALT);
            tag(TOMATO).add(BMMItems.TOMATO.getKey());
            tag(TOMATO_SEEDS).add(BMMItems.TOMATO_SEEDS.getKey());
            tag(LETTUCE).add(BMMItems.LETTUCE.getKey());
            tag(LETTUCE_SEEDS).add(BMMItems.LETTUCE_SEEDS.getKey());
            tag(CROPS)
                    .addTag(Items.TOMATO)
                    .addTag(Items.LETTUCE);

            tag(SEEDS)
                    .addTag(Items.TOMATO_SEEDS)
                    .addTag(Items.LETTUCE_SEEDS);

            tag(BURGERS)
                    .add(BMMItems.HAMBURGER.getKey())
                    .add(BMMItems.CHEESEBURGER.getKey())
                    .add(BMMItems.BIG_MAC.getKey())
                    .add(BMMItems.CHICKENBURGER.getKey())
                    .add(BMMItems.MCCHICKEN.getKey())
                    .add(BMMItems.FILET_O_FISH.getKey());

            tag(DRINKS)
                    .add(BMMItems.COCA_COLA.getKey())
                    .add(BMMItems.FANTA.getKey())
                    .add(BMMItems.SPRITE.getKey())
                    .add(BMMItems.LIPTON_ICE_TEA_PEACH.getKey());

            tag(SIDE_DISHES)
                    .add(BMMItems.CHICKEN_MCNUGGETS.getKey())
                    .add(BMMItems.FRIES.getKey());

            tag(SAUCES)
                    .add(BMMItems.MAYONNAISE.getKey())
                    .add(BMMItems.SWEET_SOUR_SAUCE.getKey())
                    .add(BMMItems.KETCHUP.getKey())
                    .add(BMMItems.MUSTARD.getKey());
        }
    }

    // Definition of the Blocks class for block tag generation
    public static class Blocks extends TagsProvider<Block>{
        // Definition of various tag keys for blocks
        public static final TagKey<Block> SALT_BLOCK = ForgeRegistries.BLOCKS.tags().createTagKey(new ResourceLocation("forge", "salt"));
        public static final TagKey<Block> SHOVEL_MINEABLE = ForgeRegistries.BLOCKS.tags().createTagKey(new ResourceLocation("minecraft", "mineable/shovel"));

        // Constructor for the Blocks class
        public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, Registries.BLOCK, registries, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
        }

        // Method to add tags to blocks
        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(SALT_BLOCK).add(BMMBlocks.SALT_BLOCK.getKey());
            tag(SHOVEL_MINEABLE).add(BMMBlocks.SALT_BLOCK.getKey());
        }
    }
}