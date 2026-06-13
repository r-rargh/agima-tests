package config;

public class WebDriverConfig {

    public String getBrowser() {
        return System.getProperty("browser", "chrome");
    }

    public String getBrowserVersion() {
        return System.getProperty("browserVersion", "128.0");
    }

    public String getBrowserSize() {
        return System.getProperty("screenResolution", "1920x1080");
    }

    public String getSelenoidUrl() {
        return System.getProperty("selenoidUrl");
    }

    public boolean isRemote() {
        return getSelenoidUrl() != null;
    }
}