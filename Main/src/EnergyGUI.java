import java.awt.BorderLayout;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

/**
 * Графічний інтерфейс для калькулятора енергії.
 * Дозволяє користувачеві переглядати, генерувати, зберігати,
 * відновлювати, змінювати та видаляти результати обчислень.
 *
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class EnergyGUI extends JFrame {
    private final EnergyTableModel tableModel;
    private final JTable resultTable;
    private final Random random = new Random();
    private final DecimalFormat df = new DecimalFormat("#.##");
    private final String SAVE_FILE = "energy_results.dat";

    /**
     * Конструктор створює вікно та додає основні елементи керування.
     */
    public EnergyGUI() {
        setTitle("Енергетичний калькулятор");
        setSize(1150, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tableModel = new EnergyTableModel();
        resultTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(resultTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        JButton viewButton = new JButton("Переглянути результат");
        JButton generateButton = new JButton("Згенерувати параметри");
        JButton saveButton = new JButton("Зберегти результат(и)");
        JButton restoreButton = new JButton("Відновити результат");
        JButton undoButton = new JButton("Скасувати останню дію");
        JButton changeButton = new JButton("Змінити елементи");
        JButton quitButton = new JButton("Вийти");

        buttonPanel.add(viewButton);
        buttonPanel.add(generateButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(restoreButton);
        buttonPanel.add(undoButton);
        buttonPanel.add(changeButton);
        buttonPanel.add(quitButton);

        quitButton.addActionListener(e -> System.exit(0));
        viewButton.addActionListener(e -> viewResult());
        generateButton.addActionListener(e -> generateParameters());
        saveButton.addActionListener(e -> saveResult());
        restoreButton.addActionListener(e -> restoreResult());
        undoButton.addActionListener(e -> undoLastOperation());
        changeButton.addActionListener(e -> changeElements());

        setVisible(true);
    }

    /**
     * Відображає останній результат у вигляді повідомлення.
     */
    private void viewResult() {
        if (!tableModel.getResults().isEmpty()) {
            EnergyResult lastResult = tableModel.getResults().get(tableModel.getResults().size() - 1);
            JOptionPane.showMessageDialog(this,
                "Маса: " + df.format(lastResult.getMass()) + "\n" +
                "Швидкість: " + df.format(lastResult.getVelocity()) + "\n" +
                "Висота: " + df.format(lastResult.getHeight()) + "\n" +
                "Повна енергія: " + df.format(lastResult.getTotalEnergy()),
                "Останній результат", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Немає доступних результатів.", "Перегляд результату", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Генерує випадкові параметри для обчислення енергії та додає їх у таблицю.
     */
    private void generateParameters() {
        double mass = random.nextDouble() * 100;
        double velocity = random.nextDouble() * 50;
        double height = random.nextDouble() * 10;
        double totalEnergy = EnergyCalculator.calculateTotalEnergy(mass, velocity, height);
        EnergyResult result = new EnergyResult(mass, velocity, height, totalEnergy);
        tableModel.addResult(result);
    }

    /**
     * Зберігає результати обчислень у файл.
     */
    private void saveResult() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            out.writeObject(new ArrayList<>(tableModel.getResults()));
            JOptionPane.showMessageDialog(this, "Результати успішно збережено.", "Збереження", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Помилка при збереженні результатів.", "Помилка збереження", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Відновлює результати обчислень з файлу.
     */
    private void restoreResult() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
            @SuppressWarnings("unchecked")
            List<EnergyResult> savedResults = (List<EnergyResult>) in.readObject();
            tableModel.setResults(savedResults);
            JOptionPane.showMessageDialog(this, "Результати успішно відновлено.", "Відновлення", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Помилка при відновленні результатів.", "Помилка відновлення", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Видаляє останній результат із таблиці.
     */
    private void undoLastOperation() {
        tableModel.removeResult();
    }

    /**
     * Дозволяє змінити останній запис у таблиці.
     */
    private void changeElements() {
        if (!tableModel.getResults().isEmpty()) {
            EnergyResult lastResult = tableModel.getResults().get(tableModel.getResults().size() - 1);
            double newMass = Double.parseDouble(JOptionPane.showInputDialog("Введіть нову масу:", df.format(lastResult.getMass())));
            double newVelocity = Double.parseDouble(JOptionPane.showInputDialog("Введіть нову швидкість:", df.format(lastResult.getVelocity())));
            double newHeight = Double.parseDouble(JOptionPane.showInputDialog("Введіть нову висоту:", df.format(lastResult.getHeight())));
            double newTotalEnergy = EnergyCalculator.calculateTotalEnergy(newMass, newVelocity, newHeight);
            tableModel.updateLastResult(newMass, newVelocity, newHeight, newTotalEnergy);
        } else {
            JOptionPane.showMessageDialog(this, "Немає результатів для зміни.", "Зміна елементів", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Відображає GUI в консолі (службова функція для тестування).
     */
    public void display() {
        System.out.println("Відображення GUI калькулятора енергії");
    }
}
