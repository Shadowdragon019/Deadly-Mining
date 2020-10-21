package net.mcreator.deadlymining.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.deadlymining.DeadlyminingModElements;

import java.util.Map;

@DeadlyminingModElements.ModElement.Tag
public class OreChunkBlockAddedProcedure extends DeadlyminingModElements.ModElement {
	public OreChunkBlockAddedProcedure(DeadlyminingModElements instance) {
		super(instance, 104);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure OreChunkBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure OreChunkBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure OreChunkBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure OreChunkBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() > 0.33)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
					(Math.round(Math.random()) == 0
							? (Math.round(Math.random()) == 0
									? (Math.round(Math.random()) == 0
											? (Math.round(Math.random()) == 0
													? (Math.round(Math.random()) == 0 ? Blocks.IRON_ORE : Blocks.REDSTONE_ORE)
													: Blocks.GOLD_ORE)
											: Blocks.LAPIS_ORE)
									: Blocks.DIAMOND_ORE)
							: Blocks.EMERALD_ORE).getDefaultState(),
					3);
		} else {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z),
					(Math.round(Math.random()) == 0
							? (Math.round(Math.random()) == 0
									? (Math.round(Math.random()) == 0
											? (Math.round(Math.random()) == 0
													? (Math.round(Math.random()) == 0 ? Blocks.IRON_BLOCK : Blocks.REDSTONE_BLOCK)
													: Blocks.GOLD_BLOCK)
											: Blocks.LAPIS_BLOCK)
									: Blocks.DIAMOND_BLOCK)
							: Blocks.EMERALD_BLOCK).getDefaultState(),
					3);
		}
	}
}
