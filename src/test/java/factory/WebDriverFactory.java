package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    private WebDriverFactory() {
    }

    private static WebDriverFactory instance = new WebDriverFactory();

    public static WebDriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(){
        @Override
        protected WebDriver initialValue() {
            System.setProperty("webdriver.chrome.driver",
                    "src/test/resources/seleniumDrivers/chromedriver");
            return new ChromeDriver();
        }
    };

    public WebDriver getDriver() {
        return driver.get();
    }

    public void closeDriver(){
        driver.get().quit();
    }
}
