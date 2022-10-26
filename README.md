# Описание проекта

Приложение "Задачи" позволяет создавать список задач и контролировать их выполнение. Задачи могут включать в себя список подзадач. Завершённые задачи можно удалять.

Проект написан с применением Clean Architecture и MVVM.

## Структура проекта

- `com.htc.domain`:
  - Сущности предметной области
  - Сценарии использования
  - Интерфейсы репозиториев сущностей
- `com.htc.infrastructure`:
  - Логика работы с СУБД
  - Представления сущностей для СУБД
  - Реализация репозиториев сущностей
- `com.htc.application`:
  - Реализация графического интерфейса пользователя

## TODO

1. Реализовать графический интерфейс.
2. Добавить внедрение зависимостей.
3. Реализовать асинхронность через RxJava.
4. Написать модульные тесты.
5. Настроить линтер.
