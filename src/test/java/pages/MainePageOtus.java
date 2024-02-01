package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tools.WaitTools;

public class MainePageOtus extends BasePage {


    public MainePageOtus(WebDriver driver) {
        super(driver);
    }

    private String otusUrl = System.getProperty("otus.Url");
    private String email = System.getProperty("email");
    private String password = System.getProperty("password");


    // переход на сайт
    public MainePageOtus goTo(){
        driver.navigate().to(otusUrl);
        driver.get(otusUrl);
        return this;
    }

    // размер экрана
    public MainePageOtus maximize(){
        driver.manage().window().maximize();
        return this;
    }
    // размер экрана
    public MainePageOtus getSize(){
        System.out.println(driver.manage().window().getSize());
        return this;
    }

    //Проверка что PopupElement нету, компонента регистрации "Войдите в свой акаунт"
    public MainePageOtus PopupElement(){
        WebElement PopupElementCss = driver.findElement(By.cssSelector("#__PORTAL__>div"));
        Assertions.assertTrue(!PopupElementCss.isDisplayed(),"PopupElement не отображается");
        return this;
    }

    //Ожидание элемента кнопка войти
    public MainePageOtus implicitlyWaitButton(){
        waitVisibility(By.xpath("//button[text()='Войти']"));
        return this;
    }

    // кликнуть по кнопки
    public MainePageOtus clickElementEnter(){
        driver.findElement(By.xpath("//button[text()='Войти']")).click();
        return this;
    }

    //Проверка PopupElement есть, компонента регистрации "Войдите в свой акаунт"
    public MainePageOtus PopupElementI(){
        WebElement PopupElementCss = driver.findElement(By.cssSelector("#__PORTAL__>div"));
        Assertions.assertTrue(PopupElementCss.isDisplayed(),"PopupElement is not displayed");
        return this;
    }


    // ввод в поле email
    public MainePageOtus authorizationEmail(){
        WebElement emailInputSelector = driver.findElement(By.cssSelector("input[name = 'email']"));
        emailInputSelector.sendKeys(email);
       return this;
    }
    // ввод в поле password
    public MainePageOtus authorizationPassword(){
        WebElement passwordInputSelector = driver.findElement(By.cssSelector("input[type='password']"));
        passwordInputSelector.sendKeys(password);
        return this;
    }

    // кликнуть по кнопки
    public MainePageOtus clickElementEnterEnter(){
        WebElement clickElementEnterEnter = driver.findElement(By.cssSelector("#__PORTAL__ button"));
        clickElementEnterEnter.click();
        return this;
    }

    //Проверка что нет кнопки "Войти"
    public MainePageOtus ThereIsNoButton(){
        waitTools(By.cssSelector("input[name = 'email']"));
        return this;
    }

    // Вывести в лог куки
    public MainePageOtus getCookies(){
        System.out.println(driver.manage().getCookies());
        return this;
    }


}
