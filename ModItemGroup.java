package com.solace.alsera.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup ALSERA = new ItemGroup("alseraTab")
    {
        @Override
        public ItemStack createIcon() {

            return new ItemStack(ModItems.PROTEA_ARUM.get());
        }
    };

    public static final ItemGroup ALSERAMINERAL = new ItemGroup("alseraMineralsTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.ALSOR_INGOT.get());
        }
    };

    public static final ItemGroup ALSERAMATERIALS = new ItemGroup("alseraMaterialsTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.ALSOR_ROD.get());
        }
    };

    public static final ItemGroup ALSERABLOCKS = new ItemGroup("alseraBlocksTab") {
        @Override
        public ItemStack createIcon() { return new ItemStack(ModItems.ALSOR_NUGGET.get());
        }
    };

}
