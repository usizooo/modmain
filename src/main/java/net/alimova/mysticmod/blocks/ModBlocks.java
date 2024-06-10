package net.alimova.mysticmod.blocks;

import net.alimova.mysticmod.MysticMod;
import net.alimova.mysticmod.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.LightBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import java.util.function.Supplier;


@EventBusSubscriber(modid = "mysticmod", bus = EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MysticMod.MOD_ID);
    public static final RegistryObject<Block> DEMON_ALTAR = registryBlock("demon_altar", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f).lightLevel((state) -> 15)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DEMON_STONE = registryBlock("demon_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(5.0f, 30.0f).sound(SoundType.AMETHYST)), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> DEMON_FIRE = registryBlock("demon_fire",
            () -> new FireBlock(BlockBehaviour.Properties.of(Material.FIRE)
                    .noOcclusion()
                    .lightLevel((state) -> 15)
                    .instabreak()
                    .noCollission()),
            CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> DEMON_ORE = registryBlock("demon_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3.0f, 15.0f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturns = BLOCKS.register(name, block);
        registryBlockItem(name, toReturns, tab);
        return toReturns;
    }
    private static <T extends Block> RegistryObject<BlockItem> registryBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    public static void register (IEventBus bus) {
        BLOCKS.register(bus);
    }
}