import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class GenericSeleniumTest {
    protected static WebDriver chromeDriver;
    protected static WebDriver firefoxDriver;
    private static final String HUB_URL = "http://selenium_hub:4444/wd/hub";

    @BeforeAll
    public static void initDrivers() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        chromeDriver = new RemoteWebDriver(new URL(HUB_URL), chromeOptions);
        firefoxDriver = new RemoteWebDriver(new URL(HUB_URL), firefoxOptions);
    }

    public void catchException(Exception e, WebDriver driver) {
        System.err.println(e.getMessage());
        driver.quit();
        Assertions.fail();
    }


    @AfterAll
    public static void closeDrivers() {
        chromeDriver.quit();
        firefoxDriver.quit();
    }
}
