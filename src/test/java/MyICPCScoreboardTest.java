import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the MyICPC scoreboard module
 *
 * @author Denton Wood
 */
public class MyICPCScoreboardTest extends GenericSeleniumTest {
    private static final String ICPC_URL = "https://my.icpc.global/World-Finals-2019/scoreboard";

    public static Stream<WebDriver> icpcProvider() {
        for (WebDriver driver: drivers) {
            driver.get(ICPC_URL);
        }
        return drivers.stream();
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("icpcProvider")
    public void testGetTitle(WebDriver driver) {
        try {
            assertEquals("MyICPC", driver.getTitle());
        } catch (Exception e) {
            catchException(e, driver);
        }
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("icpcProvider")
    public void testGetFirstElement(WebDriver driver) {
        try {
            WebElement firstPlace = driver.findElement(By.xpath("/div/div/div/div[2]/div/div/div/table/tbody/tr[1]/td[3]/a"));
            assertEquals("Moscow State University", firstPlace.getText());
        } catch (Exception e) {
            catchException(e, driver);
        }
    }
}
