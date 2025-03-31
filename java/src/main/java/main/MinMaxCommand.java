package main;

/**
 * Клас, що реалізує команду для обчислення мінімального та максимального значення серед мас.
 * Перевіряє кожен елемент на нульову масу та обчислює мінімальну та максимальну масу.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class MinMaxCommand implements Command {
    /** Об'єкт, що містить дані для обчислень. */
    private final ViewResult view;

    /** Мінімальне значення маси. */
    private double min = Double.MAX_VALUE;

    /** Максимальне значення маси. */
    private double max = Double.MIN_VALUE;

    /**
     * Конструктор класу. Ініціалізує клас {@link ViewResult}.
     * @param view Об'єкт класу {@link ViewResult}, що містить елементи для обробки.
     */
    public MinMaxCommand(ViewResult view) {
        this.view = view;
    }

    /**
     * Виконує обчислення мінімального та максимального значення маси.
     * Пропускає елементи з нульовою масою.
     */
    @Override
    public void execute() {
        // Обчислення мінімуму і максимуму
        for (Item2d item : view.getItems()) {
            if (item.getMass() != 0) { // Перевірка, чи не є маса нульовою
                min = Math.min(min, item.getMass());
                max = Math.max(max, item.getMass());
            } else {
                System.out.println("Попередження: Елемент має нульову масу. Пропускаємо...");
            }
        }

        // Перевірка результатів перед діленням
        if (min == 0 || max == 0) {
            System.out.println("Попередження: Не можна обчислити мінімум або максимум через нульове значення.");
        }
    }

    /**
     * Повертає результат обчислення мінімуму та максимуму.
     * @return Рядок з мінімальним та максимальним значенням маси.
     */
    public String getResult() {
        return "Min: " + min + ", Max: " + max;
    }
}
