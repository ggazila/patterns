package behavioral.observer.refactoring.listeners;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}
