package factory;

import exceptions.BrowserNotSupportedException;
import factory.impl.FirefoxDriverSettings;
import factory.impl.IDriverSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriveFactory {
    private String browserName = System.getProperty("browser.name");

    public WebDriver create() {
        browserName = browserName.toLowerCase();

        IDriverSettings settings = null;

        switch (browserName){
            case "firefox": {
                settings = new FirefoxDriverSettings();
                return new FirefoxDriver((FirefoxOptions) settings.settings());
            }
        }
        throw new BrowserNotSupportedException(browserName);
    }
}

