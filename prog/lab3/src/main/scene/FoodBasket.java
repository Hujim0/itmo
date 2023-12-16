package main.scene;

import main.scene.enums.FoodItems;
import main.scene.nodes.Node;

public class FoodBasket extends Node {

    @Override
    public void start() {
        addChild(new FoodItem(FoodItems.APPLE));
        addChild(new FoodItem(FoodItems.PEACH));
        addChild(new FoodItem(FoodItems.BANANA));
        addChild(new FoodItem(FoodItems.BLUE_BERRIES));


    }

    static {
        
    }
}
