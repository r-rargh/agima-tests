package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ContactsPage {

    // Элементы
    private final SelenideElement
            pageTitle = $("h1.contacts__title"),
            addressBlock = $(".contacts__address, address, .address"),
            phoneLink = $("a[href*='tel:']"),
            emailLink = $("a[href*='mailto:']");

    // Действия
    public ContactsPage openPage() {
        open("/contacts/");
        return this;
    }

    public ContactsPage checkPageTitleContains(String expectedText) {
        pageTitle.shouldHave(text(expectedText));
        return this;
    }

    public ContactsPage checkAddressVisible() {
        addressBlock.shouldBe(visible);
        return this;
    }

    public ContactsPage checkPhoneVisible() {
        phoneLink.shouldBe(visible);
        return this;
    }

    public ContactsPage checkEmailVisible() {
        emailLink.shouldBe(visible);
        return this;
    }
}