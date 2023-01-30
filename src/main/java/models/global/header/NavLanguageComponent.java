package models.global.header;

import models.component.Component;
import models.component.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@ComponentCssSelector("#nav-flyout-icp")
public class NavLanguageComponent extends Component {
    private By activeLanguageSel = By.cssSelector(".icp-radio-active");
    private String dynamicSelectLanguageStr = "//*[contains(text(), '%s')]/parent::span";
    public NavLanguageComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public String getActiveLanguage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(activeLanguageSel));
        return component.findElement(activeLanguageSel).getText();
    }

    public void selectLanguage(String value){
        String activeLanguage = getActiveLanguage();
        if(!activeLanguage.contains(value)){
            By dynamicSelectLanguageSel = convertFromDynamicSelector(dynamicSelectLanguageStr, value);
            wait.until(ExpectedConditions.elementToBeClickable(dynamicSelectLanguageSel));
            component.findElement(dynamicSelectLanguageSel).click();
        }
    }
}
