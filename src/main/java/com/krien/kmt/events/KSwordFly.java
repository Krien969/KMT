package com.krien.kmt.events;

import com.krien.kmt.Kmt;
import com.krien.kmt.item.KSword;
import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerFlyableFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Kmt.MODID)
public class KSwordFly {
    private static long lastSpacePressed = 0;

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key e){
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) return;

        if (e.getKey() == 32){
            if (e.getAction() == 1){
                long time = System.currentTimeMillis();
                if (time - lastSpacePressed <= 350){
                    if (hasItemInBag(player, KSword.K_sword.get())){
                        toggleCreativeFly(player);
                    }
                }
                lastSpacePressed = time;
            }
        }
    }

    @SubscribeEvent
    public static void cancelFallDanger(LivingFallEvent e){
        if (e.getEntity() instanceof  Player fallPlayer){
            if (hasItemInBag(fallPlayer, KSword.K_sword.get())){
                e.setCanceled(true);
                fallPlayer.fallDistance = 0f;
            }
        }
    }

//    @SubscribeEvent
//    public static void cancelFlyIfThrow()

    public static boolean hasItemInBag(Player player, Item item){
        for (ItemStack stack : player.getInventory().items){
            if (stack.getItem() == item){
                return true;
            }
        }
        for (ItemStack stack : player.getInventory().armor){
            if (stack.getItem() == item){
                return true;
            }
        }
        return player.getOffhandItem().getItem() == item;
    }

    public static void toggleCreativeFly(Player player){
        if (player.isCreative()) return;
        if (player.getAbilities().flying){
            player.getAbilities().flying = false;
            player.getAbilities().mayfly = false;
        } else {
            player.getAbilities().flying = true;
        }
        player.onUpdateAbilities();
    }

}
