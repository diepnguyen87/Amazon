package test_flows.global.header;

import models.global.header.NavFillComponent;
import models.global.header.NavLanguageComponent;
import models.global.header.NavRightComponent;
import models.pages.HomePage;
import models.pages.SearchPage;
import models.search.ResultListComponent;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchFlow {

    private WebDriver driver;
    public SearchFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void selectDepartment(String departmentName) {
        HomePage homePage = new HomePage(driver);
        NavFillComponent navFillComp = homePage.navFillComp();
        navFillComp.selectDepartmentByVisbleText(departmentName);
    }

    public void inputKeyword(String keyword) {
        HomePage homePage = new HomePage(driver);
        NavFillComponent navFillComp = homePage.navFillComp();
        navFillComp.inputSearchField(keyword);
        navFillComp.clickOnSearchSubmitBtn();
    }

    public void selectLanguage(String expectedLanguage) {
        HomePage homePage = new HomePage(driver);
        NavRightComponent navRightComp = homePage.navRightComp();
        navRightComp.hoverToLanguage();

        NavLanguageComponent navLanguageComp = homePage.navLanguageComp();
        navLanguageComp.selectLanguage(expectedLanguage);
    }

    public void verifyNumOfResultItem(int expectedSize) {
        SearchPage searchPage = new SearchPage(driver);
        ResultListComponent resultListComp = searchPage.resultListComp();
        int actualSize = resultListComp.itemResultList().size();
        Assert.assertEquals(actualSize, expectedSize);
    }
}
