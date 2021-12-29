## План автоматизации тестирования веб-сервиса "Путешествие дня"

***Автоматизируемые сценарии:***
1. Компонентное тестирование:
    1. Тестирование пользовательского интерфейса приложения на кликабельность кнопок.
    2. Тестирование пользовательского интерфейса приложения на доступность полей для ввода данных.
    3. Тестирование пользовательского интерфейса приложения на соответствие предполагаемым требованиям.
2. Интеграционное тестирование:
    1. Приходит ли ответ от сервисов со статусом карт (одобренной и отклоненной).
    2. Работа приложния на разных базах данных (MySQL, PostgreSQL).

**Данные для тестирования:**
1. Валидные:
* номер карты: 4444 4444 4444 4441 (со статусом APPROVED), 4444 4444 4444 4442 (со статусом DECLINED);
* месяц: от 01 до 12 (но не менее текущего, если год карты текущий);
* год - от 21 до 26;
* владелец - 2 слова латинскими буквами.
* CVC/CVV - 3 цифры.
2. Невалидные:
* номер карты: пустое поле, от 0 до 15 цифр, буквы, символы;
* месяц: пустая строка, 00, 13, буквы, символы;
* год: пустая строка, 20, 27;
* владелец: пустая строка, символы, цифры.

Позитивные сценарии:
1. Отправить заявку на вкладке "Купить" с заполненными полями "Номер карты" со статусом "APPROVED", "Месяц", "Год", "Владелец", "CVC/CVV" валидными данными.
   Ожидаемый результат: текст на кнопке меняется на "Отправляем запрос в банк", запрос успешно отправляется, появляется всплывающее сообщение "Операция одобрена банком.", формируются записи об операции в базе данных со статусом "APPROVED".
2. Отправить заявку на вкладке "Купить в кредит" с заполненными полями "Номер карты" со статусом "DECLINED", "Месяц", "Год", "Владелец", "CVC/CVV" валидными данными.
   Ожидаемый результат: запрос успешно отправляется, появляется всплывающее сообщение "Ошибка! Банк отказал в проведении операции.", формируются записи об операции в базе данных со статусом "DECLINED".

Негативные сценарии:
1. Отправить заявки по очереди с пустыми полями "Номер карты", "Месяц", "Год", "Владелец", "CVC/CVV" при валидных данных в остальных полях.
   Ожидаемый результат: сообщения об ошибках "Неверный формат" под полями "Номер карты", "Месяц", "Год", "CVC/CVV" и "Поле обязательно для заполнения" под полем "Владелец", текст на кнопке не меняется, в базе данных записи не формируются.

2. Отправить заявку с невалидными данными поля "Номер карты", остальные поля заполнить валидными данными.
   Ожидаемый результат: сообщение об ошибке "Неверный формат" под полем "Номер карты". В базе данных записи не формируются.

3. Отправить заявку с невалидными данными поля "Месяц", остальные поля заполнить валидными данными.
   Ожидаемый результат: сообщение об ошибке "Неверно указан срок действия карты" под полем "Месяц". В базе данных записи не формируются.

4. Отправить заявку с невалидными данными поля "Год", остальные поля заполнить валидными данными.
   Ожидаемый результат: сообщение об ошибке "Неверно указан срок действия карты" под полем "Год". В базе данных записи не формируются.


***Перечень используемых инструментов***
* Java 11 - широко используемый язык для написания автотестов, стабильная сборка, множество готовых инструментов для написания автотестов.
* IntelliJ IDEA -  самая популярная среда разработки в мире Java.
* Docker - удобный инструмент для запуска приложения в контейнере.
* JUnit 5  фреймворк для модульного тестирования программного обеспечения на языке Java.
* Gradle - система автоматической сборки и управления зависимостями, наиболее удобная для автоматизации тестирования.
* JavaFaker - это библиотека, которую можно использовать для создания широкого спектра реальных данных.
* REST- assured - Java-библиотека для тестирования REST API.
* Selenide - фреймворк для работы с веб-интерфейсом.
* GitHub - репозиторий для хранения программного кода.
* Allure - плагин для создания информативных отчетов о результатах тестирования.

***Перечень и описание возможных рисков при автоматизации***
1. Отсутствие четкого технического задния и документации к приложению, отсюда не понятно, какое окружение настроить для развертывания приложения и какой результат поведения системы является ожидаемым.
2. Выбор СУБД методом "проб и ошибок".
3. Отсутствие уникальных CSS-селекторов полей ввода данных.

***Интервальная оценка с учётом рисков (в часах)***
1. Изучение имеющегося ТЗ - 1.
2. Написание плана тестирования -  2.
3. Подготовка окружения и запуск приложения- 4.
3. Написание автотестов - 20.
4. Запуск автотестов - 2.
5. Оформление отчета - 3.
6. Составление баг-репортов - 4.
7. Составление отчета о тестировании - 3.

***План сдачи работ***
1. Авто-тесты - 6 декабря.
2. Отчет о тестировании - 13 декабря.
3. Отчет по автоматизации - 20 декабря.


