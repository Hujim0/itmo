package engine.scene.nodes;

import lombok.*;
import engine.render.Screen;

@Data
public abstract class DrawableNode extends PositionNode {
    boolean isVisible = true;
    public abstract void renderToScreen(Screen screen);

    @Override
    public void update(int currentFrame) {
        super.update(currentFrame);

        if (isActive() && isVisible) {
            this.getSceneTree().getDrawableNodesRenderQueue().add(this);
        }
    }
}
