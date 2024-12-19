package com.riverstone.unknown303.riordanlib.api.godly_altar.recipe;

import com.riverstone.unknown303.riordanlib.block.custom.godly_altar.GodlyAltarBlockEntity.GodlyAltarMenuType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

import java.util.HashMap;
import java.util.List;

public class GodlyAltarCraftingRecipe extends GodlyAltarRecipe {
    private final ResourceLocation recipeId;
    private final ItemLike result;
    private final int count;
    private int requiredProgress;
    private int lines;
    private List<String> contents;
    private HashMap<Character, ItemLike> definitions;
    private Fluid coolerFluid;

    public GodlyAltarCraftingRecipe(ResourceLocation recipeId, ItemLike result, int count) {
        this.recipeId = recipeId;
        this.result = result;
        this.count = count;
        this.coolerFluid = Fluids.WATER;
        this.lines = 0;
    }

    public GodlyAltarCraftingRecipe progress(int newRequiredProgress) {
        this.requiredProgress = newRequiredProgress;
        return this;
    }

    public GodlyAltarCraftingRecipe pattern(String line) {
        this.contents.add(line);
        this.lines++;
        return this;
    }

    public GodlyAltarCraftingRecipe define(Character key, ItemLike value) {
        this.definitions.put(key, value);
        return this;
    }

    public GodlyAltarCraftingRecipe setCooler(Fluid cooler) {
        this.coolerFluid = cooler;
        return this;
    }

    @Override
    public ResourceLocation getRecipeId() {
        return recipeId;
    }

    @Override
    public GodlyAltarMenuType getRecipeType() {
        return GodlyAltarMenuType.CRAFT;
    }

    @Override
    public ItemLike getResult() {
        return this.result;
    }

    @Override
    public int getCount() {
        return this.count;
    }

    @Override
    public int getRequiredProgress() {
        return this.requiredProgress;
    }

    public int getLines() {
        return this.lines;
    }

    public List<String> getRecipeContents() {
        return this.contents;
    }

    public HashMap<Character, ItemLike> getDefinitions() {
        return this.definitions;
    }

    public Fluid getCoolerFluid() {
        return this.coolerFluid;
    }
}
