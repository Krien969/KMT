package com.krien.kmt.item;

import com.krien.kmt.Kmt;
import com.krien.kmt.block.KSuperBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KSuperBlockItem {
    public static final DeferredRegister<Item> K_SUPER_BLOCK_ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, Kmt.MODID);
    public static final RegistryObject<Item> k_super_block_item = K_SUPER_BLOCK_ITEM.register("k_super_block",
            () -> new BlockItem(KSuperBlock.k_super_block.get(), new Item.Properties()
                    .rarity(Rarity.EPIC)){
                @Override
                public void appendHoverText(ItemStack p_40572_, @Nullable Level p_40573_, List<Component> p_40574_, TooltipFlag p_40575_) {
                    p_40574_.add(Component.literal("§kahdfodshfasjidjaoidfja"));
                    p_40574_.add(Component.literal("§4超越无限的力量..."));
                    super.appendHoverText(p_40572_, p_40573_, p_40574_, p_40575_);
                }
            });
}
