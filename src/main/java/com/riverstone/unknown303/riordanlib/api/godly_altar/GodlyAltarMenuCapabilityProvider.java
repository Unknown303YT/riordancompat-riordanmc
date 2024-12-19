package com.riverstone.unknown303.riordanlib.api.godly_altar;

import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GodlyAltarMenuCapabilityProvider implements ICapabilityProvider {
    private final LazyOptional<GodlyAltarMenuCapability> instance = LazyOptional.of(GodlyAltarMenuCapability::new);

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return cap == GodlyAltarMenuCapability.CAPABILITY ? instance.cast() : LazyOptional.empty();
    }
}
