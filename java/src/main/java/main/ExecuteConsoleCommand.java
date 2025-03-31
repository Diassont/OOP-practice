package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Клас, що реалізує команду для виконання всіх команд у окремих потоках.
 * Команди виконуються через пул потоків.
 * Забезпечує перевірку значень перед виконанням та коректне завершення роботи.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class ExecuteConsoleCommand implements ConsoleCommand {
    /** Об'єкт, що представляє дані для відображення та обчислень. */
    private final View view;

    /**
     * Конструктор класу. Ініціалізує клас {@link View}.
     * @param view Об'єкт класу {@link View}, що містить дані для обробки.
     */
    public ExecuteConsoleCommand(View view) {
        this.view = view;
    }

    /**
     * Повертає символ для виклику цієї команди у меню.
     * @return Символ команди.
     */
    @Override
    public char getKey() {
        return 'e';
    }

    /**
     * Повертає рядкове представлення цієї команди.
     * @return Опис команди.
     */
    @Override
    public String toString() {
        return "'e'xecute";
    }

    /**
     * Виконує всі команди у різних потоках за допомогою пулу потоків.
     * Перш ніж виконувати, перевіряє коректність вхідних значень.
     */
    @Override
    public void execute() {
        System.out.println("Виконати всi потоки...");

        // Створюємо пул потоків для виконання команд
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        this.maxCommand = new MaxCommand((ViewResult) view);
        this.avgCommand = new AvgCommand((ViewResult) view);
        this.minMaxCommand = new MinMaxCommand((ViewResult) view);

        // Перевірка значень перед виконанням
        if (!validateValues()) {
            System.out.println("Попередження: Вхiднi значення мають нульове значення. Пропускаємо виконання.");
            return;
        }

        // Запускаємо кожну команду у своєму потоці
        executorService.submit(() -> {
            try {
                minMaxCommand.execute();
                System.out.println("MinMax Command Result: " + minMaxCommand.getResult());
            } catch (Exception e) {
                System.err.println("Помилка при виконаннi MinMax: " + e.getMessage());
            }
        });

        executorService.submit(() -> {
            try {
                maxCommand.execute();
                System.out.println("Max Command Result: " + maxCommand.getResult());
            } catch (Exception e) {
                System.err.println("Помилка при виконаннi Max: " + e.getMessage());
            }
        });

        executorService.submit(() -> {
            try {
                avgCommand.execute();
                System.out.println("Avg Command Result: " + avgCommand.getResult());
            } catch (Exception e) {
                System.err.println("Помилка при виконаннi Avg: " + e.getMessage());
            }
        });

        // Закриваємо пул потоків і чекаємо завершення всіх завдань
        try {
            executorService.shutdown();
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            System.err.println("Помилка виконання потокiв: " + e.getMessage());
        }

        System.out.println("Всi команди виконано.");
    }

    /**
     * Перевірка значень елементів на наявність коректних даних.
     * Якщо є нульові значення, команда не виконується.
     * @return true, якщо всі елементи мають коректні значення, false — якщо хоча б один елемент має нульове значення.
     */
    private boolean validateValues() {
        boolean valid = true;
        for (Item2d item : ((ViewResult) view).getItems()) {
            System.out.println("Перевiрка елемента: " + item);
            // Перевіряємо на нульові значення перед виконанням
            if (item.getHeight() == 0 || item.getMass() == 0 || item.getVelocity() == 0) {
                System.out.println("Попередження: Елемент має нульове значення. Пропускаємо...");
                valid = false;
            }
        }
        return valid;
    }
    private AvgCommand avgCommand;
    private MaxCommand maxCommand;
    private MinMaxCommand minMaxCommand;

    public AvgCommand getAvgCommand() {
        return avgCommand;
    }

    public MaxCommand getMaxCommand() {
        return maxCommand;
    }

    public MinMaxCommand getMinMaxCommand() {
        return minMaxCommand;
    }
}
