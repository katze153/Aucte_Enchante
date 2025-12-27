package net.ktf.ae.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;

import net.ktf.ae.network.AeModVariables;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class DebugProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (0 == DoubleArgumentType.getDouble(arguments, "debug")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("0 = help"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("1 = print all"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("2 = dead x"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("3 = dead y"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("4 = dead z"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("5 = dead dimension"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("6 = show amulet lvl"), false);
		}
		if (1 == DoubleArgumentType.getDouble(arguments, "debug")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("####").format((entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).dead_point_x))), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("####").format((entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).dead_point_y))), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("####").format((entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).dead_point_z))), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(((entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).dead_point_world)), false);
		}
		if (2 == DoubleArgumentType.getDouble(arguments, "debug")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("####").format((entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).dead_point_x))), false);
		}
		if (3 == DoubleArgumentType.getDouble(arguments, "debug")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("####").format((entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).dead_point_y))), false);
		}
		if (4 == DoubleArgumentType.getDouble(arguments, "debug")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("####").format((entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).dead_point_z))), false);
		}
		if (5 == DoubleArgumentType.getDouble(arguments, "debug")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(((entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).dead_point_world)), false);
		}
		if (6 == DoubleArgumentType.getDouble(arguments, "debug")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("lvl " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("lvl")))), false);
		}
	}
}
