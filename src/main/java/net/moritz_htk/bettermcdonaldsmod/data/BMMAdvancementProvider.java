// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.data;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.moritz_htk.bettermcdonaldsmod.BetterMcDonaldsMod;
import net.moritz_htk.bettermcdonaldsmod.item.BMMItems;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

// Provider class for generating advancements for the mod
public class BMMAdvancementProvider extends AdvancementProvider {
    public BMMAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new BMMAdvancements()));
    }

    // Nested class for defining advancement generation logic
    private static class BMMAdvancements implements AdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer, ExistingFileHelper existingFileHelper) {
            // Create the root advancement
            AdvancementHolder ROOT = createRootAdvancement(consumer, existingFileHelper, AdvancementType.TASK, BMMItems.HAPPY_MEAL.get().getDefaultInstance(), "root");

            // Create child advancements and link them to the root
            AdvancementHolder GET_SALT = createAdvancement(consumer, existingFileHelper, AdvancementType.TASK, BMMItems.SALT.get().getDefaultInstance(), "get_salt", ROOT);
            createAdvancement(consumer, existingFileHelper, AdvancementType.GOAL, BMMItems.COCA_COLA.get().getDefaultInstance(), "craft_drink", GET_SALT);

            AdvancementHolder CRAFT_KNIFE = createAdvancement(consumer, existingFileHelper, AdvancementType.TASK, BMMItems.KNIFE.get().getDefaultInstance(), "craft_knife", ROOT);
            createAdvancement(consumer, existingFileHelper, AdvancementType.GOAL, BMMItems.HAMBURGER.get().getDefaultInstance(), "craft_burger", CRAFT_KNIFE);

            AdvancementHolder GET_SEEDS = createAdvancement(consumer, existingFileHelper, AdvancementType.TASK, BMMItems.LETTUCE_SEEDS.get().getDefaultInstance(), "get_seeds", ROOT);
            AdvancementHolder HARVEST_LETTUCE = createAdvancement(consumer, existingFileHelper, AdvancementType.TASK, BMMItems.LETTUCE.get().getDefaultInstance(), "harvest_lettuce", GET_SEEDS);
            createAdvancement(consumer, existingFileHelper, AdvancementType.GOAL, BMMItems.SNACK_SALAD.get().getDefaultInstance(), "craft_snack_salad", HARVEST_LETTUCE);
        }
    }

    // Method to create the root advancement
    public static AdvancementHolder createRootAdvancement(Consumer<AdvancementHolder> consumer, ExistingFileHelper existingFileHelper, AdvancementType frame, ItemStack item, String titleKey) {
        return Advancement.Builder.advancement()
                .display(createAdvancementDisplay(item,
                        Component.literal("Better McDonald's Mod"),
                        titleKey, frame, false, false))
                .addCriterion("tick", PlayerTrigger.TriggerInstance.tick())
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, BetterMcDonaldsMod.MOD_ID + "/" + titleKey), existingFileHelper);
    }

    // Method to create advancements with a parent
    public static AdvancementHolder createAdvancement(Consumer<AdvancementHolder> consumer, ExistingFileHelper existingFileHelper, AdvancementType frame, ItemStack item, String titleKey, AdvancementHolder parent) {
        return Advancement.Builder.advancement()
                .display(createAdvancementDisplay(item,
                        Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + "." + titleKey + ".title"),
                        titleKey, frame, true, true))
                .addCriterion("inventory_changed", InventoryChangeTrigger.TriggerInstance.hasItems(item.getItem()))
                .parent(parent)
                .save(consumer, new ResourceLocation(BetterMcDonaldsMod.MOD_ID, BetterMcDonaldsMod.MOD_ID + "/" + titleKey), existingFileHelper);
    }

    // Method to create display information for advancements
    public static DisplayInfo createAdvancementDisplay(ItemStack item, Component component, String titleKey, AdvancementType frame, boolean showToast, boolean announceToChat) {
        return new DisplayInfo(item, component,
                Component.translatable("advancement." + BetterMcDonaldsMod.MOD_ID + "." + titleKey + ".description"),
                Optional.of(new ResourceLocation(BetterMcDonaldsMod.MOD_ID, "textures/screens/advancement_tab.png")),
                frame, showToast, announceToChat, false);
    }
}