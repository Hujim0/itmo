package application.characters;

import application.extensions.CanBeDescribed;
import application.extensions.Sensible;
import application.sceneNodes.FoodBasket;
import application.sceneNodes.Sandwich;
import engine.structs.EnvironmentTemperature;
import engine.scene.nodes.Node;
import engine.scene.Environment;

import java.util.ArrayList;
import java.util.List;

public class MuminTroll extends Node implements Sensible {

    @Override
    public String toString() {
        return "MuminTroll";
    }

    @Override
    public void reactToEnvironment(Environment environment) {
        if (environment.getTemperature() == EnvironmentTemperature.COLD_TEMREATURE) {
            System.out.println("Было " + environment.getTemperature().description);
        }
    }
    @Override
    public void treeEnter() {
        addAction(6, (obj) -> {
            MuminTroll instance = (MuminTroll) obj;

            Environment currentEnvironment = obj.getSceneTree().getEnvironment();

            instance.reactToEnvironment(currentEnvironment);

        });
        addAction(7, (obj) -> {
            for (Node sibling : obj.getParentNode().getChildNodes())  {
                if (sibling.getName() == "Корзинка с едой") {
                    sibling.queueMoveToChild(obj);
                    break;
                }
            }

            System.out.println("Наконец Муми-тролль встал и машинально снял с ветки корзинку с едой.");
        });

        addAction(8, (obj) -> {
            FoodBasket basket = (FoodBasket)obj.getChildNodes().get(0);

            System.out.println(basket.describe());

            final class FoodBasketDescriber implements CanBeDescribed {

                final List<Sandwich> sandwiches = new ArrayList<>();
                public FoodBasketDescriber (FoodBasket basket1) {
                    for (Node node :basket1.getChildNodes()) {
                        this.sandwiches.add((Sandwich)node);
                    }
                }

                public String describe() {
                    StringBuilder builder = new StringBuilder();

                    builder.append("Вдруг он увидел надписи на свертках: их сделала ");
                    builder.append((sandwiches.get(0)).getMadeBy());
                    builder.append("\nНа каждом из них стояло ");

                    for (int i = 0; i < sandwiches.size() - 1; i++) {
                        if (i != 0) {
                            builder.append(", ");
                        }
                        builder.append("либо ");
                        builder.append(sandwiches.get(i).getName());
                    }

                    Sandwich sandwichFromPapa = sandwiches.get(sandwiches.size() - 1);

                    builder.append("\nНа последнем мама написала: \"Это от ");
                    builder.append(sandwichFromPapa.getMadeBy());
                    builder.append("\"\nВ свертке оказалась ");
                    builder.append(sandwichFromPapa.getName());
                    builder.append("\n");

                    return builder.toString();
                }
            }

            FoodBasketDescriber describer = new FoodBasketDescriber(basket);

            System.out.println(describer.describe());

//            System.out.print("Вдруг он увидел надписи на свертках: их сделала ");
//
//            System.out.println(((Sandwich)sandwiches.get(0)).getMadeBy());
//
//            System.out.print("На каждом из них стояло ");
//
//            for (int i = 0; i < sandwiches.size() - 1; i++) {
//                if (i != 0) {
//                    System.out.print(", ");
//                }
//                System.out.print("либо " + sandwiches.get(i).getName());
//            }
//
//            Sandwich sandwichFromPapa = (Sandwich) sandwiches.get(sandwiches.size() - 1);
//
//            System.out.print("\n");
//            System.out.println("На последнем мама написала: \"Это от " + sandwichFromPapa.getMadeBy() + "\"");
//
//            System.out.println("В свертке оказалась " + sandwichFromPapa.getName());
        });
    }
}