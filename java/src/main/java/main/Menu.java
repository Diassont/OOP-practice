package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Макрокоманда, що містить колекцію консольних команд.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class Menu implements Command {
    /** Колекція консольних команд. */
    private final List<ConsoleCommand> menu = new ArrayList<>();

    /**
     * Додає нову команду до колекції.
     * @param command Команда, що реалізує {@linkplain ConsoleCommand}.
     * @return Додана команда.
     */
    public ConsoleCommand add(ConsoleCommand command) {
        menu.add(command);
        return command;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Веддiть команду...\n");
        for (ConsoleCommand c : menu) {
            s.append(c).append(", ");
        }
        s.append("'q'uit: ");
        return s.toString();
    }

    @Override
    public void execute() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        menu: while (true) {
            do {
                System.out.print(this);
                try {
                    s = in.readLine();
                } catch (IOException e) {
                    System.err.println("Помилка: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            char key = s.charAt(0);
            if (key == 'q') {
                System.out.println("Вихiд.");
                break;
            }
            for (ConsoleCommand c : menu) {
                if (s.charAt(0) == c.getKey()) {
                    c.execute();
                    continue menu;
                }
            }
            System.out.println("Неправильна команда.");
        }
    }
}
