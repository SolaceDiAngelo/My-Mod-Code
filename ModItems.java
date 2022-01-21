package com.solace.alsera.item;

import com.solace.alsera.Alsera;
import com.solace.alsera.item.custom.LongevityStone;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Alsera.MOD_ID);

    public static final RegistryObject<Item> PROTEA_ARUM = ITEMS.register("protea_arum",
            () -> new Item(new Item.Properties().group(ModItemGroup.ALSERA)));

    public static final RegistryObject<Item> GUARDIAN_HEART = ITEMS.register("guardian_heart",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.ALSERA)));

    public static final RegistryObject<Item> REDALLIUM_INGOT = ITEMS.register("redallium_ingot",
            () -> new Item(new Item.Properties().group(ModItemGroup.ALSERAMINERAL)));

    public static final RegistryObject<Item> ALSOR_INGOT = ITEMS.register("alsor_ingot",
            () -> new Item(new Item.Properties().group(ModItemGroup.ALSERAMINERAL)));

    public static final RegistryObject<Item> ALSOR_ROD = ITEMS.register("alsor_rod",
            () -> new Item(new Item.Properties().group(ModItemGroup.ALSERAMATERIALS)));

    public static final RegistryObject<Item> REDALLIUM_NUGGET = ITEMS.register("redallium_nugget",
            () -> new Item(new Item.Properties().group(ModItemGroup.ALSERAMINERAL)));

    public static final RegistryObject<Item> ALSOR_NUGGET = ITEMS.register("alsor_nugget",
            () -> new Item(new Item.Properties().group(ModItemGroup.ALSERAMINERAL)));

    public static final RegistryObject<Item> LONGEVITY_STONE = ITEMS.register("longevity_stone",
            () -> new LongevityStone(new Item.Properties().group(ModItemGroup.ALSERA).maxDamage(12)));

    public static final RegistryObject<Item> ANGEL_SOUL = ITEMS.register("angels_soul",
            () -> new Item(new Item.Properties().maxStackSize(1).group(ModItemGroup.ALSERAMATERIALS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
