package driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.*;

import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    private WebDriver driver;

    public WebDriver getDriver(String browserName) {
        if (driver == null) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setPlatform(Platform.ANY);
            BrowserType browserType = getBrowserType(browserName.toUpperCase());

            switch (browserType) {
                case CHROME:
                    desiredCapabilities.setBrowserName(BrowserType.CHROME.getName());
                    break;
                case FIREFOX:
                    desiredCapabilities.setBrowserName(BrowserType.FIREFOX.getName());
                    break;
                case SAFARI:
                    desiredCapabilities.setBrowserName(BrowserType.SAFARI.getName());
                    break;
                case EDGE:
                    desiredCapabilities.setBrowserName(BrowserType.EDGE.getName());
                    break;
            }
            try {
                String hub = "http://localhost:4444/wd/hub";
                driver = new RemoteWebDriver(new URL(hub), desiredCapabilities);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                driver.manage().window().maximize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    private BrowserType getBrowserType(String browserName) {
        BrowserType browserType = null;
        try {
            browserType = BrowserType.valueOf(browserName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] Browser " + browserName + " is NOT supported");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return browserType;
    }
}
