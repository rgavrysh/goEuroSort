package resultsPageTests;

import org.testng.annotations.DataProvider;

public final class TestDataProvider {

    @DataProvider(name = "searchParameters")
    public static Object[][] searchParameters(){
        return new Object[][]{{"Berlin", "Prague"}};
    }
}
