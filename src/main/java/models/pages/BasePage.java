package models.pages;

import models.component.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage extends Component {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        //super(driver, driver.findElement(By.tagName("html")));
        //super(driver, getElem());
        super(driver);
        By parent = By.tagName("html");
        By children = By.cssSelector("#authportal-main-section div");
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, children));
        component = driver.findElement(parent);
        this.driver = driver;
    }

    private WebElement getElem(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By parent = By.tagName("html");
        By children = By.cssSelector("");
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, children));
        return driver.findElement(parent);
    }
}
