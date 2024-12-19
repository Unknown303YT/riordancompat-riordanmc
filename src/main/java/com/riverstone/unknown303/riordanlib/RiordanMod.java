package com.riverstone.unknown303.riordanlib;

import com.mojang.logging.LogUtils;
import com.riverstone.unknown303.riordanlib.api.godly_altar.GodlyAltarMenuCapability;
import com.riverstone.unknown303.riordanlib.block.ModBlocks;
import com.riverstone.unknown303.riordanlib.block.ModBlockEntities;
import com.riverstone.unknown303.riordanlib.block.custom.godly_altar.ModGodlyAltarRecipes;
import com.riverstone.unknown303.riordanlib.item.ModCreativeTabs;
import com.riverstone.unknown303.riordanlib.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(RiordanMod.MOD_ID)
public class RiordanMod {
    public static final String MOD_ID = "riordancompat";
    public static final Logger LOGGER = LogUtils.getLogger();

    public RiordanMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModGodlyAltarRecipes.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModCreativeTabs.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            event.getOriginal().getCapability(GodlyAltarMenuCapability.CAPABILITY).ifPresent(oldCap -> {
                event.getOriginal().getCapability(GodlyAltarMenuCapability.CAPABILITY).ifPresent(newCap -> {
                    newCap.setCurrentMenu(oldCap.getCurrentMenu());
                });
            });
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.FABRIC);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
