import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class PracticeTest extends GenericSeleniumTest {
    private static final String GOOGLE_URL = "http://www.google.com";

    @BeforeEach
    public void pointDrivers() {
        chromeDriver.get(GOOGLE_URL);
        firefoxDriver.get(GOOGLE_URL);
    }

    @Test
    public void testPractice() {
        try {
            WebElement element = firefoxDriver.findElement(By.name("q"));
            element.sendKeys("Cheese!");
            element.submit();
            System.out.println("Page title is: " + firefoxDriver.getTitle());
        } catch (Exception e) {
            catchException(e, firefoxDriver);
        }
    }
}
