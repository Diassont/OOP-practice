package main;

/**
 * ConcreteCreator (шаблон проектування Factory Method)
 * Об'єкт, що створює {@linkplain ViewTable}.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class ViewableTable extends ViewableResult {
    /**
     * Створює об'єкт {@linkplain ViewTable}.
     * @return Об'єкт {@linkplain ViewTable}.
     */
    @Override
    public View getView() {
        return new ViewTable();
    }
}
