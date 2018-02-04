# new feature
# Tags: optional

Feature: Search bank account details for an organization

  Scenario: List all bank and credit card accounts for your organization.
    Given an authenticated user with an active session
    When searches for all active accounts
    Then a list of all the bank and credit card accounts is returned