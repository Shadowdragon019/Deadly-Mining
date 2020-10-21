package net.mcreator.deadlymining.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;
import net.minecraft.block.Blocks;

import net.mcreator.deadlymining.DeadlyminingModElements;

import java.util.Map;

@DeadlyminingModElements.ModElement.Tag
public class PolishedObsidianCircleLargeOnStructureInstanceGeneratedProcedure extends DeadlyminingModElements.ModElement {
	public PolishedObsidianCircleLargeOnStructureInstanceGeneratedProcedure(DeadlyminingModElements instance) {
		super(instance, 105);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PolishedObsidianCircleLargeOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PolishedObsidianCircleLargeOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PolishedObsidianCircleLargeOnStructureInstanceGenerated!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PolishedObsidianCircleLargeOnStructureInstanceGenerated!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double OZ = 0;
		double OX = 0;
		double OY = 0;
		if ((y <= 32)) {
			if (!world.getWorld().isRemote) {
				Template template = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("deadlymining", "polished_obsidian_3"));
				if (template != null) {
					template.addBlocksToWorld(world, new BlockPos((int) x, (int) y, (int) z),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false));
				}
			}
		}
		OY = (double) 0;
		for (int index0 = 0; index0 < (int) (3); index0++) {
			OX = (double) 0;
			OZ = (double) 0;
			OY = (double) ((OY) + 1);
			for (int index1 = 0; index1 < (int) (3); index1++) {
				OZ = (double) 0;
				OX = (double) ((OX) + 1);
				for (int index2 = 0; index2 < (int) (3); index2++) {
					OZ = (double) ((OZ) + 1);
					if ((Math.random() > 0.33)) {
						world.setBlockState(new BlockPos((int) (x + (OX)), (int) (y + (OY)), (int) (z + (OZ))),
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
						world.setBlockState(new BlockPos((int) (x + (OX)), (int) (y + (OY)), (int) (z + (OZ))),
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
		}
	}
}
