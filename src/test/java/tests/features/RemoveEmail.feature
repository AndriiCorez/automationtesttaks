Feature: Remove Email message

  Background:
    Given I sign in the application using correct credentials
    Given I get current number of incoming email messages

  Scenario: Remove email successfully
    When I send the following email to same test Gmail account if there is no Email messages on the list
      |subject    |body  |
      |Test Remove|Remove|
    When I Remove first email message on Inbox page
    Then I see number of incoming Email messages changed by "-1"