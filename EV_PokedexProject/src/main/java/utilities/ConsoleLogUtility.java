package utilities;

import models.Pokemon;

public class ConsoleLogUtility {
    public static void logTextToConsole(OutputGeneratorInterface generator, int i, int db) {
        System.out.println(generator.generateText(i, db));
    }
}
