package practice.erol_hoca.practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class P04_BuyukKucukHarf extends TestBase {

    @Test
    public void tesr01(){
        //google sayfasına gidelim
        driver.get("https://www.google.com.tr/");

        //Büyük küçük harf şeklinde HeLlO yazdıralım
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.SHIFT,"h",Keys.SHIFT,"e",Keys.SHIFT,"l",Keys.SHIFT,"l",Keys.SHIFT,"o");
    }
}
