package pages;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

public class SearchResultPanel extends HtmlElement {
    @FindBy(xpath = ".//span[@class='currency-beforecomma']")
    private TextBlock priceBeforeComma;

    @FindBy(xpath = ".//span[@class='currency-decimals'][2]")
    private TextBlock priceDecimals;

    public Float getTotalPrice() {
        return Float.valueOf(priceBeforeComma.getText()
                .concat(".")
                .concat(priceDecimals.getText()));
    }
}
