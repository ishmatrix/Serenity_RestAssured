# new feature
# Tags: optional

Feature: Account Management

  Scenario: List all bank and credit card accounts for your organization.
    Given an authenticated user with an active session
    When searches for all active accounts
    Then a list of all the bank and credit card accounts is returned


  Scenario:Get a detailed look of the account specified
    Given an account id
    When bank info of that account are fetched
    Then return all the details for the specified bank account

  Scenario:Create a bank account or a credit card account for your organization.
    Given an a set if bank details
    When the new account details posted
    Then the account gets created
