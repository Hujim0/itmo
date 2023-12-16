package main.scene;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.scene.enums.FoodItems;
import engine.scene.nodes.Node;

@Data
@AllArgsConstructor
public class FoodItem extends Node {
    FoodItems item;

}
