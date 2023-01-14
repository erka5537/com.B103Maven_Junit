package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
/*
TimeOutExcption explicit wait kullandığımda ve locator bulunamadığında alırım
*/
    @Test
    public void timeOutExceptionTest(){
//                          TimeOutException
//        Explicit kullanıldığında ve element bulunamadığında alınır.
//        Explicit wait & yanlış locator -> timeout
//        Explicit wait & doğru locator & süre yeterli değil -> timeout
//        Explicir wait & doğru locator & sure yeterli & iframe var -> timeout

//                          Solution
//        - Sureyi artırabiliriz
//        - Farklı explicit wait seçenekleri kullanabiliriz.
//        Örneğin visibilityOfElementLocated yerine presenceOfElementLocator gibi.
//        Ya da javascript executer'daki waiter sayfa geçişlerini beklemek için kullanabiliriz
//        - Locator'ı tekrar kontrol edebiliriz
//        - Framework'unde hazır reusable method'lar yardımıyla problemleri çözebiliyoruz

        driver.get("https://www.techproeducation.com/");

//        Explicit wait için oluşturduğumuz methodlardan birini kullanalım
//        Parametre 1: beklemek istediğim element, Parametre 2: Max sure

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type=' search ']"))).sendKeys("QA" + Keys.ENTER);
//        Expected condition failed: waiting for visibility of element located by By.xpath: //input[@type=' search '] (tried for 15 second(s)
    }
}
