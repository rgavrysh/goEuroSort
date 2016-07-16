package browserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {

    private String browserName = MavenProperties.getMavenProperty("browser_name");

    private WebDriverFactory() {
    }

    private static WebDriverFactory instance = new WebDriverFactory();

    public static WebDriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>() {
        @Override
        protected WebDriver initialValue() {
            if (browserName.toLowerCase().equals("chrome")) {
                return new ChromeDriver(getChromeCapabilities());
            } else if (browserName.toLowerCase().equals("firefox")) {
                return new FirefoxDriver();
            } else
                throw new WebDriverException("Not supported browser type - " + browserName);
        }
    };

    private DesiredCapabilities getChromeCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/seleniumDrivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("-incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        return capabilities;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void closeDriver() {
        driver.get().quit();
    }
}
