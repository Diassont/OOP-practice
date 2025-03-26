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
    /** Об'єкт класу {@linkplain View} для відображення результатів. */
    private final View view;

    /**
     * Конструктор головного класу.
     * @param view Об'єкт класу {@linkplain View} для відображення результатів.
     */
    public Main(View view) {
        this.view = view;
    }

    /**
     * Меню програми.
     */
    protected void menu() {
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
                    view.viewShow();
                }
                case 'g' -> {
                    System.out.println("\nГенерацiя випадкових параметрiв...");
                    view.viewInit();
                    view.viewShow();
                }
                case 's' -> {
                    System.out.println("\nЗбереження результату...");
                    try {
                        view.viewSave();
                        System.out.println("Данi успiшно збережено!");
                    } catch (IOException e) {
                        System.out.println("Помилка збереження: " + e.getMessage());
                    }
                    view.viewShow();
                }
                case 'r' -> {
                    System.out.println("\nВiдновлення останнього збереженого результату...");
                    try {
                        view.viewRestore();
                        System.out.println("Данi успiшно вiдновлено!");
                    } catch (Exception e) {
                        System.out.println("Помилка десерiалiзацiї: " + e.getMessage());
                    }
                    view.viewShow();
                }
                default -> System.out.println("Невiдома команда. Спробуйте ще раз.");
            }
        } while (true);
    }

    /**
     * Головна функція програми.
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        Main main = new Main(new ViewableResult().getView());
        main.menu();
    }
}
