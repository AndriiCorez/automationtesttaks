Feature: Send Email

  Background:
    Given I sign in the application using correct credentials
    Given I get current number of incoming email messages

  Scenario: Send email successfully
    When I send the following email to same test Gmail account
    |subject  |body  |
    |Test Send|test B|
    Then I see popup message with "Message sent." text on Inbox page
    Then I see number of incoming Email messages changed by "1"
    Then I can see new email with "Test Send" subject appeared in incoming mail list