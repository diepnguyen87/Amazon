package models.global.header;

import models.component.Component;
import models.component.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector("#nav-belt .nav-fill")
public class NavFillComponent extends Component {
    private WebDriver driver;
    private By departmentDropdownSel = By.cssSelector("#searchDropdownBox");
    private By departmentDropdownOptionSel = By.xpath("//select[@id='searchDropdownBox']/option[contains(text(), 'Books')]");
    private By searchFieldSel = By.cssSelector("#twotabsearchtextbox");
    private By searchSubmitSel = By.cssSelector("#nav-search-submit-button");


    public NavFillComponent(WebDriver driver, WebElement component) {
        super(driver, component);
        this.driver = driver;
    }

    public void selectDepartmentByVisibleText(String value){
        try{
            selectByVisibleText(departmentDropdownSel, value);
        }catch (NullPointerException e){
            throw new NullPointerException("[ERROR] " + departmentDropdownSel + " is null");
        }
    }

    public  void inputSearchField(String value){
        WebElement searchElem = findElement(searchFieldSel);
        searchElem.sendKeys(value);
    }

    public void clickOnSearchSubmitBtn(){
        component.findElement(searchSubmitSel).click();
    }
}
