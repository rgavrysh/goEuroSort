package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class GoEuroHome extends BasePage{
    @FindBy(id = "from_filter")
    private TextInput departureInput;

    @FindBy(id = "to_filter")
    private TextInput destinationInput;

    @FindBy(id = "search-form__submit-btn")
    private Button searchButton;

    @FindBy(xpath = "//div[@class='hotel-checkbox']")
    private CheckBox airbnbCheckbox;

    private WebDriver driver;
    public GoEuroHome(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    public GoEuroHome open() {
        driver.get("http://www.goeuro.com/");
        return this;
    }

    public GoEuroHome enterDeparture(String departure) {
        departureInput.sendKeys(departure);
        departureInput.sendKeys(Keys.ENTER);
        return this;
    }

    public GoEuroHome enterDestination(String destination) {
        destinationInput.sendKeys(destination);
        destinationInput.sendKeys(Keys.ENTER);
        return this;
    }

    public GoEuroHome uncheckAirbnb() {
        airbnbCheckbox.click();
        return this;
    }

    public SearchResultPage search() {
        searchButton.click();
        return new SearchResultPage(driver);
    }
}
