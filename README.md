# Проект по автоматизации тестовых сценариев для сайта компании AGIMA

## Содержание:

- [Используемый стек](#-используемый-стек)
- [Запуск автотестов](#-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)
- [Уведомления в Telegram](#-уведомления-в-telegram)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-тестов-в-selenoid)

## 🔧 Используемый стек

<p align="center">
<img width="6%" title="IntelliJ IDEA" src="media/logo/intelijIDEA.svg">
<img width="6%" title="Java" src="media/logo/java.svg">
<img width="6%" title="Selenide" src="media/logo/selenide.svg">
<img width="6%" title="Selenoid" src="media/logo/selenoid.svg">
<img width="6%" title="Allure Report" src="media/logo/allureReport.svg">
<img width="5%" title="Allure TestOps" src="media/logo/allureTestOps.svg">
<img width="6%" title="Gradle" src="media/logo/gradle.svg">
<img width="6%" title="JUnit5" src="media/logo/jUnit5.svg">
<img width="6%" title="GitHub" src="media/logo/gitHub.svg">
<img width="6%" title="Jenkins" src="media/logo/jenkins.svg">
<img width="6%" title="Telegram" src="media/logo/telegram.svg">
</p>

Тесты в данном проекте написаны на языке **Java** с использованием фреймворка для тестирования [Selenide](https://selenide.org/), сборщик — **Gradle**. **JUnit 5** задействован в качестве фреймворка модульного тестирования.

При прогоне тестов для запуска браузеров используется [Selenoid](https://aerokube.com/selenoid/). Для удаленного запуска реализована задача в **Jenkins** с формированием Allure-отчета и отправкой результатов в **Telegram** при помощи бота. 

⚙️ **Owner** — управление конфигурацией (браузер, версия, удалённый запуск).

**Содержание Allure-отчета:**
- Шаги теста
- Скриншот страницы на последнем шаге
- Page Source
- Логи браузерной консоли
- Видео выполнения автотеста

## ▶️ Запуск автотестов

### Локальный запуск
```bash
./gradlew clean test
```

### Удалённый запуск (в Selenoid)
```bash
./gradlew clean test -DisRemote=true -DremoteUrl="https://user1:1234@selenoid.autotests.cloud/wd/hub"
```

### Параметры запуска

| Параметр | Описание | Пример |
|----------|----------|--------|
| `-Dbrowser` | Браузер | `chrome`, `firefox` |
| `-DbrowserVersion` | Версия браузера | `128.0` |
| `-DisRemote` | Удалённый запуск | `true` |
| `-DremoteUrl` | Адрес Selenoid | `https://user1:1234@...` |

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="media/logo/jenkins.svg"> Сборка в Jenkins

Для запуска сборки необходимо перейти в раздел **Собрать с параметрами** и нажать кнопку **Собрать**.

<p align="center">
<img title="Jenkins Build" src="media/screens/jenkins.png">
</p>

После выполнения сборки откроется Allure-отчёт с результатами тестирования.

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="media/logo/allureReport.svg"> Пример Allure-отчета

### Overview

<p align="center">
<img title="Allure Overview" src="media/screens/allure.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="media/logo/allureTestOps.svg"> Интеграция с Allure TestOps

На **Dashboard** в **Allure TestOps** видна статистика количества тестов: сколько из них добавлены и проходятся вручную, сколько автоматизированы.

<p align="center">
<img title="Allure TestOps Dashboard" src="media/screens/testops.png">
<img src="media/screens/testops2.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/telegram.svg"> Уведомления в Telegram

После завершения сборки специальный бот, созданный в **Telegram**, автоматически отправляет сообщение с отчётом о прогоне тестов.

```
✅ AGIMA Tests
📊 Статистика:
🟢 Пройдено: 4
🔴 Упало: 0
🟡 Пропущено: 0
📋 Всего: 4
⏱ Время: 43 сек
🔗 Отчёт
```

<p align="center">
<img width="70%" title="Telegram Notifications" src="media/screens/bot.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Selenoid" src="media/logo/selenoid.svg"> Видео примера запуска тестов в Selenoid

В отчетах Allure для каждого теста прикреплено видео прохождения теста.

<p align="center">
  <img title="Selenoid Video" src="media/screens/video.gif">
</p>

## 👨‍💻 Автор

[Рафаэль Мирзаев](https://github.com/rarhg)

---
