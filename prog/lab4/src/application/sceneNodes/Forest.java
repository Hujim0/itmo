package application.sceneNodes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import engine.scene.nodes.PositionNode;
import engine.structs.IntVector2;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor

public class Forest extends PositionNode {

    public Forest(IntVector2 position) {
        super(position);
    }

    @Override
    public void treeEnter() {
        final IntVector2[] TreesChunk = new IntVector2[] {
                new IntVector2(0,1),
                new IntVector2(5,2),
                new IntVector2(4,-1),
                new IntVector2(8,0),
            };

        final IntVector2[] TreesChunk2 = new IntVector2[] {
                new IntVector2(2,3),
                new IntVector2(4,-1),
                new IntVector2(0,1),
                new IntVector2(7,0),
        };
        final IntVector2[] offsets = new IntVector2[] {
                new IntVector2(3,0),
                new IntVector2(14,0),
                new IntVector2(26,1),
                new IntVector2(37,0),
                new IntVector2(49,1),
        };

        addChild(new Tree(new IntVector2(0, 0)));
        addChild(new Tree(new IntVector2(-2, 4)));
        addChild(new Tree(new IntVector2(52, 8)));

        for (IntVector2 pos : offsets) {
            for (IntVector2 offset : TreesChunk) {
                addChild(new Tree(new IntVector2(pos.X + offset.X, pos.Y + offset.Y)));
            }
        }
        addAction(4, (object) -> {
            forAllChildren((tree_obj) -> {
                ((Tree)tree_obj).setVisible(true);
            });
        });

        addAction(5, (object) -> {
            object.forAllChildren((child) -> {
                child.setActive(false);
            });
        });
        addAction(6, (object) -> {
            object.queueFree();
            System.out.println("За ночь опали лепестки цветов на деревьях.");

        });

        forAllChildren((tree_obj) -> {
            ((Tree)tree_obj).dropFlowerPetals();
            ((Tree)tree_obj).setVisible(false);
        });
    }
}
