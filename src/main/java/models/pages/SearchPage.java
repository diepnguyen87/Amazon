package models.pages;

import models.search.ResultListComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public ResultListComponent resultListComp(){
        return findComponent(ResultListComponent.class, driver);
    }
}
