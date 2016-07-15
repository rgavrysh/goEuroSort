package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage extends BasePage{

    @FindBy(xpath = "//div[@id='results-train']//div[@class='result-content']")
    List<SearchResultPanel> resultPanels;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }


    public List<Float> getResultPricesAsList() {
        List<Float> resultPrices = new ArrayList<Float>();
        for(SearchResultPanel result : resultPanels){
            resultPrices.add(result.getTotalPrice());
        }
        return resultPrices;
    }
}
