# new feature
# Tags: optional

Feature: Get account details

  Scenario:Get a detailed look of the account specified
    Given an account id
    When bank info of that account are fetched
    Then return all the details for the specified bank account