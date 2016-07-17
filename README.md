# GoEuro price sort test.
This is simple demo test-framework which consists from one test. The test verifies that price sorting is valid on search result page.

Test is built using Java + Maven + Selenium + TestNG.

Additional frameworks were used to simplify implementation:
* [htmlelements] (https://github.com/yandex-qatools/htmlelements) - this library allows me to divide complex page to different modules (as an objects), it has cascade lazy initialization, typization of elements, etc.
In this particular example SearchResultPanel was extracted. It gives us more flexibility (for example if we need to book tickets we wil do it directly from particular resultPanel object), readability, less code in one class.
* [guava] (https://github.com/google/guava) - this was added to simplify work with collections (just not to implement new wheels).
* [extentreports] (https://github.com/anshooarora/extentreports) - allows to build nice looking interactive report. (basically I suggest to use [Allure] (https://github.com/allure-framework/) report framework which has a lot of features, but as a practice I decided to use Extent which is quite good as well).

Chrome is using as default browser. There is a possibility to run on Firefox browser using maven property.

Java and Maven are required to be installed.

To execute the test:
* Copy project
* Path to the folder of copied project in the console
* execute command: 
```shell 
mvn clean test
```
to run test using Firefox add parameter 'browser_name'
```shell
mvn clean test -Dbrowser_name="firefox"
```


#Reporting
As a reporting tool [ExtentReport] (https://github.com/anshooarora/extentreports) have been used.
To view test results report open target/surefire-reports/Extent.html.

#What next:
* I do not really like the way how prices are collected in current version (reading text from WebElement), it quite slow and not very reliable. In such situations I'd like to use JS functions to get data and execute it by (WebDriver) JavaScriptExecutor. Unfortunately I could't find the way to fetch the data (I need help from your devs).
* There are no waits now (I didn't need it so far), but in general, appart from basic fluent waits I like to use [webElement matchers] (https://github.com/yandex-qatools/matchers-java/tree/master/webdriver-matchers), and JS flags which are responsible for actions (for example resultsLoaded.train return true if results are loaded) combining with custom waits.
