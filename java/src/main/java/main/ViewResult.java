package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас для відображення результатів.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class ViewResult implements View {
    private static final String FNAME = "EnergyData.bin";
    private static final int DEFAULT_NUM = 10;
    private List<Item2d> items;

    /**
     * Конструктор за замовчуванням.
     */
    public ViewResult() {
        this(DEFAULT_NUM);
    }

    /**
     * Конструктор з параметром.
     * @param n Кількість об'єктів {@linkplain Item2d}.
     */
    public ViewResult(int n) {
        items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            items.add(new Item2d());
        }
    }

    /**
     * Повертає список об'єктів {@linkplain Item2d}.
     * @return Список об'єктів {@linkplain Item2d}.
     */
    public List<Item2d> getItems() {
        return items;
    }

    /**
     * Обчислює енергію об'єкта.
     * @param mass Маса об'єкта.
     * @param velocity Швидкість об'єкта.
     * @param height Висота об'єкта.
     * @return Енергія об'єкта.
     */
    private double calculateEnergy(double mass, double velocity, double height) {
        final double g = 9.81;
        return (mass * velocity * velocity) / 2 + (mass * g * height);
    }

    /**
     * Ініціалізує об'єкти {@linkplain Item2d} заданими значеннями.
     * @param mass Маса об'єкта.
     * @param velocity Швидкість об'єкта.
     * @param height Висота об'єкта.
     */
    public void init(double mass, double velocity, double height) {
        for (Item2d item : items) {
            item.setValues(mass, velocity, height, calculateEnergy(mass, velocity, height));
        }
    }

    /**
     * Ініціалізує об'єкти {@linkplain Item2d} випадковими значеннями.
     */
    @Override
    public void viewInit() {
        double mass = Math.round(Math.random() * 1000) / 10.0;
        double velocity = Math.round(Math.random() * 500) / 10.0;
        double height = Math.round(Math.random() * 2000) / 10.0;
        init(mass, velocity, height);
    }

    /**
     * Зберігає об'єкти {@linkplain Item2d} у файл.
     * @throws IOException Виключення вводу-виводу.
     */
    @Override
    public void viewSave() throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME))) {
            os.writeObject(new ArrayList<>(items));
        }
    }

    /**
     * Відновлює об'єкти {@linkplain Item2d} з файлу.
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
     * Відображає заголовок результатів.
     */
    @Override
    public void viewHeader() {
        System.out.println("Результати розрахункiв:");
    }

    /**
    * Відображає тіло результатів.
    */
    @Override
    public void viewBody() {
    // Відображаємо перший об'єкт зі списку
    if (!items.isEmpty()) {
        System.out.println(items.get(0));
    } else {
        System.out.println("Немає даних для вiдображення.");
    }
}


    /**
     * Відображає підвал результатів.
     */
    @Override
    public void viewFooter() {
        System.out.println("Кiнець.");
    }

    /**
     * Відображає повний результат.
     */
    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}
