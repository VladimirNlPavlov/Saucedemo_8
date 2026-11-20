import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class BaseTest {
    WebDriver browser;

    @BeforeEach
    public void setUp() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");
        //options.addArguments("headless");

        browser = new EdgeDriver();
        browser.get("https://www.saucedemo.com/");
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @AfterEach
    public void tearDown() {
        browser.quit();
    }
}