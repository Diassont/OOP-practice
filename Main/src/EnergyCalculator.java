/**
 * Клас для обчислення загальної енергії фізичного тіла.
 * Включає метод для обчислення кінетичної та потенціальної енергії.
 * 
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class EnergyCalculator {

    /**
     * Обчислює загальну енергію фізичного тіла, що включає кінетичну та потенціальну енергію.
     * 
     * @param mass Маса тіла (в кг).
     * @param velocity Швидкість тіла (в м/с).
     * @param height Висота тіла (в метрах).
     * @return Загальна енергія (в Джоулях), що є сумою кінетичної та потенціальної енергії.
     */
    public static double calculateTotalEnergy(double mass, double velocity, double height) {
        // Обчислення кінетичної енергії: E_kin = 0.5 * m * v^2
        double kineticEnergy = 0.5 * mass * Math.pow(velocity, 2);
        
        // Обчислення потенціальної енергії: E_pot = m * g * h
        double potentialEnergy = mass * 9.81 * height;
        
        // Повертаємо суму кінетичної та потенціальної енергії
        return kineticEnergy + potentialEnergy;
    }
}
