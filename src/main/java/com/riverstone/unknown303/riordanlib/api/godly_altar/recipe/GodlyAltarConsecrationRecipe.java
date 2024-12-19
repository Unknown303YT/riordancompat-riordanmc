package com.riverstone.unknown303.riordanlib.api.godly_altar.recipe;

import com.riverstone.unknown303.riordanlib.block.custom.godly_altar.GodlyAltarBlockEntity.GodlyAltarMenuType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

public class GodlyAltarConsecrationRecipe extends GodlyAltarRecipe {
    private final ResourceLocation recipeId;
    private final ItemLike result;
    private final int count;
    private int requiredProgress;
    private ItemLike offering;

    public GodlyAltarConsecrationRecipe(ResourceLocation recipeId, ItemLike result, int count) {
        this.recipeId = recipeId;
        this.result = result;
        this.count = count;
    }

    public GodlyAltarConsecrationRecipe progress(int newRequiredProgress) {
        this.requiredProgress = newRequiredProgress;
        return this;
    }

    public GodlyAltarConsecrationRecipe offering(ItemLike offering) {
        this.offering = offering;
        return this;
    }

    @Override
    public ResourceLocation getRecipeId() {
        return this.recipeId;
    }

    @Override
    public GodlyAltarMenuType getRecipeType() {
        return GodlyAltarMenuType.CONSECRATE;
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

    public ItemLike getOffering() {
        return this.offering;
    }
}
