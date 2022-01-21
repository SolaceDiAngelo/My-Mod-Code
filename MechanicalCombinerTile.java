package com.solace.alsera.tileentity;

import com.solace.alsera.block.ModBlocks;
import com.solace.alsera.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;


public class MechanicalCombinerTile extends TileEntity {

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public MechanicalCombinerTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public MechanicalCombinerTile() {
        this(ModTileEntities.MECHANICAL_COMBINER_TILE.get());
    }

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());
        return super.write(compound);
    }

    private ItemStackHandler createHandler() {
        return new ItemStackHandler(9) {
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @NotNull ItemStack stack) {
                switch (slot) {
                    case 0:
                        return stack.getItem() == ModItems.GUARDIAN_HEART.get();
                    case 1:
                        return stack.getItem() == ModItems.PROTEA_ARUM.get();
                    case 2:
                        return stack.getItem() == ModItems.ANGEL_SOUL.get();
                    case 3:
                        return stack.getItem() == ModItems.ALSOR_INGOT.get();
                    case 4:
                        return stack.getItem() == ModItems.REDALLIUM_INGOT.get();
                    case 5:
                        return stack.getItem() == ModItems.ALSOR_NUGGET.get();
                    case 6:
                        return stack.getItem() == ModItems.REDALLIUM_NUGGET.get();
                    case 7:
                        return stack.getItem() == ModItems.ALSOR_ROD.get();
                    case 8:
                        return stack.getItem() == ModItems.GUARDIAN_HEART.get();
                    default:
                        return false;
                }
            }
            @Override
            public int getSlotLimit(int slot) {
                return 1;
            }

            @NotNull
            @Override
            public ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
                if (!isItemValid(slot, stack)){
                    return stack;
                }

                return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }

        return super.getCapability(cap, side);
    }
    public void Mechanical_Combiner() {
        boolean hasFocusInFirstSlot = this.itemHandler.getStackInSlot(0).getCount() > 0
                && this.itemHandler.getStackInSlot(0).getItem() == ModItems.GUARDIAN_HEART.get();
        boolean hasFocusInSecondSlot = this.itemHandler.getStackInSlot(1).getCount() > 0
                && this.itemHandler.getStackInSlot(1).getItem() == ModItems.PROTEA_ARUM.get();
        boolean hasFocusInThirdSlot = this.itemHandler.getStackInSlot(2).getCount() > 0
                && this.itemHandler.getStackInSlot(2).getItem() == ModItems.ANGEL_SOUL.get();
        boolean hasFocusInFourthSlot = this.itemHandler.getStackInSlot(3).getCount() > 0
                && this.itemHandler.getStackInSlot(3).getItem() == ModItems.ALSOR_INGOT.get();
        boolean hasFocusInFifthSlot = this.itemHandler.getStackInSlot(4).getCount() > 0
                && this.itemHandler.getStackInSlot(4).getItem() == ModItems.REDALLIUM_INGOT.get();
        boolean hasFocusInSixthSlot = this.itemHandler.getStackInSlot(5).getCount() > 0
                && this.itemHandler.getStackInSlot(5).getItem() == ModItems.ALSOR_NUGGET.get();
        boolean hasFocusInSeventhSlot = this.itemHandler.getStackInSlot(6).getCount() > 0
                && this.itemHandler.getStackInSlot(6).getItem() == ModItems.REDALLIUM_NUGGET.get();
        boolean hasFocusInEighthSlot = this.itemHandler.getStackInSlot(7).getCount() > 0
                && this.itemHandler.getStackInSlot(7).getItem() == ModItems.ALSOR_ROD.get();

        if(hasFocusInFirstSlot && hasFocusInSecondSlot && hasFocusInThirdSlot && hasFocusInFourthSlot && hasFocusInFifthSlot
                && hasFocusInSixthSlot && hasFocusInSeventhSlot && hasFocusInEighthSlot){
            this.itemHandler.getStackInSlot(0).shrink(1);
            this.itemHandler.getStackInSlot(1).shrink(1);
            this.itemHandler.getStackInSlot(2).shrink(1);
            this.itemHandler.getStackInSlot(3).shrink(1);
            this.itemHandler.getStackInSlot(4).shrink(1);
            this.itemHandler.getStackInSlot(5).shrink(1);
            this.itemHandler.getStackInSlot(6).shrink(1);
            this.itemHandler.getStackInSlot(7).shrink(1);

            this.itemHandler.insertItem(1, new ItemStack(ModItems.LONGEVITY_STONE.get()), false);
        }
    }
}
