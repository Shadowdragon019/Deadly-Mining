package net.mcreator.deadlymining.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.deadlymining.block.SoulsandFarmlandBlock;
import net.mcreator.deadlymining.DeadlyminingModElements;

import java.util.Map;

@DeadlyminingModElements.ModElement.Tag
public class SoulsandFarmlandMoistCheckProcedure extends DeadlyminingModElements.ModElement {
	public SoulsandFarmlandMoistCheckProcedure(DeadlyminingModElements instance) {
		super(instance, 61);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SoulsandFarmlandMoistCheck!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SoulsandFarmlandMoistCheck!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SoulsandFarmlandMoistCheck!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SoulsandFarmlandMoistCheck!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double BlockX = 0;
		double BlockY = 0;
		double BlockZ = 0;
		boolean IsLavaFound = false;
		IsLavaFound = (boolean) (false);
		BlockX = (double) 5;
		BlockY = (double) 0;
		BlockZ = (double) 5;
		for (int index0 = 0; index0 < (int) (9); index0++) {
			BlockZ = (double) 5;
			BlockX = (double) ((BlockX) - 1);
			for (int index1 = 0; index1 < (int) (9); index1++) {
				BlockZ = (double) ((BlockZ) - 1);
				if (((Blocks.LAVA.getDefaultState()
						.getBlock() == (world.getBlockState(new BlockPos((int) (x - (BlockX)), (int) (y - (BlockY)), (int) (z - (BlockZ)))))
								.getBlock())
						|| (Blocks.LAVA.getDefaultState()
								.getBlock() == (world.getBlockState(new BlockPos((int) (x - (BlockX)), (int) (y - (BlockY)), (int) (z - (BlockZ)))))
										.getBlock()))) {
					IsLavaFound = (boolean) (true);
					break;
				}
			}
		}
		if (((false) == (IsLavaFound))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), SoulsandFarmlandBlock.block.getDefaultState(), 3);
		}
	}
}
