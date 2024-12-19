package com.riverstone.unknown303.riordanlib.block.custom.godly_altar;

import com.riverstone.unknown303.riordanlib.RiordanMod;
import com.riverstone.unknown303.riordanlib.api.ModRegistries;
import com.riverstone.unknown303.riordanlib.api.godly_altar.recipe.GodlyAltarRecipe;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

public class ModGodlyAltarRecipes {
    public static final DeferredRegister<GodlyAltarRecipe> GODLY_ALTAR_RECIPES =
            DeferredRegister.create(ModRegistries.GODLY_ALTAR_RECIPES, RiordanMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        GODLY_ALTAR_RECIPES.register(eventBus);
    }
}
