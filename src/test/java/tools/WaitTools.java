package tools;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitTools {

    private WebDriver driver;
    public WaitTools(WebDriver driver){
        this.driver = driver;
    }
    public boolean  WaitForCondition(ExpectedCondition<WebElement> webElementExpectedCondition){
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10));
            return true;
        } catch (TimeoutException ignore){
            return false;
        }
    }
}
