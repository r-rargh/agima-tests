package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ContactsPage {

    private final SelenideElement pageTitle = $("h1");

    @Step("Проверить отображение заголовка страницы Контактов")
    public ContactsPage pageTitleShouldBeVisible() {
        pageTitle.shouldBe(visible);
        return this;
    }

    @Step("Получить текст заголовка страницы Контактов")
    public String getPageTitle() {
        return pageTitle.getText();
    }
}