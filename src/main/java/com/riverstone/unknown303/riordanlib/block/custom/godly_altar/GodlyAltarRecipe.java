package com.riverstone.unknown303.riordanlib.block.custom.godly_altar;

import com.riverstone.unknown303.riordanlib.RiordanMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import org.slf4j.Marker;

import java.util.HashMap;
import java.util.List;

public class GodlyAltarRecipe {
    public enum GodlyAltarRecipeType {
        CRAFT,
        ENCHANT,
        COMBINE
    }

    ResourceLocation recipeId;
    GodlyAltarRecipeType recipeType;
    int lines;
    List<String> recipe;
    HashMap<Character, ItemLike> items;
    Fluid coolerFluid;
    ItemLike result;
    int count;


    public GodlyAltarRecipe(ResourceLocation recipeId, GodlyAltarRecipeType recipeType,
                            int lines, List<String> recipe, HashMap<Character, ItemLike> items,
                            Fluid coolerFluid, ItemLike result, int count) {
        this.recipeId = recipeId;
        this.recipeType = recipeType;
        this.lines = lines;
        this.recipe = recipe;
        this.items = items;
        this.coolerFluid = coolerFluid;
        this.result = result;
        this.count = count;
    }

    public GodlyAltarRecipe(ResourceLocation recipeId, GodlyAltarRecipeType recipeType,
                             int lines, List<String> recipe, HashMap<Character, ItemLike> items,
                             ItemLike result, int count) {
        this(recipeId, recipeType, lines, recipe, items, Fluids.WATER, result, count);
    }

    public GodlyAltarRecipe(ResourceLocation recipeId, GodlyAltarRecipeType recipeType,
                            int lines, List<String> recipe, HashMap<Character, ItemLike> items,
                            Fluid coolerFluid, ItemLike result) {
        this(recipeId, recipeType, lines, recipe, items, coolerFluid, result, 1);
    }

    public GodlyAltarRecipe(ResourceLocation recipeId, GodlyAltarRecipeType recipeType,
                            int lines, List<String> recipe, HashMap<Character, ItemLike> items,
                            ItemLike result) {
        this(recipeId, recipeType, lines, recipe, items, Fluids.WATER, result);
    }

    public GodlyAltarRecipe(ResourceLocation recipeId, GodlyAltarRecipeType recipeType,
                            List<String> recipe, HashMap<Character, ItemLike> items,
                            Fluid coolerFluid, ItemLike result, int count) {
        this(recipeId, recipeType, 3, recipe, items, coolerFluid, result, count);
    }

    public GodlyAltarRecipe(ResourceLocation recipeId, GodlyAltarRecipeType recipeType,
                            List<String> recipe, HashMap<Character, ItemLike> items,
                            ItemLike result, int count) {
        this(recipeId, recipeType, recipe, items, Fluids.WATER, result, count);
    }

    public GodlyAltarRecipe(ResourceLocation recipeId, GodlyAltarRecipeType recipeType,
                            List<String> recipe, HashMap<Character, ItemLike> items,
                            Fluid coolerFluid, ItemLike result) {
        this(recipeId, recipeType, 3, recipe, items, coolerFluid, result, 1);
    }

    public GodlyAltarRecipe(ResourceLocation recipeId, GodlyAltarRecipeType recipeType,
                            List<String> recipe, HashMap<Character, ItemLike> items,
                            ItemLike result) {
        this(recipeId, recipeType, recipe, items, Fluids.WATER, result);
    }
}
