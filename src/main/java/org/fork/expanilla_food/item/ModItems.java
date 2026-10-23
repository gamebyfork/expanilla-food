package org.fork.expanilla_food.item;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.component.UseRemainder;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.RemoveStatusEffectsConsumeEffect;
import net.minecraft.world.item.consume_effects.ClearAllStatusEffectsConsumeEffect;
import net.minecraft.sounds.SoundEvents;
import org.fork.expanilla_food.Expanilla_food;


public class ModItems {


    // 1. Apple Juice (Speed I)
    public static final FoodProperties APPLE_JUICE_FOOD = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.3f).alwaysEdible().build();

    public static final Consumable APPLE_JUICE_CONSUMABLE = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.SPEED, 200, 0), 1.0f))
            .build();

    public static final Item APPLE_JUICE = registerItem(
            "apple_juice",
            new Item.Properties()
                    .food(APPLE_JUICE_FOOD, APPLE_JUICE_CONSUMABLE)
                    .component(
                            DataComponents.USE_REMAINDER,
                            new UseRemainder(new ItemStackTemplate(Items.GLASS_BOTTLE))
                    )
    );

    // 2. Carrot Juice (Night Vision)
    public static final FoodProperties CARROT_JUICE_FOOD = new FoodProperties.Builder()
            .nutrition(10).saturationModifier(0.4f).alwaysEdible().build();

    public static final Consumable CARROT_JUICE_CONSUMABLE = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0), 1.0f))
            .build();

    public static final Item CARROT_JUICE = registerItem("carrot_juice",
            new Item.Properties()
                    .food(CARROT_JUICE_FOOD, CARROT_JUICE_CONSUMABLE)
                    .component(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStackTemplate(Items.GLASS_BOTTLE)))
    );

    // 3. BERRY SMOOTHIE (Regeneration)
    public static final FoodProperties BERRY_SMOOTHIE_FOOD = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.4f).alwaysEdible().build();

    public static final Consumable BERRY_SMOOTHIE_CONSUMABLE = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0f))
            .build();

    public static final Item BERRY_SMOOTHIE = registerItem("berry_smoothie",
            new Item.Properties()
                    .food(BERRY_SMOOTHIE_FOOD, BERRY_SMOOTHIE_CONSUMABLE)
                    .component(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStackTemplate(Items.GLASS_BOTTLE)))
    );

    // 4. Honey Drink (Saturation + Regeneration)
    public static final FoodProperties HONEY_DRINK_FOOD = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.6f).alwaysEdible().build();

    public static final Consumable HONEY_DRINK_CONSUMABLE = Consumable.builder()
            .animation(ItemUseAnimation.DRINK)
            // SoundEvents.HONEY_DRINK уже является Holder<SoundEvent>, оборачивать не нужно
            .sound(SoundEvents.HONEY_DRINK)
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.SATURATION, 20, 0), 1.0f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.REGENERATION, 60, 0), 1.0f))
            // MobEffects.POISON тоже уже Holder<MobEffect>, передаём напрямую
            .onConsume(new RemoveStatusEffectsConsumeEffect(MobEffects.POISON))
            .build();

    public static final Item HONEY_DRINK = registerItem("honey_drink",
            new Item.Properties()
                    .food(HONEY_DRINK_FOOD, HONEY_DRINK_CONSUMABLE)
                    .component(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStackTemplate(Items.GLASS_BOTTLE)))
    );

    // 5. Toast (Fast consuming)
    public static final FoodProperties TOAST_FOOD = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.3f).build();

    public static final Consumable TOAST_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(0.8f).build(); // 2x faster

    public static final Item TOAST = registerItem("toast",
            new Item.Properties().food(TOAST_FOOD, TOAST_CONSUMABLE)
    );

    // 6. Fried Egg
    public static final FoodProperties FRIED_EGG_FOOD = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.6f).build();

    public static final Consumable FRIED_EGG_CONSUMABLE = Consumables.defaultFood().build();

    public static final Item FRIED_EGG = registerItem("fried_egg",
            new Item.Properties().food(FRIED_EGG_FOOD, FRIED_EGG_CONSUMABLE)
    );

    // HEARTY FOOD
    // 7. Steak Sandwich
    public static final FoodProperties STEAK_SANDWICH_FOOD = new FoodProperties.Builder()
            .nutrition(10).saturationModifier(0.8f).build();
    public static final Item STEAK_SANDWICH = registerItem("steak_sandwich",
            new Item.Properties().food(STEAK_SANDWICH_FOOD, Consumables.defaultFood().build())
    );

    // 8. Chicken Sandwich
    public static final FoodProperties CHICKEN_SANDWICH_FOOD = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.7f).build();
    public static final Item CHICKEN_SANDWICH = registerItem("chicken_sandwich",
            new Item.Properties().food(CHICKEN_SANDWICH_FOOD, Consumables.defaultFood().build())
    );

    // 9. Double Burger
    public static final FoodProperties DOUBLE_BURGER_FOOD = new FoodProperties.Builder()
            .nutrition(12).saturationModifier(1.0f).build();
    public static final Item DOUBLE_BURGER = registerItem("double_burger",
            new Item.Properties().food(DOUBLE_BURGER_FOOD, Consumables.defaultFood().build())
    );

    // 10. Meat Stew
    public static final FoodProperties MEAT_STEW_FOOD = new FoodProperties.Builder()
            .nutrition(10).saturationModifier(0.8f).build();
    public static final Item MEAT_STEW = registerItem("meat_stew",
            new Item.Properties()
                    .food(MEAT_STEW_FOOD, Consumables.defaultFood().build())
                    .component(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStackTemplate(Items.BOWL)))
    );

    // 11. Meat Pie
    public static final FoodProperties MEAT_PIE_FOOD = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.9f).build();
    public static final Item MEAT_PIE = registerItem("meat_pie",
            new Item.Properties().food(MEAT_PIE_FOOD, Consumables.defaultFood().build())
    );

    // 12. Chicken Noodle Soup (Regeneration)
    public static final FoodProperties CHICKEN_NOODLE_SOUP_FOOD = new FoodProperties.Builder()
            .nutrition(7).saturationModifier(0.6f).build();
    public static final Consumable CHICKEN_NOODLE_SOUP_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0f))
            .build();
    public static final Item CHICKEN_NOODLE_SOUP = registerItem("chicken_noodle_soup",
            new Item.Properties()
                    .food(CHICKEN_NOODLE_SOUP_FOOD, CHICKEN_NOODLE_SOUP_CONSUMABLE)
                    .component(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStackTemplate(Items.BOWL)))
    );

    // 13. Sausage Roll
    public static final FoodProperties SAUSAGE_ROLL_FOOD = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.5f).build();
    public static final Item SAUSAGE_ROLL = registerItem("sausage_roll",
            new Item.Properties().food(SAUSAGE_ROLL_FOOD, Consumables.defaultFood().build())
    );

    // VEGETABLES
    // 14. Vegetable Soup
    public static final FoodProperties VEGETABLE_STEW_FOOD = new FoodProperties.Builder()
            .nutrition(7).saturationModifier(0.8f).build();
    public static final Item VEGETABLE_STEW = registerItem("vegetable_stew",
            new Item.Properties()
                    .food(VEGETABLE_STEW_FOOD, Consumables.defaultFood().build())
                    .component(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStackTemplate(Items.BOWL)))
    );

    // 15. Pumpkin Soup
    public static final FoodProperties PUMPKIN_SOUP_FOOD = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.8f).build();
    public static final Item PUMPKIN_SOUP = registerItem("pumpkin_soup",
            new Item.Properties()
                    .food(PUMPKIN_SOUP_FOOD, Consumables.defaultFood().build())
                    .component(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStackTemplate(Items.BOWL)))
    );

    // 16. Mashed Potatoes
    public static final FoodProperties MASHED_POTATOES_FOOD = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.5f).build();
    public static final Item MASHED_POTATOES = registerItem("mashed_potatoes",
            new Item.Properties()
                    .food(MASHED_POTATOES_FOOD, Consumables.defaultFood().build())
                    .component(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStackTemplate(Items.BOWL)))
    );

    // 17. Salad (Fast consuming)
    public static final FoodProperties SALAD_FOOD = new FoodProperties.Builder()
            .nutrition(7).saturationModifier(0.6f).build();
    public static final Consumable SALAD_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(0.8f)
            .build();
    public static final Item SALAD = registerItem("salad",
            new Item.Properties()
                    .food(SALAD_FOOD, SALAD_CONSUMABLE)
                    .component(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStackTemplate(Items.BOWL)))
    );

    // 18. Cooked Beetroot
    public static final FoodProperties COOKED_BEETROOT_FOOD = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.5f).build();
    public static final Item COOKED_BEETROOT = registerItem("cooked_beetroot",
            new Item.Properties().food(COOKED_BEETROOT_FOOD, Consumables.defaultFood().build())
    );

    // 19. Cooked Carrot
    public static final FoodProperties COOKED_CARROT_FOOD = new FoodProperties.Builder()
            .nutrition(5).saturationModifier(0.6f).build();
    public static final Item COOKED_CARROT = registerItem("cooked_carrot",
            new Item.Properties().food(COOKED_CARROT_FOOD, Consumables.defaultFood().build())
    );

    // 20. Pepitas (Very fast consuming)
    public static final FoodProperties PEPITAS_FOOD = new FoodProperties.Builder()
            .nutrition(2).saturationModifier(0.2f).build();
    public static final Consumable PEPITAS_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(0.6f) // Очень быстрое поедание
            .build();
    public static final Item PEPITAS = registerItem("pepitas",
            new Item.Properties().food(PEPITAS_FOOD, PEPITAS_CONSUMABLE)
    );

    // DESSERTS
    // 21. Milk Bottle (Removes all effects)
    public static final Consumable MILK_BOTTLE_CONSUMABLE = Consumables.defaultDrink()
            .onConsume(new ClearAllStatusEffectsConsumeEffect())
            .build();

    public static final Item MILK_BOTTLE = registerItem("milk_bottle",
            new Item.Properties()
                    .food(new FoodProperties.Builder().nutrition(0).build(), MILK_BOTTLE_CONSUMABLE)
                    .component(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStackTemplate(Items.GLASS_BOTTLE)))
                    .craftRemainder(Items.GLASS_BOTTLE)
    );

    // 22. Charlotte
    public static final FoodProperties APPLE_PIE_FOOD = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.9f).build();
    public static final Item APPLE_PIE = registerItem("apple_pie",
            new Item.Properties().food(APPLE_PIE_FOOD, Consumables.defaultFood().build())
    );

    // 23. Berry Pie
    public static final FoodProperties BERRY_PIE_FOOD = new FoodProperties.Builder()
            .nutrition(7).saturationModifier(0.8f).build();
    public static final Item BERRY_PIE = registerItem("berry_pie",
            new Item.Properties().food(BERRY_PIE_FOOD, Consumables.defaultFood().build())
    );

    // 24. Honey Cake (Regeneration)
    public static final FoodProperties HONEY_CAKE_FOOD = new FoodProperties.Builder()
            .nutrition(7).saturationModifier(0.8f).build();
    public static final Consumable HONEY_CAKE_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.REGENERATION, 60, 0), 1.0f))
            .build();
    public static final Item HONEY_CAKE = registerItem("honey_cake",
            new Item.Properties().food(HONEY_CAKE_FOOD, HONEY_CAKE_CONSUMABLE)
    );

    // 25. Caramel Apple
    public static final FoodProperties CARAMEL_APPLE_FOOD = new FoodProperties.Builder()
            .nutrition(5).saturationModifier(0.5f).build();
    public static final Item CARAMEL_APPLE = registerItem("caramel_apple",
            new Item.Properties().food(CARAMEL_APPLE_FOOD, Consumables.defaultFood().build())
    );

    // 26. Chocolate Bar
    public static final FoodProperties CHOCOLATE_BAR_FOOD = new FoodProperties.Builder()
            .nutrition(4).saturationModifier(0.2f).build();
    public static final Consumable CHOCOLATE_BAR_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.SPEED, 200, 0), 1.0f))
            .build();
    public static final Item CHOCOLATE_BAR = registerItem("chocolate_bar",
            new Item.Properties().food(CHOCOLATE_BAR_FOOD, CHOCOLATE_BAR_CONSUMABLE)
    );

    // 27. Ice Cream (Fire Resistance)
    public static final FoodProperties ICE_CREAM_FOOD = new FoodProperties.Builder()
            .nutrition(3).saturationModifier(0.1f).build();
    public static final Consumable ICE_CREAM_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 0), 1.0f))
            .build();
    public static final Item ICE_CREAM = registerItem("ice_cream",
            new Item.Properties()
                    .food(ICE_CREAM_FOOD, ICE_CREAM_CONSUMABLE)
                    .component(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStackTemplate(Items.BOWL)))
    );

    // 28. Berry Cookie
    public static final FoodProperties BERRY_COOKIE_FOOD = new FoodProperties.Builder()
            .nutrition(5).saturationModifier(0.3f).build();
    public static final Item BERRY_COOKIE = registerItem("berry_cookie",
            new Item.Properties().food(BERRY_COOKIE_FOOD, Consumables.defaultFood().build())
    );

    // 29. Glow Smoothie (Glowing)
    public static final FoodProperties GLOWING_SMOOTHIE_FOOD = new FoodProperties.Builder()
            .nutrition(7).saturationModifier(0.4f).alwaysEdible().build();

    public static final Consumable GLOWING_SMOOTHIE_CONSUMABLE = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.GLOWING, 300, 0), 1.0f))
            .build();

    public static final Item GLOWING_SMOOTHIE = registerItem("glowing_smoothie",
            new Item.Properties()
                    .food(GLOWING_SMOOTHIE_FOOD, GLOWING_SMOOTHIE_CONSUMABLE)
                    .component(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStackTemplate(Items.GLASS_BOTTLE)))
    );

    // 30. Cave Pie (Glowing + Night Vision)
    public static final FoodProperties CAVE_PIE_FOOD = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.9f).build();
    public static final Consumable CAVE_PIE_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.GLOWING, 600, 0), 1.0f)) // 30 сек
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.NIGHT_VISION, 100, 0), 1.0f)) // 5 сек (сбалансировано)
            .build();
    public static final Item CAVE_PIE = registerItem("cave_pie",
            new Item.Properties().food(CAVE_PIE_FOOD, CAVE_PIE_CONSUMABLE)
    );

    // 31. Berry Toast
    public static final FoodProperties BERRY_TOAST_FOOD = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.5f).build();
    public static final Item BERRY_TOAST = registerItem("berry_toast",
            new Item.Properties().food(BERRY_TOAST_FOOD, Consumables.defaultFood().build())
    );

    // 32. Glowing Toast (Glowing)
    public static final FoodProperties GLOWING_TOAST_FOOD = new FoodProperties.Builder()
            .nutrition(6).saturationModifier(0.5f).build();
    public static final Consumable GLOWING_TOAST_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.GLOWING, 200, 0), 1.0f)) //
            .build();
    public static final Item GLOWING_TOAST = registerItem("glowing_toast",
            new Item.Properties().food(GLOWING_TOAST_FOOD, GLOWING_TOAST_CONSUMABLE)
    );

    // 33.Sea Soup (Water Breathing)
    public static final FoodProperties SEA_SOUP_FOOD = new FoodProperties.Builder()
            .nutrition(8).saturationModifier(0.8f).build();
    public static final Consumable SEA_SOUP_CONSUMABLE = Consumables.defaultFood()
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.WATER_BREATHING, 400, 0), 1.0f))
            .build();
    public static final Item SEA_SOUP = registerItem("sea_soup",
            new Item.Properties()
                    .food(SEA_SOUP_FOOD, SEA_SOUP_CONSUMABLE)
                    .component(DataComponents.USE_REMAINDER, new UseRemainder(new ItemStackTemplate(Items.BOWL)))
    );

    // 34. Mutton Sandwich
    public static final FoodProperties MUTTON_SANDWICH_FOOD = new FoodProperties.Builder()
            .nutrition(9).saturationModifier(0.8f).build();
    public static final Item MUTTON_SANDWICH = registerItem("mutton_sandwich",
            new Item.Properties().food(MUTTON_SANDWICH_FOOD, Consumables.defaultFood().build())
    );

    // 35. Shepherd's Pie
    public static final FoodProperties SHEPHERDS_PIE_FOOD = new FoodProperties.Builder()
            .nutrition(14).saturationModifier(0.9f).build();
    public static final Item SHEPHERDS_PIE = registerItem("shepherds_pie",
            new Item.Properties().food(SHEPHERDS_PIE_FOOD, Consumables.defaultFood().build())
    );


    // Initialization
    private static Item registerItem(String name, Item.Properties properties) {
        ResourceKey<Item> itemKey = ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(Expanilla_food.MOD_ID, name)
        );
        Item item = new Item(properties.setId(itemKey));
        return Registry.register(BuiltInRegistries.ITEM, itemKey, item);
    }

    public static void initialize() {
        Expanilla_food.LOGGER.info("Registering Mod Items for " + Expanilla_food.MOD_ID);
    }
}