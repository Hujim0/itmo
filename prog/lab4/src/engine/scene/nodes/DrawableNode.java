package engine.scene.nodes;

import engine.interfaces.Renderable;
import lombok.*;
import application.extensions.Screen;

@Data
public abstract class  DrawableNode<T> extends PositionNode implements Renderable<T> {
    private boolean isVisible = true;
    public abstract void renderToScreen(T screen);

    @Override
    public void update(int currentFrame) {
        super.update(currentFrame);

        if (isActive() && isVisible) {
            this.getSceneTree().getDrawableNodesRenderQueue().add(this);
        }
    }
}
