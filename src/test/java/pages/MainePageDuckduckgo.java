package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class MainePageDuckduckgo extends BasePage {
    private String duckduckgoUrl = System.getProperty("duckduckgo.url");
    private static final String TITLE = "ОТУС";
    @FindBy(xpath = "//input[@name='q']")
    private WebElement fieldInput;

    @FindBy(xpath = "//button[@class='searchbox_searchButton__F5Bwq iconButton_button__6x_9C']")
    private WebElement clickElement;

    public MainePageDuckduckgo(WebDriver driver) {
        super(driver);
    }

    // переход на сайт
    public MainePageDuckduckgo goTo(){
        driver.navigate().to(duckduckgoUrl);
        driver.get(duckduckgoUrl);
        return this;
    }

    // ввод в поле
    public MainePageDuckduckgo setInputText(){
        fieldInput.clear();
        fieldInput.sendKeys(TITLE);
        return this;
    }

    // кликнуть по кнопки
    public MainePageDuckduckgo clickElement (){
        clickElement.click();
        return this;
    }
}
