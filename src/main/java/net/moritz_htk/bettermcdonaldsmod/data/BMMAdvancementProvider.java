// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.data;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;
import net.moritz_htk.bettermcdonaldsmod.item.BMMItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

// Provider class for generating advancements for the mod
public class BMMAdvancementProvider extends ForgeAdvancementProvider {
    public BMMAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new BMMAdvancements()));
    }

    // Nested class for defining advancement generation logic
    private static class BMMAdvancements implements ForgeAdvancementProvider.AdvancementGenerator {

        @Override
        public void generate(HolderLookup.Provider registries, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {
            // Create a "Start" advancement
            Advancement START = Advancement.Builder.advancement()
                    .display(BMMItems.HAPPY_MEAL.get().getDefaultInstance(),
                            Component.literal("Better McDonald's Mod"),
                            Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + ".start.description"),
                            new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "textures/screens/advancement_tab.png"),
                            FrameType.TASK, false, false, false)
                    .addCriterion("tick", PlayerTrigger.TriggerInstance.tick())
                    .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "start"), existingFileHelper);

            // Create a "Get Salt" advancement
            Advancement GET_SALT = Advancement.Builder.advancement()
                    .display(makeNormalDisplay(BMMItems.SALT.get().getDefaultInstance(), FrameType.TASK, "get_salt"))
                    .addCriterion("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.SALT.get()))
                    .parent(START)
                    .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "get_salt"), existingFileHelper);

            // Create a "Craft Knife" advancement
            Advancement CRAFT_KNIFE = Advancement.Builder.advancement()
                    .display(makeNormalDisplay(BMMItems.KNIFE.get().getDefaultInstance(), FrameType.TASK, "craft_knife"))
                    .addCriterion("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.KNIFE.get()))
                    .parent(START)
                    .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "craft_knife"), existingFileHelper);

            // Create a "Craft Burger" advancement
            Advancement.Builder.advancement()
                    .display(makeNormalDisplay(BMMItems.HAMBURGER.get().getDefaultInstance(), FrameType.GOAL, "craft_burger"))
                    .addCriterion("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.HAMBURGER.get()))
                    .parent(CRAFT_KNIFE)
                    .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "craft_burger"), existingFileHelper);

            // Create a "Craft Drink" advancement
            Advancement.Builder.advancement()
                    .display(makeNormalDisplay(BMMItems.COCA_COLA.get().getDefaultInstance(), FrameType.GOAL, "craft_drink"))
                    .addCriterion("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(BMMItems.COCA_COLA.get()))
                    .parent(GET_SALT)
                    .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "craft_drink"), existingFileHelper);
        }
    }

    // Method to create a DisplayInfo object for advancement display
    public static DisplayInfo makeNormalDisplay(ItemStack item, FrameType frame, String titleKey) {
        return new DisplayInfo(item.getItem().getDefaultInstance(),
                Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + "." + titleKey + ".title"),
                Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + "." + titleKey + ".description"),
                new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "textures/screens/advancement_tab.png"),
                frame, true, true, false);
    }
}