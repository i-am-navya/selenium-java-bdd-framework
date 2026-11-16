package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InventoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By pageTitle = By.cssSelector(".title");
    private By addToCartButton = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    private By cartIcon = By.cssSelector(".shopping_cart_link");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");
    private By sortDropdown = By.cssSelector("[data-test='product-sort-container']");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return driver.findElement(pageTitle).getText();
    }

    public void addBackpackToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    public String getCartCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        return driver.findElement(cartBadge).getText();
    }

    public void sortBy(String option) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sortDropdown));
        driver.findElement(sortDropdown).sendKeys(option);
    }

    public boolean isLoaded() {
        try {
            return wait.until(ExpectedConditions.urlContains("inventory"));
        } catch (TimeoutException e) {
            return false;
        }
    }
}