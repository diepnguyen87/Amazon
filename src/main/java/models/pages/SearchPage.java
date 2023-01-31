package models.pages;

import models.global.header.NavRightComponent;
import models.global.header.popup.YourAccountComponent;
import models.popup.SortByPopupComponent;
import models.search.ResultListComponent;
import models.search.SearchResultInfoBarComponent;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ResultListComponent resultListComp(){
        return findComponent(ResultListComponent.class, driver);
    }

    public SearchResultInfoBarComponent searchResultInfoBarComp(){
        return findComponent(SearchResultInfoBarComponent.class, driver);
    }
    public SortByPopupComponent sortByPopupComp(){
        return findComponent(SortByPopupComponent.class, driver);
    }

    public NavRightComponent navRightComp(){
        return findComponent(NavRightComponent.class, driver);
    }

    public YourAccountComponent yourAccountComp(){
        return findComponent(YourAccountComponent.class, driver);
    }
}
