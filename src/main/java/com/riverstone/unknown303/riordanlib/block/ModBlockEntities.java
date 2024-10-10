package com.riverstone.unknown303.riordanlib.block;

import com.riverstone.unknown303.riordanlib.RiordanMod;
import com.riverstone.unknown303.riordanlib.block.custom.godly_altar.GodlyAltarBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RiordanMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<GodlyAltarBlockEntity>> GODLY_ALTAR_BE =
            BLOCK_ENTITIES.register("godly_altar_be", () ->
                    BlockEntityType.Builder.of(GodlyAltarBlockEntity::new,
                            ModBlocks.GODLY_ALTAR.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
