package main;

import java.io.IOException;

/**
 * Інтерфейс для відображення результатів.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public interface View {
    /**
     * Відображає заголовок результатів.
     */
    void viewHeader();

    /**
     * Відображає тіло результатів.
     */
    void viewBody();

    /**
     * Відображає підвал результатів.
     */
    void viewFooter();

    /**
     * Відображає повний результат.
     */
    void viewShow();

    /**
     * Ініціалізує результати.
     */
    void viewInit();

    /**
     * Зберігає результати у файл.
     * @throws IOException Виключення вводу-виводу.
     */
    void viewSave() throws IOException;

    /**
     * Відновлює результати з файлу.
     * @throws Exception Виключення.
     */
    void viewRestore() throws Exception;
}
