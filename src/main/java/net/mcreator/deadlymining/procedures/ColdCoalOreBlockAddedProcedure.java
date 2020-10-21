package net.mcreator.deadlymining.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.block.Blocks;

import net.mcreator.deadlymining.block.ColdCoalOreBlock;
import net.mcreator.deadlymining.DeadlyminingModElements;

import java.util.Map;

@DeadlyminingModElements.ModElement.Tag
public class ColdCoalOreBlockAddedProcedure extends DeadlyminingModElements.ModElement {
	public ColdCoalOreBlockAddedProcedure(DeadlyminingModElements instance) {
		super(instance, 38);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ColdCoalOreBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ColdCoalOreBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ColdCoalOreBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ColdCoalOreBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double offset = 0;
		if ((((((ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z))).equals(new ResourceLocation("snowy_tundra")))
				|| (ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("snowy_mountains"))))
				|| (ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("ice_spikes"))))
				|| ((ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("frozen_river")))
						|| (ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
								.equals(new ResourceLocation("snowy_beach")))))
				|| (((ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
						.equals(new ResourceLocation("frozen_ocean")))
						|| (ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
								.equals(new ResourceLocation("cold_ocean"))))
						|| ((ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
								.equals(new ResourceLocation("ice_spikes")))
								|| (ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
										.equals(new ResourceLocation("snowy_taiga_mountains"))))))) {
			offset = (double) 1;
			for (int index0 = 0; index0 < (int) (2); index0++) {
				if ((Blocks.COAL_ORE.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) (x + (offset)), (int) y, (int) z)))
						.getBlock())) {
					world.setBlockState(new BlockPos((int) (x + (offset)), (int) y, (int) z), ColdCoalOreBlock.block.getDefaultState(), 3);
				}
				if ((Blocks.COAL_ORE.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) (y + (offset)), (int) z)))
						.getBlock())) {
					world.setBlockState(new BlockPos((int) x, (int) (y + (offset)), (int) z), ColdCoalOreBlock.block.getDefaultState(), 3);
				}
				if ((Blocks.COAL_ORE.getDefaultState().getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + (offset)))))
						.getBlock())) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + (offset))), ColdCoalOreBlock.block.getDefaultState(), 3);
				}
				offset = (double) (-1);
			}
		}
	}
}
