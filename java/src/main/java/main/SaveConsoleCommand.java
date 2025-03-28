package main;

import java.io.IOException;

/**
 * Консольна команда для збереження елементів.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class SaveConsoleCommand implements ConsoleCommand {
    /** Об'єкт, що реалізує інтерфейс {@linkplain View}. */
    private final View view;

    /**
     * Ініціалізує об'єкт {@linkplain View}.
     * @param view Об'єкт, що реалізує інтерфейс {@linkplain View}.
     */
    public SaveConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 's';
    }

    @Override
    public String toString() {
        return "'s'ave";
    }

    @Override
    public void execute() {
        System.out.println("Зберегти поточний.");
        try {
            view.viewSave();
        } catch (IOException e) {
            System.err.println("Помилка серiалiзацiї: " + e);
        }
        view.viewShow();
    }
}
