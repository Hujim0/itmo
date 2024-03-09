package commands.nativeCommands;

import commands.CommandArgument;

import java.util.ArrayList;
import java.util.List;

public interface OverloadedCommand extends Command{
    CommandArgument[] getArguments();

    @Override
    default String getArgumentsSyntax() {

        List<String> variants = new ArrayList<>();
        variants.add("");

        for (CommandArgument argument : getArguments()) {
            if (argument.isOptional()) {
                int size = variants.size();
                for (int i = 0; i < size; i++) {
                    variants.add(variants.get(i) + argument);
                }

            }
            else {
                for (int i = 0; i < variants.size(); i++) {
                    variants.set(i, variants.get(i) + argument);
                }
            }
        }
        if(variants.remove("")) {
            variants.add("no arguments");
        }

        StringBuilder builder = new StringBuilder(variants.get(0));

        for (int i = 1; i < variants.size(); i++) {
            builder.append(" or ").append(variants.get(i));
        }

        return builder.append(".").toString();
    }
}
