package models.pages;

import models.signin.AlertComponent;
import models.signin.SignInComponent;
import org.openqa.selenium.WebDriver;

public class SigninPage extends BasePage{

    public SigninPage(WebDriver driver) {
        super(driver);
    }

    public SignInComponent signInComp(){
        return findComponent(SignInComponent.class, driver);
    }

    public AlertComponent alertComp(){
        return findComponent(AlertComponent.class, driver);
    }
}
