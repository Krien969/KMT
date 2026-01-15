package com.krien.kmt.item;

import com.krien.kmt.Kmt;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KStick {
    public static final DeferredRegister<Item> KSTICK = DeferredRegister.create(ForgeRegistries.ITEMS, Kmt.MODID);
    public static final RegistryObject<Item> k_stick = KSTICK.register("k_stick",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .stacksTo(64)
                    .fireResistant()){
                @Override
                public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
                    p_41423_.add(Component.literal("§kkriendechaojuedajian"));
                    p_41423_.add(Component.literal("§d由Kernel水晶集合铸造的无上材料."));
                    super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
                }
            });
}
