package test_flows.signin;

import models.pages.SigninPage;
import models.signin.AlertComponent;
import models.signin.SignInComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test_data.signin.Alert;

import java.time.Duration;

public class SigninFlow {

    private final WebDriver driver;

    public SigninFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmail(String email) {
        SigninPage signinPage = new SigninPage(driver);
        SignInComponent signInComp = signinPage.signInComp();

        signInComp.inputEmailAddress(email);
        signInComp.clickOnContinueBtn();
    }

    public void inputPassword(String invalidPassword) {
        SigninPage signinPage = new SigninPage(driver);
        SignInComponent signInComp = signinPage.signInComp();

        signInComp.inputPassword(invalidPassword);
        signInComp.clickOnSigninBtn();

    }

    public void verifyEmail(String invalidEmail){
        SigninPage signinPage = new SigninPage(driver);
        if(invalidEmail.isEmpty()){
            //verify invalid email client side
            verifyInvalidEmailClientSide(signinPage);
        }else{
            //verify invalid password server side
            verifyInvalidEmailServerSide(signinPage);
        }
    }

    public void verifyPassword(String invalidPassword) {
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By parent = By.cssSelector("#authportal-main-section");
        By child = By.cssSelector("#authportal-main-section div");
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, child));
*/
        SigninPage signinPage = new SigninPage(driver);
        if(invalidPassword.isEmpty()){
            //verify invalid password client side
            verifyInvalidPasswordClientSide(signinPage);
        }else{
            //verify invalid password server side
            verifyInvalidPasswordServerSide(signinPage);
        }
    }

    private void verifyInvalidEmailServerSide(SigninPage signinPage) {
        AlertComponent alertComp = signinPage.alertComp();
        Alert actualAlert = new Alert();
        actualAlert.setHeader(alertComp.getHeader().trim());
        actualAlert.setContent(alertComp.getContent().trim());

        Alert expectedAlert = new Alert();
        expectedAlert.setHeader("There was a problem");
        expectedAlert.setContent("We cannot find an account with that email address");

        Assert.assertEquals(actualAlert.getHeader(), expectedAlert.getHeader(), "[ERROR] Mismatch alert header");
        Assert.assertEquals(actualAlert.getContent(), expectedAlert.getContent(), "[ERROR] Mismatch alert content");
    }

    private void verifyInvalidEmailClientSide(SigninPage signinPage) {
        SignInComponent signInComp = signinPage.signInComp();
        String actualInlineAlert = signInComp.getInlineAlert();
        String expectedInlineAlert = "Enter your email or mobile phone number";

        Assert.assertEquals(actualInlineAlert, expectedInlineAlert, "[ERROR] Mismatch inline alert content");
    }

    private void verifyInvalidPasswordServerSide(SigninPage signinPage) {

        AlertComponent alertComp = signinPage.alertComp();
        Alert actualAlert = new Alert();
        actualAlert.setHeader(alertComp.getHeader().trim());
        actualAlert.setContent(alertComp.getContent().trim());

        Alert expectedAlert = new Alert();
        expectedAlert.setHeader("There was a problem");
        expectedAlert.setContent("We cannot find an account with that email address");

        Assert.assertEquals(actualAlert.getHeader(), expectedAlert.getHeader(), "[ERROR] Mismatch alert header");
        Assert.assertEquals(actualAlert.getContent(), expectedAlert.getContent(), "[ERROR] Mismatch alert content");
    }

    private void verifyInvalidPasswordClientSide(SigninPage signinPage) {
        SignInComponent signInComp = signinPage.signInComp();
        String actualInlineAlert = signInComp.getInlineAlert();
        String expectedInlineAlert = "Enter your password";

        Assert.assertEquals(actualInlineAlert, expectedInlineAlert, "[ERROR] Mismatch inline alert content");
    }
}
