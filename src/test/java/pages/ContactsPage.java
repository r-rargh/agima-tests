package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ContactsPage {

    private final SelenideElement pageTitle = $("h1");

    public ContactsPage pageTitleShouldBeVisible() {
        pageTitle.shouldBe(visible);
        return this;
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }
}