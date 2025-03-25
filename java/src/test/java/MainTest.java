import main.Calc;
import main.Item2d;
/**
 * Клас для тестування основної функціональності програми.
 * Використовує простий підхід без тестових фреймворків.
 */
public class MainTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТУВАННЯ КЛАСУ Calc ===");
        
        // Створюємо об'єкт калькулятора
        Calc calc = new Calc();

        // Тест 1: Ініціалізація та розрахунок енергії
        double mass = 10.0;  // кг
        double velocity = 5.0; // м/с
        double height = 2.0; // м
        
        calc.init(mass, velocity, height);
        System.out.println("Очiкуваний результат:");
        System.out.println("Маса: 10.0 кг, Швидкiсть: 5.0 м/с, Висота: 2.0 м");
        System.out.println("Результат обчислення: ");
        calc.show();

        // Тест 2: Збереження та відновлення
        try {
            calc.save();
            System.out.println("\nТест збереження: Успiшно");
            
            calc.restore();
            System.out.println("Тест вiдновлення: Успiшно");
            calc.show();
        } catch (Exception e) {
            System.out.println("Помилка пiд час збереження/вiдновлення: " + e.getMessage());
        }

        System.out.println("\n=== ТЕСТУВАННЯ КЛАСУ Item2d ===");

        // Тест 3: Робота з об'єктом Item2d
        Item2d item = new Item2d(15.0, 3.0, 5.0, 0.0);
        System.out.println("До обчислення:");
        System.out.println(item);
        
        // Виконуємо обчислення
        item.setValues(15.0, 3.0, 5.0, (15.0 * 3.0 * 3.0) / 2 + (15.0 * 9.81 * 5.0));
        System.out.println("Пiсля обчислення:");
        System.out.println(item);
    }
}