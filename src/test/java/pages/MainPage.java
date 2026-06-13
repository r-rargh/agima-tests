package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    // Элементы
    private final SelenideElement
            logoText = $("h1.first-screen__title"),
            burgerMenu = $(".header__burger"),
            footer = $("footer");

    // Действия
    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage checkLogoTextVisible() {
        logoText.shouldBe(visible);
        return this;
    }

    public MainPage checkLogoTextContains(String expectedText) {
        logoText.shouldHave(text(expectedText));
        return this;
    }

    public MainPage checkBurgerMenuVisible() {
        burgerMenu.shouldBe(visible);
        return this;
    }

    public MainPage openBurgerMenu() {
        burgerMenu.click();
        return this;
    }

    public MainPage clickMenuItem(String itemName) {
        $(".fullscreen-menu__menu")
                .findAll("a")
                .findBy(text(itemName))
                .click();
        return this;
    }

    public MainPage checkFooterVisible() {
        footer.shouldBe(visible);
        return this;
    }
}