package models.global.header;

import models.component.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;

@ComponentCssSelector("#nav-belt .nav-fill")
public class NavFillComponent extends AccountnListComponent {
    private WebDriver driver;
    private By departmentDropdownSel = By.cssSelector("#searchDropdownBox");
    private By searchFieldSel = By.cssSelector("#twotabsearchtextbox");
    private By searchSubmitSel = By.cssSelector("#nav-search-submit-button");


    public NavFillComponent(WebDriver driver, WebElement component) {
        super(driver, component);
        this.driver = driver;
    }

    public void selectDepartmentByVisbleText(String value){
        selectByVisibleText(departmentDropdownSel, value);
    }

    public  void inputSearchField(String value){
        WebElement searchElem = component.findElement(searchFieldSel);
        searchElem.sendKeys(value);
    }

    public void clickOnSearchSubmitBtn(){
        component.findElement(searchSubmitSel).click();
    }
}
