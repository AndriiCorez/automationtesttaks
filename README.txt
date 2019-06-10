Please read the following information before running the tests of the project.

The project is built using following technologies:
- Java
- Maven
- Cucumber
- Selenium Webdriver
- TestNG

The test framework uses following design patterns:
- Page Objects
- Page Factory
- Singleton
- Object relational model

The framework is configurable by test-settings.properties file, please put there any required properties before running tests.

By default project contains ChromeDriver executable for Windows OS, under the path specified in test-settings.properties file under 'chromeDriverPath' variable
But it is recommended to keep Selenium Webdriver executable out of the project. Also if you have any other OS than Windows please replace/add appropriate ChromeDriver.
Please specify path to executable in test-settings.properties file under 'chromeDriverPath' variable

Before running the project please make sure you have installed Java and Maven.
To run test with generating usable HTML report please use 'mvn clean verify' command.
To run tests and still have a basic HTML report please use 'mvn install'
HTML reports are generated under 'target' folder 'cucumber-report-html' and 'cucumber-reports' folders

To work in IDE the framework requires installation of Cucumber plugin.

The framework considers taking a screenshot of the Webpage at the moment test failure occurred.
Please find screenshots by path specified in test-settings.properties file under 'screenshotPath' variable

p.s. The framework considers running tests in Chrome headless mode, but the application behaves differently in headless mode than in browser one.
As far as headless mode wasn't a priority for the task, adjustment of the tests for headless mode is skipped.
Please use Chrome browser one specifying 'chrome' value in test-settings.properties file under 'driverType' variable
