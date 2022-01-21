package com.solace.alsera.intergration.jei;

import com.solace.alsera.Alsera;
import com.solace.alsera.block.ModBlocks;
import com.solace.alsera.data.recipes.MechanicalCombinerRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.TagsUpdatedEvent;

public class MechanicalCombinerRecipeCategory implements IRecipeCategory<MechanicalCombinerRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Alsera.MOD_ID, "mechanical");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Alsera.MOD_ID, "textures/gui/mechanical_combiner_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public MechanicalCombinerRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(new ItemStack(ModBlocks.MECHANICAL_COMBINER.get()));
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    public Class<? extends MechanicalCombinerRecipe> getRecipeClass() {
        return MechanicalCombinerRecipe.class;
    }

    @Override
    public String getTitle() {
        return ModBlocks.MECHANICAL_COMBINER.get().getTranslatedName().getString();
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setIngredients(MechanicalCombinerRecipe recipe, IIngredients ingredients) {
        ingredients.setInputIngredients(recipe.getIngredients());
        ingredients.setOutput(VanillaTypes.ITEM, recipe.getRecipeOutput());
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, MechanicalCombinerRecipe recipe, IIngredients ingredients) {
        recipeLayout.getItemStacks().init(0, true, 80, 6  );
        recipeLayout.getItemStacks().init(1, true, 44, 6  );
        recipeLayout.getItemStacks().init(2, true, 116, 6  );
        recipeLayout.getItemStacks().init(3, true, 80, 36  );
        recipeLayout.getItemStacks().init(4, true, 44, 66  );
        recipeLayout.getItemStacks().init(5, true, 116, 36  );
        recipeLayout.getItemStacks().init(6, true, 80, 66  );
        recipeLayout.getItemStacks().init(7, true, 44, 66  );
        recipeLayout.getItemStacks().init(8, false, 116, 36  );

        recipeLayout.getItemStacks().set(ingredients);
    }
}
