package test_flows.signin;

import models.global.header.AccountnListComponent;
import models.global.header.NavRightComponent;
import models.pages.HomePage;
import models.pages.SigninPage;
import models.signin.SignInComponent;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import test_data.common.DataObjectBuilder;
import test_data.signin.Account;
import test_data.signin.Alert;

import java.util.Arrays;
import java.util.List;

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

    public void verifyEmail(String invalidEmail) {
        SigninPage signinPage = new SigninPage(driver);
        if (invalidEmail.isEmpty()) {
            //verify invalid email client side
            verifyInvalidEmailClientSide(signinPage);
        } else {
            //verify invalid password server side
            verifyInvalidEmailServerSide(signinPage);
        }
    }

    public void verifyPassword(String invalidPassword) {

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SigninPage signinPage = new SigninPage(driver);
        if (invalidPassword.isEmpty()) {
            //verify invalid password client side
            verifyInvalidPasswordClientSide(signinPage);
        } else {
            //verify invalid password server side
            verifyInvalidPasswordServerSide(signinPage);
        }
    }

    private void verifyInvalidEmailServerSide(SigninPage signinPage) {
        SignInComponent signInComp = signinPage.signInComp();
        Alert actualAlert = new Alert();
        actualAlert.setHeader(signInComp.getHeader().trim());
        actualAlert.setContent(signInComp.getContent().trim());

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

        SignInComponent signInComp = signinPage.signInComp();
        Alert actualAlert = new Alert();
        actualAlert.setHeader(signInComp.getHeader().trim());
        actualAlert.setContent(signInComp.getContent().trim());

        boolean match = false;
        for (Alert alert : expectedServerSideAlert()) {
            String expectedHeader = alert.getHeader();
            String expectedContent = alert.getContent();
            if (expectedContent.equals(actualAlert.getContent())) {
                Assert.assertEquals(actualAlert.getHeader(), expectedHeader, "[ERROR] Mismatch alert header");
                Assert.assertEquals(actualAlert.getContent(), expectedContent);
                match = true;
                break;
            }
        }
        if(match == false){
            Assert.fail("[ERROR] Mismatch alert content does NOT map with expected list"
                    + "\nActual: " + actualAlert.getContent());
        }
    }

    private void verifyInvalidPasswordClientSide(SigninPage signinPage) {
        SignInComponent signInComp = signinPage.signInComp();
        String actualInlineAlert = signInComp.getInlineAlert();
        String expectedInlineAlert = "Enter your password";

        Assert.assertEquals(actualInlineAlert, expectedInlineAlert, "[ERROR] Mismatch inline alert content");
    }

    private List<Alert> expectedServerSideAlert() {
        String expectedLocation = "/src/main/java/test_data/signin/ExpectedServerSideAlert.json";
        Alert[] expectedAlerts = DataObjectBuilder.buildDataObjectFrom(expectedLocation, Alert[].class);
        return Arrays.asList(expectedAlerts);
    }

    public void verifyLoginSuccess(String expectedUserName) {
        HomePage homePage = new HomePage(driver);

        if(homePage.isHomePageDisplayed()){
            NavRightComponent navRightComp = homePage.navRightComp();
            String actualUserName = navRightComp.getLoginAccount();
            Assert.assertTrue(actualUserName.contains(expectedUserName));
        }else{
            Assert.fail("[ERROR] Login Failed");
        }
    }

    public void signin(String email, String password){
        inputEmail(email);
        inputPassword(password);
    }
}
