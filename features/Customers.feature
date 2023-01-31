Feature: check customers
  Background: commo steps in this feature file
    Given launch browser
    When launch url
    Then enter email
    And enter password
    And click login

    @smoke @prod
    Scenario: add new customer
      Then click customers
      Then click customers second one
      Then click add new customer
      Then fill info
      Then seesucess alert is present or not
      And close browser