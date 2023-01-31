package models.global.header;

import models.component.Component;
import models.component.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector("#nav-belt .nav-right")
public class NavRightComponent extends Component {
    private WebDriver driver;
    private By chooseLanguageSel = By.xpath("//*[@aria-label='Choose a language for shopping.']");
    private By loginAccountSel = By.xpath("//*[contains(text(), 'Hello')]");
    private By accountListSel = By.xpath("//*[contains(text(), 'Account & Lists')]");

    public NavRightComponent(WebDriver driver, WebElement component) {
        super(driver, component);
        this.driver = driver;
    }

    public void hoverToLanguage(){
        hoverToElement(chooseLanguageSel);
    }

    public String getLoginAccount() {
        return getElementText(loginAccountSel);
    }

    public void hoverToAccountList() {
        hoverToElement(accountListSel);
    }
}
