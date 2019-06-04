Sample Maven/Java/WebDriver project

WebDriver is used to have access to browser pages

For asserts TestNG framework is used

The Project contains implementation of:
- PageObject Pattern;
- PagFactory pattern;

Added ability to run Maven commands via suites in TestNG xml filesю

If you have installed on your Laptop Maven/JavaJDK, you can run base test via Maven command:
mvn clean test -DsuiteXmlFile=simple-search-Google-tests.xml