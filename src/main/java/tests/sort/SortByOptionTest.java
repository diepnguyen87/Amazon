package tests.sort;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.common.DataObjectBuilder;
import test_data.signin.Account;
import test_flows.global.header.SearchFlow;
import test_flows.signin.SigninFlow;
import test_flows.sort.SortFlow;
import tests.BaseTest;
import url.Urls;

public class SortByOptionTest extends BaseTest implements Urls {

    @Test(dataProvider = "validAccountData")
    public void testSortByOption(Account account) {
        WebDriver driver = getDriver();
        driver.get(baseURL.concat(signinSlug));
        SigninFlow signinFlow = new SigninFlow(driver);
        signinFlow.login(account.getEmail(), account.getPassword());

        SearchFlow searchFlow = new SearchFlow(driver);
        searchFlow.searchByDepartment("Books", "apple");

        SortFlow sortFlow = new SortFlow(driver);
        sortFlow.sortByOption("Publication Date");
        sortFlow.isSortedByDesc();
    }

    @DataProvider
    private Account[] validAccountData() {
        String accountLocation = "/src/main/java/test_data/signin/ValidPassword.json";
        Account[] accounts = DataObjectBuilder.buildDataObjectFrom(accountLocation, Account[].class);
        return accounts;
    }
}
