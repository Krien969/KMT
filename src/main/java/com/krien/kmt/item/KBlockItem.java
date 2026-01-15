package com.krien.kmt.item;

import com.krien.kmt.block.KBlock;
import com.krien.kmt.Kmt;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KBlockItem {
    public static final DeferredRegister<Item> KBLOCK_ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, Kmt.MODID);
    public static final RegistryObject<Item> k_block_item = KBLOCK_ITEM.register("k_block",
            () -> new BlockItem(KBlock.k_block.get(), new Item.Properties().rarity(Rarity.EPIC)){
                @Override
                public void appendHoverText(ItemStack p_40572_, @Nullable Level p_40573_, List<Component> p_40574_, TooltipFlag p_40575_) {
                    p_40574_.add(Component.literal("§kahdfodshfasjidjaoidfja"));
                    p_40574_.add(Component.literal("§d包罗万象！"));
                    super.appendHoverText(p_40572_, p_40573_, p_40574_, p_40575_);
                }
            });
}
