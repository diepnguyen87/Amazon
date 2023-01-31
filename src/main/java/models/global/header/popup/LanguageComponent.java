package models.global.header.popup;

import models.component.Component;
import models.component.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector("#nav-flyout-icp")
public class LanguageComponent extends Component {
    private By activeLanguageSel = By.cssSelector(".icp-radio-active");
    private String dynamicSelectLanguageStr = "//*[contains(text(), '%s')]/parent::span";
    public LanguageComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public String getActiveLanguage(){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(activeLanguageSel));
        return findElement(activeLanguageSel).getText();
    }

    public void selectLanguage(String value){
        String activeLanguage = getActiveLanguage();
        if(!activeLanguage.contains(value)){
            By dynamicSelectLanguageSel = convertFromDynamicSelector(dynamicSelectLanguageStr, value);
            clickToElement(dynamicSelectLanguageSel);
        }
    }
}
