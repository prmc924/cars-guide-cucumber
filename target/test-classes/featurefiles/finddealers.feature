@regression
Feature: Find the dealers and verify

  Background:
    Given I am on homepage
    And I mouse hover on "buy + sell" tab

  @sanity
  Scenario: Find the dealers and verify the dealers are in list
    When I click "Find a Dealer" link
    Then I navigate to "https://www.carsguide.com.au/car-dealers" url page
    And I should see the dealer names displayed on page
      | dealersName          |
      | 5 Star Auto Trade    |
      | ATG Test Dealer 2022 |
#      | ALBANY WORLD OF CARS |
#      | ALTO VOLKSWAGEN      |





