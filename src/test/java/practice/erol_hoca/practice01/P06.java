package practice.erol_hoca.practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class P06 {

    /*
    - ebay sayfasına gidiniz
    - electronics bölümüne tıklayınız
    - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
    - Her sayfanın sayfa başlığını yazdıralım
    - sayfayı kapatalım
     */
    static WebDriver driver;
    static List<WebElement> urunler;
    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        //- ebay sayfasına gidiniz
        driver.get("https://ebay.com");

        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();

        //- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        //- Her sayfanın sayfa başlığını yazdıralım
        List<WebElement> urunler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
        int sayi = urunler.size();
        for (int i = 1; i < sayi; i++) {
            driver.findElement(By.xpath("(//*[@width='225' and @height='225'])["+i+"]")).click();
            System.out.println(i+". başlık : "+driver.getTitle());
            driver.navigate().back();
        }
        //- sayfayı kapatalım
    }
}