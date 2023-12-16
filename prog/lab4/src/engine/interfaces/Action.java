package engine.interfaces;

public interface Action<T> {
    void invoke(T instance);
}
