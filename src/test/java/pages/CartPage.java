package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    // Locators
    private By cartItem = By.cssSelector(".cart_item");
    private By itemName = By.cssSelector(".inventory_item_name");
    private By removeButton = By.cssSelector("[data-test='remove-sauce-labs-backpack']");
    private By checkoutButton = By.cssSelector("[data-test='checkout']");
    private By continueShoppingButton = By.cssSelector("[data-test='continue-shopping']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isItemPresent() {
        return driver.findElements(cartItem).size() > 0;
    }

    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public void removeItem() {
        driver.findElement(removeButton).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void continueShopping() {
        driver.findElement(continueShoppingButton).click();
    }

    public boolean isLoaded() {
        return driver.getCurrentUrl().contains("cart");
    }
}