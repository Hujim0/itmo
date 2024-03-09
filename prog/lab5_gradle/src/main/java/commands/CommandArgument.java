package commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommandArgument {
    String name;
    String description;
    boolean isOptional;

    @Override
    public String toString() {
        return "{" + (isOptional? "?" : "") + name + "}";
    }
}
