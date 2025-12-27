package net.ktf.ae.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.player.LocalPlayer;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AtfirststartProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (!(new Object() {
			public boolean hasRecipe(Entity _ent, ResourceLocation recipe) {
				if (_ent instanceof ServerPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				else if (_ent.level().isClientSide() && _ent instanceof LocalPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				return false;
			}
		}.hasRecipe(entity, new ResourceLocation("amulet:rut")))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("amulet:rut")});
		}
		if (!(new Object() {
			public boolean hasRecipe(Entity _ent, ResourceLocation recipe) {
				if (_ent instanceof ServerPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				else if (_ent.level().isClientSide() && _ent instanceof LocalPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				return false;
			}
		}.hasRecipe(entity, new ResourceLocation("amulet:ra")))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("amulet:ra")});
		}
		if (!(new Object() {
			public boolean hasRecipe(Entity _ent, ResourceLocation recipe) {
				if (_ent instanceof ServerPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				else if (_ent.level().isClientSide() && _ent instanceof LocalPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				return false;
			}
		}.hasRecipe(entity, new ResourceLocation("amulet:rezept_h")))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("amulet:rezept_h")});
		}
		if (!(new Object() {
			public boolean hasRecipe(Entity _ent, ResourceLocation recipe) {
				if (_ent instanceof ServerPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				else if (_ent.level().isClientSide() && _ent instanceof LocalPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				return false;
			}
		}.hasRecipe(entity, new ResourceLocation("amulet:rezept_p")))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("amulet:rezept_p")});
		}
		if (!(new Object() {
			public boolean hasRecipe(Entity _ent, ResourceLocation recipe) {
				if (_ent instanceof ServerPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				else if (_ent.level().isClientSide() && _ent instanceof LocalPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				return false;
			}
		}.hasRecipe(entity, new ResourceLocation("amulet:rgd")))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("amulet:rgd")});
		}
		if (!(new Object() {
			public boolean hasRecipe(Entity _ent, ResourceLocation recipe) {
				if (_ent instanceof ServerPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				else if (_ent.level().isClientSide() && _ent instanceof LocalPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				return false;
			}
		}.hasRecipe(entity, new ResourceLocation("amulet:aow")))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("amulet:aow")});
		}
		if (!(new Object() {
			public boolean hasRecipe(Entity _ent, ResourceLocation recipe) {
				if (_ent instanceof ServerPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				else if (_ent.level().isClientSide() && _ent instanceof LocalPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				return false;
			}
		}.hasRecipe(entity, new ResourceLocation("amulet:ao_r")))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("amulet:ao_r")});
		}
		if (!(new Object() {
			public boolean hasRecipe(Entity _ent, ResourceLocation recipe) {
				if (_ent instanceof ServerPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				else if (_ent.level().isClientSide() && _ent instanceof LocalPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				return false;
			}
		}.hasRecipe(entity, new ResourceLocation("amulet:rkr")))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("amulet:rkr")});
		}
		if (!(new Object() {
			public boolean hasRecipe(Entity _ent, ResourceLocation recipe) {
				if (_ent instanceof ServerPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				else if (_ent.level().isClientSide() && _ent instanceof LocalPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				return false;
			}
		}.hasRecipe(entity, new ResourceLocation("amulet:raf")))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("amulet:raf")});
		}
		if (!(new Object() {
			public boolean hasRecipe(Entity _ent, ResourceLocation recipe) {
				if (_ent instanceof ServerPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				else if (_ent.level().isClientSide() && _ent instanceof LocalPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				return false;
			}
		}.hasRecipe(entity, new ResourceLocation("amulet:rht")))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("amulet:rht")});
		}
		if (!(new Object() {
			public boolean hasRecipe(Entity _ent, ResourceLocation recipe) {
				if (_ent instanceof ServerPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				else if (_ent.level().isClientSide() && _ent instanceof LocalPlayer _player)
					return _player.getRecipeBook().contains(recipe);
				return false;
			}
		}.hasRecipe(entity, new ResourceLocation("amulet:aol")))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(new ResourceLocation[]{new ResourceLocation("amulet:aol")});
		}
	}
}
