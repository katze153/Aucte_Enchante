package net.ktf.ae.procedures;

import net.minecraft.world.entity.Entity;

public class IsSittingNotProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (true == entity.getPersistentData().getBoolean("sit")) {
			return false;
		}
		return true;
	}
}
