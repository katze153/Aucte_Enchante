package net.ktf.ae.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class AmulettofinvulnerableWhileBaubleIsEquippedTickProcedure {
    public static void execute(Entity entity, ItemStack itemstack) {
        if (entity == null)
            return;
        if (1 == itemstack.getOrCreateTag().getDouble("lvl")) {
            if (false == (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.ABSORPTION))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, 1, false, false));
            }
        } else if (2 == itemstack.getOrCreateTag().getDouble("lvl")) {
            if (false == (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.ABSORPTION))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, 2, false, false));
            }
        } else if (3 == itemstack.getOrCreateTag().getDouble("lvl")) {
            if (false == (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.ABSORPTION))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, 3, false, false));
            }
        } else if (4 == itemstack.getOrCreateTag().getDouble("lvl")) {
            if (false == (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.ABSORPTION))) {
                if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
                    _entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 200, 4, false, false));
            }
        }
    }
}