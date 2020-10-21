package net.mcreator.deadlymining.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Difficulty;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.block.Blocks;

import net.mcreator.deadlymining.DeadlyminingModElements;

import java.util.Map;
import java.util.HashMap;

@DeadlyminingModElements.ModElement.Tag
public class BundleOreStoneProcedure extends DeadlyminingModElements.ModElement {
	public BundleOreStoneProcedure(DeadlyminingModElements instance) {
		super(instance, 107);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure BundleOreStone!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure BundleOreStone!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure BundleOreStone!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure BundleOreStone!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double NandomNumber = 0;
		double DifficultyMultipler = 0;
		if ((world.getDifficulty() == Difficulty.PEACEFUL)) {
			DifficultyMultipler = (double) 0.25;
		} else if ((world.getDifficulty() == Difficulty.EASY)) {
			DifficultyMultipler = (double) 0.5;
		} else if ((world.getDifficulty() == Difficulty.HARD)) {
			DifficultyMultipler = (double) 2;
		} else {
			DifficultyMultipler = (double) 1;
		}
		NandomNumber = (double) ((new java.util.Random()).nextInt((int) 2 + 1));
		if (((NandomNumber) == 0)) {
			for (int index0 = 0; index0 < (int) (Math
					.round(((((new java.util.Random()).nextInt((int) 9 + 1)) + 6) * (DifficultyMultipler)))); index0++) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Blocks.GOLD_ORE, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.getWorld().isRemote) {
					world.getWorld().addEntity(new ExperienceOrbEntity(world.getWorld(), x, y, z, (int) 6));
				}
				if ((Math.random() <= 0.33)) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("world", world);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						SummonBundleSkeletonProcedure.executeProcedure($_dependencies);
					}
				}
			}
			for (int index1 = 0; index1 < (int) (Math
					.round(((((new java.util.Random()).nextInt((int) 9 + 1)) + 6) * (DifficultyMultipler)))); index1++) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Blocks.EMERALD_ORE, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.getWorld().isRemote) {
					world.getWorld().addEntity(new ExperienceOrbEntity(world.getWorld(), x, y, z, (int) 12));
				}
				if ((Math.random() <= 0.33)) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("world", world);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						SummonBundleZombieProcedure.executeProcedure($_dependencies);
					}
				}
			}
		} else if (((NandomNumber) == 1)) {
			for (int index2 = 0; index2 < (int) (Math
					.round(((((new java.util.Random()).nextInt((int) 9 + 1)) + 6) * (DifficultyMultipler)))); index2++) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Blocks.LAPIS_ORE, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.getWorld().isRemote) {
					world.getWorld().addEntity(new ExperienceOrbEntity(world.getWorld(), x, y, z, (int) 10));
				}
				if ((Math.random() <= 0.33)) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("world", world);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						SummonBundleSpiderProcedure.executeProcedure($_dependencies);
					}
				}
			}
			for (int index3 = 0; index3 < (int) (Math
					.round((((((new java.util.Random()).nextInt((int) 9 + 1)) + 6) * (DifficultyMultipler)) / 5))); index3++) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Blocks.DIAMOND_ORE, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.getWorld().isRemote) {
					world.getWorld().addEntity(new ExperienceOrbEntity(world.getWorld(), x, y, z, (int) 14));
				}
				if ((Math.random() <= 0.33)) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("world", world);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						SummonBundleZombieProcedure.executeProcedure($_dependencies);
					}
				}
			}
			for (int index4 = 0; index4 < (int) (Math
					.round((((((new java.util.Random()).nextInt((int) 9 + 1)) + 6) * (DifficultyMultipler)) / 5))); index4++) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Blocks.GOLD_ORE, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.getWorld().isRemote) {
					world.getWorld().addEntity(new ExperienceOrbEntity(world.getWorld(), x, y, z, (int) 14));
				}
				if ((Math.random() <= 0.33)) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("world", world);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						SummonBundleZombieProcedure.executeProcedure($_dependencies);
					}
				}
			}
		} else if (((NandomNumber) == 2)) {
			for (int index5 = 0; index5 < (int) (Math
					.round(((((new java.util.Random()).nextInt((int) 9 + 1)) + 6) * (DifficultyMultipler)))); index5++) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Blocks.GOLD_ORE, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.getWorld().isRemote) {
					world.getWorld().addEntity(new ExperienceOrbEntity(world.getWorld(), x, y, z, (int) 6));
				}
				if ((Math.random() <= 0.33)) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("world", world);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						SummonBundleSkeletonProcedure.executeProcedure($_dependencies);
					}
				}
			}
			for (int index6 = 0; index6 < (int) (Math
					.round(((((new java.util.Random()).nextInt((int) 9 + 1)) + 6) * (DifficultyMultipler)))); index6++) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Blocks.IRON_ORE, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.getWorld().isRemote) {
					world.getWorld().addEntity(new ExperienceOrbEntity(world.getWorld(), x, y, z, (int) 4));
				}
				if ((Math.random() <= 0.33)) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("world", world);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						SummonBundleZombieProcedure.executeProcedure($_dependencies);
					}
				}
			}
			for (int index7 = 0; index7 < (int) (Math
					.round((((((new java.util.Random()).nextInt((int) 9 + 1)) + 6) * (DifficultyMultipler)) / 5))); index7++) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(Blocks.DIAMOND_ORE, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.getWorld().isRemote) {
					world.getWorld().addEntity(new ExperienceOrbEntity(world.getWorld(), x, y, z, (int) 14));
				}
				if ((Math.random() <= 0.33)) {
					{
						Map<String, Object> $_dependencies = new HashMap<>();
						$_dependencies.put("world", world);
						$_dependencies.put("x", x);
						$_dependencies.put("y", y);
						$_dependencies.put("z", z);
						SummonBundleZombieProcedure.executeProcedure($_dependencies);
					}
				}
			}
		}
	}
}
