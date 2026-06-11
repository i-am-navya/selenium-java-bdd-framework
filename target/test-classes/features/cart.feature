Feature: Cart functionality on SauceDemo

  Scenario: Add item to cart
    Given I am logged in as "standard_user"
    When I add the backpack to the cart
    Then the cart badge should show "1"

  Scenario: Remove item from cart
    Given I am logged in as "standard_user"
    When I add the backpack to the cart
    And I go to the cart
    Then the backpack should be present in the cart
    When I remove the item from the cart
    Then the cart should be empty

  Scenario: Navigate to checkout from cart
    Given I am logged in as "standard_user"
    When I add the backpack to the cart
    And I go to the cart
    And I click checkout
    Then I should be on the checkout page