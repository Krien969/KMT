package com.krien.kmt.block;

import com.krien.kmt.Kmt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class KBlock {
    public static final DeferredRegister<Block> KBLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, Kmt.MODID);

    public static final RegistryObject<Block> k_block = KBLOCK.register("k_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f, 999f)
                    .sound(SoundType.GLASS)
                    .lightLevel(s -> 10)
                    .speedFactor(2f)
                    .jumpFactor(2f)));
}
