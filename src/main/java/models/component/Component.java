package models.component;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Constructor;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class Component {
    protected WebDriver driver;
    protected WebElement component;
    protected WebDriverWait wait;
    protected Actions actions;
    protected JavascriptExecutor jsExecutor;

    public Component(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        jsExecutor = ((JavascriptExecutor) driver);
        actions = new Actions(driver);
    }

    public Component(WebDriver driver, WebElement component) {
        this(driver);
        this.component = component;
    }

    public WebElement getComponent() {
        return component;
    }

    public WebElement findElement(By by) {
        WebElement elem = null;
        try {
            elem = component.findElement(by);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("[ERROR] - Can NOT find the selector " + by);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elem;
    }

    public List<WebElement> findElements(By by) {
        return component.findElements(by);
    }

    public void clickOnElementByJavascript(By by) {
        WebElement elem = component.findElement(by);
        jsExecutor.executeScript("arguments[0].click();", elem);
    }

    public <T extends Component> T findComponent(Class<T> componentClass, WebDriver driver) {
        return findComponents(componentClass, driver).get(0);
    }

    public <T extends Component> List<T> findComponents(Class<T> componentClass, WebDriver driver) {
        By componentSelector;
        try {
            componentSelector = getComponentSelector(componentClass);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] - The component must have CSS Selector");
        }

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(componentSelector));

        List<WebElement> results = component.findElements(componentSelector);
        Class<?>[] params = new Class[]{WebDriver.class, WebElement.class};
        Constructor<T> constructor;

        try {
            constructor = componentClass.getConstructor(params);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] - The component must have constructor with params: " + Arrays.toString(params));
        }

        List<T> components = results.stream().map(webElement -> {
            try {
                return constructor.newInstance(driver, webElement);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
        return components;
    }

    private By getComponentSelector(Class<? extends Component> componentClass) {
        if (componentClass.isAnnotationPresent(ComponentCssSelector.class)) {
            return By.cssSelector(componentClass.getAnnotation(ComponentCssSelector.class).value());
        } else if (componentClass.isAnnotationPresent(ComponentxPathSelector.class)) {
            return By.xpath(componentClass.getAnnotation(ComponentxPathSelector.class).value());
        } else {
            throw new IllegalArgumentException("[ERROR] Component Class " + componentClass + " must have annotation " +
                    ComponentCssSelector.class.getSimpleName() + " or " + ComponentxPathSelector.class.getSimpleName());
        }
    }

    public void scrollUpToElement(WebElement element) {
        scrollToElement("false", element);
    }

    public void scrollDownToElement(WebElement element) {
        scrollToElement("true", element);
    }

    private void scrollToElement(String position, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(" + position + ");", element);
    }

    public void selectByVisibleText(By by, String value) {
        WebElement dropdownElem = findElement(by);
        Select select = new Select(dropdownElem);
        select.selectByVisibleText(value);
    }

    public By convertFromDynamicSelector(String selector, String value) {
        return By.xpath(String.format(selector, value));
    }

    public void hoverToElement(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        actions.moveToElement(findElement(by)).build().perform();
    }

    public boolean isSorted(List<Date> listOfDate) {
        if (listOfDate.isEmpty() || listOfDate.size() == 1) {
            return true;
        }

        Iterator<Date> iter = listOfDate.iterator();
        Date current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.compareTo(current) < 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    public String getElementText(By by) {
        return findElement(by).getText();
    }

    public void clickToElement(By by) {
        findElement(by).click();
    }

    public boolean isDisplayed() {
        return component.isDisplayed();
    }
}
