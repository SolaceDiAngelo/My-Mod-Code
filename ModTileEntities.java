package com.solace.alsera.tileentity;

import com.solace.alsera.Alsera;
import com.solace.alsera.block.ModBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModTileEntities {
    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Alsera.MOD_ID);

    public static RegistryObject<TileEntityType<MechanicalCombinerTile>> MECHANICAL_COMBINER_TILE =
            TILE_ENTITIES.register("mechanical_combiner_tile", () -> TileEntityType.Builder.create(
                    MechanicalCombinerTile:: new, ModBlocks.MECHANICAL_COMBINER.get()).build(null));

    public static void register(IEventBus eventbus) {
        TILE_ENTITIES.register(eventbus);

    }

}