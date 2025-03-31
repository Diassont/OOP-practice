import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Клас моделі таблиці для відображення результатів обчислення енергії.
 * Наслідується від {@link AbstractTableModel} для інтеграції з {@link javax.swing.JTable}.
 * 
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class EnergyTableModel extends AbstractTableModel {
    
    // Список результатів обчислення енергії
    private final List<EnergyResult> results;

    // Назви колонок у таблиці
    private final String[] columnNames = {"Маса (кг)", "Швидкість (м/с)", "Висота (м)", "Повна енергія (Дж)"};

    /**
     * Конструктор створює порожню таблицю результатів.
     */
    public EnergyTableModel() {
        this.results = new ArrayList<>();
    }

    /**
     * Додає новий результат у таблицю та оновлює відображення.
     *
     * @param result Об'єкт {@link EnergyResult}, який буде додано до таблиці.
     */
    public void addResult(EnergyResult result) {
        results.add(result);
        fireTableRowsInserted(results.size() - 1, results.size() - 1);
    }

    /**
     * Повертає кількість рядків у таблиці.
     *
     * @return Кількість збережених результатів.
     */
    @Override
    public int getRowCount() {
        return results.size();
    }

    /**
     * Повертає кількість колонок у таблиці.
     *
     * @return Кількість колонок (4: маса, швидкість, висота, повна енергія).
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Повертає значення конкретної комірки таблиці.
     *
     * @param rowIndex Індекс рядка.
     * @param columnIndex Індекс колонки.
     * @return Значення відповідної комірки.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EnergyResult result = results.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> result.getMass();
            case 1 -> result.getVelocity();
            case 2 -> result.getHeight();
            case 3 -> result.getTotalEnergy();
            default -> null;
        };
    }

    /**
     * Повертає назву колонки за її індексом.
     *
     * @param column Індекс колонки.
     * @return Назва відповідної колонки.
     */
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * Повертає список усіх результатів.
     *
     * @return Список об'єктів {@link EnergyResult}.
     */
    public List<EnergyResult> getResults() {
        return results;
    }

    /**
     * Видаляє останній результат з таблиці, якщо список не порожній.
     */
    public void removeResult() {
        if (!results.isEmpty()) {
            results.remove(results.size() - 1);
            fireTableDataChanged();
        }
    }

    /**
     * Оновлює список результатів та оновлює відображення таблиці.
     *
     * @param newResults Новий список результатів.
     */
    public void setResults(List<EnergyResult> newResults) {
        results.clear();
        results.addAll(newResults);
        fireTableDataChanged();
    }

    /**
     * Оновлює останній запис у таблиці новими значеннями.
     *
     * @param mass Нова маса (кг).
     * @param velocity Нова швидкість (м/с).
     * @param height Нова висота (м).
     * @param totalEnergy Нова загальна енергія (Дж).
     */
    public void updateLastResult(double mass, double velocity, double height, double totalEnergy) {
        if (!results.isEmpty()) {
            EnergyResult lastResult = results.get(results.size() - 1);
            lastResult.setMass(mass);
            lastResult.setVelocity(velocity);
            lastResult.setHeight(height);
            lastResult.setTotalEnergy(totalEnergy);
            fireTableDataChanged();
        }
    }
}
