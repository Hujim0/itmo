package engine.scene.nodes;

import lombok.*;
import engine.structs.IntVector2;

@Getter
@NoArgsConstructor
public class PositionNode extends Node implements Comparable<DrawableNode> {
    @NonNull
    IntVector2 localPosition = new IntVector2(0,0);
    @NonNull
    IntVector2 globalPosition = new IntVector2(0,0);

    public PositionNode(IntVector2 localPosition) {
        this.localPosition = localPosition;
    }

    public void setLocalPosition(IntVector2 position) {
        globalPosition = globalPosition.plus(new IntVector2(position.X - localPosition.X, position.Y - localPosition.Y));
        localPosition = position;

    }

    @Override
    public void setParentNode(Node parentNode) {
        super.setParentNode(parentNode);

        if (parentNode instanceof PositionNode) {
            IntVector2 parentGlobalPosition = ((PositionNode)parentNode).getGlobalPosition();

            localPosition = new IntVector2(this.localPosition.X - parentGlobalPosition.X,this.localPosition.Y - parentGlobalPosition.Y);
            globalPosition = this.globalPosition.plus(parentGlobalPosition);
        }
    }

    @Override
    public int compareTo(DrawableNode o) {
        int YDifference = this.globalPosition.Y - o.getGlobalPosition().Y;
        int XDifference = this.globalPosition.X - o.getGlobalPosition().X;

        if (YDifference == 0) {
            return XDifference;
        }
        else {
            return YDifference;
        }
    }
}
