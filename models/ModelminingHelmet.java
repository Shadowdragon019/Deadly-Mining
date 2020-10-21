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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Base.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.Base.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Base.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}