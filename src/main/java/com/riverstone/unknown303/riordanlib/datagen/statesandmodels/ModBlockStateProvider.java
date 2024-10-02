package com.riverstone.unknown303.riordanlib.datagen.statesandmodels;

import com.riverstone.unknown303.riordanlib.RiordanMod;
import com.riverstone.unknown303.riordanlib.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RiordanMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //Not required. Using manual bstates for rotation.
//        simpleBlockWithItem(ModBlocks.GODLY_ALTAR.get(),
//                new ModelFile.UncheckedModelFile(modLoc("block/godly_altar")));
    }

    private void registryBlockWithItem(RegistryObject<Block> blockRegistryObject) {
        blockWithItem(blockRegistryObject.get());
    }

    private void blockWithItem(Block block) {
        simpleBlockWithItem(block, cubeAll(block));
    }
}
