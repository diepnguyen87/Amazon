package tests.signin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.common.DataObjectBuilder;
import test_data.signin.Account;
import test_flows.signin.SigninFlow;
import tests.BaseTest;
import url.Urls;

public class ValidSigninTest extends BaseTest implements Urls {

    @Test(dataProvider = "validAccountData")
    public void testValidSignin(Account account){
        WebDriver driver = getDriver();
        driver.get(baseURL.concat(signinSlug));
        SigninFlow signinFlow = new SigninFlow(driver);

        signinFlow.inputEmail(account.getEmail());
        signinFlow.inputPassword(account.getPassword());
        signinFlow.verifyLoginSuccess(account.getUserName());
    }

    @DataProvider
    private Account[] validAccountData() {
        String accountLocation = "/src/main/java/test_data/signin/ValidPassword.json";
        Account[] accounts = DataObjectBuilder.buildDataObjectFrom(accountLocation, Account[].class);
        return accounts;
    }
}
