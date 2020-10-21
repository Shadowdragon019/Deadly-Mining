package net.mcreator.deadlymining.procedures;

import net.mcreator.deadlymining.DeadlyminingModElements;

import java.util.Map;

@DeadlyminingModElements.ModElement.Tag
public class MinerZombieOnInitialEntitySpawnProcedure extends DeadlyminingModElements.ModElement {
	public MinerZombieOnInitialEntitySpawnProcedure(DeadlyminingModElements instance) {
		super(instance, 95);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure MinerZombieOnInitialEntitySpawn!");
			return false;
		}
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		if ((y > 32)) {
			return (false);
		}
		return (true);
	}
}
