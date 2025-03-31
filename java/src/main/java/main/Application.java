package main;

/**
 * Клас, що реалізує шаблон Singleton та формує меню програми.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class Application {
    /** Ссилка на єдиний екземпляр класу Application. */
    private static final Application instance = new Application();

    /** Приватний конструктор для запобігання створенню нових екземплярів. */
    private Application() {}

    /**
     * Повертає єдиний екземпляр класу Application.
     * @return Єдиний екземпляр класу Application.
     */
    public static Application getInstance() {
        return instance;
    }

    /** Об'єкт, що реалізує інтерфейс {@linkplain View}. */
    private final View view = new ViewableTable().getView();

    /** Об'єкт класу {@linkplain Menu}, що є макрокомандою. */
    private final Menu menu = new Menu();

    /**
     * Обробка команд користувача.
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.add(new UndoConsoleCommand(view));
        menu.execute();
    }
}
