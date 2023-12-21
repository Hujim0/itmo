package engine;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Debug {

    public static Logger LOGGER = Logger.getAnonymousLogger();


    public static void log(Level level, String string) {
        if (LOGGER.getLevel().intValue() <= level.intValue()) {
            System.out.println(string);
        }
    }
}
