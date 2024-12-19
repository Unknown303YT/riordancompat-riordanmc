package com.riverstone.unknown303.riordanlib.api.godly_altar;

import com.riverstone.unknown303.riordanlib.RiordanMod;
import com.riverstone.unknown303.riordanlib.block.custom.godly_altar.GodlyAltarBlockEntity.GodlyAltarMenuType;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RiordanMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GodlyAltarMenuCapability implements INBTSerializable<CompoundTag> {
    public static final Capability<GodlyAltarMenuCapability> CAPABILITY = CapabilityManager.get(new CapabilityToken<GodlyAltarMenuCapability>() {});

    private GodlyAltarMenuType currentMenu = GodlyAltarMenuType.CRAFT;

    public GodlyAltarMenuType getCurrentMenu() {
        return this.currentMenu;
    }

    public void setCurrentMenu(GodlyAltarMenuType menuType) {
        this.currentMenu = menuType;
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putString("current_godly_altar_menu", this.currentMenu.name());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        this.currentMenu = GodlyAltarMenuType.fromString(tag.getString("current_godly_altar_menu"));
    }

    @SubscribeEvent
    public void registerCaps(RegisterCapabilitiesEvent event) {
        event.register(GodlyAltarMenuCapability.class);
    }
}
