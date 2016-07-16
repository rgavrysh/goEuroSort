# GoEuro price sort test.
This is simple demo test-framework which consists from one test. The test verifies that price sorting is valid on search result page.

Test is built using Java + Maven + Selenium + TestNG.

Additional frameworks ([htmlelements] (https://github.com/yandex-qatools/htmlelements), [guava] (https://github.com/google/guava)) were used to simplify implementation (like page initialisation, webElements typisation etc.).

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
