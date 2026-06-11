Feature: Checkout functionality on SauceDemo

  Scenario: Complete a successful purchase
    Given I am logged in as "standard_user"
    When I add the backpack to the cart
    And I go to the cart
    And I click checkout
    And I enter first name "Navya" last name "Zacharia" and postal code "D01"
    And I click continue
    And I click finish
    Then I should see the confirmation message "Thank you for your order!"

  Scenario: Checkout fails with missing first name
    Given I am logged in as "standard_user"
    When I add the backpack to the cart
    And I go to the cart
    And I click checkout
    And I enter first name "" last name "Zacharia" and postal code "D01"
    And I click continue
    Then I should see checkout error "Error: First Name is required"

  Scenario: Checkout fails with missing postal code
    Given I am logged in as "standard_user"
    When I add the backpack to the cart
    And I go to the cart
    And I click checkout
    And I enter first name "Navya" last name "Zacharia" and postal code ""
    And I click continue
    Then I should see checkout error "Error: Postal Code is required"