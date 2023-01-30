Feature: check login
  Background: commo steps in this feature file
    Given launch browser
    When launch url
@smoke
  Scenario: check login with valid credentials
    Then enter email
    And enter password
    And click login
    Then check home page title "Dashboard / nopCommerce administration"
    And click logout
    Then check login page title "Your store. Login"
    And close browser
@regression
Scenario Outline: check login with valid and invalid set of data
  Then enter email "<email>"
  And enter password "<password>"
  And click login
  And check login successful or not
  And close browser
    Examples:
            | email | password |
            | admin@yourstore.com | admin |
            | admin@yourstore.com | badmin |
            | dsd@gmail.com | admin |
            | fbgh@10mail.com | kadmin |
