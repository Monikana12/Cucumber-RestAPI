Feature: Login  page field vaildation

  Scenario: UI validation for login
    Given I open the browser and navigate to facebook login page
    When I land on facebook homepage i vaildate login page is displayed
    Then I vaildate email or phone field is displayed
    Then I vaildate password field is displayed
    Then I vaildation Login button is displayed
    Then I quit the browser



