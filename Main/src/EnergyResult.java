import java.io.Serializable;

/**
 * Клас для збереження результатів обчислення енергії фізичного тіла.
 * Реалізує інтерфейс {@link Serializable} для можливості серіалізації.
 * 
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class EnergyResult implements Serializable {
    
    // Маса тіла (в кг)
    private double mass;

    // Швидкість тіла (в м/с)
    private double velocity;

    // Висота тіла (в метрах)
    private double height;

    // Загальна енергія (в Джоулях)
    private double totalEnergy;

    /**
     * Конструктор для ініціалізації параметрів енергетичного розрахунку.
     *
     * @param mass Маса тіла (кг).
     * @param velocity Швидкість тіла (м/с).
     * @param height Висота (м).
     * @param totalEnergy Загальна енергія (Дж).
     */
    public EnergyResult(double mass, double velocity, double height, double totalEnergy) {
        this.mass = mass;
        this.velocity = velocity;
        this.height = height;
        this.totalEnergy = totalEnergy;
    }

    /**
     * Повертає масу тіла.
     * @return Маса (кг).
     */
    public double getMass() {
        return mass;
    }

    /**
     * Встановлює нове значення маси.
     * @param mass Нова маса (кг).
     */
    public void setMass(double mass) {
        this.mass = mass;
    }

    /**
     * Повертає швидкість тіла.
     * @return Швидкість (м/с).
     */
    public double getVelocity() {
        return velocity;
    }

    /**
     * Встановлює нове значення швидкості.
     * @param velocity Нова швидкість (м/с).
     */
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    /**
     * Повертає висоту тіла.
     * @return Висота (м).
     */
    public double getHeight() {
        return height;
    }

    /**
     * Встановлює нове значення висоти.
     * @param height Нова висота (м).
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Повертає загальну енергію тіла.
     * @return Загальна енергія (Дж).
     */
    public double getTotalEnergy() {
        return totalEnergy;
    }

    /**
     * Встановлює нове значення загальної енергії.
     * @param totalEnergy Нова загальна енергія (Дж).
     */
    public void setTotalEnergy(double totalEnergy) {
        this.totalEnergy = totalEnergy;
    }
}
