package com.krien.kmt.item;

import com.krien.kmt.Kmt;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
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

public class KStone {
    public static final DeferredRegister<Item> KSTONE = DeferredRegister.create(ForgeRegistries.ITEMS, Kmt.MODID);

    public static final RegistryObject<Item> k_stone = KSTONE.register("k_stone",
            () -> new Item(new Item.Properties()
                    .setNoRepair()
                    .stacksTo(64)
                    .fireResistant()
                    .rarity(Rarity.EPIC)){
                @Override
                public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
                    p_41423_.add(Component.literal("§kkriendechaojuedajian"));
                    p_41423_.add(Component.literal("§d集合万千，无限潜能!"));
                    p_41423_.add(Component.literal("§4右键效果: 获取力量强化II 20秒"));
                    super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
                }

                @Override
                public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {
                    ItemStack stack = p_41433_.getItemInHand(p_41434_);

                    p_41433_.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 1));
                    p_41433_.swing(p_41434_);
                    if (!p_41433_.getAbilities().instabuild){
                        stack.shrink(1);
                    }
                    p_41432_.playSound(null, p_41433_.getX(), p_41433_.getY(), p_41433_.getZ(),
                            SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.PLAYERS, 1f, 1f);
                    if (stack.isEmpty()){
                        return InteractionResultHolder.consume(ItemStack.EMPTY);
                    } else {
                        return InteractionResultHolder.success(stack);
                    }
                }
            });
}
