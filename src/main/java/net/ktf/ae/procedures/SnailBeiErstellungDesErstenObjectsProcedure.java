package net.ktf.ae.procedures;

import net.minecraft.world.entity.Entity;

public class SnailBeiErstellungDesErstenObjectsProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("in", false);
		entity.getPersistentData().putBoolean("sit", false);
	}
}
