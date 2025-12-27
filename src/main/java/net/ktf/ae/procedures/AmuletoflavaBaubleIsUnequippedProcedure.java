package net.ktf.ae.procedures;

import net.minecraft.world.entity.Entity;

public class AmuletoflavaBaubleIsUnequippedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.setMaxUpStep((float) 0.6);
	}
}
