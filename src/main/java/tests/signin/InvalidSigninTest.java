package tests.signin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.common.DataObjectBuilder;
import test_data.signin.Account;
import test_flows.signin.SigninFlow;
import tests.BaseTest;
import url.Urls;

public class InvalidSigninTest extends BaseTest implements Urls {

    @Test(dataProvider = "invalidEmailData")
    public void testInvalidEmail(Account account) {
        WebDriver driver = getDriver();
        driver.get(baseURL.concat(signinSlug));
        SigninFlow signinFlow = new SigninFlow(driver);

        String invalidEmail = account.getEmail().trim();
        signinFlow.inputEmail(invalidEmail);
        signinFlow.verifyEmail(invalidEmail);
    }

    @Test(dataProvider = "invalidPasswordData")
    public void testInvalidPassword(Account account) {
        WebDriver driver = getDriver();
        driver.get(baseURL.concat(signinSlug));
        SigninFlow signinFlow = new SigninFlow(driver);

        String validEmail = account.getEmail().trim();
        String invalidPassword = account.getPassword();
        signinFlow.inputEmail(validEmail);
        signinFlow.inputPassword(invalidPassword);
        signinFlow.verifyPassword(invalidPassword);
    }

    @DataProvider
    private Account[] invalidEmailData() {
        String emailLocation = "/src/main/java/test_data/signin/InvalidEmail.json";
        Account[] accounts = DataObjectBuilder.buildDataObjectFrom(emailLocation, Account[].class);
        return accounts;
    }

    @DataProvider
    private Account[] invalidPasswordData() {
        String emailLocation = "/src/main/java/test_data/signin/InvalidPassword.json";
        Account[] accounts = DataObjectBuilder.buildDataObjectFrom(emailLocation, Account[].class);
        return accounts;
    }
}
