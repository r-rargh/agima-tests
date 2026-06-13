package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class ProjectsPage {

    // Элементы
    private final SelenideElement
            pageTitle = $("h1.projects-nav__title");

    private final ElementsCollection
            projectCards = $$(".projects-nav__item, a[href*='/projects/']");

    // Действия
    public ProjectsPage openPage() {
        open("/projects/");
        return this;
    }

    public ProjectsPage checkPageTitle(String expectedTitle) {
        pageTitle.shouldHave(text(expectedTitle));
        return this;
    }

    public ProjectsPage checkProjectCardsVisible() {
        projectCards.first().shouldBe(visible);
        return this;
    }

    public ProjectsPage checkMinimumCardsCount(int minCount) {
        projectCards.shouldHave(sizeGreaterThan(minCount));
        return this;
    }

    public ProjectsPage clickProjectByIndex(int index) {
        projectCards.get(index).click();
        return this;
    }

    public ProjectsPage checkProjectPageOpened() {
        webdriver().shouldHave(urlContaining("/projects/"));
        return this;
    }
}