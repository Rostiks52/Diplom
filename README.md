# Дипломный проект профессии «Тестировщик»

Проект автоматизации тестирования веб-приложения. Описание <a href= https://github.com/netology-code/qa-diploma>задания</a>.

<a href= https://github.com/Rostiks52/Diplom/blob/master/Artifacts/Plan.md>План</a> автоматизации тестирования.

<a href= https://github.com/Rostiks52/Diplom/blob/master/Artifacts/Report.md>Отчет</a> о проведенном тестировании.

<a href= https://github.com/Rostiks52/Diplom/blob/master/Artifacts/Summary.md>Отчет</a> об автоматизации.

## Начало работы

Проект необходимо склонировать на ПК, используя комманду 
    
    git clone

### Предусловия

Для запуска проекта на ПК должны быть установлены: Java 11, Intellej IDEA Ultimate, Docker.

### Установка и запуск

Открыть проект в IntelliJ IDEA Ultimate.

Запустить Docker на ПК.

В терминале IDEA выполнить команду 

    docker-compose up

В другой вкладке терминала выполнить команду  для запуска приложения на СУБД MySQL:

    java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar aqa-shop.jar

В другой вкладке теринала выполнить команду для запуска тестов:
  
    .\gradlew test "-Ddb.url=jdbc:mysql://localhost:3306/app"

После выполнения тестов для просмотра отчетов в другой вкладке терминала выполнить команды:

    .\gradlew allureReport

и затем

    .\gradlew allureServe 

Завершить работу плагина Ctrl+C.

Для запуска приложения на СУБД PostgreSQL:

    java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar aqa-shop.jar

Тесты запускаются командой в другой вкладке терминала:

    .\gradlew test "-Ddb.url=jdbc:postgresql://localhost:5432/app"


