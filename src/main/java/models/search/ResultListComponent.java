package models.search;

import models.component.Component;
import models.component.ComponentxPathSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@ComponentxPathSelector("//div[contains(@class, 's-search-results')]")
public class ResultListComponent extends Component {

    private By itemResultListSel = By.xpath("//div[@data-asin[not(.='')]]");
    public ResultListComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public List<WebElement> itemResultList(){
        return component.findElements(itemResultListSel);
    }
}
