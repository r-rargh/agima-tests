package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeAll
    static void setUp() {
        String browser = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browserVersion", "");
        String screenResolution = System.getProperty("screenResolution", "1920x1080");
        String selenoidUrl = System.getProperty("selenoidUrl", "");

        Configuration.browser = browser;
        Configuration.baseUrl = "https://agima.ru";
        Configuration.pageLoadStrategy = "eager";

        if (!browserVersion.isEmpty()) {
            Configuration.browserVersion = browserVersion;
        }

        Configuration.browserSize = screenResolution;

        if (!selenoidUrl.isEmpty()) {
            Configuration.remote = selenoidUrl;
        }

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));

        System.out.println("=========================================");
        System.out.println("=== Test Configuration ===");
        System.out.println("Browser: " + browser);
        System.out.println("Browser Version: " + (browserVersion.isEmpty() ? "default" : browserVersion));
        System.out.println("Screen Resolution: " + screenResolution);
        System.out.println("Selenoid URL: " + (selenoidUrl.isEmpty() ? "local" : selenoidUrl));
        System.out.println("=========================================");
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWindow();
    }

    @AfterAll
    static void globalTearDown() {
        closeWebDriver();
    }
}