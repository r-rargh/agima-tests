package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import pages.MainPage;

@Epic("Тестирование сайта AGIMA")
@Feature("Навигация по сайту")
public class AgimaTests extends BaseTest {

    @Test
    @Description("Открытие главной страницы и проверка логотипа")
    void openMainPageTest() {
        new MainPage()
                .openPage()
                .checkLogoVisible();
    }

    @Test
    @Description("Переход на страницу Контактов и проверка заголовка")
    void openContactsPageTest() {
        new MainPage()
                .openPage()
                .goToContactsPage()
                .pageTitleShouldBeVisible();
    }

    @Test
    @Description("Переход на страницу Проектов и проверка отображения списка проектов")
    void openProjectsPageTest() {
        new MainPage()
                .openPage()
                .goToProjectsPage()
                .projectsShouldBeDisplayed();
    }

    @Test
    @Description("Проверка отображения футера на главной странице")
    void footerShouldBeVisibleTest() {
        new MainPage()
                .openPage()
                .checkFooterVisible();
    }
}