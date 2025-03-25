package main;

import java.io.Serializable;

/**
 * Клас для збереження параметрів фізичного тіла та обчисленої енергії.
 * Реалізує інтерфейс Serializable для можливості серіалізації.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class Item2d implements Serializable {
    /** Константа серіалізації */
    private static final long serialVersionUID = 1L;
    
    /** Маса тіла (кг) */
    private double mass;
    /** Швидкість (м/с) */
    private double velocity;
    /** Висота (м) */
    private double height;
    /** Обчислена повна енергія (Дж) */
    private double energy;
    
    /** Конструктор за замовчуванням */
    public Item2d() {
        this.mass = 0.0;
        this.velocity = 0.0;
        this.height = 0.0;
        this.energy = 0.0;
    }
    
    /** Конструктор із параметрами */
    public Item2d(double mass, double velocity, double height, double energy) {
        this.mass = mass;
        this.velocity = velocity;
        this.height = height;
        this.energy = energy;
    }
    
    /** Метод для встановлення значень */
    public void setValues(double mass, double velocity, double height, double energy) {
        this.mass = mass;
        this.velocity = velocity;
        this.height = height;
        this.energy = energy;
    }
    
    /** Повертає масу */
    public double getMass() {
        return mass;
    }
    
    /** Повертає швидкість */
    public double getVelocity() {
        return velocity;
    }
    
    /** Повертає висоту */
    public double getHeight() {
        return height;
    }
    
    /** Повертає енергію */
    public double getEnergy() {
        return energy;
    }
    
    /** Перевизначений метод toString для виведення даних */
    @Override
    public String toString() {
        return "Маса: " + mass + " кг, Швидкiсть: " + velocity + " м/с, Висота: " + height + " м, Енергiя: " + energy + " Дж";
    }
}