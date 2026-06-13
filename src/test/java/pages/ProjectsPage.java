package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage {

    private final ElementsCollection projectTitles = $$(".card__title");

    @Step("Проверить, что список проектов отображается")
    public ProjectsPage projectsShouldBeDisplayed() {
        projectTitles.first().shouldBe(visible);
        return this;
    }
}