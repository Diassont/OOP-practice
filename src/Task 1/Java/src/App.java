import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введiть перше число: ");
            double num1 = scanner.nextDouble();

            System.out.print("Введiть друге число: ");
            double num2 = scanner.nextDouble();

            double sum = num1 + num2;
            double difference = num1 - num2;
            double product = num1 * num2;
            double quotient = num1 / num2;

            System.out.println("Сума: " + sum);
            System.out.println("Рiзниця: " + difference);
            System.out.println("Добуток: " + product);
            System.out.println("Частка: " + quotient);
        }
    }
}
