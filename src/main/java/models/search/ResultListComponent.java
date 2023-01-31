package models.search;

import models.component.Component;
import models.component.ComponentxPathSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ComponentxPathSelector("//div[contains(@class, 's-search-results')]")
public class ResultListComponent extends Component {

    private By itemResultListSel = By.xpath("//div[@data-asin[not(.='')]]");
    private By releaseOnDateSel = By.xpath("//div[contains(@class, 'top-micro')]//*[contains(text(), 'released on')]");
    public ResultListComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public List<WebElement> itemResultList(){
        return findElements(itemResultListSel);
    }

    public List<Date> releaseOnDateList(){
        List<WebElement> releaseOnDateElems = findElements(releaseOnDateSel);
        List<Date> releaseOnDateList = new ArrayList<>();

        for (WebElement element : releaseOnDateElems) {
            String releaseOnDateStr = element.getText();
            int startIndex = releaseOnDateStr.indexOf("on") + 3;
            int endIndex = releaseOnDateStr.length() - 1;

            releaseOnDateStr = releaseOnDateStr.substring(startIndex, endIndex);
            SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
            try {
                Date date = sdf.parse(releaseOnDateStr);
                releaseOnDateList.add(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return releaseOnDateList;
    }

}
