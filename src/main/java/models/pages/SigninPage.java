package models.pages;

import models.signin.SignInComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SigninPage extends BasePage{

    public SigninPage(WebDriver driver) {
        super(driver);
    }

    public SignInComponent signInComp(){
        return findComponent(SignInComponent.class, driver);
    }

}
