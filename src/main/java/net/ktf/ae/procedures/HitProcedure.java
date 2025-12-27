package net.ktf.ae.procedures;

import net.minecraft.world.entity.Entity;

public class HitProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("hit")) {
			return false;
		}
		return true;
	}
}
