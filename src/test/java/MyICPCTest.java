import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyICPCTest extends GenericSeleniumTest {
    private static final String ICPC_URL = "https://my.icpc.global/World-Finals-2019/scoreboard";

    @BeforeEach
    public void pointDrivers() {
        chromeDriver.get(ICPC_URL);
        firefoxDriver.get(ICPC_URL);
    }

    @Test
    public void testGetIcpc() {
        try {
            WebElement firstPlace = firefoxDriver.findElement(By.xpath("/div/div/div/div[2]/div/div/div/table/tbody/tr[1]/td[3]/a"));
            assertEquals("Moscow State University", firstPlace.getText());
        } catch (Exception e) {
            catchException(e, firefoxDriver);
        }
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

}
