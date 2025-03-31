package main;

/**
 * Клас, що реалізує команду для обчислення максимального значення серед швидкостей.
 * Перевіряє кожен елемент на нульову швидкість та обчислює максимальну швидкість.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class MaxCommand implements Command {
    /** Об'єкт, що містить дані для обчислень. */
    private final ViewResult view;

    /** Максимальне значення швидкості. */
    private double max = Double.MIN_VALUE;

    /**
     * Конструктор класу. Ініціалізує клас {@link ViewResult}.
     * @param view Об'єкт класу {@link ViewResult}, що містить елементи для обробки.
     */
    public MaxCommand(ViewResult view) {
        this.view = view;
    }

    /**
     * Виконує обчислення максимального значення серед швидкостей.
     * Пропускає елементи з нульовою швидкістю.
     */
    @Override
    public void execute() {
        for (Item2d item : view.getItems()) {
            if (item.getVelocity() != 0) { // Перевірка на нульову швидкість
                max = Math.max(max, item.getVelocity());
            } else {
                System.out.println("Попередження: Елемент має нульову швидкість. Пропускаємо...");
            }
        }
    }

    /**
     * Повертає максимальне значення швидкості.
     * @return Максимальна швидкість.
     */
    public double getResult() {
        return max;
    }
}
