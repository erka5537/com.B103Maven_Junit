package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C01_ScreenShot1 extends TestBase {
    /*
Selenium tun ekran goruntusu nasil alinir?
    -tum ekran goruntusu seleniumdan gelen getScreenshotAs metotu ile alinir.
    -getScreenshotAs metotu seleniumdaki TakesScreenshot api indan gelir
 */

    @Test
    public void fullPageScreenShotTest() throws IOException {

        //Techpro education a git ve Sayfanin goruntusunu al
        driver.get("https://www.techproeducation.com");

//        1. Ekran görüntüsünü getScreenshotAs() methodu ile alıp File olarak oluşturalım
        File goruntu = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

//        2. Almış olduğum ekran görüntüsünü belirlediğim path'e kaydet
//        NOTE: kayıt ismini dinamik yapmak için date objesi kullandım
        System.out.println(LocalDateTime.now());
        String currenDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/ScreenShots/"+currenDate+"image.png";
        File hedef = new File(path);

//        3. Görüntüm ile dosyamı birleştirip kaydet
        FileUtils.copyFile(goruntu, hedef);

//        ALTERNATIF OLARAK TUM BU ADIMLARI TEK SEFERDE DEGISKEN KULLANMADAN YAPABILIRIM
//        FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir") + "/test-output/ScreenShots/image.png"));

        //-“QA” aramasi yap
        driver.findElement(By.xpath("//*[@placeholder='Search...']")).sendKeys("qa" + Keys.ENTER);

        //Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”
        String text = driver.findElement(By.xpath("//*[contains(text(),'Search Results')]")).getText();
        Assert.assertTrue("Search Results for: qa".contains(text));

//        Reusable method yardımıyla ekran görüntüsünü alalım
        takeScreenShotOfPage();
    }
}
