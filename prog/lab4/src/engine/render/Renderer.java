package engine.render;

import lombok.Data;
import engine.structs.IntVector2;
import engine.scene.SceneTree;
import engine.scene.nodes.DrawableNode;

@Data
public class Renderer {
    private Screen currentScreen;
    private SceneTree currentSceneTree;

    private final int amountOfFrames;

    public Renderer(IntVector2 resolution, SceneTree sceneTree, int amountOfFrames) {
        currentScreen = new Screen(resolution);
        this.amountOfFrames = amountOfFrames;
        this.currentSceneTree = sceneTree;
    }
    public void render() {
        while (currentScreen.getFrame() < amountOfFrames) {
            currentScreen.clear();

            currentSceneTree.update(currentScreen.getFrame());

            currentSceneTree.sortDrawables();

            for (DrawableNode drawableNode : currentSceneTree.getDrawableNodesRenderQueue()) {
                drawableNode.renderToScreen(currentScreen);
            }

            for(int i = 0; i < currentScreen.getResolution().Y; i++) {
                String out = new String(currentScreen.getCanvas()[i]);
                if (out.isBlank()) {
                    continue;
                }
                System.out.println(out);
            }

            currentSceneTree.releaseRenderQueue();
            currentSceneTree.releaseActionQueue();

            currentScreen.updateFrameCounter();
        }
    }
}
