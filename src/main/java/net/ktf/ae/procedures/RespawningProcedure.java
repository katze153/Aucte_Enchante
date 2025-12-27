package net.ktf.ae.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.ktf.ae.network.AeModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RespawningProcedure {
	@SubscribeEvent
	public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).was_amulet_equict == true) {
			{
				boolean _setval = false;
				entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.was_amulet_equict = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level().getServer(), _ent),
							(((("execute in dd run tp @s dx dy dz".replace("dd", (entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).dead_point_world)).replace("dz",
									new java.text.DecimalFormat("#").format((entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).dead_point_z)))
									.replace("dy", new java.text.DecimalFormat("#").format((entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).dead_point_y)))
									.replace("dx", new java.text.DecimalFormat("#").format((entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).dead_point_x))));
				}
			}
			if (2 == (entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).rv_amulet_lvl) {
				if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY) == false) {
					{
						final int _slotid = 0;
						final ItemStack _setstack = ((entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).v_item).copy();
						_setstack.setCount((int) AeModVariables.MapVariables.get(world).v_menge);
						entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
								_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
						});
					}
				}
			} else if (3 == (entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).rv_amulet_lvl) {
				if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY) == false) {
					{
						final int _slotid = 0;
						final ItemStack _setstack = ((entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AeModVariables.PlayerVariables())).v_item).copy();
						_setstack.setCount((int) AeModVariables.MapVariables.get(world).v_menge);
						entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot)
								_modHandlerEntSetSlot.setStackInSlot(_slotid, _setstack);
						});
					}
				}
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 160, 24, false, false));
			}
		}
	}
}
