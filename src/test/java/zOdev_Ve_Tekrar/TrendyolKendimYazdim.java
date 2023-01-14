package zOdev_Ve_Tekrar;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TrendyolKendimYazdim {
    /*
  1.  https://www.trendyol.com/ adresine gidiniz
  2.  "Sepete En Cok EKlenenler" basligina tiklayin
    3.Acilan sayfada sepete en cok eklenen ilk 4 urun icin
     4.once urunu genel hatlariyla incelemek icin sayfaya gidin
     5.daha sonra sayfada "ÜRÜNÜN TÜM ÖZELLİKLERİ" ne tiklayip urunlerin ozelliklerine bakin
     6.Her bir urunden sonra "Ürün Değerlendirmeleri" basligina tiklayin
     7."Ürün Değerlendirmeleri" yazilarinin gorunurlugunu dogrulayin
     8.ardindan sirasiyla her bir urunu sepete ekleyin
     9-4. Urunden sonra "Sepete Git" butonunu tiklayin
     10.Her bir urunun ayri ayri sepette gondugunu dogrulayin
     11."Sepeti Onayla" butonuna tiklayin
     12.Gelen ekranda "Trendyol’a giriş yap veya hesap oluştur, indirimleri kaçırma!" yazisinin gorunur oldugunu dogrulayin
     13.Daha sonra AnaSayfaya gidin
     14. "Sepetim" butonuna tiklayin
     15.Sepette secmis oldugunuz urunleri silin(Bu asamada urun silinmesiyle ilgili gelen uyarilari kabul edin)
     16. Butun urunleri sildikten sonra sayfada "Sepetinde ürün bulunmamaktadır." yazisinin gorunur oldugunu dogrulayin
     */
    static WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Before
    public void setUp() throws Exception {
        //     1.  https://www.trendyol.com/ adresine gidiniz
        driver.get("https://www.trendyol.com/");
    }
    @Test
    public void test01() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='modal-close']")).click(); //kadin erkek uyarisini kapatmak icin
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("button[id='onetrust-accept-btn-handler']")).click(); //ilk uyariyi kabul etmek icin
        Thread.sleep(4000);
//     2.  "Sepete En Cok EKlenenler" basligina tiklayin
        driver.findElement(By.cssSelector("a[href='https://www.trendyol.com/sr?fl=sepetteurunler']")).click();
//    3.Acilan sayfada sepete en cok eklenen ilk 4 urun icin
//     4.once urunu genel hatlariyla incelemek icin sayfaya gidin
        //Urun inceleme sayfasinin gorunur oldugunu dogruayin
//     5.daha sonra sayfada "ÜRÜNÜN TÜM ÖZELLİKLERİ" ne tiklayip urunlerin ozelliklerine bakin
//     6.Her bir urunden sonra "Ürün Değerlendirmeleri" basligina tiklayin
//     7."Ürün Değerlendirmeleri" yazilarinin gorunurlugunu dogrulayin
//     8.ardindan sirasiyla her bir urunu sepete ekleyin

        //ürünleri almak için
        for(int i=1; i<=4; i++){
            driver.findElement(By.xpath("(//div[@class='image-overlay-body'])["+i+"]")).click();
            //driver.findElement(By.id("//*[@class=\"button-all-features\"]")).click(); //urunu genel hatlariyla incelemek icin (butun urunler tek tek incelendigi icin hepsinde ortak
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            WebElement urunIncelemeSayfasiGorunurMu = driver.findElement(By.xpath("(//div[@class='flex-container'])[1]"));//urun inceleme sayfasinin gorunurlugu
            Assert.assertTrue(urunIncelemeSayfasiGorunurMu.isDisplayed());
            driver.findElement(By.cssSelector("a[class='button-all-features']")).click(); //urunun tum ozelliklerini inceleme
            //driver.findElement(By.id("product-reviews-dr")).click(); //urun degerlendirmeleri
            WebElement urunDegerlendirmeleriGorunurMu = driver.findElement(By.cssSelector("div[class='pr-rnr-com-w']"));
            Assert.assertTrue(urunDegerlendirmeleriGorunurMu.isDisplayed());
            driver.findElement(By.xpath("(//div[@class='add-to-basket-button-text'])[1]")).click();//sepete ekleme

            driver.close();
            driver.switchTo().window(tabs.get(0));

        }

//     9-4. Urunden sonra "Sepete Git" butonunu tiklayin
        driver.findElement(By.xpath("(//*[@class=\"link-text\"])[3]")).click();

//     10.Her bir urunun ayri ayri sepette gondugunu ayri ayri kontrol edip toplu bir sekilde  Assert.assertTrue ile  dogrulayin
        WebElement sepetteVAr1=driver.findElement(By.xpath("(//*[@class='pb-basket-item'])[1]"));
        WebElement sepetteVAr2=driver.findElement(By.xpath("(//*[@class='pb-basket-item'])[2]"));
        WebElement sepetteVAr3=driver.findElement(By.xpath("(//*[@class='pb-basket-item'])[3]"));
        WebElement sepetteVAr4=driver.findElement(By.xpath("(//*[@class='pb-basket-item'])[4]"));
        Assert.assertTrue(sepetteVAr1.isDisplayed()&&sepetteVAr2.isDisplayed() && sepetteVAr3.isDisplayed() && sepetteVAr4.isDisplayed());

//     11."Sepeti Onayla" butonuna tiklayin
        driver.findElement(By.xpath("(//div[@class='pb-summary-approve'])[1]")).click();

//     12.Gelen ekranda "Trendyol’a giriş yap veya hesap oluştur, indirimleri kaçırma!" yazisinin gorunur oldugunu dogrulayin
        WebElement girisYapGorunurmu= driver.findElement(By.xpath("//*[text()='Trendyol’a giriş yap veya hesap oluştur, indirimleri kaçırma!']"));
        String expectedGirisYaizis="Trendyol’a giriş yap veya hesap oluştur, indirimleri kaçırma!";
        Assert.assertEquals(girisYapGorunurmu.getText(), expectedGirisYaizis);

//     13.Daha sonra AnaSayfaya gidin
        driver.findElement(By.cssSelector("a[title='trendyol']")).click();

        // 14. Anasayfanin gorunur oldugunu dogrulayin
        WebElement anaSayfaGorunurMu=driver.findElement(By.id("container"));
        Assert.assertTrue(anaSayfaGorunurMu.isDisplayed());

//     15. "Sepetim" butonuna tiklayin
        driver.findElement(By.xpath("(//*[@class='link-text'])[3]")).click();

//     16.Sepette secmis oldugunuz urunleri silin(Bu asamada urun silinmesiyle ilgili gelen uyarilari kabul edin)
        List<WebElement> silbutonlari = driver.findElements(By.xpath("//*[@class=\"pb-basket-item-actions\"]/button"));
        silbutonlari.get(0).click();
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();//gelen uyariyi kabul etmek icin

        Thread.sleep(1000);
        silbutonlari.get(1).click();
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();//gelen uyariyi kabul etmek icin

        Thread.sleep(1000);
        silbutonlari.get(2).click();
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();//gelen uyariyi kabul etmek icin

        Thread.sleep(1000);
        silbutonlari.get(3).click();
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();//gelen uyariyi kabul etmek icin


//     17. Butun urunleri sildikten sonra sayfada "Sepetinde ürün bulunmamaktadır." yazisinin gorunur oldugunu dogrulayin
        WebElement sepetteUrunKalmadi= driver.findElement(By.xpath("//*[text()='Sepetinde ürün bulunmamaktadır.']"));
        Assert.assertTrue(sepetteUrunKalmadi.isDisplayed());
    }
}