Для запуска проекта на ПК должны быть установлены: Java 11, Intellej IDEA Ultimate, Docker.

Выполнить команду git clone данного репозитория.

Открыть проект в IntelliJ IDEA Ultimate.

Запустить Docker на ПК.

В терминале IDEA выполнить команду docker-compose up.

В другой вкладке терминала выполнить команду  для запуска приложения на СУБД MySQL java -jar aqa-shop.jar -P:jdbc.url=jdbc:mysql://localhost:3306/app -P:jdbc.user=app -P:jdbc.password=pass

В другой вкладке теринала выполнить команду для запуска тестов  .\gradlew test -Ddatabase.url=jdbc:mysql://localhost:3306/app -Ddatabase.name=app -Ddatabase.password=pass

После выполнения тестов для просмотра отчетов в другой вкладке терминала выполнить команды .\gradlew allureReport и затем .\gradlew allureServe . Завершить работу плагина Ctrl+C.

Для запуска приложения на СУБД PostgreSQL  java -jar aqa-shop.jar -P:jdbc.url=jdbc:postgresql://localhost:5432/postgres -P:jdbc.user=app -P:jdbc.password=pass

Тесты запускаются командой в другой вкладке терминала .\gradlew test -Ddatabase.url=jdbc:postgresql://localhost:5432/postgres -Ddatabase.name=app -Ddatabase.password=pass

