package net.mcreator.deadlymining.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.deadlymining.DeadlyminingModElements;

import java.util.Map;

@DeadlyminingModElements.ModElement.Tag
public class FlamingSwordLivingEntityIsHitWithToolProcedure extends DeadlyminingModElements.ModElement {
	public FlamingSwordLivingEntityIsHitWithToolProcedure(DeadlyminingModElements instance) {
		super(instance, 44);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FlamingSwordLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 5);
	}
}
