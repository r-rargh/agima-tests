package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement logo = $(".header__logo");
    private final SelenideElement footer = $("footer.footer");
    private final SelenideElement cookiePopup = $(".cookie-popup");
    private final SelenideElement cookieAcceptButton = $(".cookie-popup button");

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage closeCookiePopup() {
        if (cookiePopup.isDisplayed()) {
            cookieAcceptButton.click();
        }
        return this;
    }

    public MainPage checkLogoVisible() {
        logo.shouldBe(visible);
        return this;
    }

    public MainPage checkFooterVisible() {
        footer.shouldBe(visible);
        return this;
    }

    public MainPage checkPageTitleContains(String expectedPart) {
        String actualTitle = title();
        if (!actualTitle.contains(expectedPart)) {
            throw new AssertionError("Заголовок '" + actualTitle + "' не содержит: " + expectedPart);
        }
        return this;
    }

    public ContactsPage goToContactsPage() {
        closeCookiePopup();
        open("/contacts/");
        return new ContactsPage();
    }

    public ProjectsPage goToProjectsPage() {
        closeCookiePopup();
        open("/projects/");
        return new ProjectsPage();
    }
}