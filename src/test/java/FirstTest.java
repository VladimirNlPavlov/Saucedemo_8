import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class FirstTest extends BaseTest {

    @Test
    public void lockedOutUser() throws InterruptedException {
        browser.findElement(By.cssSelector("#user-name")).sendKeys("locked_out_user");
        browser.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("#login-button")).click();

        assertTrue(browser.findElement(By.cssSelector("[role='alert']")).isDisplayed());

        String errorText = browser.findElement(By.cssSelector("[role='alert']")).getText();
        assertEquals(errorText, "Epic sadface: Sorry, this user has been locked out.");

    }

    @Test
    public void emptyUsername() throws InterruptedException {
        browser.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("#login-button")).click();

        assertTrue(browser.findElement(By.cssSelector("[role='alert']")).isDisplayed());

        String errorText = browser.findElement(By.cssSelector("[role='alert']")).getText();
        assertEquals(errorText, "Epic sadface: Username is required");

    }

    @Test
    public void emptyPassword() throws InterruptedException {
        browser.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        browser.findElement(By.cssSelector("#login-button")).click();

        assertTrue(browser.findElement(By.cssSelector("[role='alert']")).isDisplayed());

        String errorText = browser.findElement(By.cssSelector("[role='alert']")).getText();
        assertEquals(errorText, "Epic sadface: Password is required");

    }

    @Test
    public void wrongPassword() throws InterruptedException {
        browser.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        browser.findElement(By.cssSelector("#password")).sendKeys("secret");
        browser.findElement(By.cssSelector("#login-button")).click();

        assertTrue(browser.findElement(By.cssSelector("[role='alert']")).isDisplayed());

        String errorText = browser.findElement(By.cssSelector("[role='alert']")).getText();
        assertEquals(errorText, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void correctLogin() throws InterruptedException {

        browser.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        browser.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        browser.findElement(By.cssSelector("#login-button")).click();

        String currentUrl = browser.getCurrentUrl();
        assertTrue(currentUrl.contains("/inventory.html"));

        assertTrue(browser.findElement(By.cssSelector("[data-test='title']")).isDisplayed());

        String errorText = browser.findElement(By.cssSelector("[data-test='title']")).getText();
        assertEquals(errorText, "Products");

    }
}
