package tests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CareersPage;
import pages.ContactsPage;
import pages.MainPage;
import pages.ProjectsPage;

@DisplayName("Тесты сайта AGIMA")
public class AgimaTests extends BaseTest {

    private final MainPage mainPage = new MainPage();
    private final ProjectsPage projectsPage = new ProjectsPage();
    private final CareersPage careersPage = new CareersPage();
    private final ContactsPage contactsPage = new ContactsPage();

    @Test
    @DisplayName("Проверка текста на главной странице")
    void checkMainPageLogoTextTest() {
        mainPage.openPage()
                .checkLogoTextVisible()
                .checkLogoTextContains("Крупнейший интегратор");
    }

    @Test
    @DisplayName("Проверка бургер-меню на главной странице")
    void checkBurgerMenuTest() {
        mainPage.openPage()
                .checkBurgerMenuVisible();
    }

    @Test
    @DisplayName("Проверка футера на главной странице")
    void checkFooterOnMainPageTest() {
        mainPage.openPage()
                .checkFooterVisible();
    }

    @Test
    @DisplayName("Открытие страницы Кейсы через бургер-меню")
    void openProjectsViaBurgerMenuTest() {
        mainPage.openPage()
                .openBurgerMenu()
                .clickMenuItem("Кейсы");

        projectsPage.checkPageTitle("Наши работы");
    }

    @Test
    @DisplayName("Проверка карточек проектов на странице Кейсы")
    void checkProjectCardsTest() {
        projectsPage.openPage()
                .checkProjectCardsVisible()
                .checkMinimumCardsCount(3);
    }

    @Test
    @DisplayName("Открытие страницы Контакты через бургер-меню")
    void openContactsViaBurgerMenuTest() {
        mainPage.openPage()
                .openBurgerMenu()
                .clickMenuItem("Контакты");

        contactsPage.checkPageTitleContains("Контакты")
                .checkAddressVisible()
                .checkPhoneVisible()
                .checkEmailVisible();
    }

    @Test
    @DisplayName("Открытие страницы Вакансии через бургер-меню и проверка секции")
    void checkCareersPageTest() {
        mainPage.openPage()
                .openBurgerMenu()
                .clickMenuItem("Работа в AGIMA");

        careersPage.clickVacanciesButton()
                .checkVacanciesSectionVisible()
                .checkHasVacancies();
    }
}