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

public class BMMTagProvider {
    public static class Items extends TagsProvider<Item> {
        public static final TagKey<Item> SALT = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("forge", "dusts/salt"));
        public static final TagKey<Item> BURGERS = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("bettermcdonaldsmod", "burgers"));
        public static final TagKey<Item> DRINKS = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("bettermcdonaldsmod", "drinks"));
        public static final TagKey<Item> SIDE_DISHES = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("bettermcdonaldsmod", "side_dishes"));
        public static final TagKey<Item> SAUCES = ForgeRegistries.ITEMS.tags().createTagKey(new ResourceLocation("bettermcdonaldsmod", "sauces"));

        public Items(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, Registries.ITEM, registries, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            TagAppender<Item> saltTagAppender = tag(SALT);
            saltTagAppender.add(BMMItems.SALT.getKey());

            TagAppender<Item> burgerTagAppender = tag(BURGERS);
            burgerTagAppender.add(BMMItems.HAMBURGER.getKey());
            burgerTagAppender.add(BMMItems.CHEESEBURGER.getKey());
            burgerTagAppender.add(BMMItems.BIG_MAC.getKey());
            burgerTagAppender.add(BMMItems.CHICKENBURGER.getKey());
            burgerTagAppender.add(BMMItems.MCCHICKEN.getKey());
            burgerTagAppender.add(BMMItems.FILET_O_FISH.getKey());

            TagAppender<Item> drinkTagAppender = tag(DRINKS);
            drinkTagAppender.add(BMMItems.COCA_COLA.getKey());
            drinkTagAppender.add(BMMItems.FANTA.getKey());
            drinkTagAppender.add(BMMItems.SPRITE.getKey());
            drinkTagAppender.add(BMMItems.LIPTON_ICE_TEA_PEACH.getKey());

            TagAppender<Item> sideDishTagAppender = tag(SIDE_DISHES);
            sideDishTagAppender.add(BMMItems.CHICKEN_MCNUGGETS.getKey());
            sideDishTagAppender.add(BMMItems.FRIES.getKey());

            TagAppender<Item> sauceTagAppender = tag(SAUCES);
            sauceTagAppender.add(BMMItems.MAYONNAISE.getKey());
            sauceTagAppender.add(BMMItems.SWEET_SOUR_SAUCE.getKey());
            sauceTagAppender.add(BMMItems.KETCHUP.getKey());
        }
    }

    public static class Blocks extends TagsProvider<Block>{
        public static final TagKey<Block> SALT_BLOCK = ForgeRegistries.BLOCKS.tags().createTagKey(new ResourceLocation("forge", "salt"));

        public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, Registries.BLOCK, registries, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            TagAppender<Block> saltBlockTagAppender = tag(SALT_BLOCK);
            saltBlockTagAppender.add(BMMBlocks.SALT_BLOCK.getKey());
        }
    }
}