package pages;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage {

    private final ElementsCollection projectTitles = $$(".card__title");

    public ProjectsPage projectsShouldBeDisplayed() {
        projectTitles.first().shouldBe(visible);
        return this;
    }
}