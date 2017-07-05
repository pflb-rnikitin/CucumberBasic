Feature: LoginFeature
  This feature deals with the login functionality

  Scenario: Login with correct username and password
    Given I navigate to the login page
    And I enter the users email address as email:admin
    And I enter the following authentication credentials
      | username  | password    |
      | v.m.varga | Tasmania008 |
    And I click login button
    Then I should see the inbox page

  Scenario Outline: Login with correct username and password using scenario outline
    Given I navigate to the login page
    And I enter the <username> and <password>
    And I click login button
    Then I should see the inbox page

    Examples:
      | username  | password    |
      | v.m.varga | Tasmania008 |
      | wrongname | wrongpass   |