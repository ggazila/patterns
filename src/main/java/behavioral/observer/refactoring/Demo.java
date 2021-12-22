package behavioral.observer.refactoring;

import behavioral.observer.refactoring.editor.Editor;
import behavioral.observer.refactoring.listeners.EmailNotificationListener;
import behavioral.observer.refactoring.listeners.LogOpenListener;

import java.io.File;

public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener(new File("/file.txt")));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
