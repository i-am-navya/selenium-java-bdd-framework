package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By cartItem = By.cssSelector(".cart_item");
    private By itemName = By.cssSelector(".inventory_item_name");
    private By removeButton = By.cssSelector("[data-test='remove-sauce-labs-backpack']");
    private By checkoutButton = By.cssSelector("[data-test='checkout']");
    private By continueShoppingButton = By.cssSelector("[data-test='continue-shopping']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isItemPresent() {
        return driver.findElements(cartItem).size() > 0;
    }

    public String getItemName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemName));
        return driver.findElement(itemName).getText();
    }

    public void removeItem() {
        wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }

    public void continueShopping() {
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
    }

    public boolean isLoaded() {
        return driver.getCurrentUrl().contains("cart");
    }
}