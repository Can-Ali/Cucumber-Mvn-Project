Feature: Google search functionality
  Agile story: As a suserm when I am on the Google search page
  I should be able to search whatever I want and see relevant information

  @google
  Scenario: Search page title verification
    When user is on Google search page
    Then user should see title is Google

#  Scenario: Search functionality result title verification
#    Given user is on Google search page
#    When user types apple and clicks enter
#    Then user sees apple in the google title

  @google1
  Scenario: Search functionality result title verification
    Given user is on Google search page
    When user types "apple" and clicks enter
    Then user sees "apple" in the google title



