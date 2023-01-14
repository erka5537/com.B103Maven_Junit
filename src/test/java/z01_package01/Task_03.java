package z01_package01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Task_03 extends TestBase {

    @Test
    public void readMoreFunctionality()  {

        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //3) Mağaza Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();

        //4) Ana sayfadaki devamını oku düğmesine tıklayın
        driver.findElement(By.xpath("//nav/a[@href='https://practice.automationtesting.in']")).click();//anasayfaya git
        driver.findElement(By.xpath("//a[@data-product_id='160']")).click();//Devamini oku'ya tiklar

        //5) Devamını Oku seçeneği Tükendi'yi gösterir.
        String stokDurumu = driver.findElement(By.xpath("//div[@class='summary entry-summary']/p")).getText();
        System.out.println("stokDurumu = " + stokDurumu);
        String expected="Out of stock";
        Assert.assertEquals(expected, stokDurumu);

        //6) Kullanıcı, devamını oku seçeneği olan ürünü stokta kalmadığı için ekleyemez.
        driver.findElement(By.xpath("//nav/a[@href='https://practice.automationtesting.in']")).click();

        List<WebElement> durumlar = driver.findElements(By.xpath("//*[@rel=\"nofollow\"]"));

        durumlar.forEach(t-> Assert.assertEquals(t.getText(),"READ MORE"));

        //WebElement addToBasketButton= driver.findElement(By.xpath("//button[@type='submit']"));
        //Assert.assertFalse(driver.findElement(By.xpath("//button[@type='submit']")).isEnabled());

    }
}
