REST API Spring Boot на Java.
Стек:
Java SE 11 - Платформа Java;
Spring Boot - инструмент фреймворка Spring для написания приложений с минимальной конфигурацией (имеет встроенный контейнер сервлетов Tomcat по умолчанию);
Spring Web - включает в себя все настройки Spring MVC и позволяет писать REST API без дополнительных настроек;
Spring Data JPA - позволяет работать с SQL с помощью Java Persistence API, используя Spring Data и Hibernate;
Lombok - библиотека для сокращения написания стандартного кода на java (геттеры, сеттеры и т.д.);
Maven - фреймворк для автоматизации сборки проектов на основе описания их структуры в файлах на языке POM (англ. Project Object Model).
H2 database - Открытая кроссплатформенная СУБД.

Функционал.
Это приложение предоставляет REST API для работы с базой данных магазину компьютерной техники.

Хранение данных.
Структура таблиц Базы данных

Сборка.
Сборка исполняемого jar-файла.

Для получения списка всей базы данных.
запрос get  /addProduct

Для получения всех существующих товаров по типу.
запрос get  /getTypeProduct/{type}

{type} - тип товара (например: Настольный компьютер)

Для получения по индификационному номеру.
запрос get /getProduct/{id}

{id} - индификационный номер товара

Для создания товара.
запрос post /addProduct
вида 
{
"typeProduct":"PC",
"serial":"19772867",
"manufacturer":"DELL",
"price":"17700",
"quantity":"2",
"description":"17"
}

typeProduct - тип товара (например: Настольный компьютер)
serial - серийный номер товара
manufacturer - производитель товара
price - цена товара
quantity - количество товара
description - дополнительное свойство товара (например: 17 дюймовый монитор)

Для редактирования товара.
запрос patch /{id}

{id} - индификационный номер товара

вида
{
"typeProduct":"PC",
"serial":"19772867",
"manufacturer":"DELL",
"price":"17700",
"quantity":"2",
"description":"17"
}

typeProduct - тип товара (например: Настольный компьютер)
serial - серийный номер товара
manufacturer - производитель товара
price - цена товара
quantity - количество товара
description - дополнительное свойство товара (например: 17 дюймовый монитор)