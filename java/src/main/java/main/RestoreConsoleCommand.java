package main;

/**
 * Консольна команда для відновлення елементів.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class RestoreConsoleCommand implements ConsoleCommand {
    /** Об'єкт, що реалізує інтерфейс {@linkplain View}. */
    private final View view;

    /**
     * Ініціалізує об'єкт {@linkplain View}.
     * @param view Об'єкт, що реалізує інтерфейс {@linkplain View}.
     */
    public RestoreConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'r';
    }

    @Override
    public String toString() {
        return "'r'estore";
    }

    @Override
    public void execute() {
        System.out.println("Вiдновити останнє збережене.");
        try {
            view.viewRestore();
        } catch (Exception e) {
            System.err.println("Помилка серiалiзацiї: " + e);
        }
        view.viewShow();
    }
}
