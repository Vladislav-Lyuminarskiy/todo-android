# Описание проекта

Приложение "Задачи" позволяет создавать список задач и контролировать их выполнение. Задачи могут включать в себя список подзадач. Завершённые задачи можно удалять.

Проект написан с применением Clean Architecture и MVVM.

## Структура проекта

Основные блоки проекта и их содержимое:

- `com.htc.domain` - независимая от фреймворков абстракция предметной области:
  - сущности предметной области,
  - интерфейсы репозиториев сущностей,
  - сценарии использования.
- `com.htc.infrastructure` - работа с данными и внешними сервисами:
  - логика работы с СУБД,
  - представления сущностей для СУБД,
  - реализация репозиториев сущностей.
- `com.htc.presentation` - взаимодействие с пользователями:
  - реализация графического интерфейса пользователя.

## Экраны приложения

### Список задач

Экран содержит:
1. прокручивающийся по вертикали список задач,
2. плавающую кнопку создания новой задачи,
3. плавающую кнопку удаления всех завершённых задач.

Элемент списка задач содержит:
1. переключатель завершённости задачи (галочка),
2. описание задачи,
3. количество выполненных подзадач (например, `0 из 3`).

При нажатии на элемент списка задач открывается [детальный экран](#Задача) соответствующей задачи.

При нажатии на плавующую кнопку создания новой задачи отображается диалоговое окно с вводом описания задачи.

### Задача

Экран содержит:
1. переключатель завершённости задачи (галочка),
2. описание задачи,
3. количество выполненных подзадач (например, `0 из 3`),
4. прокручивающийся по вертикали список подзадач,
5. плавающую кнопку добавления подзадачи.

Элемент списка подзадач содержит:
1. переключатель завершённости подзадачи (галочка),
2. описание подзадачи.

При нажатии на элемент списка подзадач происходит переключение завершённости соответствующей подзадачи.

При нажатии на плавующую кнопку добавления подзадачи отображается диалоговое окно с вводом описания подзадачи.

## Задачи по проекту

Задачи по проекту, в порядке выполнения:

- [x] Подготовить описание проекта (README). `1ч`
- [x] Реализовать доменный слой приложения: `2ч`
  - [x] Создать сущности предметной области.
  - [x] Создать интерфейсы репозиториев сущностей.
  - [x] Создать сценарии использования.
- [x] Реализовать инфраструктурный слой приложения: `4ч`
  - [x] Создать представления сущностей для СУБД.
  - [x] Реализовать логику работы с СУБД.
  - [x] Создать реализацию интерфейсов репозиториев сущностей.
- [ ] Реализовать графический интерфейс: `6ч`
  - [ ] Реализовать экран со списком задач.
  - [ ] Реализовать экран задачи.
  - [ ] Реализовать навигацию между экранами приложения.
- [ ] Реализовать асинхронность через RxJava. `4ч`
- [ ] Добавить внедрение зависимостей. `1ч`
- [ ] Написать модульные тесты. `4ч`
- [ ] Настроить линтер, исправить найденные замечания. `1ч`