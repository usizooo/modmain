package net.alimova.mysticmod.items;

import net.alimova.mysticmod.MysticMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.PickaxeItem;

@EventBusSubscriber(modid = "mysticmod", bus = EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MysticMod.MOD_ID);

    public static final RegistryObject<Item> DEMON_SWORD = ITEMS.register("demon_sword", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> DEMONIC_FOOD = ITEMS.register("demon_food", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).food(new FoodProperties.Builder().nutrition(8).saturationMod(0.8f).build())));
    public static final RegistryObject<Item> DEMONIC_BOOK = ITEMS.register("demon_book", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    public static final RegistryObject<Item> DEMONIC_PICKAXE = ITEMS.register("demon_pickaxe", () -> new PickaxeItem(Tiers.DIAMOND, 1, -2.8f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));
    public static final RegistryObject<Item> DEMONIC_MACE = ITEMS.register("demonic_mace", () -> new DemonicMace());
    public static void register (IEventBus bus) {
        ITEMS.register(bus);
    }
}