package net.tonyearlnate.awesomemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.tonyearlnate.awesomemod.AwesomeMod;
import net.tonyearlnate.awesomemod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup KITIUM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AwesomeMod.MOD_ID, "kitium_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_KITIUM))
                    .displayName(Text.translatable("itemgroup.awesome-mod.kitium_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PINK_KITIUM);
                        entries.add(ModItems.BLUE_KITIUM);
                        entries.add(ModItems.ENERGIZED_KITIUM);
                    }).build());

    public static final ItemGroup KITIUM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(AwesomeMod.MOD_ID, "kitium_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_KITIUM_BLOCK))
                    .displayName(Text.translatable("itemgroup.awesome-mod.kitium_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PINK_KITIUM_BLOCK);
                        entries.add(ModBlocks.BLUE_KITIUM_BLOCK);
                        entries.add(ModBlocks.ENERGIZED_KITIUM_BLOCK);
                        entries.add(ModBlocks.PINK_KITIUM_ORE);
                        entries.add(ModBlocks.BLUE_KITIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PINK_KITIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_BLUE_KITIUM_ORE);
                    }).build());

    public static void registerItemGroups() {
        AwesomeMod.LOGGER.info("Registering Item Groups for " + AwesomeMod.MOD_ID);
    }
}