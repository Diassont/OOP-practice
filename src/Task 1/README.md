# Завдання 1 - арифметичні операції

Ця програма запитує користувача ввести два числа та виконує над ними основні арифметичні операції: суму, різницю, добуток та частку.

## Код програми

```java
import java.util.Scanner;

/**
 * Клас App виконує арифметичні операції над двома введеними числами.
 * Користувач вводить два числа, і програма виводить їхню суму, різницю, добуток і частку.
 */
public class App {

    /**
     * Головний метод програми.
     * Запитує у користувача два числа та виконує над ними арифметичні операції.
     * 
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        // Створюємо об'єкт Scanner для зчитування вводу користувача
        try (Scanner scanner = new Scanner(System.in)) {
            // Запитуємо перше число
            System.out.print("Введiть перше число: ");
            double num1 = scanner.nextDouble();

            // Запитуємо друге число
            System.out.print("Введiть друге число: ");
            double num2 = scanner.nextDouble();

            // Виконуємо арифметичні операції
            double sum = num1 + num2;            // Сума
            double difference = num1 - num2;     // Різниця
            double product = num1 * num2;        // Добуток
            double quotient = num1 / num2;       // Частка

            // Виводимо результати
            System.out.println("Сума: " + sum);
            System.out.println("Рiзниця: " + difference);
            System.out.println("Добуток: " + product);
            System.out.println("Частка: " + quotient);
        }
    }
}

```
## Результат роботи програми
![Результат роботи програми](https://github.com/Diassont/OOP-practice/blob/main/src/Task%200/image/task0.png?raw=true)
