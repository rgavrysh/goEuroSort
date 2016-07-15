# GoEuro price sort test.
This is simple demo test-framework which consists from one test. The test verifies that price sorting is valid on search result page.

Test is built using Java + Maven + Selenium + TestNG.

Additional frameworks ([htmlelements] (https://github.com/yandex-qatools/htmlelements), [guava] (https://github.com/google/guava)) were used to simplify implementation (like page initialisation, webElements typisation etc.).

Chrome is using as default browser.

Java and Maven are required to be installed.

To execute the test:
* Copy project
* Path to the folder of copied project in the console
* execute command: 
```shell 
mvn clean test
```
