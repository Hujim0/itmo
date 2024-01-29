package engine.interfaces;

import application.extensions.Screen;

public interface Renderable<T> {
    void renderToScreen(T screen);
}
