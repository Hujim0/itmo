package console;

import commands.nativeCommands.Command;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class ConsoleAwareCommand implements Command {
    private final ConsoleProcessor processor;

}
