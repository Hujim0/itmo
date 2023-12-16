package engine.structs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import engine.interfaces.Action;

@AllArgsConstructor
public class ActionOnFrame<T> {
    @Getter
    final int ActionFrame;
    @NonNull
    Action<T> action;
    public void invoke(T instance) {
        action.invoke(instance);
    }
}
