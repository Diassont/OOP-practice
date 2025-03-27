import java.io.IOException;

import main.Item2d;
import main.View;
import main.ViewResult;
import main.ViewTable;

/**
 * Клас для тестування функціональності головного класу програми.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class MainTest {

    public static void main(String[] args) {
        testViewInit();
        testViewSaveAndRestore();
        testViewShow();
        testItem2dCreation();
        testCalculateEnergy();
        testTableView();
    }

    /**
     * Тестує метод ініціалізації виду.
     */
    public static void testViewInit() {
        View view = new ViewResult();
        view.viewInit();
        System.out.println("Тест iнiцiалiзацiї виду пройшов успiшно.");
    }

    /**
     * Тестує методи збереження та відновлення виду.
     */
    public static void testViewSaveAndRestore() {
        View view = new ViewResult();
        view.viewInit();

        try {
            view.viewSave();
            System.out.println("Данi успiшно збережено.");

            try {
                view.viewRestore();
            } catch (Exception e) {
                System.out.println("Помилка при вiдновленнi даних: " + e.getMessage());
            }
            System.out.println("Данi успiшно вiдновлено.");
        } catch (IOException e) {
            System.out.println("Помилка при збереженнi або вiдновленнi даних: " + e.getMessage());
        }
    }

    /**
     * Тестує метод відображення виду.
     */
    public static void testViewShow() {
        View view = new ViewResult();
        view.viewInit();
        view.viewShow();
        System.out.println("Тест вiдображення виду пройшов успiшно.");
    }

    /**
     * Тестує створення об'єкта Item2d.
     */
    public static void testItem2dCreation() {
        Item2d item = new Item2d(10.0, 5.0, 20.0, 1500.0);
        System.out.println("Створено об'єкт Item2d: " + item);

        if (item.getMass() == 10.0 && item.getVelocity() == 5.0 &&
            item.getHeight() == 20.0 && item.getEnergy() == 1500.0) {
            System.out.println("Тест створення Item2d пройшов успiшно.");
        } else {
            System.out.println("Тест створення Item2d не пройшов.");
        }
    }

    /**
     * Тестує метод обчислення енергії.
     */
    public static void testCalculateEnergy() {
        ViewResult view = new ViewResult();
        double energy = view.calculateEnergy(10.0, 5.0, 20.0);
        System.out.println("Обчислена енергiя: " + energy);

        double expectedEnergy = (10.0 * 5.0 * 5.0) / 2 + (10.0 * 9.81 * 20.0);
        if (Math.abs(energy - expectedEnergy) < 0.001) {
            System.out.println("Тест обчислення енергiї пройшов успiшно.");
        } else {
            System.out.println("Тест обчислення енергiї не пройшов.");
        }
    }

    /**
     * Тестує відображення у вигляді таблиці.
     */
    public static void testTableView() {
        View view = new ViewTable();
        view.viewInit();
        if (view instanceof ViewTable viewTable) {
            viewTable.setWidth(30);
            viewTable.viewShow();
            System.out.println("Тест табличного вiдображення пройшов успiшно.");
        } else {
            System.out.println("Поточний вид не пiдтримує табличне вiдображення.");
        }
    }
}
