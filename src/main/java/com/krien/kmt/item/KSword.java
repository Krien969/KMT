package com.krien.kmt.item;

import com.krien.kmt.Kmt;
import com.krien.kmt.Kmt.*;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class KSword {
    public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, Kmt.MODID);

    public static class KMaterial implements Tier{
        public static final Tier INSTANCE = new KMaterial();

        @Override
        public int getUses(){
            return -1;
        }

        @Override
        public float getSpeed() {
            return 19f;
        }

        @Override
        public float getAttackDamageBonus() {
            return Float.MAX_VALUE;
        }

        @Override
        public int getLevel() {
            return 5;
        }

        @Override
        public int getEnchantmentValue() {
            return 30;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.EMPTY;
        }
    }

    public static final RegistryObject<Item> K_sword = ITEM.register("k_sword",
            () -> new SwordItem(
                    KMaterial.INSTANCE,
                    0,
                    -2.7f,
                    new Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.EPIC)
                            .fireResistant()
                            .setNoRepair()
            ){
                public static int mode = 0;
                @Override
                public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
                    p_41423_.add(Component.literal("§kkriendechaojuedajian"));
                    p_41423_.add(Component.literal("§d万化无限尽在其中，以此剑，肃清万象！"));
                    p_41423_.add(Component.literal("§4右键效果: 对周围60格的生物进行毁灭性打击并召唤落雷"));
                    p_41423_.add(Component.literal("§4当Kernel · Killer在背包/副手/主手/物品栏中时，启动创造飞行并免疫摔落伤害"));
                    super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
                }

                @Override
                public InteractionResultHolder<ItemStack> use(Level p_41432_, Player p_41433_, InteractionHand p_41434_) {
                    ItemStack stack = p_41433_.getItemInHand(p_41434_);

                    AABB area = new AABB(
                            p_41433_.getX() - 30, p_41433_.getY() - 30, p_41433_.getZ() - 30,
                            p_41433_.getX() + 30, p_41433_.getY() + 30, p_41433_.getZ() + 30
                    );
                    List<LivingEntity> entities = p_41432_.getEntitiesOfClass(
                            LivingEntity.class,
                            area,
                            e -> e != p_41433_
                    );
                    if (!entities.isEmpty()){
                        p_41433_.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP);
                        for (var e : entities){
                            switch (mode){
                                case 0:
                                    var lighting = new LightningBolt(EntityType.LIGHTNING_BOLT, p_41432_);
                                    lighting.setVisualOnly(true);
                                    lighting.setPos(e.getX(), e.getY(), e.getZ());
                                    p_41432_.addFreshEntity(lighting);
                                    e.hurt(e.damageSources().playerAttack(p_41433_), Float.MAX_VALUE);
                                    break;
                            }
                        }
                    }

                    p_41433_.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 2));
                    p_41433_.swing(p_41434_);

                    return InteractionResultHolder.success(stack);
                }
            });

}
