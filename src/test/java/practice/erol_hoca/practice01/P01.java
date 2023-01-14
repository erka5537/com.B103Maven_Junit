package practice.erol_hoca.practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //-"amazon.com" adresine gidelim
        driver.get("https://www.amazon.com/");

        //-bu web adresinin sayfa basligini(title) ve adres(url)ini yazdıralım
        String baslik = driver.getTitle();
        String url = driver.getCurrentUrl();



        //-title ve url'nin "spend" kelimesinin icerip icermedigini kontrol edelim
        Assert.assertTrue(baslik.contains("spend") && url.contains("spend"));

        //-Ardindan "trendyol.com" adresine gidelim
        driver.get("https://www.trendyol.com/");

        //-bu adresin basligini alalim ve "Sitesi" kelismesini icerip icermedigini kontrol edelim
        String baslik2 = driver.getTitle();
        if(baslik2.contains("Sitesi")){
            System.out.println("Baslik testi PASSED");
        }else System.out.println("Baslik testi FAILED");

        //-Bi onceki web sayfamiza geri donelim
        driver.navigate().back();

        //-sayfayi yenileyelim
        driver.navigate().refresh();

        //-Daha sonra trendyol sayfamiza tekrar donelim ve sayfayi kapatalim
        driver.navigate().forward();
        driver.close();

    }
}
