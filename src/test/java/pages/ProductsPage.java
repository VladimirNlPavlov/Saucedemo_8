package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private final By title = By.cssSelector("[data-test='title']");
    private final String productsPageUrl = "inventory.html";

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean pageTitleIsVisible() {
        return driver.findElement(title).isDisplayed();
    }

    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    public boolean productsPageOpened() {
        return driver.getCurrentUrl().contains(productsPageUrl);
    }
}
