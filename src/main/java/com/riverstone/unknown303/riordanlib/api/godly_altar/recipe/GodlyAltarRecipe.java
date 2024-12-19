package com.riverstone.unknown303.riordanlib.api.godly_altar.recipe;

import com.riverstone.unknown303.riordanlib.RiordanMod;
import com.riverstone.unknown303.riordanlib.block.custom.godly_altar.GodlyAltarBlockEntity.GodlyAltarMenuType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

import java.util.List;

public abstract class GodlyAltarRecipe {
    public abstract ResourceLocation getRecipeId();
    public abstract GodlyAltarMenuType getRecipeType();
    public abstract ItemLike getResult();
    public abstract int getCount();
    public abstract int getRequiredProgress();

    public static boolean doesCraftingRecipeMatch(List<ItemLike> items, GodlyAltarCraftingRecipe recipe) {
        if (items.size() != 9) {
            IllegalStateException exception = new IllegalStateException("Invalid Size of Items in Godly Altar Recipe");
            RiordanMod.LOGGER.error("Invalid Size of Items provided.", exception);
            return false;
        }

        List<String> recipeContents = recipe.getRecipeContents();
        int index = 0;
        for (String line : recipeContents) {
            for (char itemKey : line.toCharArray()) {
                ItemLike value;
                if (recipe.getDefinitions().containsKey(itemKey)) {
                    value = recipe.getDefinitions().get(itemKey);
                } else if (itemKey == ' ') {
                    value = Items.AIR;
                } else {
                    IllegalStateException exception = new IllegalStateException("Recipe Contents not defined.");
                    RiordanMod.LOGGER.error("Recipe Contents not defined.", exception);
                    return false;
                }

                if (!items.get(index).equals(value)) {
                    return false;
                }
                index++;
            }
        }

        return false;
    }

    public static boolean doesCombiningRecipeMatch(List<ItemLike> items, GodlyAltarCombiningRecipe recipe) {
        if (items.size() != 2) {
            IllegalStateException exception = new IllegalStateException("Invalid Size of Items in Godly Altar Recipe");
            RiordanMod.LOGGER.error("Invalid Size of Items provided.", exception);
            return false;
        }

        List<ItemLike> recipeContents = recipe.getContents();
        return items.get(0).equals(recipeContents.get(0)) && items.get(1).equals(recipeContents.get(1));
    }

    public static boolean doesConsecrationRecipeMatch(ItemLike offering, GodlyAltarConsecrationRecipe recipe) {
        return offering.equals(recipe.getOffering());
    }
}
