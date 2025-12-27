package net.ktf.ae.procedures;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.ktf.ae.network.AeModVariables;
import net.ktf.ae.init.AeModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DeadpointProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = entity.getX();
			entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.dead_point_x = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.getY();
			entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.dead_point_y = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.getZ();
			entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.dead_point_z = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (Level.END == (entity.level().dimension())) {
			{
				String _setval = "minecraft:the_end";
				entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.dead_point_world = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (Level.NETHER == (entity.level().dimension())) {
			{
				String _setval = "minecraft:the_nether";
				entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.dead_point_world = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (Level.OVERWORLD == (entity.level().dimension())) {
			{
				String _setval = "minecraft:overworld";
				entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.dead_point_world = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(AeModItems.AMULET_OF_REVIVAL.get(), lv).isPresent() : false) {
			{
				boolean _setval = true;
				entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.was_amulet_equict = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (false == world.getLevelData().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
				SaveiteminhandProcedure.execute(world, entity, entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getCount());
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "item replace entity @s container.0 with air");
					}
				}
			}
		} else {
			{
				boolean _setval = false;
				entity.getCapability(AeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.was_amulet_equict = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
