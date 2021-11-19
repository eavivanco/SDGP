package utilities;

abstract public class LoggerDecorator implements Logger {
    private Logger decoratedLoggerReference;

    public LoggerDecorator(Logger decoratedLoggerReference) {
        this.decoratedLoggerReference = decoratedLoggerReference;
    }

    @Override
    public void log(String msg) {
        this.decoratedLoggerReference.log(msg);
    }
}
