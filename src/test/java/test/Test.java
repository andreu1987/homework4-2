package test;

import exceptions.BrowserNotSupportedException;
import factory.DriveFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainePageDuckduckgo;
import pages.MainePageOtus;
import pages.MainePageOtusHome;
import pages.TaskCheck;

import java.util.concurrent.TimeUnit;

public class Test  {

    private WebDriver driver;
    public MainePageDuckduckgo mainePageDuckduckgo;
    public TaskCheck taskOne;
    public MainePageOtusHome mainePageOtusHome;
    public MainePageOtus mainePageOtus;

    @BeforeAll
    public static void beforeALL(){
    }

    @BeforeEach
    public void beforeEach()  {
        this.driver = new DriveFactory().create();
        mainePageDuckduckgo = PageFactory.initElements(driver, MainePageDuckduckgo.class);
        taskOne = PageFactory.initElements(driver, TaskCheck.class);
        mainePageOtusHome = PageFactory.initElements(driver,MainePageOtusHome.class);
        mainePageOtus = PageFactory.initElements(driver,MainePageOtus.class);
    }



    @org.junit.jupiter.api.Test
    public void test1() {
        mainePageDuckduckgo  .goTo() // переход на сайт
                             .setInputText() // ввод слово
                             .clickElement();      // клик на поиск
        taskOne              .checkPageIsCorrect(); // проверка элемента

    }

    @org.junit.jupiter.api.Test
    public void test2() {

        mainePageOtusHome   .goTo() // переход на сайт
                            .fullscreen() // размер экрана
                            .getSize() // размер экрана
                            .clickElement() // клик по элементу
                            .elementLoadTimeout(); // ожидание элемента
        taskOne             .checkPicture(); // проверка элемента


    }

    @org.junit.jupiter.api.Test
    public void test3() {

        mainePageOtus    .goTo() // переход на сайт
                         .maximize() // размер экрана
                         .getSize() // размер экрана
                         .implicitlyWaitButton() // ожидания элемента кнопка "Войти"
                         .clickElementEnter() // клик по элементу кнопки "Войти"
                         .PopupElementI() //Проверка что PopupElement есть - "Войдите в свой акаунт"
                         .authorizationEmail()  // ввод Email
                         .authorizationPassword()  // ввод Password
                         .clickElementEnterEnter()  // клик по элементу
                         .ThereIsNoButton() //Проверка что нет кнопки "Войти"
                         .getCookies(); // вывод в лог куков
    }

    @AfterEach
    public  void finish(){
        driver.quit();
    }
}


