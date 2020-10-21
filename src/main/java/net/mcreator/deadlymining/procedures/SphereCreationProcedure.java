package net.mcreator.deadlymining.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.deadlymining.DeadlyminingModElements;

import java.util.Map;

@DeadlyminingModElements.ModElement.Tag
public class SphereCreationProcedure extends DeadlyminingModElements.ModElement {
	public SphereCreationProcedure(DeadlyminingModElements instance) {
		super(instance, 27);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SphereCreation!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SphereCreation!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SphereCreation!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SphereCreation!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double radius = 0;
		double location_x = 0;
		double location_y = 0;
		double location_z = 0;
		double location_distance = 0;
		radius = (double) 5;
		location_x = (double) 0;
		location_y = (double) 0;
		location_z = (double) 0;
		for (int index0 = 0; index0 < (int) (Double.POSITIVE_INFINITY); index0++) {
			location_distance = (double) Math.sqrt((((location_y) * (location_y)) + (((location_x) * (location_x)) + ((location_z) * (location_z)))));
			if (((location_distance) <= ((radius) + 0.1))) {
				world.setBlockState(new BlockPos((int) (x + ((location_x) * 1)), (int) (y + ((location_y) * 1)), (int) (z + ((location_z) * 1))),
						Blocks.COBBLESTONE.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + ((location_x) * (-1))), (int) (y + ((location_y) * 1)), (int) (z + ((location_z) * 1))),
						Blocks.COBBLESTONE.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + ((location_x) * 1)), (int) (y + ((location_y) * (-1))), (int) (z + ((location_z) * 1))),
						Blocks.COBBLESTONE.getDefaultState(), 3);
				world.setBlockState(new BlockPos((int) (x + ((location_x) * 1)), (int) (y + ((location_y) * 1)), (int) (z + ((location_z) * (-1)))),
						Blocks.COBBLESTONE.getDefaultState(), 3);
				world.setBlockState(
						new BlockPos((int) (x + ((location_x) * (-1))), (int) (y + ((location_y) * 1)), (int) (z + ((location_z) * (-1)))),
						Blocks.COBBLESTONE.getDefaultState(), 3);
				world.setBlockState(
						new BlockPos((int) (x + ((location_x) * (-1))), (int) (y + ((location_y) * (-1))), (int) (z + ((location_z) * 1))),
						Blocks.COBBLESTONE.getDefaultState(), 3);
				world.setBlockState(
						new BlockPos((int) (x + ((location_x) * 1)), (int) (y + ((location_y) * (-1))), (int) (z + ((location_z) * (-1)))),
						Blocks.COBBLESTONE.getDefaultState(), 3);
				world.setBlockState(
						new BlockPos((int) (x + ((location_x) * (-1))), (int) (y + ((location_y) * (-1))), (int) (z + ((location_z) * (-1)))),
						Blocks.COBBLESTONE.getDefaultState(), 3);
				location_z = (double) ((location_z) + 1);
			} else {
				location_x = (double) ((location_x) + 1);
				location_z = (double) 0;
			}
			if (((location_x) > (radius))) {
				location_y = (double) ((location_y) + 1);
				location_x = (double) 0;
				location_z = (double) 0;
			}
			if (((location_y) > (radius))) {
				break;
			}
		}
	}
}
