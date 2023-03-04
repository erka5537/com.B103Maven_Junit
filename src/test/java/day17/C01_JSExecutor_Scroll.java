package day17;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C01_JSExecutor_Scroll extends TestBase {

    @Test
    public void scrollIntoViewTest() throws InterruptedException, IOException {
        //scrollIntoViewTest metotu olustur
        //Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(3);

        //We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
//        1. İşlem yapmak istediğin elementi bul
        WebElement weOffer = driver.findElement(By.xpath("//*[.='we offer']"));

//        2. JS executor objesi oluştur
        JavascriptExecutor js = (JavascriptExecutor) driver;

//        3. Yapmak istediğim işlemi js.executeScript method'u ile yap
//        scrollIntoView(true); metotu belirli bir elemente scroll yapmak icin kullanilir
        js.executeScript("arguments[0].scrollIntoView(true);", weOffer);
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", weOffer);

//        sayfa goruntusunu al
        waitFor(3);
        takeScreenShotOfPage();


        //Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//*[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();

        //Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al

        scrollIntoViewJS(driver.findElement(By.xpath("//h3[.='WHY US?']")));
        waitFor(3);
        takeScreenShotOfPage();


        //Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(driver.findElement(By.xpath("//span[.='Enroll Free Course']")));
        waitFor(3);
        takeScreenShotOfPage();

//        EN USTE GIT
        scrollTopJS();

//        EN ALTA GIT
        scrollEndJS();
    }
}
