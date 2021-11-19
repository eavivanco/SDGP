package views;

import utilities.FileLogger;

public class FileHTMLLogger extends FileLogger {

    @Override
    public void log(String msg) {
        String htmlString = "<p>" + msg + "</p>";
        super.log(htmlString);
    }
}
