Feature: Requested scenarios for interview

  Scenario: End to end path to purchase a product
    Given I am on the RS homepage
    When I click on the All Products link
    And I click on the Non-Rechargeable Batteries on Batteries mouseover
    And click on the AA Volt Batteries
    And enter the quantity and add it to basket
    And I click on View basket link
    Then I Should see Checkout securely button

  Scenario: Removing the products from the basket after selecting the products
    Given I am on the RS homepage
    When I click on 'Our Brands' link
    And I select a brand from the list
    And I select a product from the list
    And enter the quantity and add it to basket
    And I click on View basket link
    And I click on Clear all products link
    Then My Basket Should Be Empty

  Scenario: Title of your scenario
    Given I am on the RS homepage
    When I search for a product by "ABB" brand
    Then Products from the specified brand should be retrieved

  Scenario: Successfully searching for products by Mfr. Part No.
    Given I am on the RS homepage
    When I search for a product by "DV164140-1" Mfr. Part No.
    Then Product Details Page With The Specified Mfr. Part No. Should Be Opened

  Scenario: Successfully searching for products by RS Stock No.
    Given I am on the RS homepage
    When I search for a product by "870-0742" RS Stock No.
    Then Product Details Page With The Specified RS Stock No. Should Be Opened
