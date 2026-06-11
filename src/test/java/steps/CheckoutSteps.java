package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CheckoutPage;
import utils.DriverManager;

public class CheckoutSteps {

    CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver());

    @When("I enter first name {string} last name {string} and postal code {string}")
    public void iEnterCheckoutDetails(String firstName, String lastName, String postalCode) {
        checkoutPage.fillDetails(firstName, lastName, postalCode);
    }

    @When("I click continue")
    public void iClickContinue() {
        checkoutPage.clickContinue();
    }

    @When("I click finish")
    public void iClickFinish() {
        checkoutPage.clickFinish();
    }

    @Then("I should see the confirmation message {string}")
    public void iShouldSeeConfirmationMessage(String expectedMessage) {
        Assert.assertEquals(checkoutPage.getConfirmationMessage(), expectedMessage);
    }

    @Then("I should see checkout error {string}")
    public void iShouldSeeCheckoutError(String expectedError) {
        Assert.assertEquals(checkoutPage.getErrorMessage(), expectedError);
    }
}