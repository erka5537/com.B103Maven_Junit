package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase {

    @Test
    public void windowHandleTest(){

        //Tests package'inda yeni bir class olusturun: WindowHandle
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        String actualWindow1Text = driver.findElement(By.xpath("//h3")).getText();
        String expectedWindow1Text = "Opening a new window";
        Assert.assertEquals(expectedWindow1Text, actualWindow1Text);

        //Sayfa başlığının(title) "The Internet" olduğunu doğrulayın.
        String actualWindow1title = driver.getTitle();
        String expectedWindow1Title = "The Internet";
        Assert.assertEquals(expectedWindow1Title, actualWindow1title);

        //Click Here butonuna basın.
        driver.findElement(By.xpath("//div[@class='example']/a")).click();
        waitFor(3);

        //Acilan yeni pencerenin sayfa başlığının (title) "New Window" oldugunu dogrulayin.
        String ilk = driver.getWindowHandle();
        switchToWindow(2);

        //Sayfadaki textin "New Window" olduğunu doğrulayın.
        String text1 = driver.findElement(By.xpath("//div[@class='example']")).getText();
        Assert.assertEquals("New Window", text1);

        //Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu  doğrulayın.
        switchToWindow(1);
        Assert.assertEquals("The Internet", driver.getTitle());

    }
}
