package com.solace.alsera.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ScreenShotHelper;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class LongevityStone extends Item {
    public LongevityStone(Properties properties) {
        super(properties);
    }


    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        World world = context.getWorld();

        if (!world.isRemote) {
            PlayerEntity playerEntity = Objects.requireNonNull(context.getPlayer());
            BlockState clickedBlock = world.getBlockState(context.getPos());

            rightClick(clickedBlock, context, playerEntity);
            stack.damageItem(1, playerEntity, player -> player.sendBreakAnimation(context.getHand()));
        }

        return super.onItemUseFirst(stack, context);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        if (Screen.hasShiftDown()) {

            tooltip.add(new TranslationTextComponent("tooltip.alsera.longevity_stone_shift"));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.alsera.longevity_stone"));
        }
            super.addInformation(stack, worldIn, tooltip, flagIn);

    }

    private void rightClick(BlockState clickedBlock, ItemUseContext context, PlayerEntity playerEntity) {

        boolean playerIsNotOnFire = !playerEntity.isBurning();

        if (random.nextFloat() > 0.5f) {
            lightEntityOnFire(playerEntity, 6);
        } else if (playerIsNotOnFire) {
            gainRegenerationResistenceAndInstantHealth(playerEntity);
        } else {
            lightGroundOnFire(context);
        }

    }

    public static void lightEntityOnFire(Entity entity, int second) {
        entity.setFire(second);
    }

    private void rightClick() {

    }

    private void gainRegenerationResistenceAndInstantHealth(PlayerEntity playerEntity) {
        gainHealth(playerEntity);
        gainRegeneration(playerEntity);
        gainResistence(playerEntity);
    }

    public static void gainRegeneration(PlayerEntity playerEntity) {
        playerEntity.addPotionEffect(new EffectInstance(Effects.REGENERATION, 200));
    }

    public static void gainHealth(PlayerEntity playerEntity) {
        playerEntity.addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, 100));
    }

    public static void gainResistence(PlayerEntity playerEntity) {
        playerEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 200));
    }

    public static void lightGroundOnFire(ItemUseContext context) {
        PlayerEntity playerentity = context.getPlayer();
        World world = context.getWorld();
        BlockPos blockpos = context.getPos().offset(context.getFace());

        if (AbstractFireBlock.canLightBlock(world, blockpos, context.getPlacementHorizontalFacing())) {
            world.playSound(playerentity, blockpos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F,
                    random.nextFloat() * 0.4F + 0.8F);
            BlockState blockstate = AbstractFireBlock.getFireForPlacement(world, blockpos);
            world.setBlockState(blockpos, blockstate, 11);

        }
    }
}
