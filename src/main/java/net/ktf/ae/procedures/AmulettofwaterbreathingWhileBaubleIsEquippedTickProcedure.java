package net.ktf.ae.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class AmulettofwaterbreathingWhileBaubleIsEquippedTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (1 == itemstack.getOrCreateTag().getDouble("lvl")) {
			if (false == (entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.WATER_BREATHING))) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "effect give @s minecraft:water_breathing infinite 1 true");
					}
				}
			}
		}
		if (2 == itemstack.getOrCreateTag().getDouble("lvl")) {
			if (false == (entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.WATER_BREATHING))) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "effect give @s minecraft:water_breathing infinite 1 true");
					}
				}
			}
			if (false == (entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.NIGHT_VISION))) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "effect give @s minecraft:night_vision infinite 1 true");
					}
				}
			}
		}
	}
}
