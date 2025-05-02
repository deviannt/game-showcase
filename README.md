# 🎮 Game Showcase App

## 📱 Описание
Приложение отображает список видеоигр с использованием двух архитектур:
- **MVVM** (Model-View-ViewModel)
- **MVI** (Model-View-Intent)

Пользователь может выбрать архитектуру при запуске.

## 🛠 Технологии
- Kotlin
- ViewBinding
- Glide
- RecyclerView
- Coroutine + Flow
- MVVM / MVI
- SOLID (чистая архитектура по слоям)

## 💡 Возможности
- Выбор архитектуры при запуске
- Загрузка обложек игр через интернет
- Красивая верстка карточек (CardView + тени)
- Обработка состояний: загрузка, успех, ошибка

## 🗂 Структура проекта
com.example.hw7
├── data // реализация репозиториев
├── domain // модели и абстракции
├── presentation
│ ├── mvvm // MVVM фрагмент и ViewModel
│ └── mvi // MVI фрагмент, Intent, State, ViewModel
├── ui // адаптер для RecyclerView
├── utils // расширения Glide и др.
└── MainActivity // точка входа + диалог выбора архитектуры


## ✅ Что реализовано
✔ MVVM и MVI  
✔ SOLID-структура  
✔ Glide + placeholder/error  
✔ Переключение архитектур  
✔ Адаптер и отображение обложек  
✔ UI с CardView и стилями

## 🗃 Работа с Room и миграцией

### 🔨 Реализация
- Использована библиотека **Room** (версия 2.6.1)
- Добавлена сущность `GameEntity` с полями:
  - `id`, `name`, `genre`, `platform`
- В версии **2** добавлено новое поле: `releaseYear`

### 🔁 Миграция
- В `Migrations.kt` реализован `MIGRATION_1_2`
- Команда SQL:
  ```sql
  ALTER TABLE games ADD COLUMN releaseYear INTEGER DEFAULT NULL


## ✍ Автор
Студент [Темирлан] — домашнее задание по Android
