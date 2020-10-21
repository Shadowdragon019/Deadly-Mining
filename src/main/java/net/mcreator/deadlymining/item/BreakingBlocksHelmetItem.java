
package net.mcreator.deadlymining.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.block.Blocks;

import net.mcreator.deadlymining.procedures.BreakingBlocksHelmetHelmetTickEventProcedure;
import net.mcreator.deadlymining.DeadlyminingModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@DeadlyminingModElements.ModElement.Tag
public class BreakingBlocksHelmetItem extends DeadlyminingModElements.ModElement {
	@ObjectHolder("deadlymining:breaking_blocks_helmet_helmet")
	public static final Item helmet = null;
	@ObjectHolder("deadlymining:breaking_blocks_helmet_chestplate")
	public static final Item body = null;
	@ObjectHolder("deadlymining:breaking_blocks_helmet_leggings")
	public static final Item legs = null;
	@ObjectHolder("deadlymining:breaking_blocks_helmet_boots")
	public static final Item boots = null;
	public BreakingBlocksHelmetItem(DeadlyminingModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			public int getEnchantability() {
				return 9;
			}

			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Blocks.REDSTONE_BLOCK, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			public String getName() {
				return "breaking_blocks_helmet";
			}

			public float getToughness() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedHead = new ModelminingHelmet().Base;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "deadlymining:textures/models/armor/mininghelmet__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				super.onArmorTick(itemstack, world, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					BreakingBlocksHelmetHelmetTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("breaking_blocks_helmet_helmet"));
	}
	// Made with Blockbench 3.5.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class ModelminingHelmet extends EntityModel<Entity> {
		private final ModelRenderer Base;
		public ModelminingHelmet() {
			textureWidth = 128;
			textureHeight = 128;
			Base = new ModelRenderer(this);
			Base.setRotationPoint(0.0F, 24.0F, 0.0F);
			Base.setTextureOffset(24, 0).addBox(-4.0F, -7.0F, 4.0F, 8.0F, 6.0F, 1.0F, 0.0F, false);
			Base.setTextureOffset(22, 22).addBox(4.0F, -7.0F, -5.0F, 1.0F, 6.0F, 10.0F, 0.0F, false);
			Base.setTextureOffset(0, 18).addBox(-5.0F, -7.0F, -5.0F, 1.0F, 6.0F, 10.0F, 0.0F, false);
			Base.setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
			Base.setTextureOffset(0, 9).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
			Base.setTextureOffset(12, 18).addBox(-4.0F, -7.0F, -5.0F, 8.0F, 6.0F, 1.0F, 0.0F, false);
			Base.setTextureOffset(0, 18).addBox(-2.0F, -6.5F, -6.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Base.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.Base.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.Base.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}
}
