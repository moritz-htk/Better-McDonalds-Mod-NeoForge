// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;
import net.moritz_htk.bettermcdonaldsmod.item.BMMItems;

// Custom item model provider for defining item models and textures
public class BMMItemModelProvider extends ItemModelProvider {
    public BMMItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        // Initialize the item model provider with the output location, mod ID, and existing file helper
        super(output, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Register models and textures for each item in the mod
        simpleItem(BMMItems.SALT);
        simpleItem(BMMItems.CHEESE);
        simpleItem(BMMItems.TOMATO);
        simpleItem(BMMItems.TOMATO_SEEDS);
        simpleItem(BMMItems.LETTUCE);
        simpleItem(BMMItems.LETTUCE_SEEDS);
        simpleItem(BMMItems.BEEF_PATTY);
        simpleItem(BMMItems.COOKED_BEEF_PATTY);
        simpleItem(BMMItems.RAW_BACON);
        simpleItem(BMMItems.COOKED_BACON);
        simpleItem(BMMItems.MAYONNAISE);
        simpleItem(BMMItems.SWEET_SOUR_SAUCE);
        simpleItem(BMMItems.KETCHUP);
        simpleItem(BMMItems.MUSTARD);
        simpleItem(BMMItems.HAMBURGER);
        simpleItem(BMMItems.CHEESEBURGER);
        simpleItem(BMMItems.BIG_MAC);
        simpleItem(BMMItems.CHICKENBURGER);
        simpleItem(BMMItems.MCCHICKEN);
        simpleItem(BMMItems.FILET_O_FISH);
        simpleItem(BMMItems.MCWRAP);
        simpleItem(BMMItems.CHICKEN_MCNUGGETS);
        simpleItem(BMMItems.FRIES);
        simpleItem(BMMItems.HAPPY_MEAL);
        simpleItem(BMMItems.COCA_COLA);
        simpleItem(BMMItems.FANTA);
        simpleItem(BMMItems.SPRITE);
        simpleItem(BMMItems.LIPTON_ICE_TEA_PEACH);
        simpleItem(BMMItems.MCFLURRY);

        // Register model and texture for handheld item (knife)
        handheldItem();
    }

    // Register a simple item model and texture
    private void simpleItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(), new ResourceLocation("item/generated")).texture("layer0", new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    // Register a handheld item model and texture
    private void handheldItem() {
        withExistingParent(BMMItems.KNIFE.getId().getPath(), new ResourceLocation("item/handheld")).texture("layer0", new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "item/" + BMMItems.KNIFE.getId().getPath()));
    }
}