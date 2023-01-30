package models.pages;

import models.global.header.NavFillComponent;
import models.global.header.NavLanguageComponent;
import models.global.header.NavRightComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isHomePageDisplayed(){
        return component.isDisplayed();
    }

    public NavRightComponent navRightComp(){
        return findComponent(NavRightComponent.class, driver);
    }

    public NavFillComponent navFillComp(){
        return findComponent(NavFillComponent.class, driver);
    }

    public NavLanguageComponent navLanguageComp(){
        return findComponent(NavLanguageComponent.class, driver);
    }
}
