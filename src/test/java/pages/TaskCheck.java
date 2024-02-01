package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskCheck extends BasePage {

    public TaskCheck(WebDriver driver) {
        super(driver);
    }

    public void checkPageIsCorrect(){
        isElementDisplayed(By.xpath("//span[@class='EKtkFWMYpwzMKOYr0GYm LQVY1Jpkk8nyJ6HBWKAk']"));
        System.out.println("Текст успешно найден");
     }

     public void checkPicture(){
        isElementDisplayed(By.xpath("//*[@data-id='id-3']"));
         System.out.println("Картинка успешно найдена");
     }
}
