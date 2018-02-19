Feature: Requested scenarios for interview

  @EndtoEnd
  Scenario: End to end path to purchase a product
    Given User on the RS homepage
    When User click on the All Products link
    And User click on the Non-Rechargeable Batteries on Batteries mouseover
    And User click on the AA Volt Batteries
    And enter the quantity and add it to basket
    And User click on View basket link
    Then User Should see Checkout securely button

  @EndtoEnd
  Scenario: Removing the products from the basket after selecting the products
    Given User on the RS homepage
    When User click on 'Our Brands' link
    And User select a brand from the list
    And User select a product from the list
    And enter the quantity and add it to basket
    And User click on View basket link
    And User click on Clear all products link
    Then My Basket Should Be Empty

  @SearchResults
  Scenario: Successfully searching for products by brand
    Given User on the RS homepage
    When User search for a product by "ABB" brand
    Then Products from the specified brand should be retrieved

  @SearchResults
  Scenario: Successfully searching for products by Mfr. Part No.
    Given User on the RS homepage
    When User search for a product by "DV164140-1" Mfr. Part No.
    Then Product Details Page With The Specified Mfr. Part No. Should Be Opened

  @SearchResults
  Scenario: Successfully searching for products by RS Stock No.
    Given User on the RS homepage
    When User search for a product by "870-0742" RS Stock No.
    Then Product Details Page With The Specified RS Stock No. Should Be Opened
