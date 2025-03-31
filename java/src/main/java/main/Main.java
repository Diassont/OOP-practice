package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Головний клас програми, який запускає додаток.
 * @author Ярослав Пічугін
 * @version 6.0
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
    public void menu() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        
        do {
            // Виводимо меню
            displayMenu();
            
            try {
                // Читаємо введену команду
                s = in.readLine();
                if (s.isEmpty()) continue; // Пропускаємо порожній ввід
            } catch (IOException e) {
                // Якщо сталася помилка при введенні, виводимо повідомлення
                System.out.println("Помилка вводу: " + e.getMessage());
                return;
            }
    
            // Перевірка на команду 'q' для виходу з циклу
            if (s.charAt(0) == 'q') {
                System.out.println("\nВихiд з програми...");
                break; // Виходимо з циклу
            }
    
            // Обробляємо інші команди
            handleCommand(s.charAt(0));
    
        } while (true); // Цикл триває, поки не буде виконано break на 'q'
    }
    
    
    private void displayMenu() {
        System.out.println("\n╔═════════════════════════════════════╗");
        System.out.println("║         МЕНЮ ПРОГРАМИ               ║");
        System.out.println("╠═════════════════════════════════════╣");
        System.out.println("║ 'q' - Вихiд                         ║");
        System.out.println("║ 'v' - Перегляд результату           ║");
        System.out.println("║ 'g' - Генерацiя параметрiв          ║");
        System.out.println("║ 's' - Збереження результату         ║");
        System.out.println("║ 'r' - Вiдновлення результату        ║");
        System.out.println("║ 't' - Вiдображення таблицею         ║");
        System.out.println("║ 'u' - Скасування останньої операцiї ║");
        System.out.println("║ 'e' - Виконання всiх потiкiв        ║");
        System.out.println("║ 'c' - Змiнити елементи              ║"); 
        System.out.println("╚═════════════════════════════════════╝");
        System.out.print("Оберiть команду: ");
    }
    
    private void handleCommand(char command) {
        switch (command) {
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
            case 't' -> {
                System.out.println("\nВiдображення таблицею:");
                if (view instanceof ViewTable viewTable) {
                    viewTable.setWidth(20);
                    viewTable.viewShow();
                } else {
                    System.out.println("Поточний вид не пiдтримує табличне вiдображення.");
                }
            }
            case 'u' -> {
                System.out.println("\nСкасування останньої операцiї...");
                if (view instanceof ViewResult viewResult) {
                    viewResult.undo();
                    view.viewShow();
                } else {
                    System.out.println("Скасування неможливе для поточного виду.");
                }
            }
            case 'e' -> {
                System.out.println("\nВиконання всiх потiкiв...");
                ExecuteConsoleCommand executeCommand = new ExecuteConsoleCommand(view);
                executeCommand.execute();
            }
            case 'c' -> { 
                System.out.println("\nЗмiнити елементи...");
                ChangeConsoleCommand changeCommand = new ChangeConsoleCommand(view);
                changeCommand.execute();
            }
            default -> System.out.println("Невiдома команда. Спробуйте ще раз.");
        }
    }

    /**
     * Головна функція програми.
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }
}
