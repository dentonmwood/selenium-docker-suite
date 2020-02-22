import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyICPCTest extends GenericSeleniumTest {
    private static final String ICPC_URL = "https://my.icpc.global/World-Finals-2019/scoreboard";

    /**
     * This method returns the list of drivers to use for testing. It also
     * ensures that the tests are independent (i.e. the page is refreshed
     * each time)
     *
     * @return the list of drivers to test.
     */
    public static Stream<WebDriver> icpcProvider() {
        for (WebDriver driver: drivers) {
            driver.get(ICPC_URL);
        }
        return drivers.stream();
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("icpcProvider")
    public void testGetTitle(WebDriver driver) {
        assertEquals("MyICPC", driver.getTitle());
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("icpcProvider")
    public void testGetFirstPlaceTeam(WebDriver driver) {
        WebElement firstPlace = driver.findElement(By.xpath("//tbody/tr/td/a"));
        assertEquals("Moscow State University", firstPlace.getText());
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("icpcProvider")
    public void testFavoriteATeam(WebDriver driver) {
        WebElement row8 = driver.findElement(By.xpath("//tbody/tr[8]"));
        WebElement name = row8.findElement(By.xpath("//td[2]/a"));
        assertEquals("KimChaek University of Technology", name.getText());
//        WebElement star = row8.findElement(By.xpath("//td[0]"));
//        star.click();
//        WebElement row0 = driver.findElement(By.xpath(""))
    }
}
