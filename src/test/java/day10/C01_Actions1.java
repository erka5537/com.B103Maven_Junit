package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions1 extends TestBase {

    @Test
    public void test01(){

//        Class: Actions1
//        https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

//        Kutuya sag tıklayın
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();
        waitFor(3);


//        Alert’te cikan yazinin “You selected a context menu” oldugunu
//        test edin
//        Object olusturmak wait gerekdiren durumlarda makul
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("You selected a context menu", alert.getText());
        alert.accept();
//        Tamam diyerek alert’i kapatın

    }
}
