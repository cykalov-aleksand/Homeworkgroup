Формат: OpenAPI (Swagger)  

Очистка кешей  
POST /management/clear-caches  
- Очищает все кеши системы.  

Информация о сервисе  
GET /management/info  
- Возвращает информацию о сервисе.  

Удаление рекомендации  
DELETE /dinamic/{id}  
- Удаляет рекомендацию по ID продукта.  

Добавление продукта  
POST /dinamic  
- Создает или обновляет продукт.  

Все продукты  
GET /dinamic/all  
- Получает список всех продуктов.  

Удаление рекомендаций  
DELETE /rule/delete  
- Удаляет рекомендации по ID продукта и ID совета.  

Советы по продукту  
GET /rule/allRule  
- Возвращает советы по продукту.  

Статистика правил  
GET /rule/stats  
- Показывает статистику использования динамических правил.  

Рекомендации по клиенту  
GET /recommendation/{user_Id}  
- Возвращает рекомендации для клиента.  

Динамические рекомендации  
GET /recommendation/dynamic/{user_Id}  
- Вычисляет динамические рекомендации для клиента.  

Динамический анализ по имени клиента  
GET /recommendation/username/{userName}  
- Возвращает информацию о клиенте по имени пользователя.  
<hr>
Подробная информация доступна по адресу:

[http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)
при запущенном приложении.
</hr>