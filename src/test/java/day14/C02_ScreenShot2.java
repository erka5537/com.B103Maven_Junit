package day14;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_ScreenShot2 extends TestBase {

    @Test
    public void screenShotTest() throws IOException {

        //Techpro education a git
        driver.get("https://www.techproeducation.com");

        //Sosyal medya elemanlarını goruntusunu al
        WebElement socialMediaIcons = driver.findElement(By.xpath("//*[@data-id='d7545f2']"));
        File image = socialMediaIcons.getScreenshotAs(OutputType.FILE);

//        2. Save screenshot
        String currenDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/ScreenShots/"+currenDate+"image.png";
        File target = new File(path);
        FileUtils.copyFile(image, target);

//        LOGONUN EKRAN GORUNTUSUNU AL
        takeScreenshotOfElement(driver.findElement(By.xpath("//*[@id='NDU1Ojc5MQ==-1']")));
    }
}
