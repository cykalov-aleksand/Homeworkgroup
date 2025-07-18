# Название продукта:
- Сервис рекомендаций банковских продуктов.

# Описание:
- Cервис, предназначенный для автоматического подбора и отображения персонализированных рекомендаций банковских продуктов клиентам банка «Стар». Система помогает маркетологам банка формировать целевые предложения, повышает лояльность клиентов и увеличивает продажи финансовых услуг.

# Исполнители:
- [Александр Ц.](https://github.com/cykalov-aleksand/)
- [Михаил С.](https://github.com/Mick210/)
- [Андрей С.](https://github.com/andrejstrogonov/)

# Функции сервиса:
- отображение информации о сервисе
- рекомендации продуктов для пользователя
- динамический анализ для пользователя по имени
- динамический анализ для пользователя по id
- добавление продуктов банка
- отображение имеющихся продуктов
- удаление рекомендаций
- отображение статистики исполнения динамических данных
- отображение имеющихся рекомендаций по продукту
- удаление рекомендаций из продукта
- очистка кэша

# Используемые технологии:
- Java SE: Версия 17
- Spring Boot: Версия 3.5.0 
- Web-сервер: spring-boot-starter-web
- ORM фреймворк: hibernate-core
- Доступ к данным через JDBC: spring-boot-starter-jdbc
- Файловая база данных: h2
- Документация API: springdoc-openapi-starter-webmvc-ui
- Реляционные СУБД: postgresql
- Управление изменениями базы данных: liquibase-core
- Кеширование: spring-boot-starter-cache, caffeine
- Аннотированная сборка: spring-boot-maven-plugin