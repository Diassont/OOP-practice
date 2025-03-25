package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Головний клас для демонстрації роботи з обчисленням енергії тіла.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class Main {
    /** Об'єкт класу {@linkplain Calc} для обчислень. */
    private final Calc calc = new Calc();
    
    /** Меню програми. */
    private void menu() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;

        do {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║         МЕНЮ ПРОГРАМИ          ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 'q' - Вихiд                    ║");
            System.out.println("║ 'v' - Перегляд результату      ║");
            System.out.println("║ 'g' - Генерацiя параметрiв     ║");
            System.out.println("║ 's' - Збереження результату    ║");
            System.out.println("║ 'r' - Вiдновлення результату   ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Оберiть команду: ");

            try {
                s = in.readLine();
                if (s.isEmpty()) continue; // Пропускаємо порожній ввід
            } catch (IOException e) {
                System.out.println("Помилка вводу: " + e.getMessage());
                return;
            }

            switch (s.charAt(0)) {
                case 'q' -> {
                    System.out.println("\nВихiд з програми...");
                    return;
                }
                case 'v' -> {
                    System.out.println("\nПерегляд результату:");
                    calc.show();
                }
                case 'g' -> {
                    System.out.println("\nГенерацiя випадкових параметрiв...");
                    double mass = Math.round(Math.random() * 1000) / 10.0; 
                    double velocity = Math.round(Math.random() * 500) / 10.0;
                    double height = Math.round(Math.random() * 2000) / 10.0;
                    calc.init(mass, velocity, height);
                    calc.show();
                }
                case 's' -> {
                    System.out.println("\nЗбереження результату...");
                    try {
                        calc.save();
                        System.out.println("Данi успiшно збережено!");
                    } catch (IOException e) {
                        System.out.println("Помилка збереження: " + e.getMessage());
                    }
                    calc.show();
                }
                case 'r' -> {
                    System.out.println("\nВiдновлення останнього збереженого результату...");
                    try {
                        calc.restore();
                        System.out.println("Данi успiшно вiдновлено!");
                    } catch (Exception e) {
                        System.out.println("Помилка десерiалiзацiї: " + e.getMessage());
                    }
                    calc.show();
                }
                default -> System.out.println("Невiдома команда. Спробуйте ще раз.");
            }
        } while (true);
    }
    
    /**
     * Головний метод програми.
     * @param args параметри запуску
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}