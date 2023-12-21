package application.characters;

import application.extensions.Sensible;
import application.main.scene.Sandwich;
import application.main.scene.enums.EnvironmentTemperature;
import engine.scene.nodes.Node;
import application.main.scene.Environment;

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
        addAction(2, (obj) -> {
            MuminTroll instance = (MuminTroll) obj;

            Environment currentEnvironment = obj.getSceneTree().getEnvironment();

            instance.reactToEnvironment(currentEnvironment);

        });
        addAction(3, (obj) -> {
            for (Node sibling : obj.getParentNode().getChildNodes())  {
                if (sibling.getName() == "Корзинка с едой") {
                    sibling.queueMoveToChild(obj);
                    break;
                }
            }

            System.out.println("Наконец Муми-тролль встал и машинально снял с ветки корзинку с едой.");
        });

        addAction(4, (obj) -> {

            List<Node> sandwiches = obj.getChildNodes().get(0).getChildNodes();

            System.out.print("Вдруг он увидел надписи на свертках: их сделала ");

            System.out.println(((Sandwich)sandwiches.get(0)).getMadeBy());

            System.out.print("На каждом из них стояло ");

            for (int i = 0; i < sandwiches.size() - 1; i++) {
                if (i != 0) {
                    System.out.print(", ");
                }
                System.out.print("либо " + sandwiches.get(i).getName());
            }

            Sandwich sandwichFromPapa = (Sandwich) sandwiches.get(sandwiches.size() - 1);

            System.out.print("\n");
            System.out.println("На последнем мама написала: \"Это от " + sandwichFromPapa.getMadeBy() + "\"");

            System.out.println("В свертке оказалась " + sandwichFromPapa.getName());
        });
    }
}