// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;
import net.moritz_htk.bettermcdonaldsmod.item.BMMItems;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

// Custom item model provider for defining item models and textures
public class BMMItemModelProvider extends ItemModelProvider {
    public BMMItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        // Initialize the item model provider with the output location, mod ID, and existing file helper
        super(output, BetterMcDonaldsMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Register models and textures for each item in the mod
        simpleItem(BMMItems.SALT.getId());
        simpleItem(BMMItems.TOMATO.getId());
        simpleItem(BMMItems.TOMATO_SEEDS.getId());
        simpleItem(BMMItems.LETTUCE.getId());
        simpleItem(BMMItems.LETTUCE_SEEDS.getId());
        simpleItem(BMMItems.CHEESE.getId());
        simpleItem(BMMItems.TORTILLA.getId());
        simpleItem(BMMItems.BEEF_PATTY.getId());
        simpleItem(BMMItems.COOKED_BEEF_PATTY.getId());
        simpleItem(BMMItems.RAW_BACON.getId());
        simpleItem(BMMItems.COOKED_BACON.getId());
        simpleItem(BMMItems.MAYONNAISE.getId());
        simpleItem(BMMItems.SWEET_SOUR_SAUCE.getId());
        simpleItem(BMMItems.KETCHUP.getId());
        simpleItem(BMMItems.MUSTARD.getId());
        simpleItem(BMMItems.HAMBURGER.getId());
        simpleItem(BMMItems.CHEESEBURGER.getId());
        simpleItem(BMMItems.MCBACON.getId());
        simpleItem(BMMItems.BIG_MAC.getId());
        simpleItem(BMMItems.CHICKENBURGER.getId());
        simpleItem(BMMItems.MCCHICKEN.getId());
        simpleItem(BMMItems.FILET_O_FISH.getId());
        simpleItem(BMMItems.MCWRAP.getId());
        simpleItem(BMMItems.SNACK_SALAD.getId());
        simpleItem(BMMItems.CHICKEN_MCNUGGETS.getId());
        simpleItem(BMMItems.FRIES.getId());
        simpleItem(BMMItems.HAPPY_MEAL.getId());
        simpleItem(BMMItems.COCA_COLA.getId());
        simpleItem(BMMItems.FANTA.getId());
        simpleItem(BMMItems.SPRITE.getId());
        simpleItem(BMMItems.LIPTON_ICE_TEA_PEACH.getId());
        simpleItem(BMMItems.MCFLURRY.getId());

        // Register model and texture for handheld item (knife)
        handheldItem(BMMItems.KNIFE.getId());
    }

    // Register a simple item model and texture
    private void simpleItem(ResourceLocation item) {
        withExistingParent(item.toString(), new ResourceLocation("item/generated")).texture("layer0", new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "item/" + item.getPath()));
    }

    // Register a handheld item model and texture
    private void handheldItem(ResourceLocation item) {
        withExistingParent(item.toString(), new ResourceLocation("item/handheld")).texture("layer0", new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "item/" + item.getPath()));
    }
}