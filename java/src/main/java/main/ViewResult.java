package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас для відображення результатів обчислення енергії тіла.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class ViewResult implements View {
    private static final String FNAME = "EnergyData.bin";
    private static final int DEFAULT_NUM = 1;
    private List<Item2d> items;

    /**
     * Конструктор за замовчуванням.
     */
    public ViewResult() {
        this(DEFAULT_NUM);
    }

    /**
     * Конструктор з параметром кількості елементів.
     * @param n Кількість елементів для ініціалізації.
     */
    public ViewResult(int n) {
        items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new Item2d());
        }
    }

    /**
     * Отримати список елементів.
     * @return Список елементів.
     */
    public List<Item2d> getItems() {
        return items;
    }

    /**
     * Обчислення енергії тіла.
     * @param mass Маса тіла.
     * @param velocity Швидкість тіла.
     * @param height Висота тіла.
     * @return Обчислена енергія.
     */
    public double calculateEnergy(double mass, double velocity, double height) {
        final double g = 9.81;
        return (mass * velocity * velocity) / 2 + (mass * g * height);
    }

    /**
     * Ініціалізація елементів з заданими параметрами.
     * @param mass Маса тіла.
     * @param velocity Швидкість тіла.
     * @param height Висота тіла.
     */
    public void init(double mass, double velocity, double height) {
        for (Item2d item : items) {
            item.setValues(mass, velocity, height, calculateEnergy(mass, velocity, height));
        }
    }

    /**
     * Ініціалізація елементів з випадковими параметрами.
     */
    @Override
    public void viewInit() {
        double mass = Math.round(Math.random() * 1000) / 10.0;
        double velocity = Math.round(Math.random() * 500) / 10.0;
        double height = Math.round(Math.random() * 2000) / 10.0;
        init(mass, velocity, height);
    }

    /**
     * Збереження результатів у файл.
     * @throws IOException Виключення вводу-виводу.
     */
    @Override
    public void viewSave() throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME))) {
            os.writeObject(new ArrayList<>(items));
        }
    }

    /**
     * Відновлення результатів з файлу.
     * @throws IOException Виключення вводу-виводу.
     * @throws ClassNotFoundException Виключення, якщо клас не знайдено.
     */
    @Override
    public void viewRestore() throws IOException, ClassNotFoundException {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME))) {
            Object obj = is.readObject();
            if (obj instanceof List<?> rawList) {
                items = new ArrayList<>();
                for (Object o : rawList) {
                    if (o instanceof Item2d item2d) {
                        items.add(item2d);
                    }
                }
            } else {
                throw new ClassCastException("Невiрний формат файлу: очiкувався List<Item2d>");
            }
        }
    }

    /**
     * Відображення заголовка результатів.
     */
    @Override
    public void viewHeader() {
        System.out.println("Результати розрахункiв:");
    }

    /**
     * Відображення тіла результатів.
     */
    @Override
    public void viewBody() {
        if (!items.isEmpty()) {
            System.out.println(items.get(0));
        } else {
            System.out.println("Немає даних для вiдображення.");
        }
    }

    /**
     * Відображення підвалу результатів.
     */
    @Override
    public void viewFooter() {
        System.out.println("Кiнець.");
    }

    /**
     * Відображення повного результату.
     */
    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}
