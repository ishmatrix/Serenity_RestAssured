Feature:To be able to search for country name using country code
  Scenario: Search a country name
    Given The CODE of the country
    When Search country code by
    Then Verify the request was successful and country