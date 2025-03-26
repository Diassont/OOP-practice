import java.io.IOException;
import java.util.List;

import main.Item2d;
import main.ViewResult;

/**
 * Клас для тестування функціональності програми.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class MainTest {

    /**
     * Головний метод для запуску тестів.
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        // Створюємо об'єкт ViewResult для тестування
        ViewResult viewResult = new ViewResult();

        // Тестуємо ініціалізацію з випадковими значеннями
        testViewInit(viewResult);

        // Тестуємо збереження та відновлення даних
        testSaveAndRestore(viewResult);

        // Тестуємо відображення результатів
        testViewShow(viewResult);
    }

    /**
     * Тестує ініціалізацію об'єктів {@linkplain Item2d} випадковими значеннями.
     * @param viewResult Об'єкт {@linkplain ViewResult} для тестування.
     */
    private static void testViewInit(ViewResult viewResult) {
        System.out.println("Тестування iнiцiалiзацiї з випадковими значеннями:");
        viewResult.viewInit();
        List<Item2d> items = viewResult.getItems();
        if (!items.isEmpty()) {
            System.out.println(items.get(0));
        } else {
            System.out.println("Немає даних для вiдображення.");
        }
        System.out.println("Тест iнiцiалiзацiї пройдено.\n");
    }

    /**
     * Тестує збереження та відновлення даних об'єктів {@linkplain Item2d}.
     * @param viewResult Об'єкт {@linkplain ViewResult} для тестування.
     */
    private static void testSaveAndRestore(ViewResult viewResult) {
        System.out.println("Тестування збереження та вiдновлення даних:");
        try {
            viewResult.viewSave();
            System.out.println("Данi успiшно збережено.");

            // Створюємо новий об'єкт для відновлення даних
            ViewResult restoredViewResult = new ViewResult();
            restoredViewResult.viewRestore();
            System.out.println("Данi успiшно вiдновлено.");

            List<Item2d> restoredItems = restoredViewResult.getItems();
            if (!restoredItems.isEmpty()) {
                System.out.println(restoredItems.get(0));
            } else {
                System.out.println("Немає даних для вiдображення.");
            }
            System.out.println("Тест збереження та вiдновлення пройдено.\n");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Помилка пiд час збереження/вiдновлення: " + e.getMessage());
        }
    }

    /**
     * Тестує відображення результатів.
     * @param viewResult Об'єкт {@linkplain ViewResult} для тестування.
     */
    private static void testViewShow(ViewResult viewResult) {
        System.out.println("Тестування вiдображення результатiв:");
        viewResult.viewShow();
        System.out.println("Тест вiдображення пройдено.\n");
    }
}
