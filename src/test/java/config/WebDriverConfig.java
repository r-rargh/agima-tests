package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:src/test/resources/webdriver.properties",
        "system:properties"
})
public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    @DefaultValue("")
    String browserVersion();

    @Key("remoteUrl")
    @DefaultValue("")
    String remoteUrl();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();
}