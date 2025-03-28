package main;

import java.io.Serializable;

/**
 * Клас, що представляє об'єкт з масою, швидкістю, висотою та енергією.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class Item2d implements Serializable {
    private static final long serialVersionUID = 1L;
    private double mass;
    private double velocity;
    private double height;
    private double energy;

    /**
     * Конструктор за замовчуванням.
     */
    public Item2d() {
        this.mass = 0.0;
        this.velocity = 0.0;
        this.height = 0.0;
        this.energy = 0.0;
    }

    /**
     * Конструктор з параметрами.
     * @param mass Маса об'єкта.
     * @param velocity Швидкість об'єкта.
     * @param height Висота об'єкта.
     * @param energy Енергія об'єкта.
     */
    public Item2d(double mass, double velocity, double height, double energy) {
        this.mass = mass;
        this.velocity = velocity;
        this.height = height;
        this.energy = energy;
    }

    /**
     * Встановлює значення маси, швидкості, висоти та енергії.
     * @param mass Маса об'єкта.
     * @param velocity Швидкість об'єкта.
     * @param height Висота об'єкта.
     * @param energy Енергія об'єкта.
     */
    public void setValues(double mass, double velocity, double height, double energy) {
        this.mass = mass;
        this.velocity = velocity;
        this.height = height;
        this.energy = energy;
    }

    /**
     * Повертає масу об'єкта.
     * @return Маса об'єкта.
     */
    public double getMass() {
        return mass;
    }

    /**
     * Повертає швидкість об'єкта.
     * @return Швидкість об'єкта.
     */
    public double getVelocity() {
        return velocity;
    }

    /**
     * Повертає висоту об'єкта.
     * @return Висота об'єкта.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Повертає енергію об'єкта.
     * @return Енергія об'єкта.
     */
    public double getEnergy() {
        return energy;
    }

    /**
     * Повертає рядок, що представляє об'єкт.
     * @return Рядок з інформацією про об'єкт.
     */
    @Override
    public String toString() {
        return "Маса: " + mass + " кг, Швидкiсть: " + velocity + " м/с, Висота: " + height + " м, Енергiя: " + energy + " Дж";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     * Sets the velocity of the item.
     * @param velocity The new velocity value.
     */
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }
}
