package main;

/**
 * Консольна команда для зміни елемента.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class ChangeConsoleCommand extends ChangeItemCommand implements ConsoleCommand {
    /** Об'єкт, що реалізує інтерфейс {@linkplain View}. */
    private final View view;
    /** Збережений множник для тестування. */
    private double offset;

    /**
     * Ініціалізує об'єкт {@linkplain View}.
     * @param view Об'єкт, що реалізує інтерфейс {@linkplain View}.
     */
    public ChangeConsoleCommand(View view) {
        this.view = view;
    }

    @Override
    public char getKey() {
        return 'c';
    }

    @Override
    public String toString() {
        return "'c'hange";
    }

    @Override
    public void execute() {
        // Використовуємо випадковий множник для тесту
        offset = Math.random() * 100.0;
        System.out.println("Елемент змiни: масштабний множник" + String.format("%.2f", offset));
        for (Item2d item : ((ViewResult) view).getItems()) {
            // Змінюємо висоту, масу, швидкість та енергію
            item.setHeight(Math.round(item.getHeight() * offset * 100.0) / 100.0);
            item.setMass(Math.round(item.getMass() * offset * 100.0) / 100.0);
            item.setVelocity(Math.round(item.getVelocity() * offset * 100.0) / 100.0);
            item.setEnergy(Math.round((item.getMass() * item.getVelocity() * item.getVelocity() / 2 + item.getMass() * 9.81 * item.getHeight()) * 100.0) / 100.0);
        }
        view.viewShow();
    }

    /**
     * Повертає збережений множник.
     * @return Збережений множник.
     */
    @Override
    public double getOffset() {
        return offset;
    }
}
