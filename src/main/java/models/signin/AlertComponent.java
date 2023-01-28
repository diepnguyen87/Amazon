package models.signin;

import models.component.Component;
import models.component.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@ComponentCssSelector("#authportal-main-section .auth-server-side-message-box .a-alert-container")
public class AlertComponent extends Component {
    private By headerSel = By.cssSelector(".a-alert-heading");
    private By contentSel = By.cssSelector(".a-alert-content");

    public AlertComponent(WebDriver driver, WebElement component) {
        super(driver, component);
        //wait.until(ExpectedConditions.visibilityOf(component));
    }

    public String getHeader(){
        return component.findElement(headerSel).getText().trim();
    }

    public String getContent(){
        return component.findElement(contentSel).getText().trim();
    }
}
