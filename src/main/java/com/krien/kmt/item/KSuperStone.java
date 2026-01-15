package com.krien.kmt.item;

import com.krien.kmt.Kmt;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class KSuperStone {
    public static final DeferredRegister<Item> K_SUPER_STONE = DeferredRegister.create(ForgeRegistries.ITEMS, Kmt.MODID);
    public static final RegistryObject<Item> k_super_stone = K_SUPER_STONE.register("k_super_stone",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .setNoRepair()
                    .fireResistant()
                    .stacksTo(64)){
                @Override
                public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
                    p_41423_.add(Component.literal("§kkriendechaojuedajian"));
                    p_41423_.add(Component.literal("§f无限不稳定的能量结晶!"));
                    p_41423_.add(Component.literal("§4右键效果: 以使用者为中心发生毁灭性爆炸"));
                    super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
                }

                @Override
                public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {
                    ItemStack stack = p_41433_.getItemInHand(p_41434_);

                    AABB area = new AABB(
                            p_41433_.getX() - 30f, p_41433_.getY() - 30f, p_41433_.getZ() - 30,
                            p_41433_.getX() + 30f, p_41433_.getY() + 30f, p_41433_.getZ() + 30
                    );

                    p_41432_.explode(
                            p_41433_,
                            p_41433_.getX(), p_41433_.getY(), p_41433_.getZ(),
                            30f,
                            Level.ExplosionInteraction.TNT
                    );

                    List<LivingEntity> entities = p_41432_.getEntitiesOfClass(
                            LivingEntity.class,
                            area,
                            Objects::nonNull
                    );

                    for (LivingEntity e : entities){
                        e.setSecondsOnFire(10);
                        e.hurt(p_41432_.damageSources().playerAttack(p_41433_), Float.MAX_VALUE);
                    }

                    if (!p_41433_.isCreative()){
                        stack.shrink(1);
                    }

                    p_41433_.swing(p_41434_);
                    p_41433_.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP);

                    if (stack.isEmpty()){
                        return InteractionResultHolder.consume(ItemStack.EMPTY);
                    }
                    return InteractionResultHolder.success(stack);
                }
            });
}
