package zOdev_Ve_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class O01 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

//        3- cookies uyarisini kabul ederek kapatin
        //Bende cookies çıkmıyor o yüzden kapatmama gerek kalmadı

//        4Sayfa basliginin “Google” ifadesi icerdigini test edin
        if(driver.getTitle().contains("Google")){
            System.out.println("Title Testi PASSED");
        }else System.out.println("Title Testi FAILED");

//        5Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//*[@class=\"gLFyf\"]")).sendKeys("Nutella", Keys.ENTER);

//        6Bulunan sonuc sayisini yazdirin
        String sonucYazısı = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        String[] sonucArr = sonucYazısı.split(" ");
        int sonucSayisi = Integer.parseInt(sonucArr[1].replace(".",""));

//        7sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        if(sonucSayisi>10000000){
            System.out.println("Sonuc Sayısı 10 milyon'dan fazla");
        }else System.out.println("Sonuc Sayısı 10 milyon'dan az");

//        8Sayfayi kapatin
        driver.close();
    }
}
