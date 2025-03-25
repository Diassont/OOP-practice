package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Клас для обчислення повної енергії фізичного тіла.
 * Включає методи для серіалізації та десеріалізації.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class Calc {
    /** Ім'я файлу для збереження результатів */
    private static final String FNAME = "EnergyData.bin";
    
    /** Об'єкт для збереження результатів */
    private Item2d result;
    
    /** Конструктор, ініціалізує result */
    public Calc() {
        result = new Item2d();
    }
    
    /** Встановити значення result */
    public void setResult(Item2d result) {
        this.result = result;
    }
    
    /** Отримати значення result */
    public Item2d getResult() {
        return result;
    }
    
    /** Обчислення повної енергії фізичного тіла
     * @param mass маса (кг)
     * @param velocity швидкість (м/с)
     * @param height висота (м)
     * @return повна енергія (Дж)
     */
    private double calculateEnergy(double mass, double velocity, double height) {
        final double g = 9.81; // Прискорення вільного падіння
        return (mass * velocity * velocity) / 2 + (mass * g * height);
    }
    
    /** Ініціалізує об'єкт значеннями та зберігає результат
     * @param mass маса
     * @param velocity швидкість
     * @param height висота
     */
    public void init(double mass, double velocity, double height) {
        result.setValues(mass, velocity, height, calculateEnergy(mass, velocity, height));
    }
    
    /** Вивести результат */
    public void show() {
        System.out.println(result);
    }
    
    /** Зберегти результат у файл */
    public void save() throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME))) {
            os.writeObject(result);
            os.flush();
        }
    }
    
    /** Відновити результат із файлу */
    public void restore() throws Exception {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME))) {
            result = (Item2d) is.readObject();
        }
    }
}