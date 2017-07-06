Feature: YaLoginFeature
  This feature deals with the yandex mail login functionality

  Scenario Outline: Login with correct username and password using scenario outline
    Given Navigate to the yandex login page
    When I enter valid <username> and <password>
    And I press login button
    Then I should see the yandex inbox page

    Examples:
      | username  | password    |
      | v.m.varga | Tasmania008 |