package day14;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ExtentReports extends TestBase {
    //    HATIRLAMAMIZ GEREKEN 3 CLASS
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;
    @Test
    public void extentReportsTest() throws IOException {
//      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";
//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();
//       *************************************RAPORU CUSTOMIZE EDEBILIRIZ*********************
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application","TechPro Education");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Takim","Eagles");
        extentReports.setSystemInfo("Epic","Odeme Sayfasi");
        extentReports.setSystemInfo("Sprint Numarasi","Sprint-145");
        extentReports.setSystemInfo("QA","Erkam");

//        *********************************EXTRA RAPOR ISMI VE DOCUMAN ISMI EKLEYEBILIRIZ****
        extentHtmlReporter.config().setDocumentTitle("TechProEd Extent Reports");
        extentHtmlReporter.config().setReportName("Regression Test Sonucu");

//        ********************************RAPOR AYARLARI BITTI****************************
//        Raporu projeme ekliyorum
        extentReports.attachReporter(extentHtmlReporter);

//        Extend Test objesi'ni oluştur
        extentTest = extentReports.createTest("Extent Report Login Test", "Smoke Test Raporu");

//        TUM AYARLAR BITTI. EXTENT TEST OBJESI ILE LOGLAMA(RAPORA YAZDIRMA) ISLEMINI YAPABILIRIM
        extentTest.pass("Kullanıcı ana sayfaya gider");//.addScreenCaptureFromPath("20230113110048image.png");
        driver.get("https://www.techproeducation.com");

//        LMS SAYFASINA GIDELIM
        extentTest.pass("Kullanıcı LMS sayfasına gider");
        driver.findElement(By.linkText("LMS LOGIN")).click();

//        TEST BITTI
        extentTest.pass("Test başarıyla gerçekleşti");

//        RAPORU GOSTER. RAPORUN OLUŞMASI İÇİN BU ADIM ZORUNLUDUR
        extentReports.flush();
    }
}

//Ekran goruntusu alma:
//getScreenShotAs metotu ile alinir. Bu metot Selenium dan gelir
//getScreenshotAs metotu TakesScreenshot api indan gelir
//Selenium 4 den itibaren 2 farklı sekilde ekran goruntusu alınabilir: Tum Sayfa, Özel element
//Olusturmus oldugumuz ReusableMetot yardimizya ister tum sayfanin, istersem belirli bir elementin ekran goruntusunu kolaylıkla alabilirim
//Extent Reports :
//Otomasyon raporları almak icin kullanılır.
//Extent report ayrı bir API dir. Extent reports seleniumin disindada kullanilabirlar.  Bu API dan gelen metotlar yardımıyla rapor sablonu oluşturabilir.
//3 class kullandık
//ExtentReports -> sablonu olusturu
//ExtentHTMLReporter -> sablonu projeye ekler
//ExtentTest -> raporlama islemini yapar. Loglari rapora yazdırir.