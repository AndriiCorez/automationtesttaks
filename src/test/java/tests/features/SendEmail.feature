Feature: Sign in email account

  Background:
    Given I sign in the application using correct credentials

  Scenario: Send email successfully
    When I send the following email to same test Gmail account
    |subject|body  |
    |Test S |test B|
    Then I see popup message with "Message sent." text on Inbox page
    Then I can see new email with "Test S" subject appeared in incoming mail list