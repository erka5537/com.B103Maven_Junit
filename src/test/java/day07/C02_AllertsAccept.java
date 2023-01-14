package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_AllertsAccept extends TestBase {

    @Test
    public void acceptAlertTest() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

//        1. butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

//        uyarıdaki OK butonuna tıklayın
        driver
                .switchTo()//değiştir
                .alert()//alerte değiştir
                .accept();//OK seçeneğine tıklanır
        Thread.sleep(5000);

//        ve result mesajının
//       “You successfully clicked an alert” oldugunu test edin.
        String actualResultsult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You successfully clicked an alert";
        Assert.assertEquals(expectedResult, actualResultsult);
    }
    /*
    Alert'leri nasıl automate edersin? How to handle alerts in selenium?
    - Alertler javascript ile oluşur. Inspect edilemezler. Öncelikle alerte switch etmemiz gerekir.
    */
}
