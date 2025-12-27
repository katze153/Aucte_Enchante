package net.ktf.ae.procedures;

import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;

public class IstamennProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) {
			return false;
		}
		return true;
	}
}
