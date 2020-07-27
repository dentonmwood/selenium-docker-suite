import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

/**
 * Practice test copied from Selenium tutorial
 */
public class PracticeTest extends GenericSeleniumTest {
    private static final String GOOGLE_URL = "http://www.google.com";

    public static Stream<WebDriver> practiceProvider() {
        for (WebDriver driver: drivers) {
            driver.get(GOOGLE_URL);
        }
        return drivers.stream();
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("practiceProvider")
    public void testPractice(WebDriver driver) {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());
    }
}
