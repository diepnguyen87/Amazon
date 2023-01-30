package models.global.header;

import models.component.Component;
import models.component.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector("#nav-link-accountList")
public class AccountnListComponent extends Component {

    private By loginAccountSel = By.xpath("//*[contains(text(), 'Hello')]");
    private By AccountListSel = By.cssSelector("//*[contains(text(), 'Account & Lists')]");

    public AccountnListComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public String getLoginAccount(){
        return component.findElement(loginAccountSel).getText();
    }

}
