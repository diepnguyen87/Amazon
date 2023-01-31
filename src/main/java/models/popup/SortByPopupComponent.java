package models.popup;

import models.component.Component;
import models.component.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".a-dropdown")
public class SortByPopupComponent extends Component {

    private String dynamicSortOptionStr = "//*[contains(text(), '%s')]";
    public SortByPopupComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void selectSortOption(String option){
        By sortOptionSel = convertFromDynamicSelector(dynamicSortOptionStr, option);
        findElement(sortOptionSel).click();
    }
}
