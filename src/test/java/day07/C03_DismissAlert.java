package day07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_DismissAlert extends TestBase {

    @Test
    public void dismissAlert(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

//      2. butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

//      uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();

//      ve result mesajının “You clicked: Cancel” oldugunu test edin.
        String actualResultsult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You clicked: Cancel";
        Assert.assertEquals(expectedResult, actualResultsult);
    }
}
