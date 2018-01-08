
Feature: Log in to Portal application
  

  Scenario: Log in with valid credentials
    Given I open firefox
    And I open application
    When I enter valid username
    And valid password
    And Click Sign In button
    Then User dashboard should be displayed
