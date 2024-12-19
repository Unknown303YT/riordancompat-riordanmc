package com.riverstone.unknown303.riordanlib.api.godly_altar.recipe;

import com.riverstone.unknown303.riordanlib.block.custom.godly_altar.GodlyAltarBlockEntity.GodlyAltarMenuType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluid;

import java.util.ArrayList;
import java.util.List;

public class GodlyAltarCombiningRecipe extends GodlyAltarRecipe {
    private final ResourceLocation recipeId;
    private final ItemLike result;
    private final int count;
    private int requiredProgress;
    private final List<ItemLike> contents = new ArrayList<>();
    private Fluid cooler;

    public GodlyAltarCombiningRecipe(ResourceLocation recipeId, ItemLike result, int count) {
        this.recipeId = recipeId;
        this.result = result;
        this.count = count;
    }

    public GodlyAltarCombiningRecipe progress(int newRequiredProgress) {
        this.requiredProgress = newRequiredProgress;
        return this;
    }

    public GodlyAltarCombiningRecipe setContents(ItemLike base, ItemLike addition) {
        contents.set(0, base);
        contents.set(1, addition);
        return this;
    }

    public GodlyAltarCombiningRecipe setCooler(Fluid fluid) {
        this.cooler = fluid;
        return this;
    }

    @Override
    public ResourceLocation getRecipeId() {
        return this.recipeId;
    }

    @Override
    public GodlyAltarMenuType getRecipeType() {
        return GodlyAltarMenuType.COMBINE;
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

    public List<ItemLike> getContents() {
        return this.contents;
    }

    public Fluid getCooler() {
        return this.cooler;
    }
}
