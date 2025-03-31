package main;

/**
 * Клас, що реалізує інтерфейс {@linkplain Viewable}.
 * @author Ярослав Пічугін
 * @version 1.0
 */
public class ViewableResult implements Viewable {
    /**
     * Повертає об'єкт {@linkplain View}.
     * @return Об'єкт {@linkplain View}.
     */
    @Override
    public View getView() {
        return new ViewResult();
    }
}
