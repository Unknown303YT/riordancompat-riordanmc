package com.riverstone.unknown303.riordanlib.block.custom.godly_altar;

import com.riverstone.unknown303.riordanlib.api.godly_altar.GodlyAltarMenuCapability;
import com.riverstone.unknown303.riordanlib.block.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GodlyAltarBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler craftingItemHandler = new ItemStackHandler(10);
    private LazyOptional<IItemHandler> craftingLazyItemHandler = LazyOptional.empty();
    private static final int CRAFTING_OUTPUT_SLOT = 9;
    private final ItemStackHandler combiningItemHandler = new ItemStackHandler(3);
    private LazyOptional<IItemHandler> combiningLazyItemHandler = LazyOptional.empty();
    private static final int COMBINING_OUTPUT_SLOT = 2;
    private final ItemStackHandler consecrationItemHandler = new ItemStackHandler(1);
    private LazyOptional<IItemHandler> consecrationLazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int craftingProgress;
    private int combiningProgress;
    private int consecrationProgress;

    List<Player> activePlayers = new ArrayList<>();

    public GodlyAltarBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.GODLY_ALTAR_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> GodlyAltarBlockEntity.this.craftingProgress;
                    case 1 -> GodlyAltarBlockEntity.this.combiningProgress;
                    case 2 -> GodlyAltarBlockEntity.this.consecrationProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> GodlyAltarBlockEntity.this.craftingProgress = pValue;
                    case 1 -> GodlyAltarBlockEntity.this.combiningProgress = pValue;
                    case 2 -> GodlyAltarBlockEntity.this.consecrationProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        };
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return activePlayers.get(activePlayers.size() - 1).getCapability(GodlyAltarMenuCapability.CAPABILITY).map(menuCap -> {
                return switch (menuCap.getCurrentMenu()) {
                    case CRAFT -> craftingLazyItemHandler.cast();
                    case COMBINE -> combiningLazyItemHandler.cast();
                    case CONSECRATE -> consecrationLazyItemHandler.cast();
                };
            }).orElse(LazyOptional.empty()).cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        craftingLazyItemHandler.invalidate();
        combiningLazyItemHandler.invalidate();
        consecrationLazyItemHandler.invalidate();
        for (Player player : activePlayers) {
            activePlayers.remove(player);
        }
    }

    public void drops() {
        SimpleContainer craftingInventory = new SimpleContainer(craftingItemHandler.getSlots());
        SimpleContainer combiningInventory = new SimpleContainer(combiningItemHandler.getSlots());
        SimpleContainer consecrationInventory = new SimpleContainer(consecrationItemHandler.getSlots());
        for (int i = 0; i < craftingItemHandler.getSlots(); i++) {
            craftingInventory.setItem(i, craftingItemHandler.getStackInSlot(i));
        } for (int i = 0; i < combiningItemHandler.getSlots(); i++) {
            combiningInventory.setItem(i, combiningItemHandler.getStackInSlot(i));
        } for (int i = 0; i < consecrationItemHandler.getSlots(); i++) {
            consecrationInventory.setItem(i, consecrationItemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, craftingInventory);
        Containers.dropContents(this.level, this.worldPosition, combiningInventory);
        Containers.dropContents(this.level, this.worldPosition, consecrationInventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.riordancompat.godly_altar");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return null;
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("crafting_inventory", craftingItemHandler.serializeNBT());
        pTag.put("combining_inventory", combiningItemHandler.serializeNBT());
        pTag.put("consecration_inventory", consecrationItemHandler.serializeNBT());

        pTag.putInt("godly_altar.crafting_progress", craftingProgress);
        pTag.putInt("godly_altar.combining_progress", combiningProgress);
        pTag.putInt("godly_altar.consecration_progress", consecrationProgress);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);

        craftingItemHandler.deserializeNBT(pTag.getCompound("crafting_inventory"));
        combiningItemHandler.deserializeNBT(pTag.getCompound("combining_inventory"));
        consecrationItemHandler.deserializeNBT(pTag.getCompound("consecration_inventory"));

        craftingProgress = pTag.getInt("godly_altar.crafting_progress");
        combiningProgress = pTag.getInt("godly_altar.combining_progress");
        consecrationProgress = pTag.getInt("godly_altar.consecration_progress");
    }

    public void tick(Level pLevel, BlockState pState) {
        if (hasRecipe()) {
            increaseCraftingProgress();
            
        }
    }

    public void setActivePlayer(Player player) {
        activePlayers.remove(player);
        activePlayers.add(player);
    }

    public enum GodlyAltarMenuType {
        CRAFT,
        COMBINE,
        CONSECRATE;

        public static GodlyAltarMenuType fromString(String name) {
            try {
                return GodlyAltarMenuType.valueOf(name.toUpperCase());
            } catch (IllegalArgumentException e) {
                return CRAFT;
            }
        }
    }
}
