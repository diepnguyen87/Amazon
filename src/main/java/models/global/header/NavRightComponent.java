package models.global.header;

import models.component.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector("#nav-belt .nav-right")
public class NavRightComponent extends AccountnListComponent {
    private WebDriver driver;
    private By chooseLanguageSel = By.xpath("//*[@aria-label='Choose a language for shopping.']");

    public NavRightComponent(WebDriver driver, WebElement component) {
        super(driver, component);
        this.driver = driver;
    }

    public AccountnListComponent accountnListComp(){
        return findComponent(AccountnListComponent.class, driver);
    }

    public void hoverToLanguage(){
        hoverToElement(chooseLanguageSel);
    }
}
