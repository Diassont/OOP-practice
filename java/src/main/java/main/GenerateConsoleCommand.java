package main;

/**
 * Консольна команда для генерації елементів.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class GenerateConsoleCommand implements ConsoleCommand {
    /** Об'єкт, що реалізує інтерфейс {@linkplain View}. */
    private final View view;

    /**
     * Ініціалізує об'єкт {@linkplain View}.
     * @param view Об'єкт, що реалізує інтерфейс {@linkplain View}.
     */
    public GenerateConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'g';
    }

    @Override
    public String toString() {
        return "'g'enerate";
    }

    @Override
    public void execute() {
        System.out.println("Випадкова генерацiя.");
        view.viewInit();
        view.viewShow();
    }
}
