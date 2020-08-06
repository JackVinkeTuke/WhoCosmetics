package com.whocraft.whocosmetics.client.models;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.LivingEntity;

// Made with Blockbench 3.6.5
// Exported for Minecraft version 1.14
// Paste this class into your mod and generate all required imports


public class RedCloakModelAlex extends EntityModel<LivingEntity> {
	private final RendererModel torso;
	private final RendererModel body;
	private final RendererModel leg_skirt;
	private final RendererModel alex_right_arm;
	private final RendererModel right;
	private final RendererModel alex_left_arm;
	private final RendererModel left;

	public RedCloakModelAlex() {
		textureWidth = 64;
		textureHeight = 64;

		torso = new RendererModel(this);
		torso.setRotationPoint(0.0F, 0.0F, 0.0F);
		

		body = new RendererModel(this);
		body.setRotationPoint(-0.5F, 24.75F, -0.5F);
		torso.addChild(body);
		body.cubeList.add(new ModelBox(body, 0, 0, -3.0F, -25.0F, 2.0F, 7, 12, 1, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 6, 22, -4.0F, -25.0F, 1.0F, 1, 12, 2, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 22, 4.0F, -25.0F, 1.0F, 1, 12, 2, 0.0F, false));

		leg_skirt = new RendererModel(this);
		leg_skirt.setRotationPoint(-0.25F, 11.75F, 2.5F);
		torso.addChild(leg_skirt);
		leg_skirt.cubeList.add(new ModelBox(leg_skirt, 0, 13, -3.25F, 0.0F, -1.0F, 7, 8, 1, 0.0F, false));
		leg_skirt.cubeList.add(new ModelBox(leg_skirt, 32, 32, 3.75F, 0.0F, -2.0F, 1, 8, 2, 0.0F, false));
		leg_skirt.cubeList.add(new ModelBox(leg_skirt, 18, 29, -4.25F, 0.0F, -2.0F, 1, 8, 2, 0.0F, false));

		alex_right_arm = new RendererModel(this);
		alex_right_arm.setRotationPoint(-5.0F, 2.5F, 0.0F);
		

		right = new RendererModel(this);
		right.setRotationPoint(4.5F, 22.25F, -0.5F);
		alex_right_arm.addChild(right);
		right.cubeList.add(new ModelBox(right, 12, 29, -6.0F, -24.0F, 2.0F, 2, 9, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 16, 0, -7.0F, -24.0F, -1.0F, 1, 9, 4, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 22, 14, -7.0F, -25.0F, -1.0F, 3, 1, 4, 0.0F, false));

		alex_left_arm = new RendererModel(this);
		alex_left_arm.setRotationPoint(5.0F, 2.5F, 0.0F);
		

		left = new RendererModel(this);
		left.setRotationPoint(-4.5F, 22.25F, -0.5F);
		alex_left_arm.addChild(left);
		left.cubeList.add(new ModelBox(left, 16, 16, 6.0F, -24.0F, -1.0F, 1, 9, 4, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 26, 26, 4.0F, -24.0F, 2.0F, 2, 9, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 22, 9, 4.0F, -25.0F, -1.0F, 3, 1, 4, 0.0F, false));
	}

	@Override
	public void render(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		torso.render(scaleFactor);
		alex_right_arm.render(scaleFactor);
		alex_left_arm.render(scaleFactor);
	}

	public void setRotationAngle(RendererModel modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}