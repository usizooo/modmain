package net.alimova.mysticmod.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class DemonicMace extends SwordItem {

    public DemonicMace() {
        super(Tiers.NETHERITE, 5, -3.0F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player) {
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1));
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int itemSlot, boolean isSelected) {
        if (entity instanceof Player) {
            Player player = (Player) entity;
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 0, false, false, true));
        }
        super.inventoryTick(stack, world, entity, itemSlot, isSelected);
    }
}