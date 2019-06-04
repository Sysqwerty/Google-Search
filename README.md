Sample Maven/Java/WebDriver project

WebDriver is used to have access to browser pages

For asserts TestNG framework is used

The Project contains implementation of:
- PageObject Pattern;
- PagFactory pattern;

Structure of the project:

2 packages: "page" and "test" for pageObject classes and test classes accordingly.

"page" package contains:
BasePage class which implements by all PageObjects.
GooglePage class describes start google page (elements and actions with them) "https://www.google.com".
ResultsPage class describes page with results after search is used.

"test" package contains:
BaseTest class contains @BeforeMethod() and @AfterMethod() which are run before and after each test method
GoogleSearchTest class is main class and contains all the test Actions which user does and asserts (Expected Results)

Added ability to run Maven commands via suites in TestNG xml files.

If you have installed on your Laptop Maven/JavaJDK, you can run base test via Maven command:

mvn clean test -DsuiteXmlFile=simple-search-Google-tests.xml