package com.krien.kmt;

import com.krien.kmt.block.KBlock;
import com.krien.kmt.block.KSuperBlock;
import com.krien.kmt.item.*;
import com.krien.kmt.tab.KmtTab;
import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod("kmt")
public class Kmt {
    public static final String MODID = "kmt";
    public static final Logger LOGGER = LogUtils.getLogger();
    public Kmt(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        KStick.KSTICK.register(modEventBus);
        KSuperBlock.K_SUPER_BLOCK.register(modEventBus);
        KSuperBlockItem.K_SUPER_BLOCK_ITEM.register(modEventBus);
        KSword.ITEM.register(modEventBus);
        KStone.KSTONE.register(modEventBus);
        KSuperStone.K_SUPER_STONE.register(modEventBus);
        KBlock.KBLOCK.register(modEventBus);
        KBlockItem.KBLOCK_ITEM.register(modEventBus);
        KmtTab.KMT_TAB.register(modEventBus);

        System.out.println("Kmt 模组已加载");
    }
}

