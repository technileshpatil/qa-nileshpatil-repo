# qa-nileshpatil-repo
This framework is to validate the fake news in other sources like google, bing. 
---

## Tools and Libraries
This project mostly use Selenium and Cucumber
The complete list of tooling/libraries can be see in the `pom.xml` 

## Requirement
* JDK
* Maven
* WebDriver

# How to run Tests
* Clone the repo
* Open the project using any Java IDE as pom.xml project
* Run the tests with the script below
```shell
$ mvn clean install
```
* If you want to run the specific test, use the cucumber tags like this
```shell
$ mvn clean install -Dcucumber.filter.tags="@REPLACE_WITH_YOUR_TAGS"
```
* If mvn clean install does not work in you local then simply run this
```shell
$ TestRunner.java or src/test/resources/suites
```
* Run the tests with docker
```shell
$ docker build .
```

## Test Results
* Test report automatically generated on `target` folder after finished the test execution
* See test report from `target/cucumber-reports/advanced-reports/cucumber-html-reports/overview-features.html`
* You can also share your Cucumber Report with another person at https://reports.cucumber.io, just go to `src/test/resources/cucumber.properties` then change the value to be `true`
```properties
cucumber.publish.enabled=true
```
Example for of failed report https://reports.cucumber.io/reports/8ddeafa6-2943-473f-8f33-45d679f5662a
