Feature: Sign in email account
  As user
  I want to be able to login the application
  So I can use its functionality

  Background:
    Given I sign in the application using correct credentials

  Scenario: Sign in successfully
    Then I'm on application Inbox page