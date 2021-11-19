package utilities;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import views.HtmlGeneratorInterface;

public class FileLogUtility {
    public static void logHtmlToFile(String filePath, HtmlGeneratorInterface htmlGenerator, int i, int db) throws IOException {
        Files.write(Paths.get(filePath), htmlGenerator.generateHtml(i, db).getBytes(StandardCharsets.UTF_8));
    }
}