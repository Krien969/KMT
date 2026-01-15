package com.krien.kmt.block;

import com.krien.kmt.Kmt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class KSuperBlock {
    public static final DeferredRegister<Block> K_SUPER_BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, Kmt.MODID);
    public static final RegistryObject<Block> k_super_block = K_SUPER_BLOCK.register("k_super_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.GLASS)
                    .jumpFactor(4f)
                    .strength(3f, 999f)
                    .speedFactor(3f)
                    .lightLevel(s -> 15)));
}
