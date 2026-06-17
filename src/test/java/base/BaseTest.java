package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @BeforeAll
    static void setUp() {
        WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

        Configuration.browser = config.browser();

        if (!config.browserVersion().isEmpty()) {
            Configuration.browserVersion = config.browserVersion();
        }

        if (config.isRemote()) {
            Configuration.remote = config.remoteUrl();
        }

        Configuration.baseUrl = "https://agima.ru";
        Configuration.pageLoadStrategy = "eager";

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));

        System.out.println("=========================================");
        System.out.println("=== Test Configuration ===");
        System.out.println("Browser: " + config.browser());
        System.out.println("Browser Version: " + (config.browserVersion().isEmpty() ? "default" : config.browserVersion()));
        System.out.println("Remote: " + config.isRemote());
        System.out.println("Remote URL: " + (config.isRemote() ? config.remoteUrl() : "local"));
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