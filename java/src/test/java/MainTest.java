import main.ChangeConsoleCommand;
import main.ChangeItemCommand;
import main.Item2d;
import main.View;
import main.ViewResult;
/**
 * Клас для тестування функціональності команд.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class MainTest {
    public static void main(String[] args) {
        testExecute();
        testChangeConsoleCommand();
    }

    /**
     * Тестує метод execute() класу ChangeItemCommand.
     */
    public static void testExecute() {
        Item2d item = new Item2d(10, 20, 30, 0);
        ChangeItemCommand command = new ChangeItemCommand();
        command.setItem(item);
        command.setOffset(2.0);
        command.execute();

        // Перевірка, чи висота змінилася на 60.0
        if (Math.abs(item.getHeight() - 60.0) < 0.01) {
            System.out.println("testExecute пройдено.");
        } else {
            System.out.println("testExecute не пройдено: висота має бути 60.0, але була " + item.getHeight());
        }
    }

    /**
     * Тестує функціональність класу ChangeConsoleCommand.
     */
    public static void testChangeConsoleCommand() {
        View view = new ViewResult();
        ChangeConsoleCommand command = new ChangeConsoleCommand(view);

        // Встановлюємо початкові значення для тесту
        double initialMass = 10.0;
        double initialVelocity = 20.0;
        double initialHeight = 30.0;
        for (Item2d item : ((ViewResult) view).getItems()) {
            item.setValues(initialMass, initialVelocity, initialHeight, 0);
        }

        // Виконуємо команду
        command.execute();

        // Отримуємо збережений множник
        double offset = command.getOffset();

        // Перевірка, чи всі параметри змінилися правильно
        boolean allChanged = true;
        for (Item2d item : ((ViewResult) view).getItems()) {
            if (Math.abs(item.getHeight() - initialHeight * offset) > 0.01 ||
                Math.abs(item.getMass() - initialMass * offset) > 0.01 ||
                Math.abs(item.getVelocity() - initialVelocity * offset) > 0.01) {
                allChanged = false;
                break;
            }
        }

        if (allChanged) {
            System.out.println("testChangeConsoleCommand пройдено.");
        } else {
            System.out.println("testChangeConsoleCommand не пройдено: не всi параметри були змiненi правильно.");
        }
    }
}
