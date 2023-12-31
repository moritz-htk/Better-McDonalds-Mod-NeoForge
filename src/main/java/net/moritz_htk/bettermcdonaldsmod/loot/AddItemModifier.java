// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class AddItemModifier extends LootModifier {
    // Supplier for creating the Codec for this modifier
    public static final Supplier<Codec<AddItemModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).and(BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(m -> m.item)).apply(inst, AddItemModifier::new)));

    // The item to add as loot
    private final Item item;

    public AddItemModifier(LootItemCondition[] conditionsIn, Item item) {
        // Initialize the modifier with conditions and the item to add
        super(conditionsIn);
        this.item = item;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        // Check if the conditions are met
        for (LootItemCondition condition : this.conditions) {
            if (!condition.test(context)) {
                return generatedLoot;
            }
        }

        // Add the specified item to the generated loot
        generatedLoot.add(new ItemStack(this.item));
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        // Return the Codec used to serialize/deserialize this modifier
        return CODEC.get();
    }
}