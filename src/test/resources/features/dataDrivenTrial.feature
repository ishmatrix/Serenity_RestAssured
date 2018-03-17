#Datadriven testing using cucumber
Feature: Enable learning of data driven testing  using feature files

  #Simple inline data driven
  Scenario: Simple data driven testing
    Given some pre-requisite information
    When I pass param "param1" and "param2"
    Then display both of these

  #Using examples keywords
  Scenario Outline: Using Examples keyword to pass multiple test data
    When we pass "<username>" and "<password>" with "<number>"
    Then display both of these

    Examples:
      | username | password | number   |
      | alpha    | pass1    | 345.3453 |
      | beta     | pass2    | 12       |

  #Using data table with List
  Scenario: Another way of passing data using DataTable
    Given some pre-requisite information
    When user enters username and password
      | ish@ish.com | password1 |

  #Using data driven with List of Maps
  Scenario: Let's try doing by List of Maps
    Then we will pass a set of data
      | username | password | mobNum    | id   |
      | ish      | pass1    | 987654321 | 1234 |
      | john     | pass2    | 123456789 | 4321 |