package models.search;

import models.component.Component;
import models.component.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector(".rush-component")
public class SearchResultInfoBarComponent extends Component {
    private By sortBySel = By.cssSelector(".a-dropdown-container");
    public SearchResultInfoBarComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }
    public void clickOnSortBy(){
        findElement(sortBySel).click();
    }
}
