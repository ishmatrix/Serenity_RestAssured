Feature: The Google Places API Text Search Service is a web service that returns information about a set of places
based on a string — for example "pizza in New York" or "shoe stores near Ottawa" or "123 Main Street".
The service responds with a list of places matching the text string and any location bias that has been set.

  Scenario: Search text on Google Maps
    Given given condition
    When search text
    Then get size of the results