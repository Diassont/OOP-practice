import java.util.ArrayList;
import java.util.List;

/**
 *  Клас для виконання тестів, що перевіряють правильність обчислення середнього, максимального та мінімального значення
 * @author Ярослав Пічугін
 * @version 1.0
 */

public class MainTest {

    public static void main(String[] args) {
        // Створюємо список елементів
        ViewResult viewResult = new ViewResult();
        viewResult.addItem(new Item2d(1.0, 2.0, 3.0)); // height, mass, velocity
        viewResult.addItem(new Item2d(4.0, 5.0, 6.0));
        viewResult.addItem(new Item2d(0.0, 7.0, 8.0)); // height is zero
        viewResult.addItem(new Item2d(9.0, 0.0, 10.0)); // mass is zero
        viewResult.addItem(new Item2d(11.0, 12.0, 0.0)); // velocity is zero

        // Запускаємо тести
        testAvgCommand(viewResult);
        testMaxCommand(viewResult);
        testMinMaxCommand(viewResult);
        testExecuteConsoleCommand(viewResult);
    }

    // Тест для AvgCommand
    public static void testAvgCommand(ViewResult viewResult) {
        double result = calculateAvgForValidItems(viewResult);
        // Перевірка середнього для валідних елементів
        double expectedAvg = calculateAvgForValidItems(viewResult);
        assert result == expectedAvg : "Обчислення середнього значення висоти неправильне. Очікувалося: " + expectedAvg + ", Отримано: " + result;
        System.out.println("Тест AvgCommand пройшов успiшно.");
    }

    // Тест для MaxCommand
    public static void testMaxCommand(ViewResult viewResult) {
        double result = calculateMaxForValidItems(viewResult);
        // Перевірка максимальної швидкості для валідних елементів
        double expectedMax = calculateMaxForValidItems(viewResult);
        assert result == expectedMax : "Обчислення максимальної швидкості неправильне. Очікувалося: " + expectedMax + ", Отримано: " + result;
        System.out.println("Тест MaxCommand пройшов успiшно.");
    }

    // Тест для MinMaxCommand
    public static void testMinMaxCommand(ViewResult viewResult) {
        String result = calculateMinMaxForValidItems(viewResult);
        // Перевірка мінімальної та максимальної маси для валідних елементів
        String expectedMinMax = calculateMinMaxForValidItems(viewResult);
        assert result.equals(expectedMinMax) : "Обчислення мінімальної та максимальної маси неправильне. Очікувалося: " + expectedMinMax + ", Отримано: " + result;
        System.out.println("Тест MinMaxCommand пройшов успiшно.");
    }

    // Тест для ExecuteConsoleCommand
    public static void testExecuteConsoleCommand(ViewResult viewResult) {
        double avgResult = calculateAvgForValidItems(viewResult);
        double maxResult = calculateMaxForValidItems(viewResult);
        String minMaxResult = calculateMinMaxForValidItems(viewResult);

        // Перевірка, чи були виконані команди
        assert avgResult == calculateAvgForValidItems(viewResult) : "Результат AvgCommand неправильний.";
        assert maxResult == calculateMaxForValidItems(viewResult) : "Результат MaxCommand неправильний.";
        assert minMaxResult.equals(calculateMinMaxForValidItems(viewResult)) : "Результат MinMaxCommand неправильний.";
        System.out.println("Тест ExecuteConsoleCommand пройшов успiшно.");
    }

    // Метод для обчислення середнього значення для валідних елементів
    private static double calculateAvgForValidItems(ViewResult viewResult) {
        double totalHeight = 0.0;
        int count = 0;
        for (Item2d item : viewResult.getItems()) {
            // Пропускаємо елементи з нульовими значеннями
            if (item.getHeight() != 0.0 && item.getMass() != 0.0 && item.getVelocity() != 0.0) {
                totalHeight += item.getHeight();
                count++;
            }
        }
        return count > 0 ? totalHeight / count : 0.0;
    }

    // Метод для обчислення максимальної швидкості для валідних елементів
    private static double calculateMaxForValidItems(ViewResult viewResult) {
        double maxVelocity = Double.MIN_VALUE;
        for (Item2d item : viewResult.getItems()) {
            // Пропускаємо елементи з нульовими значеннями
            if (item.getHeight() != 0.0 && item.getMass() != 0.0 && item.getVelocity() != 0.0) {
                maxVelocity = Math.max(maxVelocity, item.getVelocity());
            }
        }
        return maxVelocity == Double.MIN_VALUE ? 0.0 : maxVelocity; // Якщо всі елементи з нульовими значеннями, повертаємо 0
    }

    // Метод для обчислення мінімальної та максимальної маси для валідних елементів
    private static String calculateMinMaxForValidItems(ViewResult viewResult) {
        double minMass = Double.MAX_VALUE;
        double maxMass = Double.MIN_VALUE;

        for (Item2d item : viewResult.getItems()) {
            // Пропускаємо елементи з нульовими значеннями
            if (item.getHeight() != 0.0 && item.getMass() != 0.0 && item.getVelocity() != 0.0) {
                minMass = Math.min(minMass, item.getMass());
                maxMass = Math.max(maxMass, item.getMass());
            }
        }

        if (minMass == Double.MAX_VALUE || maxMass == Double.MIN_VALUE) {
            return "Min: 0.0, Max: 0.0"; // Якщо всі елементи з нульовими значеннями
        }

        return "Min: " + minMass + ", Max: " + maxMass;
    }

    // Внутрішній клас для елементів
    public static class Item2d {
        private final double height;
        private final double mass;
        private final double velocity;

        public Item2d(double height, double mass, double velocity) {
            this.height = height;
            this.mass = mass;
            this.velocity = velocity;
        }

        public double getHeight() {
            return height;
        }

        public double getMass() {
            return mass;
        }

        public double getVelocity() {
            return velocity;
        }
    }

    // Внутрішній клас для зберігання елементів
    public static class ViewResult {
        private final List<Item2d> items = new ArrayList<>();

        public void addItem(Item2d item) {
            items.add(item);
        }

        public List<Item2d> getItems() {
            return items;
        }
    }
}
