package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class Can_Hoca_09_WH extends TestBase {

    @Test
    public void test01(){

//       url'ye git: http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");

//       ilk pencereyi al
        String firstTab = driver.getWindowHandle();

//       "Click Here" butonuna tıklayın
        driver.findElement(By.xpath("//*[@target=\"_blank\"]")).click();

//       setteki tüm pencereyi al
        Set<String> allTabs = driver.getWindowHandles();

//       diğer pencereye geç
        driver.switchTo().window(allTabs.stream().filter(t-> !t.equals(firstTab)).findFirst().get());

//       e-posta kimliğini (somepne@gmail.com) girin ve bu girişe bir şey yazın
        driver.findElement(By.name("emailid")).sendKeys("somepne@gmail.com");

//       Gönder düğmesine tıklayarak
        driver.findElement(By.name("btnLogin")).click();

//       ""This access is valid only for 20 days."" ifadesinin beklendiği gibi olduğunu doğrula
        String baslik = driver.findElement(By.xpath("//*[@colspan=\"2\"]/h3")).getText();
        Assert.assertEquals("This access is valid only for 20 days.", baslik);

//       Tekrar ilk pencereye geç
        driver.switchTo().window(firstTab);

//       İlk pencerede olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"container-fluid\"]")).isDisplayed());
    }
}
