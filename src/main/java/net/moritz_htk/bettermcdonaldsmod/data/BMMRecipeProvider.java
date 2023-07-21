package net.moritz_htk.bettermcdonaldsmod.data;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;
import net.moritz_htk.bettermcdonaldsmod.block.BMMBlocks;
import net.moritz_htk.bettermcdonaldsmod.item.BMMItems;

import java.util.function.Consumer;

public class BMMRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public BMMRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, BMMBlocks.SALT_BLOCK.get(), 1)
                .define('#', BMMTagProvider.Items.SALT)
                .pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTagProvider.Items.SALT))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMBlocks.SALT_BLOCK.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.CHEESE.get())
                .requires(Items.MILK_BUCKET.asItem())
                .requires(BMMTagProvider.Items.SALT)
                .unlockedBy(getHasName(Items.MILK_BUCKET.asItem()), has(Items.MILK_BUCKET.asItem()))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTagProvider.Items.SALT))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.CHEESE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.BEEF_PATTY.get(), 2)
                .requires(BMMItems.KNIFE.get())
                .requires(Items.BEEF.asItem())
                .unlockedBy(getHasName(BMMItems.KNIFE.get()), has(BMMItems.KNIFE.get()))
                .unlockedBy(getHasName(Items.BEEF.asItem()), has(Items.BEEF.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.BEEF_PATTY.get())));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(BMMItems.BEEF_PATTY.get()), RecipeCategory.FOOD, BMMItems.COOKED_BEEF_PATTY.get(), 1.0f, 200, RecipeSerializer.SMELTING_RECIPE)
                .unlockedBy(getHasName(BMMItems.BEEF_PATTY.get()), has(BMMItems.BEEF_PATTY.get()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BEEF_PATTY.get()) + "_smelting"));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(BMMItems.BEEF_PATTY.get()), RecipeCategory.FOOD, BMMItems.COOKED_BEEF_PATTY.get(), 1.0f, 100, RecipeSerializer.SMOKING_RECIPE)
                .unlockedBy(getHasName(BMMItems.BEEF_PATTY.get()), has(BMMItems.BEEF_PATTY.get()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BEEF_PATTY.get()) + "_smoking"));

        SimpleCookingRecipeBuilder.generic(Ingredient.of(BMMItems.BEEF_PATTY.get()), RecipeCategory.FOOD, BMMItems.COOKED_BEEF_PATTY.get(), 1.0f, 600, RecipeSerializer.CAMPFIRE_COOKING_RECIPE)
                .unlockedBy(getHasName(BMMItems.BEEF_PATTY.get()), has(BMMItems.BEEF_PATTY.get()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COOKED_BEEF_PATTY.get()) + "_campfire_cooking"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.MAYONNAISE.get())
                .requires(Items.MILK_BUCKET.asItem())
                .requires(Items.EGG.asItem())
                .unlockedBy(getHasName(Items.MILK_BUCKET.asItem()), has(Items.MILK_BUCKET.asItem()))
                .unlockedBy(getHasName(Items.EGG.asItem()), has(Items.EGG.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.MAYONNAISE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.SWEET_SOUR_SAUCE.get())
                .requires(Items.WATER_BUCKET.asItem())
                .requires(Items.SUGAR.asItem())
                .requires(BMMTagProvider.Items.SALT)
                .requires(Items.HONEY_BOTTLE.asItem())
                .unlockedBy(getHasName(Items.WATER_BUCKET.asItem()), has(Items.WATER_BUCKET.asItem()))
                .unlockedBy(getHasName(Items.SUGAR.asItem()), has(Items.SUGAR.asItem()))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.HONEY_BOTTLE.asItem()), has(Items.HONEY_BOTTLE.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.SWEET_SOUR_SAUCE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.KETCHUP.get())
                .requires(Items.WATER_BUCKET.asItem())
                .requires(Items.SUGAR.asItem())
                .requires(BMMTagProvider.Items.SALT)
                .requires(Items.RED_DYE.asItem())
                .unlockedBy(getHasName(Items.WATER_BUCKET.asItem()), has(Items.WATER_BUCKET.asItem()))
                .unlockedBy(getHasName(Items.SUGAR.asItem()), has(Items.SUGAR.asItem()))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.RED_DYE.asItem()), has(Items.RED_DYE.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.KETCHUP.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.HAMBURGER.get())
                .requires(Items.BREAD.asItem())
                .requires(BMMItems.COOKED_BEEF_PATTY.get())
                .unlockedBy(getHasName(Items.BREAD.asItem()), has(Items.BREAD.asItem()))
                .unlockedBy(getHasName(BMMItems.COOKED_BEEF_PATTY.get()), has(BMMItems.COOKED_BEEF_PATTY.get()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.HAMBURGER.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.CHEESEBURGER.get())
                .requires(Items.BREAD.asItem())
                .requires(BMMItems.COOKED_BEEF_PATTY.get())
                .requires(BMMItems.CHEESE.get())
                .unlockedBy(getHasName(Items.BREAD.asItem()), has(Items.BREAD.asItem()))
                .unlockedBy(getHasName(BMMItems.COOKED_BEEF_PATTY.get()), has(BMMItems.COOKED_BEEF_PATTY.get()))
                .unlockedBy(getHasName(BMMItems.CHEESE.get()), has(BMMItems.CHEESE.get()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.CHEESEBURGER.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.BIG_MAC.get())
                .requires(Items.BREAD.asItem())
                .requires(BMMItems.COOKED_BEEF_PATTY.get(), 2)
                .requires(BMMItems.CHEESE.get())
                .requires(Items.GRASS.asItem())
                .unlockedBy(getHasName(Items.BREAD.asItem()), has(Items.BREAD.asItem()))
                .unlockedBy(getHasName(BMMItems.COOKED_BEEF_PATTY.get()), has(BMMItems.COOKED_BEEF_PATTY.get()))
                .unlockedBy(getHasName(BMMItems.CHEESE.get()), has(BMMItems.CHEESE.get()))
                .unlockedBy(getHasName(Items.GRASS.asItem()), has(Items.GRASS.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.BIG_MAC.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.CHICKENBURGER.get())
                .requires(Items.BREAD.asItem())
                .requires(Items.COOKED_CHICKEN.asItem())
                .requires(BMMItems.KETCHUP.get())
                .requires(Items.GRASS.asItem())
                .unlockedBy(getHasName(Items.BREAD.asItem()), has(Items.BREAD.asItem()))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN.asItem()), has(Items.COOKED_CHICKEN.asItem()))
                .unlockedBy(getHasName(BMMItems.KETCHUP.get()), has(BMMItems.KETCHUP.get()))
                .unlockedBy(getHasName(Items.GRASS.asItem()), has(Items.GRASS.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.CHICKENBURGER.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.MCCHICKEN.get())
                .requires(Items.BREAD.asItem())
                .requires(Items.COOKED_CHICKEN.asItem())
                .requires(BMMItems.MAYONNAISE.get())
                .requires(Items.GRASS.asItem())
                .unlockedBy(getHasName(Items.BREAD.asItem()), has(Items.BREAD.asItem()))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN.asItem()), has(Items.COOKED_CHICKEN.asItem()))
                .unlockedBy(getHasName(BMMItems.MAYONNAISE.get()), has(BMMItems.MAYONNAISE.get()))
                .unlockedBy(getHasName(Items.GRASS.asItem()), has(Items.GRASS.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.MCCHICKEN.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.FILET_O_FISH.get())
                .requires(Items.BREAD.asItem())
                .requires(BMMItems.CHEESE.get())
                .requires(Items.COOKED_SALMON.asItem())
                .unlockedBy(getHasName(Items.BREAD.asItem()), has(Items.BREAD.asItem()))
                .unlockedBy(getHasName(BMMItems.CHEESE.get()), has(BMMItems.CHEESE.get()))
                .unlockedBy(getHasName(Items.COOKED_SALMON.asItem()), has(Items.COOKED_SALMON.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.FILET_O_FISH.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.CHICKEN_MCNUGGETS.get())
                .requires(BMMItems.KNIFE.get())
                .requires(Items.COOKED_CHICKEN.asItem())
                .unlockedBy(getHasName(BMMItems.KNIFE.get()), has(BMMItems.KNIFE.get()))
                .unlockedBy(getHasName(Items.COOKED_CHICKEN.asItem()), has(Items.COOKED_CHICKEN.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.CHICKEN_MCNUGGETS.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.FRIES.get())
                .requires(BMMItems.KNIFE.get())
                .requires(Items.BAKED_POTATO.asItem())
                .requires(BMMTagProvider.Items.SALT)
                .unlockedBy(getHasName(BMMItems.KNIFE.get()), has(BMMItems.KNIFE.get()))
                .unlockedBy(getHasName(Items.BAKED_POTATO.asItem()), has(Items.BAKED_POTATO.asItem()))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTagProvider.Items.SALT))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.FRIES.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.HAPPY_MEAL.get())
                .requires(BMMTagProvider.Items.BURGERS)
                .requires(BMMTagProvider.Items.DRINKS)
                .requires(BMMTagProvider.Items.SIDE_DISHES)
                .requires(Items.APPLE.asItem())
                .unlockedBy("has_burger", has(BMMTagProvider.Items.BURGERS))
                .unlockedBy("has_drink", has(BMMTagProvider.Items.DRINKS))
                .unlockedBy("has_side_dish", has(BMMTagProvider.Items.SIDE_DISHES))
                .unlockedBy(getHasName(Items.APPLE.asItem()), has(Items.APPLE.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.HAPPY_MEAL.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.COCA_COLA.get())
                .requires(Items.WATER_BUCKET.asItem())
                .requires(Items.SUGAR.asItem())
                .requires(BMMTagProvider.Items.SALT)
                .requires(Items.BROWN_DYE.asItem())
                .unlockedBy(getHasName(Items.WATER_BUCKET.asItem()), has(Items.WATER_BUCKET.asItem()))
                .unlockedBy(getHasName(Items.SUGAR.asItem()), has(Items.SUGAR.asItem()))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.BROWN_DYE.asItem()), has(Items.BROWN_DYE.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.COCA_COLA.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.FANTA.get())
                .requires(Items.WATER_BUCKET.asItem())
                .requires(Items.SUGAR.asItem())
                .requires(BMMTagProvider.Items.SALT)
                .requires(Items.YELLOW_DYE.asItem())
                .unlockedBy(getHasName(Items.WATER_BUCKET.asItem()), has(Items.WATER_BUCKET.asItem()))
                .unlockedBy(getHasName(Items.SUGAR.asItem()), has(Items.SUGAR.asItem()))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.YELLOW_DYE.asItem()), has(Items.YELLOW_DYE.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.FANTA.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.SPRITE.get())
                .requires(Items.WATER_BUCKET.asItem())
                .requires(Items.SUGAR.asItem())
                .requires(BMMTagProvider.Items.SALT)
                .requires(Items.GREEN_DYE.asItem())
                .unlockedBy(getHasName(Items.WATER_BUCKET.asItem()), has(Items.WATER_BUCKET.asItem()))
                .unlockedBy(getHasName(Items.SUGAR.asItem()), has(Items.SUGAR.asItem()))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.GREEN_DYE.asItem()), has(Items.GREEN_DYE.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.SPRITE.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.LIPTON_ICE_TEA_PEACH.get())
                .requires(Items.WATER_BUCKET.asItem())
                .requires(Items.SUGAR.asItem())
                .requires(BMMTagProvider.Items.SALT)
                .requires(Items.PINK_DYE.asItem())
                .unlockedBy(getHasName(Items.WATER_BUCKET.asItem()), has(Items.WATER_BUCKET.asItem()))
                .unlockedBy(getHasName(Items.SUGAR.asItem()), has(Items.SUGAR.asItem()))
                .unlockedBy(getHasName(BMMItems.SALT.get()), has(BMMTagProvider.Items.SALT))
                .unlockedBy(getHasName(Items.PINK_DYE.asItem()), has(Items.PINK_DYE.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.LIPTON_ICE_TEA_PEACH.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, BMMItems.MCFLURRY.get())
                .requires(Items.MILK_BUCKET.asItem())
                .requires(Items.SNOWBALL.asItem())
                .requires(Items.SUGAR.asItem())
                .unlockedBy(getHasName(Items.MILK_BUCKET.asItem()), has(Items.MILK_BUCKET.asItem()))
                .unlockedBy(getHasName(Items.SNOWBALL.asItem()), has(Items.SNOWBALL.asItem()))
                .unlockedBy(getHasName(Items.SUGAR.asItem()), has(Items.SUGAR.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.MCFLURRY.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, BMMItems.KNIFE.get())
                .define('I', Items.IRON_INGOT.asItem())
                .define('S', Items.STICK.asItem())
                .pattern(" I ")
                .pattern(" S ")
                .unlockedBy(getHasName(Items.IRON_INGOT.asItem()), has(Items.IRON_INGOT.asItem()))
                .unlockedBy(getHasName(Items.STICK.asItem()), has(Items.STICK.asItem()))
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, getItemName(BMMItems.KNIFE.get())));
    }
}