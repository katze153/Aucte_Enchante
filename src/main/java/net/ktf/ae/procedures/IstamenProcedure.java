package net.ktf.ae.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;

import net.ktf.ae.entity.SnailEntity;

import java.util.Comparator;

public class IstamenProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double t = 0;
		boolean bool = false;
		for (int index0 = 0; index0 < 8; index0++) {
			t = t + 1;
			if (1 == t) {
				sx = x + 1;
				sy = y + 0;
				sz = z + -1;
			} else if (2 == t) {
				sx = x + 1;
				sy = y + 0;
				sz = z + 0;
			} else if (3 == t) {
				sx = x + 1;
				sy = y + 0;
				sz = z + 1;
			} else if (4 == t) {
				sx = x + 0;
				sy = y + 0;
				sz = z + 1;
			} else if (5 == t) {
				sx = x + -1;
				sy = y + 0;
				sz = z + 1;
			} else if (6 == t) {
				sx = x + 1;
				sy = y + 0;
				sz = z + 0;
			} else if (7 == t) {
				sx = x + -1;
				sy = y + 0;
				sz = z + 1;
			} else if (8 == t) {
				sx = x + 0;
				sy = y + 0;
				sz = z + -1;
			}
			if ((((Entity) world.getEntitiesOfClass(SnailEntity.class, AABB.ofSize(new Vec3(sx, sy, sz), 1, 1, 1), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(sx, sy, sz)).findFirst().orElse(null)) instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) == true) {
				bool = true;
			}
		}
		if (bool) {
			return true;
		}
		return false;
	}
}
