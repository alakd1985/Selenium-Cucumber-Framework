Feature: Automated E2E_Test
  Description: The Purpose of the test is to test End to End Test feature

  Scenario: Customer place an order by purchasing an item from search
    Given user is on Home Page
    When he search for "dress"
    And choose to buy the first item
    And moves to checkout from mini cart
    And enter personal details on checkout page
    And select same delivery address
    And place the order
