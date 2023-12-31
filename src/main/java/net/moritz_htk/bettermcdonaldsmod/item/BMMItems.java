// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;
import net.moritz_htk.bettermcdonaldsmod.block.BMMBlocks;
import net.moritz_htk.bettermcdonaldsmod.item.custom.DrinkItem;
import net.moritz_htk.bettermcdonaldsmod.item.custom.KnifeItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// Class for registering custom items using DeferredRegister
public class BMMItems {
    // Create a DeferredRegister for Item instances
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BetterMcDonaldsMod.MOD_ID);

    // Register each custom item using a DeferredHolder
    public static final DeferredItem<Item> SALT = ITEMS.register("salt", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TOMATO = ITEMS.register("tomato", () -> new Item(new Item.Properties().food(registerFoodValues(1, 0.3f).build())));
    public static final DeferredItem<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds", () -> new ItemNameBlockItem(BMMBlocks.TOMATO_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> LETTUCE = ITEMS.register("lettuce", () -> new Item(new Item.Properties().food(registerFoodValues(1, 0.3f).build())));
    public static final DeferredItem<Item> LETTUCE_SEEDS = ITEMS.register("lettuce_seeds", () -> new ItemNameBlockItem(BMMBlocks.LETTUCE_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> CHEESE = ITEMS.register("cheese", () -> new Item(new Item.Properties().food(registerFoodValues(2, 0.4f).build())));
    public static final DeferredItem<Item> TORTILLA = ITEMS.register("tortilla", () -> new Item(new Item.Properties().food(registerFoodValues(2, 0.4f).build())));
    public static final DeferredItem<Item> BEEF_PATTY = ITEMS.register("beef_patty", () -> new Item(new Item.Properties().food(registerFoodValues(4, 0.4f).meat().build())));
    public static final DeferredItem<Item> COOKED_BEEF_PATTY = ITEMS.register("cooked_beef_patty", () -> new Item(new Item.Properties().food(registerFoodValues(5, 0.4f).meat().build())));
    public static final DeferredItem<Item> RAW_BACON = ITEMS.register("raw_bacon", () -> new Item(new Item.Properties().food(registerFoodValues(3, 0.4f).meat().build())));
    public static final DeferredItem<Item> COOKED_BACON = ITEMS.register("cooked_bacon", () -> new Item(new Item.Properties().food(registerFoodValues(4, 0.4f).meat().build())));
    public static final DeferredItem<Item> MAYONNAISE = ITEMS.register("mayonnaise", () -> new Item(new Item.Properties().food(registerFoodValues(1, 0.3f).build())));
    public static final DeferredItem<Item> SWEET_SOUR_SAUCE = ITEMS.register("sweet_sour_sauce", () -> new Item(new Item.Properties().food(registerFoodValues(1, 0.3f).build())));
    public static final DeferredItem<Item> KETCHUP = ITEMS.register("ketchup", () -> new Item(new Item.Properties().food(registerFoodValues(1, 0.3f).build())));
    public static final DeferredItem<Item> MUSTARD = ITEMS.register("mustard", () -> new Item(new Item.Properties().food(registerFoodValues(1, 0.3f).build())));
    public static final DeferredItem<Item> HAMBURGER = ITEMS.register("hamburger", () -> new Item(new Item.Properties().food(registerFoodValues(6, 0.5f).build())));
    public static final DeferredItem<Item> CHEESEBURGER = ITEMS.register("cheeseburger", () -> new Item(new Item.Properties().food(registerFoodValues(8, 0.5f).build())));
    public static final DeferredItem<Item> MCBACON = ITEMS.register("mcbacon", () -> new Item(new Item.Properties().food(registerFoodValues(8, 0.5f).build())));
    public static final DeferredItem<Item> BIG_MAC = ITEMS.register("big_mac", () -> new Item(new Item.Properties().food(registerFoodValues(10, 0.5f).build())));
    public static final DeferredItem<Item> CHICKENBURGER = ITEMS.register("chickenburger", () -> new Item(new Item.Properties().food(registerFoodValues(7, 0.5f).build())));
    public static final DeferredItem<Item> MCCHICKEN = ITEMS.register("mcchicken", () -> new Item(new Item.Properties().food(registerFoodValues(8, 0.5f).build())));
    public static final DeferredItem<Item> FILET_O_FISH = ITEMS.register("filet_o_fish", () -> new Item(new Item.Properties().food(registerFoodValues(6, 0.5f).build())));
    public static final DeferredItem<Item> MCWRAP = ITEMS.register("mcwrap", () -> new Item(new Item.Properties().food(registerFoodValues(5, 0.4f).build())));
    public static final DeferredItem<Item> SNACK_SALAD = ITEMS.register("snack_salad", () -> new Item(new Item.Properties().food(registerFoodValues(4, 0.4f).build())));
    public static final DeferredItem<Item> CHICKEN_MCNUGGETS = ITEMS.register("chicken_mcnuggets", () -> new Item(new Item.Properties().food(registerFoodValues(4, 0.4f).build())));
    public static final DeferredItem<Item> FRIES = ITEMS.register("fries", () -> new Item(new Item.Properties().food(registerFoodValues(5, 0.4f).build())));
    public static final DeferredItem<Item> HAPPY_MEAL = ITEMS.register("happy_meal", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON).food(registerFoodValues(14, 0.5f).build())));
    public static final DeferredItem<DrinkItem> COCA_COLA = ITEMS.register("coca_cola", () -> new DrinkItem(new Item.Properties()));
    public static final DeferredItem<DrinkItem> FANTA = ITEMS.register("fanta", () -> new DrinkItem(new Item.Properties()));
    public static final DeferredItem<DrinkItem> SPRITE = ITEMS.register("sprite", () -> new DrinkItem(new Item.Properties()));
    public static final DeferredItem<DrinkItem> LIPTON_ICE_TEA_PEACH = ITEMS.register("lipton_ice_tea_peach", () -> new DrinkItem(new Item.Properties()));
    public static final DeferredItem<Item> MCFLURRY = ITEMS.register("mcflurry", () -> new Item(new Item.Properties().food(registerFoodValues(6, 0.4f).build())));

    // Register a KnifeItem with custom properties using a DeferredHolder
    public static final DeferredItem<KnifeItem> KNIFE = ITEMS.register("knife", () -> new KnifeItem(3, -3f, new Item.Properties()));

    // Method to create a FoodProperties.Builder with given nutrition and saturation values
    public static FoodProperties.Builder registerFoodValues(int nutrition, float saturation) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturation);
    }

    // Method to register the items to the event bus
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}