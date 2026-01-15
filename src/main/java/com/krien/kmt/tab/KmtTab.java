package com.krien.kmt.tab;

import com.krien.kmt.Kmt;
import com.krien.kmt.block.KBlock;
import com.krien.kmt.block.KSuperBlock;
import com.krien.kmt.item.KStick;
import com.krien.kmt.item.KStone;
import com.krien.kmt.item.KSuperStone;
import com.krien.kmt.item.KSword;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class KmtTab {
    public static final DeferredRegister<CreativeModeTab> KMT_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Kmt.MODID);
    public static final RegistryObject<CreativeModeTab> kmt_tab = KMT_TAB.register("kmt_tab",
            () -> {
                return CreativeModeTab.builder()
                        .title(Component.translatable("itemGroup.kmt"))
                        .icon(() -> new ItemStack(KStone.k_stone.get()))
                        .displayItems((p, i) -> {
                            i.accept(KSword.K_sword.get());
                            i.accept(KStone.k_stone.get());
                            i.accept(KSuperStone.k_super_stone.get());
                            i.accept(KBlock.k_block.get());
                            i.accept(KStick.k_stick.get());
                            i.accept(KSuperBlock.k_super_block.get());
                        }).build();
            });
}
