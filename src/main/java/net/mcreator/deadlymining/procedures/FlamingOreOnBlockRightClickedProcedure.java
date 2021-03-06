package net.mcreator.deadlymining.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.deadlymining.item.DiamondBucketItem;
import net.mcreator.deadlymining.item.DiamondBucketFullItem;
import net.mcreator.deadlymining.block.FlamingOreEmptyBlock;
import net.mcreator.deadlymining.DeadlyminingModElements;

import java.util.Map;

@DeadlyminingModElements.ModElement.Tag
public class FlamingOreOnBlockRightClickedProcedure extends DeadlyminingModElements.ModElement {
	public FlamingOreOnBlockRightClickedProcedure(DeadlyminingModElements instance) {
		super(instance, 34);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FlamingOreOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FlamingOreOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FlamingOreOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FlamingOreOnBlockRightClicked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FlamingOreOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((new ItemStack(DiamondBucketItem.block, (int) (1))
				.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem())) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(DiamondBucketItem.block, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(DiamondBucketFullItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), FlamingOreEmptyBlock.block.getDefaultState(), 3);
		}
	}
}
