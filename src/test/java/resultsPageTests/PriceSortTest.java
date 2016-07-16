package resultsPageTests;

import com.google.common.collect.Ordering;
import browserSetup.WebDriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.GoEuroHome;
import pages.SearchResultPage;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class PriceSortTest {

    @Test(dataProvider = "searchParameters", dataProviderClass = TestDataProvider.class)
    public void priceSortVerification(String departureCity, String destinationCity){
        GoEuroHome goEuroHome = new GoEuroHome(WebDriverFactory.getInstance().getDriver());
        goEuroHome.open();
        SearchResultPage searchResultPage = goEuroHome.enterDeparture(departureCity)
                .enterDestination(destinationCity)
                .uncheckAirbnb()
                .search();
        List<Float> resultPrices = searchResultPage.getResultPricesAsList();
        System.out.println(resultPrices);
        assertTrue(Ordering.natural().isOrdered(resultPrices), "List is not ordered.");
    }

    @AfterMethod
    public void tearDown(){
        WebDriverFactory.getInstance().closeDriver();
    }
}
