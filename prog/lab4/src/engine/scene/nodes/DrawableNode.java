package engine.scene.nodes;

import engine.interfaces.Renderable;
import lombok.*;
import application.extensions.Screen;

@Data
public abstract class DrawableNode extends PositionNode implements Renderable {
    private boolean isVisible = true;
    public abstract void renderToScreen(Screen screen);

    @Override
    public void update(int currentFrame) {
        super.update(currentFrame);

        if (isActive() && isVisible) {
            this.getSceneTree().getDrawableNodesRenderQueue().add(this);
        }
    }
}
