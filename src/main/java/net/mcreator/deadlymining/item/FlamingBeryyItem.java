
package net.mcreator.deadlymining.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;

import net.mcreator.deadlymining.DeadlyminingModElements;

@DeadlyminingModElements.ModElement.Tag
public class FlamingBeryyItem extends DeadlyminingModElements.ModElement {
	@ObjectHolder("deadlymining:flaming_beryy")
	public static final Item block = null;
	public FlamingBeryyItem(DeadlyminingModElements instance) {
		super(instance, 25);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).food((new Food.Builder()).hunger(6).saturation(0.6f).build()));
			setRegistryName("flaming_beryy");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}
	}
}
