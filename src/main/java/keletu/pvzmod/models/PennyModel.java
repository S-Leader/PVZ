package keletu.pvzmod.models;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import keletu.pvzmod.PVZMod;
import keletu.pvzmod.entities.dave.Penny;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class PennyModel extends HierarchicalModel<Penny> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(PVZMod.MODID, "textures/entity/npc/penny.png"), "main");
    private final ModelPart root;
    private final ModelPart all;
    private final ModelPart luntai;
    private final ModelPart bone8;
    private final ModelPart bone52;
    private final ModelPart bone43;
    private final ModelPart bone44;
    private final ModelPart bone45;
    private final ModelPart bone48;
    private final ModelPart bone53;
    private final ModelPart bone51;
    private final ModelPart bone50;
    private final ModelPart bone21;
    private final ModelPart bone13;
    private final ModelPart bone26;
    private final ModelPart bone46;
    private final ModelPart bone37;
    private final ModelPart bone29;
    private final ModelPart bone25;
    private final ModelPart bone40;
    private final ModelPart bone39;
    private final ModelPart bone14;
    private final ModelPart bone41;
    private final ModelPart bone28;
    private final ModelPart bone42;
    private final ModelPart bone11;
    private final ModelPart bone36;
    private final ModelPart bone9;
    private final ModelPart bone4;
    private final ModelPart bone3;
    private final ModelPart bone34;
    private final ModelPart bone33;
    private final ModelPart bone31;
    private final ModelPart bone10;
    private final ModelPart bone7;
    private final ModelPart bone5;
    private final ModelPart bone6;
    private final ModelPart bone32;
    private final ModelPart bone;
    private final ModelPart bone35;
    private final ModelPart bone2;
    private final ModelPart bone17;
    private final ModelPart bone16;
    private final ModelPart bone15;
    private final ModelPart bone18;
    private final ModelPart bone47;
    private final ModelPart bone38;
    private final ModelPart bone30;
    private final ModelPart bone24;
    private final ModelPart bone49;
    private final ModelPart bone27;

    public PennyModel(ModelPart root) {
        this.root = root;
        this.all = root.getChild("all");
        this.luntai = this.all.getChild("luntai");
        this.bone8 = this.all.getChild("bone8");
        this.bone52 = this.all.getChild("bone52");
        this.bone43 = this.all.getChild("bone43");
        this.bone44 = this.all.getChild("bone44");
        this.bone45 = this.all.getChild("bone45");
        this.bone48 = this.all.getChild("bone48");
        this.bone53 = this.all.getChild("bone53");
        this.bone51 = this.all.getChild("bone51");
        this.bone50 = this.bone51.getChild("bone50");
        this.bone21 = this.all.getChild("bone21");
        this.bone13 = this.all.getChild("bone13");
        this.bone26 = this.all.getChild("bone26");
        this.bone46 = this.all.getChild("bone46");
        this.bone37 = this.bone46.getChild("bone37");
        this.bone29 = this.bone46.getChild("bone29");
        this.bone25 = this.all.getChild("bone25");
        this.bone40 = this.all.getChild("bone40");
        this.bone39 = this.all.getChild("bone39");
        this.bone14 = this.all.getChild("bone14");
        this.bone41 = this.all.getChild("bone41");
        this.bone28 = this.all.getChild("bone28");
        this.bone42 = this.all.getChild("bone42");
        this.bone11 = this.all.getChild("bone11");
        this.bone36 = this.all.getChild("bone36");
        this.bone9 = this.all.getChild("bone9");
        this.bone4 = this.all.getChild("bone4");
        this.bone3 = this.all.getChild("bone3");
        this.bone34 = this.all.getChild("bone34");
        this.bone33 = this.all.getChild("bone33");
        this.bone31 = this.all.getChild("bone31");
        this.bone10 = this.all.getChild("bone10");
        this.bone7 = this.all.getChild("bone7");
        this.bone5 = this.all.getChild("bone5");
        this.bone6 = this.all.getChild("bone6");
        this.bone32 = this.all.getChild("bone32");
        this.bone = this.bone32.getChild("bone");
        this.bone35 = this.bone32.getChild("bone35");
        this.bone2 = this.all.getChild("bone2");
        this.bone17 = this.all.getChild("bone17");
        this.bone16 = this.all.getChild("bone16");
        this.bone15 = this.all.getChild("bone15");
        this.bone18 = this.all.getChild("bone18");
        this.bone47 = this.all.getChild("bone47");
        this.bone38 = this.bone47.getChild("bone38");
        this.bone30 = this.bone47.getChild("bone30");
        this.bone24 = this.all.getChild("bone24");
        this.bone49 = this.all.getChild("bone49");
        this.bone27 = this.all.getChild("bone27");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition all = partdefinition.addOrReplaceChild("all", CubeListBuilder.create().texOffs(204, 0).addBox(-19.0F, -14.0F, -40.0F, 38.0F, 32.0F, 24.0F, new CubeDeformation(0F))
                .texOffs(296, 278).addBox(-19.0F, -32.0F, 47.5F, 38.0F, 50.0F, 1.0F, new CubeDeformation(-0.01F))
                .texOffs(176, 326).addBox(10.75F, -11.0F, 48.0F, 6.0F, 12.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(438, 457).addBox(13.25F, 1.0F, 48.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(466, 200).addBox(10.75F, 4.5F, 48.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(466, 83).addBox(-3.5F, -24.5F, 48.05F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0F))
                .texOffs(0, 300).addBox(-17.0F, -35.0F, -23.0F, 34.0F, 4.0F, 13.0F, new CubeDeformation(0F))
                .texOffs(462, 271).addBox(-20.0F, -29.5F, -27.5F, 1.0F, 7.0F, 7.0F, new CubeDeformation(0F))
                .texOffs(316, 462).addBox(-16.75F, -11.0F, 48.0F, 6.0F, 12.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(420, 473).addBox(-14.25F, 1.0F, 48.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(470, 112).addBox(-16.75F, 4.5F, 48.0F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(352, 462).addBox(-20.0F, -29.5F, -27.5F, 1.0F, 7.0F, 7.0F, new CubeDeformation(0.3F))
                .texOffs(142, 180).addBox(-19.0F, 10.0F, -16.0F, 38.0F, 8.0F, 33.0F, new CubeDeformation(0F))
                .texOffs(0, 326).addBox(-19.0F, 10.0F, 33.0F, 38.0F, 8.0F, 15.0F, new CubeDeformation(0F))
                .texOffs(0, 0).addBox(-19.0F, -32.0F, -16.0F, 38.0F, 42.0F, 64.0F, new CubeDeformation(0F))
                .texOffs(322, 364).addBox(-10.0F, 10.0F, 17.0F, 20.0F, 8.0F, 16.0F, new CubeDeformation(0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

        PartDefinition cube_r1 = all.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(374, 295).addBox(-16.0F, -13.0F, -8.05F, 32.0F, 11.0F, 0.0F, new CubeDeformation(0F))
                .texOffs(438, 122).addBox(-3.0F, -7.0F, -9.0F, 6.0F, 3.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.01F, -19.872F, -34.3432F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r2 = all.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(252, 443).addBox(-5.5F, -9.0F, -0.5F, 9.0F, 14.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(442, 251).addBox(23.1F, -9.0F, -0.5F, 9.0F, 14.0F, 1.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-13.3F, 17.8F, 32.8F, 0.2618F, 0.0F, 0.0F));

        PartDefinition luntai = all.addOrReplaceChild("luntai", CubeListBuilder.create().texOffs(334, 388).addBox(25.0F, -12.0F, -6.0F, 7.0F, 14.0F, 14.0F, new CubeDeformation(0F))
                .texOffs(376, 388).addBox(25.0F, -12.0F, 66.0F, 7.0F, 14.0F, 14.0F, new CubeDeformation(0F))
                .texOffs(170, 392).addBox(-4.0F, -12.0F, 66.0F, 7.0F, 14.0F, 14.0F, new CubeDeformation(0F))
                .texOffs(48, 396).addBox(-4.0F, -12.0F, -6.0F, 7.0F, 14.0F, 14.0F, new CubeDeformation(0F)), PartPose.offset(-14.0F, 24.0F, -49.0F));

        PartDefinition bone8 = all.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(278, 473).addBox(9.0F, -2.0F, -28.3637F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(464, 156).addBox(9.0F, -1.5F, -27.8637F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0F))
                .texOffs(442, 193).addBox(9.0F, -4.6158F, -21.1819F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.002F))
                .texOffs(466, 193).addBox(9.0F, -1.5F, -9.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0F))
                .texOffs(284, 473).addBox(9.0F, -2.0F, -6.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0F)), PartPose.offset(9.5F, 8.0F, -34.6363F));

        PartDefinition cube_r3 = bone8.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(466, 98).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(10.0F, -2.0579F, -10.3409F, -0.8727F, 0.0F, 0.0F));

        PartDefinition cube_r4 = bone8.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(466, 91).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(10.0F, -2.0579F, -22.0228F, 0.8727F, 0.0F, 0.0F));

        PartDefinition bone52 = all.addOrReplaceChild("bone52", CubeListBuilder.create().texOffs(416, 453).addBox(5.329F, 4.3521F, -8.75F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(456, 49).addBox(5.329F, 4.3521F, 6.75F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(374, 278).addBox(-8.0F, -0.5F, -8.0F, 14.0F, 1.0F, 16.0F, new CubeDeformation(0F)), PartPose.offset(-25.0F, 1.5F, -28.0F));

        PartDefinition cube_r5 = bone52.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(328, 96).addBox(-6.0F, -0.5F, -6.0F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(284, 219).addBox(-6.0F, -0.5F, 9.5F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(2.0F, 3.25F, -2.25F, 0.0F, 0.0F, 0.5672F));

        PartDefinition bone43 = all.addOrReplaceChild("bone43", CubeListBuilder.create(), PartPose.offset(-29.3353F, -3.0F, -25.4288F));

        PartDefinition cube_r6 = bone43.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(454, 401).addBox(-3.0F, 2.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0F))
                .texOffs(418, 87).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3054F, 0.0F));

        PartDefinition cube_r7 = bone43.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(372, 202).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, 1.6F, 0.0F, 0.0F, 0.9599F, 0.0F));

        PartDefinition bone44 = all.addOrReplaceChild("bone44", CubeListBuilder.create(), PartPose.offset(-29.3353F, -1.0F, -32.4288F));

        PartDefinition cube_r8 = bone44.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(470, 177).addBox(-0.5F, -3.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0F))
                .texOffs(322, 429).addBox(-0.5F, -3.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3491F, 0.0F));

        PartDefinition cube_r9 = bone44.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(138, 275).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(3.0187F, -5.2591F, 0.8072F, -0.3186F, -0.1451F, 1.1578F));

        PartDefinition cube_r10 = bone44.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(68, 383).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.6317F, -3.5F, 0.3023F, -0.0939F, -0.3367F, 0.2778F));

        PartDefinition bone45 = all.addOrReplaceChild("bone45", CubeListBuilder.create(), PartPose.offset(-23.6693F, -1.5F, -27.993F));

        PartDefinition cube_r11 = bone45.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(470, 185).addBox(-1.5F, -2.7F, -2.5F, 1.0F, 3.0F, 5.0F, new CubeDeformation(0F))
                .texOffs(416, 53).addBox(-0.45F, -4.5F, -2.5F, 1.0F, 7.0F, 5.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0076F, 0.043F, 0.1747F));

        PartDefinition cube_r12 = bone45.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(86, 463).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0436F, 0.0F));

        PartDefinition bone48 = all.addOrReplaceChild("bone48", CubeListBuilder.create().texOffs(106, 326).addBox(-12.0F, -12.0F, -8.9286F, 24.0F, 24.0F, 11.0F, new CubeDeformation(0F))
                .texOffs(274, 386).addBox(11.0F, -15.0F, 2.0714F, 4.0F, 30.0F, 11.0F, new CubeDeformation(0F))
                .texOffs(90, 396).addBox(-8.0F, -8.0F, -14.9286F, 16.0F, 16.0F, 6.0F, new CubeDeformation(0F))
                .texOffs(400, 248).addBox(-10.0F, -10.0F, -15.4286F, 20.0F, 20.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(372, 172).addBox(-11.0F, -15.0F, 2.0714F, 22.0F, 4.0F, 11.0F, new CubeDeformation(0F))
                .texOffs(372, 187).addBox(-11.0F, 11.0F, 2.0714F, 22.0F, 4.0F, 11.0F, new CubeDeformation(0F))
                .texOffs(304, 388).addBox(-15.0F, -15.0F, 2.0714F, 4.0F, 30.0F, 11.0F, new CubeDeformation(0F)), PartPose.offset(0.0F, -5.0F, 62.9286F));

        PartDefinition bone53 = all.addOrReplaceChild("bone53", CubeListBuilder.create().texOffs(466, 207).addBox(-16.5F, -12.0F, 77.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0F))
                .texOffs(130, 470).addBox(-32.0F, -12.0F, 77.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(466, 221).addBox(-22.5F, -12.0F, 77.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0F))
                .texOffs(466, 214).addBox(-10.5F, -12.0F, 76.9F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0F))
                .texOffs(458, 435).addBox(-2.0F, -12.0F, 77.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0F)), PartPose.offset(15.0F, -19.5F, -28.55F));

        PartDefinition bone51 = all.addOrReplaceChild("bone51", CubeListBuilder.create().texOffs(374, 322).addBox(5.6151F, 3.9375F, 8.9679F, 13.0F, 6.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(410, 462).addBox(6.1151F, 1.4375F, 7.9679F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(96, 275).addBox(-11.8849F, -0.5625F, 7.9679F, 20.0F, 2.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(408, 473).addBox(-11.8849F, 1.4375F, 7.9679F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(442, 237).addBox(-22.3849F, 3.9375F, 8.9679F, 13.0F, 6.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(204, 100).addBox(-20.8849F, 4.4375F, 7.9679F, 38.0F, 5.0F, 1.0F, new CubeDeformation(0F)), PartPose.offset(1.8849F, 7.5625F, 40.0321F));

        PartDefinition bone50 = bone51.addOrReplaceChild("bone50", CubeListBuilder.create().texOffs(0, 317).addBox(-17.5F, -10.0F, 79.075F, 31.0F, 9.0F, 0.0F, new CubeDeformation(0.0F).extend(-10F, -2F, 0F))
                .texOffs(442, 244).addBox(-8.5F, -8.5F, 78.0F, 13.0F, 6.0F, 1.0F, new CubeDeformation(0F)), PartPose.offset(0.1151F, 12.4375F, -69.0321F));

        PartDefinition bone21 = all.addOrReplaceChild("bone21", CubeListBuilder.create().texOffs(328, 65).addBox(-17.0F, -5.3333F, -8.0F, 34.0F, 4.0F, 16.0F, new CubeDeformation(0F))
                .texOffs(212, 410).addBox(13.0F, -1.3333F, -8.0F, 4.0F, 6.0F, 16.0F, new CubeDeformation(0F))
                .texOffs(416, 31).addBox(-17.0F, -1.3333F, -8.0F, 4.0F, 6.0F, 16.0F, new CubeDeformation(0F)), PartPose.offset(0.0F, -36.6667F, 37.0F));

        PartDefinition bone13 = all.addOrReplaceChild("bone13", CubeListBuilder.create(), PartPose.offset(16.011F, -67.5975F, 60.7213F));

        PartDefinition cube_r13 = bone13.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(368, 466).addBox(-2.0F, 4.0F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.9021F, 1.0F, 2.8612F, -0.9599F, 0.3054F, 0.0F));

        PartDefinition cube_r14 = bone13.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(284, 180).addBox(-2.0F, -44.0F, 7.0F, 3.0F, 18.0F, 3.0F, new CubeDeformation(0.001F))
                .texOffs(0, 433).addBox(-3.0F, -26.0F, 6.0F, 5.0F, 24.0F, 5.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-4.011F, 49.0975F, -12.7213F, 0.0F, 0.3054F, 0.0F));

        PartDefinition cube_r15 = bone13.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(246, 341).addBox(-3.5F, -4.0F, -6.0F, 7.0F, 8.0F, 12.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.8865F, 47.0975F, -10.6635F, 0.2182F, 0.3054F, 0.0F));

        PartDefinition bone26 = all.addOrReplaceChild("bone26", CubeListBuilder.create().texOffs(400, 202).addBox(-21.0F, -22.0F, 37.0F, 2.0F, 4.0F, 19.0F, new CubeDeformation(0F))
                .texOffs(142, 221).addBox(-21.0F, -18.0F, 13.0F, 4.0F, 14.0F, 43.0F, new CubeDeformation(0F))
                .texOffs(284, 329).addBox(-19.0F, -15.0F, 27.0F, 4.0F, 4.0F, 31.0F, new CubeDeformation(0F))
                .texOffs(466, 370).addBox(-18.5F, -14.5F, 58.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0F))
                .texOffs(322, 433).addBox(-21.0F, -4.0F, 43.0F, 2.0F, 6.0F, 13.0F, new CubeDeformation(0F))
                .texOffs(418, 358).addBox(-19.0F, -13.0F, 21.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0F))
                .texOffs(134, 417).addBox(-21.0F, -4.0F, 13.0F, 2.0F, 6.0F, 16.0F, new CubeDeformation(0F)), PartPose.offset(40.0F, 16.0F, -12.0F));

        PartDefinition cube_r16 = bone26.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(296, 100).addBox(0.0F, -11.6F, -17.0F, 0.0F, 16.0F, 38.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-19.0F, -22.0F, 41.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition bone46 = all.addOrReplaceChild("bone46", CubeListBuilder.create(), PartPose.offset(19.5F, -2.0F, -8.0F));

        PartDefinition bone37 = bone46.addOrReplaceChild("bone37", CubeListBuilder.create().texOffs(188, 460).addBox(-0.5F, -18.0F, -8.2F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.2F))
                .texOffs(92, 317).addBox(0.5F, -4.0F, 6.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(246, 463).addBox(-0.5F, 12.0F, -8.2F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.2F))
                .texOffs(136, 361).addBox(-0.5F, -20.0F, -8.0F, 1.0F, 40.0F, 16.0F, new CubeDeformation(0F))
                .texOffs(334, 416).addBox(0.5F, 17.0F, -8.0F, 6.0F, 1.0F, 16.0F, new CubeDeformation(0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone29 = bone46.addOrReplaceChild("bone29", CubeListBuilder.create().texOffs(198, 420).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0F))
                .texOffs(438, 107).addBox(-2.0F, -5.0F, -6.0F, 4.0F, 3.0F, 12.0F, new CubeDeformation(0F))
                .texOffs(36, 466).addBox(-2.0F, -2.0F, 3.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0F))
                .texOffs(438, 163).addBox(-2.0F, 4.0F, -6.0F, 4.0F, 3.0F, 12.0F, new CubeDeformation(0F))
                .texOffs(0, 401).addBox(0.0F, -7.0F, -8.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F).extend(0F, -0.5F, -0.5F)), PartPose.offset(2.5F, 8.0F, 0.0F));

        PartDefinition bone25 = all.addOrReplaceChild("bone25", CubeListBuilder.create().texOffs(20, 463).addBox(-0.5F, -11.5885F, -9.4989F, 2.0F, 5.0F, 6.0F, new CubeDeformation(0F))
                .texOffs(48, 377).addBox(-2.0F, -6.5885F, -7.4989F, 5.0F, 13.0F, 5.0F, new CubeDeformation(0F))
                .texOffs(212, 392).addBox(0.5F, -11.5885F, -3.4989F, 0.0F, 11.0F, 5.0F, new CubeDeformation(0F))
                .texOffs(308, 219).addBox(-1.9F, -3.0885F, -8.5989F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(312, 219).addBox(-1.9F, 4.9115F, -8.5989F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0F)), PartPose.offset(21.0F, -8.4115F, 11.4989F));

        PartDefinition cube_r17 = bone25.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(284, 327).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(316, 219).addBox(-0.5F, -8.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-1.4F, 5.4115F, -1.8989F, 0.0F, -1.5708F, 0.0F));

        PartDefinition cube_r18 = bone25.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(178, 470).addBox(-0.5F, -2.0F, -0.2F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

        PartDefinition bone40 = all.addOrReplaceChild("bone40", CubeListBuilder.create().texOffs(32, 424).addBox(-4.5F, -1.0F, -8.0F, 2.0F, 0.0F, 16.0F, new CubeDeformation(0F)), PartPose.offset(-15.9991F, -25.665F, -8.0F));

        PartDefinition cube_r19 = bone40.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(90, 418).addBox(-1.5F, -1.0F, -8.0F, 6.0F, 0.0F, 16.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-7.1415F, 2.7782F, 0.0F, 0.0F, 0.0F, -0.7418F));

        PartDefinition cube_r20 = bone40.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(422, 409).addBox(0.5F, -1.0F, -8.0F, 4.0F, 0.0F, 16.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-7.9227F, 7.5535F, 0.0F, 0.0F, 0.0F, -1.5708F));

        PartDefinition bone39 = all.addOrReplaceChild("bone39", CubeListBuilder.create().texOffs(422, 425).addBox(-4.6415F, -3.7782F, -8.0F, 2.0F, 0.0F, 16.0F, new CubeDeformation(0F)), PartPose.offset(23.1406F, -22.8869F, -8.0F));

        PartDefinition cube_r21 = bone39.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(418, 322).addBox(-4.5F, -1.0F, -8.0F, 6.0F, 0.0F, 16.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

        PartDefinition cube_r22 = bone39.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(424, 0).addBox(-4.5F, -1.0F, -8.0F, 4.0F, 0.0F, 16.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.7812F, 4.7754F, 0.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition bone14 = all.addOrReplaceChild("bone14", CubeListBuilder.create(), PartPose.offset(15.0F, -37.0F, -39.8F));

        PartDefinition cube_r23 = bone14.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(462, 329).addBox(-1.0029F, -0.0523F, -9.8348F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-0.9971F, -0.0536F, 8.072F, -0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r24 = bone14.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(96, 252).addBox(-1.0029F, -1.1465F, -9.272F, 4.0F, 4.0F, 19.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-0.9971F, -0.0536F, 8.072F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r25 = bone14.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(282, 100).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0F))
                .texOffs(464, 0).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, -0.5947F, -1.7482F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r26 = bone14.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(462, 59).addBox(-10.5443F, -1.1465F, 5.5423F, 7.0F, 4.0F, 4.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-0.9971F, -0.0536F, 8.072F, -0.1098F, 0.6516F, -0.0668F));

        PartDefinition bone41 = all.addOrReplaceChild("bone41", CubeListBuilder.create().texOffs(442, 205).addBox(-5.0F, -50.0F, -10.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0F))
                .texOffs(392, 453).addBox(-5.0F, -47.0F, -10.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offset(2.0F, 10.0F, -27.0F));

        PartDefinition bone28 = all.addOrReplaceChild("bone28", CubeListBuilder.create().texOffs(372, 152).addBox(-1.0F, -47.0F, 21.0F, 16.0F, 4.0F, 16.0F, new CubeDeformation(0F)), PartPose.offset(2.0F, 12.0F, -12.0F));

        PartDefinition cube_r27 = bone28.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(464, 8).addBox(-4.0F, -17.625F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0F))
                .texOffs(156, 462).addBox(-3.0F, -13.625F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(328, 31).addBox(-13.0F, -10.6F, -11.0F, 22.0F, 12.0F, 22.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(11.0F, -61.0F, 29.0F, 0.0F, 0.0F, 1.1781F));

        PartDefinition cube_r28 = bone28.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(170, 376).addBox(-8.0F, -2.0F, -6.0F, 16.0F, 4.0F, 12.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(9.0F, -54.0F, 29.0F, 0.0F, 0.0F, 1.309F));

        PartDefinition cube_r29 = bone28.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(424, 466).addBox(-2.0F, -2.0F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0F))
                .texOffs(410, 466).addBox(-2.0F, -2.0F, 9.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(5.0F, -58.0F, 23.5F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r30 = bone28.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(374, 306).addBox(-8.0F, -2.0F, -6.0F, 16.0F, 4.0F, 12.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(5.0F, -53.9F, 29.0F, 0.0F, 0.0F, -1.309F));

        PartDefinition bone42 = all.addOrReplaceChild("bone42", CubeListBuilder.create().texOffs(32, 401).addBox(-15.0F, -62.0F, 9.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0F))
                .texOffs(400, 269).addBox(-17.0F, -46.0F, 7.0F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0F))
                .texOffs(48, 440).addBox(-16.0F, -74.0F, 8.0F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0F))
                .texOffs(100, 349).addBox(-14.0F, -83.0F, 10.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(462, 285).addBox(-14.5F, -85.0F, 9.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0F)), PartPose.offset(2.0F, 12.0F, -12.0F));

        PartDefinition bone11 = all.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(170, 420).addBox(1.0F, -4.25F, 1.0F, 0.0F, 16.0F, 14.0F, new CubeDeformation(0F))
                .texOffs(304, 465).addBox(-0.5F, -0.25F, 7.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0F)), PartPose.offset(10.5F, -43.75F, -16.5F));

        PartDefinition cube_r31 = bone11.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(72, 349).addBox(-3.5F, -1.25F, -3.5F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0F))
                .texOffs(252, 427).addBox(-4.5F, 3.75F, -4.5F, 9.0F, 7.0F, 9.0F, new CubeDeformation(0F))
                .texOffs(340, 472).addBox(-1.0F, -4.25F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(464, 67).addBox(-2.0F, -8.25F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition bone36 = all.addOrReplaceChild("bone36", CubeListBuilder.create().texOffs(214, 459).addBox(16.0F, -30.5F, 5.5F, 1.0F, 7.0F, 7.0F, new CubeDeformation(0.3F))
                .texOffs(140, 462).addBox(16.0F, -30.5F, 5.5F, 1.0F, 7.0F, 7.0F, new CubeDeformation(0F)), PartPose.offset(3.0F, 1.0F, -33.0F));

        PartDefinition bone9 = all.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(400, 472).addBox(-1.0F, -0.1F, 16.2F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F))
                .texOffs(276, 361).addBox(-1.0F, -1.6F, 10.2F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.2F))
                .texOffs(428, 53).addBox(-1.0F, -1.5F, 3.5F, 2.0F, 3.0F, 15.0F, new CubeDeformation(0.001F))
                .texOffs(372, 452).addBox(0.0F, -3.5F, -7.0F, 0.0F, 4.0F, 10.0F, new CubeDeformation(0F))
                .texOffs(92, 323).addBox(-0.5F, -1.0F, 3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(284, 201).addBox(-1.0F, 2.0F, 7.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0F)), PartPose.offset(20.0F, -20.5F, -43.5F));

        PartDefinition cube_r32 = bone9.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(252, 458).addBox(0.0F, -0.5F, -7.0F, 0.0F, 1.0F, 10.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

        PartDefinition cube_r33 = bone9.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(402, 433).addBox(2.873F, -6.0F, -8.8934F, 0.0F, 10.0F, 10.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-1.0782F, 5.5F, 9.8428F, 0.0F, 0.1963F, 0.0F));

        PartDefinition cube_r34 = bone9.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(392, 462).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 3.0F, 7.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, 2.6439F, 23.2779F, -0.3927F, 0.0F, 0.0F));

        PartDefinition bone4 = all.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(-0.01F, -19.872F, -34.3432F));

        PartDefinition bone3 = all.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(0.01F, -19.872F, -34.3432F));

        PartDefinition cube_r35 = bone3.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(78, 472).addBox(14.0F, -15.0F, -5.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0F))
                .texOffs(116, 434).addBox(14.5F, -17.0F, -4.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(170, 369).addBox(19.0F, -14.0F, -1.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0F))
                .texOffs(0, 472).addBox(17.5F, -13.0F, -0.5F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.2F))
                .texOffs(462, 251).addBox(19.5F, -13.0F, -2.5F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.001F))
                .texOffs(222, 449).addBox(19.5F, -17.0F, -4.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r36 = bone3.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(462, 471).addBox(-6.5F, -3.1F, 39.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0F))
                .texOffs(414, 473).addBox(-2.5F, -5.0F, 40.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.3F))
                .texOffs(32, 420).addBox(-6.0F, -5.0F, 40.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(0, 252).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 46.0F, new CubeDeformation(0F))
                .texOffs(78, 466).addBox(-1.0F, -5.0F, 40.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(20.5F, -11.9079F, -1.3507F, -0.0436F, 0.0F, 0.0F));

        PartDefinition bone34 = all.addOrReplaceChild("bone34", CubeListBuilder.create().texOffs(148, 106).addBox(18.6959F, 0.5F, -31.9249F, 3.0F, 3.0F, 71.0F, new CubeDeformation(0F))
                .texOffs(20, 433).addBox(29.9587F, 0.5F, -7.3956F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.4F))
                .texOffs(330, 208).addBox(29.9587F, 0.5F, -32.3956F, 3.0F, 3.0F, 32.0F, new CubeDeformation(0F))
                .texOffs(466, 377).addBox(29.9587F, 0.5F, -28.3956F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.4F))
                .texOffs(330, 243).addBox(-2.6631F, 0.5F, -32.3956F, 3.0F, 3.0F, 32.0F, new CubeDeformation(0F))
                .texOffs(470, 244).addBox(-2.6631F, 0.5F, -28.3956F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.4F))
                .texOffs(470, 293).addBox(-2.6631F, 0.5F, -7.3956F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.4F))
                .texOffs(148, 106).mirror().addBox(8.5996F, 0.5F, -31.9249F, 3.0F, 3.0F, 71.0F, new CubeDeformation(0F)).mirror(false), PartPose.offset(-15.1478F, 18.0F, -1.4556F));

        PartDefinition cube_r37 = bone34.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(198, 432).addBox(0.0F, 0.5F, -2.5F, 3.0F, 3.0F, 14.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(21.6478F, 0.0F, -36.0444F, 0.0F, 1.0036F, 0.0F));

        PartDefinition cube_r38 = bone34.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(440, 370).addBox(-3.0F, 0.5F, -3.5F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-2.5302F, 0.0F, 1.6119F, 0.0F, -0.9599F, 0.0F));

        PartDefinition cube_r39 = bone34.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(288, 429).addBox(-3.0F, 0.5F, -2.5F, 3.0F, 3.0F, 14.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(8.6478F, 0.0F, -36.0444F, 0.0F, -1.0036F, 0.0F));

        PartDefinition cube_r40 = bone34.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(144, 439).addBox(0.0F, 0.5F, -3.5F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(32.8257F, 0.0F, 1.6119F, 0.0F, 0.9599F, 0.0F));

        PartDefinition cube_r41 = bone34.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(226, 386).addBox(0.0F, 0.5F, -3.5F, 3.0F, 3.0F, 21.0F, new CubeDeformation(0.001F))
                .texOffs(20, 440).addBox(0.0F, 0.5F, -0.5F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(22.0766F, 0.0F, 39.9809F, 0.0F, 1.309F, 0.0F));

        PartDefinition cube_r42 = bone34.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 377).addBox(-3.0F, 0.5F, -3.5F, 3.0F, 3.0F, 21.0F, new CubeDeformation(0.001F))
                .texOffs(116, 439).addBox(-3.0F, 0.5F, -0.5F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(8.2189F, 0.0F, 39.9809F, 0.0F, -1.309F, 0.0F));

        PartDefinition bone33 = all.addOrReplaceChild("bone33", CubeListBuilder.create().texOffs(0, 349).addBox(-14.0F, 2.0F, 0.0F, 16.0F, 8.0F, 20.0F, new CubeDeformation(0F))
                .texOffs(464, 75).addBox(2.0F, 5.0F, 3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0F))
                .texOffs(464, 140).addBox(-18.0F, 5.0F, 3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0F))
                .texOffs(0, 180).addBox(-9.0F, 2.0F, 8.0F, 6.0F, 7.0F, 65.0F, new CubeDeformation(0F))
                .texOffs(406, 128).addBox(-14.0F, 3.0F, 73.0F, 16.0F, 7.0F, 8.0F, new CubeDeformation(0F))
                .texOffs(464, 148).addBox(2.0F, 5.0F, 75.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0F))
                .texOffs(464, 304).addBox(-18.0F, 5.0F, 75.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0F)), PartPose.offset(6.0F, 12.0F, -53.0F));

        PartDefinition bone31 = all.addOrReplaceChild("bone31", CubeListBuilder.create().texOffs(328, 85).addBox(-13.2125F, 1.4481F, -1.0F, 40.0F, 6.0F, 5.0F, new CubeDeformation(0F))
                .texOffs(252, 410).addBox(-6.2125F, -0.5519F, -2.0F, 5.0F, 10.0F, 6.0F, new CubeDeformation(0F))
                .texOffs(422, 441).addBox(14.7875F, -0.5519F, -2.0F, 5.0F, 10.0F, 6.0F, new CubeDeformation(0F))
                .texOffs(62, 317).addBox(-0.2125F, -3.8019F, -0.5F, 14.0F, 7.0F, 1.0F, new CubeDeformation(0.001F)), PartPose.offset(-6.7875F, 10.8019F, -64.0F));

        PartDefinition cube_r43 = bone31.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(428, 269).addBox(-1.5F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition cube_r44 = bone31.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(170, 361).addBox(-0.5F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(13.5751F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition bone10 = all.addOrReplaceChild("bone10", CubeListBuilder.create(), PartPose.offset(-6.5F, -34.3535F, -43.8891F));

        PartDefinition cube_r45 = bone10.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(246, 361).addBox(-3.5F, 0.5F, -1.5F, 7.0F, 0.0F, 3.0F, new CubeDeformation(0F))
                .texOffs(352, 96).addBox(9.5F, 0.5F, -1.5F, 7.0F, 0.0F, 3.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r46 = bone10.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(462, 415).addBox(-2.0F, -17.0F, -6.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0F))
                .texOffs(116, 453).addBox(-3.0F, -18.0F, -1.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(6.5F, 14.4957F, 9.5459F, 0.7854F, 0.0F, 0.0F));

        PartDefinition bone7 = all.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(468, 356).addBox(-11.0F, -1.5F, -27.8637F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0F))
                .texOffs(290, 473).addBox(-10.0F, -2.0F, -28.3637F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(442, 217).addBox(-11.0F, -4.6158F, -21.1819F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.002F))
                .texOffs(468, 442).addBox(-11.0F, -1.5F, -9.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0F))
                .texOffs(296, 473).addBox(-10.0F, -2.0F, -6.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0F)), PartPose.offset(-9.5F, 8.0F, -34.6363F));

        PartDefinition cube_r47 = bone7.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(468, 435).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-10.0F, -2.0579F, -10.3409F, -0.8727F, 0.0F, 0.0F));

        PartDefinition cube_r48 = bone7.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(468, 363).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.001F)), PartPose.offsetAndRotation(-10.0F, -2.0579F, -22.0228F, 0.8727F, 0.0F, 0.0F));

        PartDefinition bone5 = all.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(17.5F, -12.0F, -46.5F));

        PartDefinition cube_r49 = bone5.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(470, 228).addBox(-2.6F, -3.7F, 0.1F, 5.0F, 7.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(442, 266).addBox(-1.1F, -1.2F, -0.6F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.132F, -0.1298F, 0.0172F));

        PartDefinition cube_r50 = bone5.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(188, 469).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.01F, -2.941F, -2.0653F, 2.0944F, 0.0F, 0.0F));

        PartDefinition cube_r51 = bone5.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(468, 449).addBox(-0.5F, -1.3F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.01F, -6.6467F, 0.0683F, 0.8727F, 0.0F, 0.0F));

        PartDefinition cube_r52 = bone5.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(68, 387).addBox(16.5F, -10.0F, -8.05F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-17.49F, -7.872F, 12.1568F, 0.7854F, 0.0F, 0.0F));

        PartDefinition bone6 = all.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offset(-0.01F, -19.872F, -34.3432F));

        PartDefinition cube_r53 = bone6.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(68, 390).addBox(-18.5F, -10.0F, -8.05F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r54 = bone6.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(102, 470).addBox(-0.5F, -1.3F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-17.5F, 1.2253F, -12.0886F, 0.8727F, 0.0F, 0.0F));

        PartDefinition cube_r55 = bone6.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(246, 469).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-17.5F, 4.9311F, -14.2221F, 2.0944F, 0.0F, 0.0F));

        PartDefinition cube_r56 = bone6.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(272, 443).addBox(-0.9F, -1.2F, -0.6F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(470, 236).addBox(-2.4F, -3.7F, 0.1F, 5.0F, 7.0F, 1.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-17.49F, 7.872F, -12.1568F, -0.132F, 0.1298F, -0.0172F));

        PartDefinition bone32 = all.addOrReplaceChild("bone32", CubeListBuilder.create().texOffs(192, 306).addBox(-10.75F, 3.7944F, -15.4176F, 22.0F, 11.0F, 24.0F, new CubeDeformation(0F)), PartPose.offset(-0.25F, 2.2056F, -48.5824F));

        PartDefinition cube_r57 = bone32.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(328, 0).addBox(-10.75F, 0.5067F, -15.8734F, 22.0F, 5.0F, 26.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, -0.1328F, -0.0419F, 0.2182F, 0.0F, 0.0F));

        PartDefinition bone = bone32.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r58 = bone.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(246, 364).addBox(-8.75F, -0.4007F, -11.8734F, 17.0F, 1.0F, 21.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.5F, -0.1328F, -0.0419F, 0.3054F, 0.0F, 0.0F));

        PartDefinition cube_r59 = bone.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(442, 229).addBox(-5.25F, -3.146F, -3.5289F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.3F))
                .texOffs(406, 143).addBox(-5.25F, -3.146F, -3.5289F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0F))
                .texOffs(284, 208).addBox(-4.75F, -2.4717F, 0.4635F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.5F, -0.1328F, -0.0419F, 0.1745F, 0.0F, 0.0F));

        PartDefinition bone35 = bone32.addOrReplaceChild("bone35", CubeListBuilder.create().texOffs(354, 329).addBox(-37.0F, -13.0F, -23.0F, 8.0F, 11.0F, 24.0F, new CubeDeformation(0F))
                .texOffs(424, 16).addBox(-37.0F, -2.0F, -23.0F, 8.0F, 6.0F, 9.0F, new CubeDeformation(0F))
                .texOffs(102, 463).addBox(-37.0F, -2.0F, 0.0F, 8.0F, 6.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(72, 361).addBox(-7.0F, -13.0F, -23.0F, 8.0F, 11.0F, 24.0F, new CubeDeformation(0F))
                .texOffs(430, 306).addBox(-7.0F, -2.0F, -23.0F, 8.0F, 6.0F, 9.0F, new CubeDeformation(0F))
                .texOffs(120, 463).addBox(-7.0F, -2.0F, 0.0F, 8.0F, 6.0F, 1.0F, new CubeDeformation(0F)), PartPose.offset(18.25F, 11.7944F, 7.5824F));

        PartDefinition bone2 = all.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(464, 312).addBox(2.0F, -6.3465F, -3.1292F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.2F))
                .texOffs(438, 471).addBox(2.0855F, -6.3465F, -2.3641F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0F))
                .texOffs(214, 473).addBox(4.0F, -1.0F, 3.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(440, 383).addBox(1.0F, 1.0F, -1.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(470, 105).addBox(4.0F, 1.0F, 0.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0F))
                .texOffs(12, 472).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(20.4582F, 2.8965F, -39.1818F, 0.0F, 0.3491F, 0.0F));

        PartDefinition cube_r60 = bone2.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(470, 285).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(5.0F, -4.05F, 4.325F, 0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r61 = bone2.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(402, 322).addBox(-2.0F, 1.0F, -2.5F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(5.0F, -3.9465F, 0.3708F, 0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r62 = bone2.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(202, 469).addBox(1.0F, -1.0F, -2.5F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(5.5813F, -4.3465F, -0.1214F, 0.0F, -0.2182F, 0.0F));

        PartDefinition cube_r63 = bone2.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(462, 261).addBox(-2.0F, -1.0F, -2.5F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(5.0F, -4.8465F, 0.3708F, -0.2182F, 0.0F, 0.0F));

        PartDefinition cube_r64 = bone2.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(320, 208).addBox(-1.0F, -3.0F, -1.5F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.001F))
                .texOffs(230, 463).addBox(-2.0F, -8.0F, -2.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -2.891F, 2.6833F, -1.0036F, 0.0F, 0.0F));

        PartDefinition cube_r65 = bone2.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(380, 466).addBox(1.0F, -1.0F, -1.85F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.3491F, -4.3465F, -0.1066F, 0.0F, 0.2182F, 0.0F));

        PartDefinition bone17 = all.addOrReplaceChild("bone17", CubeListBuilder.create(), PartPose.offset(-16.011F, -67.5975F, 60.7213F));

        PartDefinition cube_r66 = bone17.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(260, 469).addBox(-1.0F, 4.0F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-0.9021F, 1.0F, 2.8612F, -0.9599F, -0.3054F, 0.0F));

        PartDefinition cube_r67 = bone17.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(284, 306).addBox(-1.0F, -43.0F, 7.0F, 3.0F, 18.0F, 3.0F, new CubeDeformation(0.001F))
                .texOffs(352, 433).addBox(-2.0F, -25.0F, 6.0F, 5.0F, 24.0F, 5.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(4.011F, 48.0975F, -12.7213F, 0.0F, -0.3054F, 0.0F));

        PartDefinition cube_r68 = bone17.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(418, 338).addBox(-3.0F, -4.0F, -4.0F, 7.0F, 8.0F, 12.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(4.011F, 47.0975F, -12.7213F, 0.2182F, -0.3054F, 0.0F));

        PartDefinition bone16 = all.addOrReplaceChild("bone16", CubeListBuilder.create(), PartPose.offset(-15.0F, -37.0F, -39.8F));

        PartDefinition cube_r69 = bone16.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(450, 471).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0F))
                .texOffs(272, 465).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, -0.5947F, -1.7482F, 0.1309F, 0.0F, 0.0F));

        PartDefinition cube_r70 = bone16.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(462, 407).addBox(-2.9971F, -0.0523F, -9.8348F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.9971F, -0.0536F, 8.072F, -0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r71 = bone16.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(394, 364).addBox(-2.9971F, -1.1465F, -9.272F, 4.0F, 4.0F, 19.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.9971F, -0.0536F, 8.072F, -0.0873F, 0.0F, 0.0F));

        PartDefinition cube_r72 = bone16.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(462, 321).addBox(3.5443F, -1.1465F, 5.5423F, 7.0F, 4.0F, 4.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.9971F, -0.0536F, 8.072F, -0.1098F, -0.6516F, 0.0668F));

        PartDefinition bone15 = all.addOrReplaceChild("bone15", CubeListBuilder.create(), PartPose.offset(-10.5F, -43.75F, -16.5F));

        PartDefinition cube_r73 = bone15.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(428, 71).addBox(-4.5F, 3.75F, -4.5F, 9.0F, 7.0F, 9.0F, new CubeDeformation(0F))
                .texOffs(440, 358).addBox(-3.5F, -1.25F, -3.5F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0F))
                .texOffs(392, 472).addBox(-1.0F, -4.25F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(288, 465).addBox(-2.0F, -8.25F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition bone18 = all.addOrReplaceChild("bone18", CubeListBuilder.create(), PartPose.offset(-0.01F, -19.872F, -34.3432F));

        PartDefinition cube_r74 = bone18.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(426, 473).addBox(1.5F, -5.0F, 40.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.3F))
                .texOffs(230, 472).addBox(3.5F, -3.1F, 39.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0F))
                .texOffs(468, 456).addBox(1.0F, -5.0F, 40.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(96, 278).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 46.0F, new CubeDeformation(0F))
                .texOffs(332, 472).addBox(-1.0F, -5.0F, 40.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-20.5F, -11.9079F, -1.3507F, -0.0436F, 0.0F, 0.0F));

        PartDefinition cube_r75 = bone18.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(110, 454).addBox(-19.0F, -14.0F, -1.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0F))
                .texOffs(470, 299).addBox(-19.5F, -17.0F, -4.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(320, 217).addBox(-21.5F, -13.0F, -0.5F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.2F))
                .texOffs(332, 462).addBox(-21.5F, -13.0F, -2.5F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0F))
                .texOffs(344, 452).addBox(-21.5F, -17.0F, -4.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0F))
                .texOffs(90, 472).addBox(-17.0F, -15.0F, -5.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition bone47 = all.addOrReplaceChild("bone47", CubeListBuilder.create(), PartPose.offset(-2.0F, 13.0F, -29.0F));

        PartDefinition bone38 = bone47.addOrReplaceChild("bone38", CubeListBuilder.create().texOffs(68, 377).addBox(-19.0F, -19.0F, 27.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(372, 96).addBox(-18.0F, -35.0F, 13.0F, 1.0F, 40.0F, 16.0F, new CubeDeformation(0F))
                .texOffs(222, 473).addBox(-18.0F, -33.0F, 12.8F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.2F))
                .texOffs(272, 473).addBox(-18.0F, -4.0F, 12.8F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.2F))
                .texOffs(378, 416).addBox(-24.0F, 2.0F, 13.0F, 6.0F, 1.0F, 16.0F, new CubeDeformation(0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition bone30 = bone47.addOrReplaceChild("bone30", CubeListBuilder.create().texOffs(406, 96).addBox(0.0F, -7.0F, -8.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F).extend(0F, -0.5F, -0.5F))
                .texOffs(50, 466).addBox(-2.0F, -2.0F, 3.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0F))
                .texOffs(438, 178).addBox(-2.0F, -5.0F, -6.0F, 4.0F, 3.0F, 12.0F, new CubeDeformation(0F))
                .texOffs(64, 466).addBox(-2.0F, -2.0F, -6.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0F))
                .texOffs(438, 289).addBox(-2.0F, 4.0F, -6.0F, 4.0F, 3.0F, 12.0F, new CubeDeformation(0F)), PartPose.offset(-20.0F, -7.0F, 21.0F));

        PartDefinition bone24 = all.addOrReplaceChild("bone24", CubeListBuilder.create().texOffs(116, 470).addBox(-17.0F, -14.0F, -12.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(164, 470).addBox(13.0F, -14.0F, -12.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(266, 361).addBox(14.0F, -7.0F, -12.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0F))
                .texOffs(198, 429).addBox(-16.0F, -7.0F, -12.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0F)), PartPose.offset(-1.0F, 16.0F, -52.5F));

        PartDefinition cube_r76 = bone24.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(470, 163).addBox(-3.0F, -3.0F, -0.5F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-14.0F, -9.75F, -14.75F, 0.3491F, 0.0F, 0.0F));

        PartDefinition cube_r77 = bone24.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(278, 443).addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-14.0F, -9.75F, -14.75F, 0.2618F, 0.0F, 0.0F));

        PartDefinition bone49 = all.addOrReplaceChild("bone49", CubeListBuilder.create().texOffs(236, 221).addBox(19.0F, -12.0F, 19.0F, 4.0F, 14.0F, 43.0F, new CubeDeformation(0F))
                .texOffs(400, 225).addBox(21.0F, -16.0F, 43.0F, 2.0F, 4.0F, 19.0F, new CubeDeformation(0F))
                .texOffs(470, 170).addBox(17.5F, -8.5F, 64.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0F))
                .texOffs(372, 433).addBox(21.0F, 2.0F, 49.0F, 2.0F, 6.0F, 13.0F, new CubeDeformation(0F))
                .texOffs(418, 387).addBox(21.0F, 2.0F, 19.0F, 2.0F, 6.0F, 16.0F, new CubeDeformation(0F))
                .texOffs(176, 341).addBox(17.0F, -9.0F, 33.0F, 4.0F, 4.0F, 31.0F, new CubeDeformation(0F))
                .texOffs(458, 25).addBox(17.0F, -7.0F, 27.0F, 4.0F, 0.0F, 6.0F, new CubeDeformation(0F)), PartPose.offset(-42.0F, 10.0F, -18.0F));

        PartDefinition cube_r78 = bone49.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(296, 154).addBox(0.0F, -11.6F, -17.0F, 0.0F, 16.0F, 38.0F, new CubeDeformation(0F)), PartPose.offsetAndRotation(21.0F, -16.0F, 47.0F, 0.0F, 0.0F, -0.4363F));

        PartDefinition bone27 = all.addOrReplaceChild("bone27", CubeListBuilder.create().texOffs(204, 56).addBox(-1.0F, -53.0F, 1.0F, 38.0F, 20.0F, 24.0F, new CubeDeformation(0F))
                .texOffs(68, 424).addBox(37.0F, -53.0F, -9.0F, 0.0F, 21.0F, 10.0F, new CubeDeformation(0F))
                .texOffs(232, 432).addBox(-1.0F, -53.0F, -9.0F, 0.0F, 21.0F, 10.0F, new CubeDeformation(0F)), PartPose.offset(-18.0F, 19.0F, -41.0F));

        PartDefinition cube_r79 = bone27.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(192, 278).addBox(-19.0F, -14.0F, -8.0F, 38.0F, 14.0F, 14.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(18.0F, -38.8579F, 6.6568F, 0.7854F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 512, 512);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return root;
    }

    @Override
    public void setupAnim(Penny pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        float bob = Mth.sin(pAgeInTicks * 5) * 0.05F;

        for (ModelPart part : this.all.getAllParts().toList()) {
            if (part != this.luntai && !this.luntai.getAllParts().toList().contains(part)) {
                part.y += bob;
            }
        }
    }
}