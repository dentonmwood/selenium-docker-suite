import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class SeleniumTest {
    private static WebDriver chromeDriver;
    private static WebDriver firefoxDriver;
    private static final String HUB_URL = "http://selenium_hub:4444/wd/hub";
    private static final String ICPC_URL = "https://my.icpc.global/World-Finals-2019/scoreboard";
    private static final String GOOGLE_URL = "http://www.google.com";

    @BeforeAll
    public static void initDrivers() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        chromeDriver = new RemoteWebDriver(new URL(HUB_URL), chromeOptions);
        firefoxDriver = new RemoteWebDriver(new URL(HUB_URL), firefoxOptions);
        // chromeDriver.get(ICPC_URL);
        // firefoxDriver.get(ICPC_URL);
        chromeDriver.get(GOOGLE_URL);
        firefoxDriver.get(GOOGLE_URL);
    }

    public void catchException(Exception e, WebDriver driver) {
        System.err.println(e.getMessage());
        System.err.println(Arrays.toString(e.getStackTrace()));
        driver.quit();
        Assertions.fail();
    }

//    @Test
//    public void testSelenium() {
//        try {
//            WebElement element = firefoxDriver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/div/table/tbody/tr[1]/td[3]"));
//            System.out.println("Text is: " + firefoxDriver.getTitle());
//            Assertions.assertTrue(true);
//        } catch (Exception e) {
//            catchException(e, firefoxDriver);
//        }
//    }

    @Test
    public void practiceTest() {
        try {
            firefoxDriver.get("http://www.google.com");
            WebElement element = firefoxDriver.findElement(By.name("q"));
            element.sendKeys("Cheese!");
            element.submit();
            System.out.println("Page title is: " + firefoxDriver.getTitle());
        } catch (Exception e) {
            catchException(e, firefoxDriver);
        }
    }

    @AfterAll
    public static void closeDrivers() {
        chromeDriver.quit();
        firefoxDriver.quit();
    }
}
