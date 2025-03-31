package main;

/**
 * Консольна команда для відображення елементів.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class ViewConsoleCommand implements ConsoleCommand {
    /** Об'єкт, що реалізує інтерфейс {@linkplain View}. */
    private final View view;

    /**
     * Ініціалізує об'єкт {@linkplain View}.
     * @param view Об'єкт, що реалізує інтерфейс {@linkplain View}.
     */
    public ViewConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'v';
    }

    @Override
    public String toString() {
        return "'v'iew";
    }

    @Override
    public void execute() {
        System.out.println("Переглянути поточний.");
        view.viewShow();
    }
}
