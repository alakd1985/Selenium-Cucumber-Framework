Feature: Automated E2E_Test
  Description: The Purpose of the test is to test End to End Test feature

  Scenario Outline: Customer place an order by purchasing an item from search
    Given user is on Home Page
    When he search for "dress"
    And choose to buy the first item
    And moves to checkout from mini cart
    And enter "<customer>" personal details on checkout page
    And place the order

    Examples: 
      | customer |
      | Alak     |
      | Toma     |
