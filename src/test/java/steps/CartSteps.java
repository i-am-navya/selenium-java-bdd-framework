package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.DriverManager;

public class CartSteps {

    LoginPage loginPage = new LoginPage(DriverManager.getDriver());
    InventoryPage inventoryPage = new InventoryPage(DriverManager.getDriver());
    CartPage cartPage = new CartPage(DriverManager.getDriver());

    @Given("I am logged in as {string}")
    public void iAmLoggedInAs(String username) {
        loginPage.navigateTo();
        loginPage.login(username, "secret_sauce");
    }

    @When("I add the backpack to the cart")
    public void iAddBackpackToCart() {
        inventoryPage.addBackpackToCart();
    }

    @Then("the cart badge should show {string}")
    public void cartBadgeShouldShow(String expectedCount) {
        Assert.assertEquals(inventoryPage.getCartCount(), expectedCount);
    }

    @When("I go to the cart")
    public void iGoToCart() {
        inventoryPage.goToCart();
    }

    @Then("the backpack should be present in the cart")
    public void backpackShouldBePresentInCart() {
        Assert.assertTrue(cartPage.isItemPresent(), "Item not found in cart");
    }

    @When("I remove the item from the cart")
    public void iRemoveItemFromCart() {
        cartPage.removeItem();
    }

    @Then("the cart should be empty")
    public void cartShouldBeEmpty() {
        Assert.assertFalse(cartPage.isItemPresent(), "Cart is not empty");
    }

    @When("I click checkout")
    public void iClickCheckout() {
        cartPage.clickCheckout();
    }

    @Then("I should be on the checkout page")
    public void iShouldBeOnCheckoutPage() {
        Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("checkout-step-one"));
    }
}