// Import necessary classes and packages
package net.moritz_htk.bettermcdonaldsmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

// Custom class extending Item for drinkable items
public class DrinkItem extends Item {
    // Constructor for the DrinkItem class
    public DrinkItem(Properties properties) {
        super(properties);
    }

    // Method to determine the use animation for the item
    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        // Return UseAnim.DRINK if the item is edible, else UseAnim.NONE
        return itemStack.getItem().isEdible() ? UseAnim.DRINK : UseAnim.NONE;
    }
}