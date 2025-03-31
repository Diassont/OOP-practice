package main;

/**
 * Інтерфейс для черги завдань.
 * Визначає базову структуру для черги, що приймає та видає команди для виконання.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public interface Queue {
    /**
     * Додає команду до черги.
     * @param cmd Команда, яка додається до черги.
     */
    void put(Command cmd);

    /**
     * Витягує команду з черги.
     * @return Команда, що була витягнута з черги.
     * @throws InterruptedException Якщо потік був перерваний під час очікування на команду.
     */
    Command take() throws InterruptedException;
}
