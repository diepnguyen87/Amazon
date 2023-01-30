package tests.search;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.common.DataObjectBuilder;
import test_data.signin.Account;
import test_flows.global.header.SearchFlow;
import test_flows.signin.SigninFlow;
import tests.BaseTest;
import url.Urls;

public class SearchTest extends BaseTest implements Urls {

    @Test(dataProvider = "validAccountData")
    public void testSearch(Account account){
        WebDriver driver = getDriver();
        driver.get(baseURL.concat(signinSlug));
        SigninFlow signinFlow = new SigninFlow(driver);
        signinFlow.signin(account.getEmail(), account.getPassword());

        SearchFlow searchFlow = new SearchFlow(driver);
        searchFlow.selectDepartment("Books");
        searchFlow.selectLanguage("English");
        searchFlow.inputKeyword("apple");
        searchFlow.verifyNumOfResultItem(16);
    }

    @DataProvider
    private Account[] validAccountData() {
        String accountLocation = "/src/main/java/test_data/signin/ValidPassword.json";
        Account[] accounts = DataObjectBuilder.buildDataObjectFrom(accountLocation, Account[].class);
        return accounts;
    }
}
