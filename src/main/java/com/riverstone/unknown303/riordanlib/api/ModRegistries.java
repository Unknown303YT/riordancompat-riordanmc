package com.riverstone.unknown303.riordanlib.api;

import com.riverstone.unknown303.riordanlib.api.errorlib.ModHelpers;
import com.riverstone.unknown303.riordanlib.api.godly_altar.recipe.GodlyAltarRecipe;
import net.minecraftforge.registries.IForgeRegistry;

public class ModRegistries {
    public static final IForgeRegistry<GodlyAltarRecipe> GODLY_ALTAR_RECIPES =
            ModHelpers.REGISTRY.createRegistry("godly_altar_recipes");
}
