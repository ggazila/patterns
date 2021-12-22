package behavioral.observer.refactoring.listeners;

import java.io.File;

public class LogOpenListener implements EventListener {
    private final File log;

    public LogOpenListener(File log) {
        this.log = log;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Save to log " + log + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}
