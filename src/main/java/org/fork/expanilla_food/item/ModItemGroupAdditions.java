package org.fork.expanilla_food.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;

public class ModItemGroupAdditions {

    public static void register() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS).register(output ->
        {
            output.accept(ModItems.APPLE_JUICE);
            output.accept(ModItems.CARROT_JUICE);
            output.accept(ModItems.BERRY_SMOOTHIE);
            output.accept(ModItems.HONEY_DRINK);
            output.accept(ModItems.TOAST);
            output.accept(ModItems.FRIED_EGG);
            output.accept(ModItems.STEAK_SANDWICH);
            output.accept(ModItems.CHICKEN_SANDWICH);
            output.accept(ModItems.DOUBLE_BURGER);
            output.accept(ModItems.MEAT_STEW);
            output.accept(ModItems.MEAT_PIE);
            output.accept(ModItems.CHICKEN_NOODLE_SOUP);
            output.accept(ModItems.SAUSAGE_ROLL);
            output.accept(ModItems.VEGETABLE_STEW);
            output.accept(ModItems.PUMPKIN_SOUP);
            output.accept(ModItems.MASHED_POTATOES);
            output.accept(ModItems.SALAD);
            output.accept(ModItems.COOKED_BEETROOT);
            output.accept(ModItems.COOKED_CARROT);
            output.accept(ModItems.PEPITAS);
            output.accept(ModItems.MILK_BOTTLE);
            output.accept(ModItems.APPLE_PIE);
            output.accept(ModItems.BERRY_PIE);
            output.accept(ModItems.HONEY_CAKE);
            output.accept(ModItems.CARAMEL_APPLE);
            output.accept(ModItems.CHOCOLATE_BAR);
            output.accept(ModItems.ICE_CREAM);
            output.accept(ModItems.BERRY_COOKIE);

            // NEW
            output.accept(ModItems.GLOWING_SMOOTHIE);
            output.accept(ModItems.CAVE_PIE);
            output.accept(ModItems.BERRY_TOAST);
            output.accept(ModItems.GLOWING_TOAST);
            output.accept(ModItems.SEA_SOUP);
            output.accept(ModItems.MUTTON_SANDWICH);
            output.accept(ModItems.SHEPHERDS_PIE);
        });
    }
}