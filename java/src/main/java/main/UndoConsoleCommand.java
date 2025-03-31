package main;

/**
 * Консольна команда для скасування останньої операції.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class UndoConsoleCommand implements ConsoleCommand {
    /** Об'єкт, що реалізує інтерфейс {@linkplain View}. */
    private final View view;

    /**
     * Ініціалізує об'єкт {@linkplain View}.
     * @param view Об'єкт, що реалізує інтерфейс {@linkplain View}.
     */
    public UndoConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'u';
    }

    @Override
    public String toString() {
        return "'u'ndo";
    }

    @Override
    public void execute() {
        System.out.println("Скасувати останню операцiю.");
        if (view instanceof ViewResult viewResult) {
            viewResult.undo();
            view.viewShow();
        } else {
            System.out.println("Скасування неможливе для поточного виду.");
        }
    }
}
