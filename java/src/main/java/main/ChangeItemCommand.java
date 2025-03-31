package main;

/**
 * Команда для зміни елемента.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class ChangeItemCommand implements Command {
    /** Оброблюваний об'єкт. */
    private Item2d item;
    /** Параметр команди. */
    private double offset;

    /**
     * Встановлює об'єкт для зміни.
     * @param item Об'єкт для зміни.
     * @return Об'єкт для зміни.
     */
    public Item2d setItem(Item2d item) {
        return this.item = item;
    }

    /**
     * Повертає об'єкт для зміни.
     * @return Об'єкт для зміни.
     */
    public Item2d getItem() {
        return item;
    }

    /**
     * Встановлює параметр зміни.
     * @param offset Параметр зміни.
     * @return Параметр зміни.
     */
    public double setOffset(double offset) {
        return this.offset = offset;
    }

    /**
     * Повертає параметр зміни.
     * @return Параметр зміни.
     */
    public double getOffset() {
        return offset;
    }

    @Override
    public void execute() {
        item.setHeight(item.getHeight() * offset);
    }
}
