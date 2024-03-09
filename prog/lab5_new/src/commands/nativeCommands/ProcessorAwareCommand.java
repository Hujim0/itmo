package commands.nativeCommands;

import commands.CommandProcessor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class ProcessorAwareCommand implements Command {
    private final CommandProcessor processor;
}
