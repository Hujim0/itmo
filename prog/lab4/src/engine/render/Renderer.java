package engine.render;

import engine.Debug;
import lombok.Data;
import engine.scene.SceneTree;

import java.util.logging.Level;

@Data
public abstract class Renderer {
    private SceneTree currentSceneTree;

    private final int amountOfFrames;
    private int currentFrame = 0;

    public abstract void showSceneObjects();

    public void render() {
        while (currentFrame < amountOfFrames) {
            Debug.log(Level.FINEST, currentSceneTree.printTree());


            currentSceneTree.update(currentFrame);

            currentSceneTree.sortDrawables();

            showSceneObjects();

            currentSceneTree.releaseRenderQueue();
            currentSceneTree.releaseActionQueue();

            currentFrame++;
        }
    }
}
