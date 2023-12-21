package application.main.scene;

import application.extensions.CanBeDescribed;
import engine.scene.nodes.Node;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FoodBasket extends Node implements CanBeDescribed {
    @Override
    public String describe() {
        return "Она была набита маленькими аккуратными бутербродиками, завернутыми в шелковистую бумагу";
    }

    @Override
    public void treeEnter() {
        setName("Корзинка с едой");
        addChild(new Sandwich("\"Сыр\"", "Мама"));
        addChild(new Sandwich("\"Только с маслом\"", "мама"));
        addChild(new Sandwich("\"Дорогая колбаса\"", "мама"));
        addChild(new Sandwich("\"С добрым утром!\"", "мама"));
        addChild(new Sandwich("банка крабов, которую папа берег с весны.", "папы"));

        addAction(3, (obj) -> {
            System.out.println(((CanBeDescribed) obj).describe());
        });
    }
}
