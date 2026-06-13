package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CareersPage {

    // Элементы
    private final SelenideElement
            vacanciesButton = $("a[href='#vacancies']"),
            vacanciesSection = $("#vacancies, .vacancies, .careers-list");

    // Действия
    public CareersPage openPage() {
        open("/careers/");
        return this;
    }

    public CareersPage clickVacanciesButton() {
        vacanciesButton.click();
        return this;
    }

    public CareersPage checkVacanciesSectionVisible() {
        vacanciesSection.shouldBe(visible);
        return this;
    }

    public CareersPage checkHasVacancies() {
        String dataCount = vacanciesButton.getAttribute("data-count");
        int count = Integer.parseInt(dataCount);
        if (count <= 0) {
            throw new AssertionError("Количество вакансий: " + count + ". Ожидалось больше 0");
        }
        return this;
    }
}