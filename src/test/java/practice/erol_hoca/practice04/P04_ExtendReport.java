package practice.erol_hoca.practice04;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class P04_ExtendReport extends TestBase {
    protected ExtentReports extentReports;//Raporlamayı başlatırız
    protected ExtentHtmlReporter extentHtmlReporter;//Raporumu HTLM formatında düzenler
    protected ExtentTest extentTest; //Test aşamalarına extentTest objesi ile bilgi ekleriz

    @Test
    public void invisibleTest() {
        //----------------------------------------------------------------
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/ExtentReports/htmlreport"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);
        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Erol");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Test Sonucu");
        extentTest=extentReports.createTest("Extent Tests","Test Raporu");

        //https://automationfc.github.io/dynamic-loading/ sayfasına gidelim
        driver.get("https://automationfc.github.io/dynamic-loading/");
        extentTest.info("Url'e gidildi");
        //Start button'nuna basalım
        driver.findElement(By.xpath("//*[text()='Start']")).click();
        extentTest.info("Start buttonuna basıldı");
        //Hello World! yazısının çıktığını doğrulayalım
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[text()='Loading... ']")));
        extentTest.info("Hello World yazısı doğrulandı");
        //Start buttonuna bastıktan sonra Loading webelementi kaybolana kadar bekledik
        assert driver.findElement(By.xpath("//*[text()='Hello World!']")).isDisplayed();
        extentTest.pass("WE beklendi");

        extentReports.flush();
    }
}
