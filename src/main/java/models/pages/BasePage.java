package models.pages;

import models.component.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends Component {

    protected By parent;
    public BasePage(WebDriver driver) {
        super(driver);
        parent = By.tagName("html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(parent));
        component = driver.findElement(parent);
    }
}
