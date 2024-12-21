@regression
Feature: Search functionality
  As a user I should be able to search cars

  Background:
    Given I am on homepage
    And I mouse hover on "buy + sell" tab

  @smoke
  Scenario Outline: Search the buy car with model
    When I click "Used" link
    Then I navigate to "Used Cars" page
    And I select make "<make>"
#    And I select model "<model>"
    And I select location "<location>"
    And I select min price "<minPrice>"
    And I select max price "<maxPrice>"
    And I click on Find My Next Car tab
    Then I should see the make "<make>" in results
    Examples:
      | make       | model     | location          | minPrice | maxPrice |
      | BMW        | x3        | Queensland        | $5,000   | $50,000  |
      | Audi       | A5        | New South Wales   | $10,000  | $60,000  |
      | Hyundai    | Imax      | South Australia   | $15,000  | $70,000  |
      | Mitsubishi | Outlander | Queensland        | $20,000  | $80,000  |
      | Honda      | Odyssey   | Western Australia | $25,000  | $90,000  |

#  @sanity
  Scenario Outline: Search the used car with model
    When I click "New" link
    Then I navigate to "New Cars" page
    And I select make "<make>"
#    And I select model "<model>"
    And I select location "<location>"
    And I select min price "<minPrice>"
    And I select max price "<maxPrice>"
    And I click on Find My Next Car tab
    Then I should see the make "<make>" in results
    Examples:
      | make       | model     | location          | minPrice | maxPrice |
      | BMW        | x3        | Queensland        | $5,000   | $50,000  |
      | Audi       | A5        | New South Wales   | $10,000  | $60,000  |
      | Hyundai    | Imax      | South Australia   | $15,000  | $70,000  |
      | Mitsubishi | Outlander | Queensland        | $20,000  | $80,000  |
      | Honda      | Odyssey   | Western Australia | $25,000  | $90,000  |


