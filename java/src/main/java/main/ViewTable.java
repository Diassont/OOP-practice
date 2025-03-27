package main;

import java.util.Formatter;

/**
 * Клас для відображення результатів у вигляді таблиці.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class ViewTable extends ViewResult {
    private static final int DEFAULT_WIDTH = 20;
    private int width;

    /**
     * Конструктор за замовчуванням.
     */
    public ViewTable() {
        width = DEFAULT_WIDTH;
    }

    /**
     * Конструктор з параметром ширини.
     * @param width Ширина таблиці.
     */
    public ViewTable(int width) {
        this.width = width;
    }

    /**
     * Конструктор з параметрами ширини та кількості елементів.
     * @param width Ширина таблиці.
     * @param n Кількість елементів.
     */
    public ViewTable(int width, int n) {
        super(n);
        this.width = width;
    }

    /**
     * Встановлення ширини таблиці.
     * @param width Ширина таблиці.
     * @return Встановлена ширина.
     */
    public int setWidth(int width) {
        return this.width = width;
    }

    /**
     * Отримання ширини таблиці.
     * @return Ширина таблиці.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Виведення лінії.
     */
    private void outLine() {
        for (int i = width; i > 0; i--) {
            System.out.print('-');
        }
    }

    /**
     * Виведення лінії з новим рядком.
     */
    private void outLineLn() {
        outLine();
        System.out.println();
    }

    /**
     * Виведення заголовка таблиці.
     */
    private void outHeader() {
        try (Formatter fmt = new Formatter()) {
            fmt.format("%s%d%s%2$d%s", "%", (width - 3) / 2, "s | %", "s\n");
            System.out.printf(fmt.toString(), "Маса", "Енергiя");
        }
    }

    /**
     * Виведення тіла таблиці.
     */
    private void outBody() {
        try (Formatter fmt = new Formatter()) {
            fmt.format("%s%d%s%2$d%s", "%", (width - 3) / 2, ".1f | %", ".3f\n");
            for (Item2d item : getItems()) {
                System.out.printf(fmt.toString(), item.getMass(), item.getEnergy());
            }
        }
    }

    /**
     * Ініціалізація з шириною.
     * @param width Ширина таблиці.
     */
    public final void init(int width) {
        this.width = width;
        viewInit();
    }

    /**
     * Ініціалізація з шириною та кроком.
     * @param width Ширина таблиці.
     * @param stepX Крок.
     */
    public final void init(int width, double stepX) {
        this.width = width;
        init((int) stepX);
    }

    /**
     * Ініціалізація з масою, швидкістю та висотою.
     * @param mass Маса тіла.
     * @param velocity Швидкість тіла.
     * @param height Висота тіла.
     */
    @Override
    public void init(double mass, double velocity, double height) {
        System.out.print("Iнiцiалiзацiя... ");
        super.init(mass, velocity, height);
        System.out.println("Виконано. ");
    }

    /**
     * Відображення заголовка таблиці.
     */
    @Override
    public void viewHeader() {
        outHeader();
        outLineLn();
    }

    /**
     * Відображення тіла таблиці.
     */
    @Override
    public void viewBody() {
        outBody();
    }

    /**
     * Відображення підвалу таблиці.
     */
    @Override
    public void viewFooter() {
        outLineLn();
    }
}
