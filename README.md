# 📊 Завдання 3 - Спадкування

## 📌 Опис завдання:
Як основа для нової лабораторної роботи використовуємо вихідний текст з попередньої лабораторної роботи. Необхідно забезпечити збереження результатів обчислень у колекції з можливістю збереження та відновлення:
>-  Результати обчислень повинні зберігатися в колекції 
>-  Програма повинна підтримувати функціональність для серіалізації та десеріалізації даних, що дозволяє зберігати стан програми в файл і відновлювати його при необхідності

Використання шаблону проектування Factory Method (Virtual Constructor).

Розширення ієрархії через інтерфейси для "фабрикованих" об'єктів.

Реалізація інтерфейсу для "фабрикуючого" методу.

## 📌 Етапи виконання:
1️⃣ Як основа використовувати вихідний текст проекту попередньої лабораторної роботи. Забезпечити розміщення результатів обчислень уколекції з можливістю збереження/відновлення.<br>
2️⃣ Використовуючи шаблон проектування Factory Method (Virtual Constructor), розробити ієрархію, що передбачає розширення рахунок додавання нових відображуваних класів.<br>
3️⃣ Розширити ієрархію інтерфейсом "фабрикованих" об'єктів, що представляє набір методів для відображення результатів обчислень.<br>
4️⃣ Реалізувати ці методи виведення результатів у текстовому виде.<br>
5️⃣ Розробити тареалізувати інтерфейс для "фабрикуючого" методу.

## 📌 Приклад роботи програми:
```
╔════════════════════════════════╗
║         МЕНЮ ПРОГРАМИ          ║
╠════════════════════════════════╣
║ 'q' - Вихiд                    ║
║ 'v' - Перегляд результату      ║
║ 'g' - Генерацiя параметрiв     ║
║ 's' - Збереження результату    ║
║ 'r' - Вiдновлення результату   ║
╚════════════════════════════════╝
Оберiть команду: v

Перегляд результату:
Результати розрахункiв:
Маса: 0.0 кг, Швидкiсть: 0.0 м/с, Висота: 0.0 м, Енергiя: 0.0 Дж
Кiнець.

Оберiть команду: g

Генерацiя випадкових параметрiв...
Результати розрахункiв:
Маса: 13.9 кг, Швидкiсть: 16.4 м/с, Висота: 0.4 м, Енергiя: 1923.8155999999997 Дж
Кiнець.

Оберiть команду: s

Збереження результату...
Данi успiшно збережено!
Результати розрахункiв:
Маса: 13.9 кг, Швидкiсть: 16.4 м/с, Висота: 0.4 м, Енергiя: 1923.8155999999997 Дж
Кiнець.

Оберiть команду: r

Вiдновлення останнього збереженого результату...
Данi успiшно вiдновлено!
Результати розрахункiв:
Маса: 13.9 кг, Швидкiсть: 16.4 м/с, Висота: 0.4 м, Енергiя: 1923.8155999999997 Дж
Кiнець.

Оберiть команду: q

Вихiд з програми...
```

## 🖼️ Результат роботи програми:
![Результат роботи програми](https://github.com/Diassont/OOP-practice/blob/Task-3-26.03.2025/java/src/image/Task3.png?raw=true)
![Результат роботи програми](https://github.com/Diassont/OOP-practice/blob/Task-3-26.03.2025/java/src/image/Task3.1.png?raw=true)

## 🖼️ Тестування програми:
![Результат тестування програми](https://github.com/Diassont/OOP-practice/blob/Task-3-26.03.2025/java/src/image/Test3.png?raw=true)
