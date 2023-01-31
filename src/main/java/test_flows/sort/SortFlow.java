package test_flows.sort;

import models.pages.SearchPage;
import models.popup.SortByPopupComponent;
import models.search.ResultListComponent;
import models.search.SearchResultInfoBarComponent;
import org.openqa.selenium.WebDriver;

import java.util.Date;
import java.util.List;

public class SortFlow {

    private WebDriver driver;

    public SortFlow(WebDriver driver) {
        this.driver = driver;
    }

    public void sortByOption(String option) {
        SearchPage searchPage = new SearchPage(driver);
        SearchResultInfoBarComponent searchResultInfoBarComp = searchPage.searchResultInfoBarComp();
        searchResultInfoBarComp.clickOnSortBy();

        SortByPopupComponent sortByPopupComp = searchPage.sortByPopupComp();
        try{
            sortByPopupComp.selectSortOption(option);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public void isSortedByDesc() {
        SearchPage searchPage = new SearchPage(driver);
        ResultListComponent resultListComp = searchPage.resultListComp();
        List<Date> releaseOnDateList = resultListComp.releaseOnDateList();
        resultListComp.isSorted(releaseOnDateList);

        searchPage.navRightComp().hoverToAccountList();
        searchPage.yourAccountComp().clickOnSignOut();
    }
}
