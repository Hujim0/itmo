package main.scene.interfaces;

public interface Action<T> {
    void invoke(T instance);
}
