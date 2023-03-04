package practice.erol_hoca.practice04;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class P06_Excel extends TestBase {

    @Test
    public void test01() throws IOException {
        //Bilgisayarınızdaki data isimli excel dosyasından kullanıcı bilgilerini alıp
        String dosyaYolu = "C:\\Users\\ERKA55\\Desktop\\data.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);

        //https://www.bluerentalcars.com/ adresine gidip
        driver.get("https://www.bluerentalcars.com/");

        //Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        WebElement email = driver.findElement(By.xpath("//*[@name='email']"));
        WebElement password = driver.findElement(By.xpath("//*[@name='password']"));

        email.sendKeys(workbook.getSheet("Sayfa1").getRow(1).getCell(1).toString());
        password.sendKeys(workbook.getSheet("Sayfa1").getRow(2).getCell(1).toString());
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        waitFor(10);

        //Login olduğumuzu doğrulayalım
        Assert.assertEquals(driver.findElement(By.id("dropdown-basic-button")).getText(),"Erol Evren");
    }
}
