package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;
import pages.InventoryPage;
import utils.DriverManager;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverManager.getDriver());
    InventoryPage inventoryPage = new InventoryPage(DriverManager.getDriver());

    @Given("I am on the SauceDemo login page")
    public void iAmOnTheLoginPage() {
        loginPage.navigateTo();
    }

    @When("I enter username {string} and password {string}")
    public void iEnterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void iClickLoginButton() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the inventory page")
    public void iShouldBeOnInventoryPage() {
        Assert.assertTrue(inventoryPage.isLoaded(), "User was not redirected to inventory page");
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeErrorMessage(String expectedError) {
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals(actualError, expectedError, "Error message did not match");
    }
}