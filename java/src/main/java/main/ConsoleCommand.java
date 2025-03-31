package main;

/**
 * Інтерфейс консольної команди.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public interface ConsoleCommand extends Command {
    /**
     * Повертає гарячу клавішу команди.
     * @return Символ гарячої клавіши.
     */
    char getKey();
}
