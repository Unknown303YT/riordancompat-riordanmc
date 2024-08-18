package com.riverstone.unknown303.riordanlib.item;

import com.riverstone.unknown303.riordanlib.RiordanMod;
import com.riverstone.unknown303.riordanlib.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RiordanMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> RIORDAN_TAB = CREATIVE_TABS.register("riordan_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.FABRIC.get()))
                    .title(Component.translatable("creativetab.riordancompat.riordan_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.FABRIC.get());
                        pOutput.accept(ModBlocks.GODLY_ALTAR.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
