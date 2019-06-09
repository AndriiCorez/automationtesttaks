Feature: Remove Email message

  Background:
    Given I sign in the application using correct credentials

  Scenario: Remove email successfully
    When I send the following email to same test Gmail account
      |subject|body  |
      |Test D |Remove|
    When I Remove first email message on Inbox page
    Then There is no more incoming email messages on Inbox page