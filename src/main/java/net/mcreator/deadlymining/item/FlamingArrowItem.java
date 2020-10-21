
package net.mcreator.deadlymining.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.deadlymining.DeadlyminingModElements;

@DeadlyminingModElements.ModElement.Tag
public class FlamingArrowItem extends DeadlyminingModElements.ModElement {
	@ObjectHolder("deadlymining:flaming_arrow")
	public static final Item block = null;
	public FlamingArrowItem(DeadlyminingModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(64));
			setRegistryName("flaming_arrow");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
