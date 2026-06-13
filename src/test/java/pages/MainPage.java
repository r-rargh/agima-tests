package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement logo = $(".header__logo");
    private final SelenideElement footer = $("footer.footer");
    private final SelenideElement cookiePopup = $(".cookie-popup");
    private final SelenideElement cookieAcceptButton = $(".cookie-popup button");

    @Step("Открыть главную страницу")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Закрыть окно с куками")
    public MainPage closeCookiePopup() {
        if (cookiePopup.isDisplayed()) {
            cookieAcceptButton.click();
        }
        return this;
    }

    @Step("Проверить отображение логотипа")
    public MainPage checkLogoVisible() {
        logo.shouldBe(visible);
        return this;
    }

    @Step("Проверить отображение футера")
    public MainPage checkFooterVisible() {
        footer.shouldBe(visible);
        return this;
    }

    @Step("Проверить заголовок страницы")
    public MainPage checkPageTitleContains(String expectedPart) {
        String actualTitle = title();
        if (!actualTitle.contains(expectedPart)) {
            throw new AssertionError("Заголовок '" + actualTitle + "' не содержит: " + expectedPart);
        }
        return this;
    }

    @Step("Перейти на страницу Контактов")
    public ContactsPage goToContactsPage() {
        closeCookiePopup();
        open("/contacts/");
        return new ContactsPage();
    }

    @Step("Перейти на страницу Проектов")
    public ProjectsPage goToProjectsPage() {
        closeCookiePopup();
        open("/projects/");
        return new ProjectsPage();
    }
}