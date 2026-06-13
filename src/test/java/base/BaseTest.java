package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebDriverConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    private static final WebDriverConfig config = new WebDriverConfig();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.agima.ru";
        Configuration.browserSize = config.getBrowserSize();

        if (config.isRemote()) {
            Configuration.browser = null; // Запрещаем Selenide создавать браузер

            ChromeOptions options = new ChromeOptions();
            options.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            try {
                RemoteWebDriver driver = new RemoteWebDriver(
                        new URL(config.getSelenoidUrl()), options);
                WebDriverRunner.setWebDriver(driver);
            } catch (MalformedURLException e) {
                throw new RuntimeException("Неправильный URL Selenoid: " + config.getSelenoidUrl(), e);
            }
        }
    }

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}