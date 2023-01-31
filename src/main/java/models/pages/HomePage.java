package models.pages;

import models.global.header.NavFillComponent;
import models.global.header.popup.LanguageComponent;
import models.global.header.NavRightComponent;
import models.global.header.popup.YourAccountComponent;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private WebDriver driver;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public NavRightComponent navRightComp(){
        return findComponent(NavRightComponent.class, driver);
    }

    public NavFillComponent navFillComp(){
        return findComponent(NavFillComponent.class, driver);
    }

    public LanguageComponent popupLanguageComp(){
        return findComponent(LanguageComponent.class, driver);
    }

    public YourAccountComponent yourAccountComp(){
        return findComponent(YourAccountComponent.class, driver);
    }
}
