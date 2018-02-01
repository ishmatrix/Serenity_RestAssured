Feature: Tweeting
  User should be able to post, view and delete their own tweets using their personal twitter account

  Scenario:Post a tweet
    Given the authentication tokens for a twitter account
    When the user posts
    Then the tweet is posted successfully

  Scenario:Search the latest tweet
    Given the authentication tokens for a twitter account
    When the  GET request for the latest tweet is sent
    Then the  latest tweet is retrieved successfully