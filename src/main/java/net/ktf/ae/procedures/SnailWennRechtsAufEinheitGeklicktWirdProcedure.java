package net.ktf.ae.procedures;

import net.minecraft.world.entity.Entity;

public class SnailWennRechtsAufEinheitGeklicktWirdProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (true == entity.getPersistentData().getBoolean("sit")) {
			entity.getPersistentData().putBoolean("sit", false);
		} else if (false == entity.getPersistentData().getBoolean("sit")) {
			entity.getPersistentData().putBoolean("sit", true);
		}
	}
}
