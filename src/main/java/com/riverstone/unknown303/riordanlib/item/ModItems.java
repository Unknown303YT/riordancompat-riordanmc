package com.riverstone.unknown303.riordanlib.item;

import com.riverstone.unknown303.riordanlib.RiordanMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RiordanMod.MOD_ID);

    public static final RegistryObject<Item> FABRIC = ITEMS.register("fabric",
            () -> new Item(new Item.Properties().rarity(Rarity.COMMON).stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
