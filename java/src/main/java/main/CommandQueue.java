package main;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Клас для управління чергою команд та виконання їх в окремих потоках.
 * Реалізує інтерфейс {@linkplain Queue}.
 * Забезпечує додавання команд у чергу, їх виконання в окремих потоках, а також завершення роботи черги.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class CommandQueue implements Queue {
    /** Черга для зберігання команд, що мають бути виконані. */
    private final LinkedBlockingQueue<Command> tasks = new LinkedBlockingQueue<>();

    /** Флаг, що вказує на завершення роботи черги. */
    private boolean shutdown = false;

    /**
     * Конструктор класу. Створює нову чергу без запуску додаткових потоків.
     */
    public CommandQueue() {
        // Черга автоматично працює без запуску потоку в конструкторі
    }

    /**
     * Запускає окремі потоки для виконання команд з черги.
     */
    public void start() {
        new Thread(new Worker()).start();
    }

    /**
     * Додає команду в чергу для виконання, якщо черга не закрита.
     * Якщо команда null, виводиться помилка.
     * @param command Команда, яку потрібно додати в чергу.
     */
    @Override
    public void put(Command command) {
        if (command == null) {
            System.err.println("Не можна додати null команду в чергу.");
            return;
        }
        if (!shutdown) {
            tasks.offer(command);
        }
    }

    /**
     * Отримує команду з черги для виконання.
     * Блокує потік до тих пір, поки команда не буде доступна.
     * @return Команда для виконання.
     */
    @Override
    public Command take() {
        try {
            return tasks.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted while taking a command", e);
        }
    }

    /**
     * Завершує роботу черги. Ніякі нові команди не будуть додаватися.
     */
    public void shutdown() {
        shutdown = true;
    }

    /**
     * Клас, що виконує команди з черги в окремому потоці.
     */
    private class Worker implements Runnable {
        @Override
        public void run() {
            while (!shutdown) {
                try {
                    Command command = take();
                    if (command != null) {
                        System.out.println("Виконання команди: " + command);
                        command.execute();
                    } else {
                        System.err.println("Не вдалося отримати команду з черги.");
                    }
                } catch (RuntimeException e) {
                    System.err.println("Помилка в Worker: " + e.getMessage());
                }
            }
        }
    }
}
