package models.global.header.popup;

import models.component.Component;
import models.component.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector("#nav-al-your-account")
public class YourAccountComponent extends Component {

    private By signOutSel = By.cssSelector("#nav-item-signout");
    public YourAccountComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void clickOnSignOut(){
        clickToElement(signOutSel);
    }
}
