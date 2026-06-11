package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    // Locators
    private By pageTitle = By.cssSelector(".title");
    private By addToCartButton = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    private By cartIcon = By.cssSelector(".shopping_cart_link");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");
    private By sortDropdown = By.cssSelector("[data-test='product-sort-container']");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public void addBackpackToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public String getCartCount() {
        return driver.findElement(cartBadge).getText();
    }

    public void sortBy(String option) {
        driver.findElement(sortDropdown).sendKeys(option);
    }

    public boolean isLoaded() {
        return driver.getCurrentUrl().contains("inventory");
    }
}