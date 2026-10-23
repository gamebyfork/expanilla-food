package org.fork.expanilla_food;

import net.fabricmc.api.ModInitializer;
import org.fork.expanilla_food.item.ModItemGroupAdditions;
import org.fork.expanilla_food.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Expanilla_food implements ModInitializer {
    public static final String MOD_ID = "expanilla_food";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.initialize();

        ModItemGroupAdditions.register();

        LOGGER.info("Expanilla Food initialized!");
    }
}
