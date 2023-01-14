package day12;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.Verifier;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {

    @Test
    public void ad(){

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();

        //Hello World! Yazının sitede oldugunu test et

//        1.WebDriverWait objesini oluştur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

//        2.wait objesini kullanarak bekleme problemini çözmeye çalış
        WebElement helloWorldElement = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.='Hello World!']"))));
        String helloWorldText = helloWorldElement.getText();
        Assert.assertEquals("Hello World!", helloWorldText);
    }
}
