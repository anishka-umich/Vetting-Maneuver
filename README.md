# Vetting-Maneuver

The instructions for running the Online Shopping Store can be found here https://github.com/zhulinn/SpringBoot-Angular7-Online-Shopping-Store#how-to--run

To run Selenium:
1. Import the CucumberSelenium project
2. Download the appropriate WebDriver for your browser https://www.selenium.dev/downloads/#:~:text=Platforms%20Supported%20by%20Selenium
3. Put the WebDriver in CucumberSelenium/src/test/resources/Drivers/ (note: If you are not using ChromeDriver, you will need to update the StepDefinitions classes accordingly)
4. Make sure the Online Shopping Store application is running locally on your machine
5. Right-click the CucumberSelenium project and do Run As JUnit Test

To generate Maven Cucumber Report (Windows):
1. Make sure the Online Shopping Store application is running locally on your machine
2. In your terminal, change to the CucumberSelenium directory
3. Run "mvn clean verify" without any quotes and the report will be generated in target/cucumber-report-html/cucumber-html-reports/
