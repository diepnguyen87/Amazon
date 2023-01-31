package models.signin;

import models.component.Component;
import models.component.ComponentCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@ComponentCssSelector("#authportal-main-section")
public class SignInComponent extends Component {

    private final By emailSel = By.cssSelector("[type='email']");
    private final By passwordSel = By.cssSelector("[type='password']");
    private final By continueSel = By.id("continue");
    private final By signinSel = By.id("signInSubmit");

    private final By inlineAlertSel = By.cssSelector("form .a-alert-container .a-alert-content");
    private By headerSel = By.cssSelector(".a-alert-heading");
    private By contentSel = By.cssSelector(".a-alert-content");

    public SignInComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public void inputEmailAddress(String email){
        WebElement emailElem = findElement(emailSel);
        emailElem.sendKeys(email);
    }

    public void inputPassword(String password){
        WebElement emailElem = findElement(passwordSel);
        emailElem.sendKeys(password);
    }

    public void clickOnContinueBtn(){
        findElement(continueSel).click();
    }

    public void clickOnSigninBtn(){
        findElement(signinSel).click();
    }

    public String getInlineAlert(){
        return findElement(inlineAlertSel).getText().trim();
    }

    public String getHeader(){
        return findElement(headerSel).getText().trim();
    }

    public String getContent(){
        return findElement(contentSel).getText().trim();
    }

}
