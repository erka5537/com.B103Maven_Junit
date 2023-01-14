package zOdev_Ve_Tekrar;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class O05 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //  3) Click on Shop Menu
        driver.findElement(By.xpath("//*[.='Shop']")).click();

        //4) Now click on Home menu button
        driver.findElement(By.xpath("//*[.='Home']")).click();

        //5) Test whether the Home page has Three Arrivals only
        List<WebElement> arrivals = driver.findElements(By.className("products"));
        arrivals.forEach(t-> Assert.assertTrue(t.isEnabled()));

        //6) The Home page must contains only three Arrivals
        Assert.assertTrue(arrivals.size()==3);

        stokDurumuUygunsaKitapEkle();

        //11) Kullanıcı o Kitabı Menü öğesinde fiyatla görüntüleyebilir.
//        WebElement fiyatGorunurMu = driver.findElement(By.xpath("//span[@class='woocommerce-Price-amount amount']"));//sepete ekleme butonunun oldugu yerdeki fiyat
//        Assert.assertTrue(fiyatGorunurMu.isDisplayed());

        //12) Kullanıcı, o kitabı Sepetine ekleyen Sepete Ekle düğmesine tıklayarak bir kitap ekleyebilir.
//        WebElement sepeteEkleDugmesiUlasilabilirMi=driver.findElement(By.xpath("(//*[@type='submit'])[1]"));
//        Assert.assertTrue(sepeteEkleDugmesiUlasilabilirMi.isEnabled());


        //13) Stoktaki kitaplardan daha fazla kitap seçin. Örneğin, stokta 20 kitap varsa, 21 eklemeye çalışın.
        WebElement stokSayi = driver.findElement(By.xpath("//*[@type=\"number\"]"));
        stokSayi.clear();
        stokSayi.sendKeys("7593");

        //14) Sepete ekle butonuna tıklayın
        driver.findElement(By.xpath("//*[text()='Add to basket']")).click();

        //15) Şimdi 1 ile 20 arasında bir değer girmeniz gerekiyormuş gibi bir hata mesajı veriyor.
        String message = driver.findElement(By.xpath("//*[@type=\"number\"]")).getAttribute("validationMessage");
        System.out.println(message);


    }

    static int i = 1;
    private static void stokDurumuUygunsaKitapEkle() {
        driver.findElement(By.xpath("(//*[@class='products'])["+i+"]")).click();

        WebElement urunEkleMeSayfasiGorunurMu = driver.findElement(By.xpath("//*[@id='content']"));
        Assert.assertTrue(urunEkleMeSayfasiGorunurMu.isDisplayed());

        String stokDurumu = driver.findElement(By.xpath("//div[@class='summary entry-summary']/p")).getText();
        System.out.println("stokDurumu = " + stokDurumu);

        if (stokDurumu.equals("Out of stock")) {
            driver.findElement(By.xpath("(//a[@href='https://practice.automationtesting.in'])[2]")).click();
        } else {
            driver.findElement(By.xpath("//*[text()='Add to basket']")).click();
            return;
        }
        i++;
        stokDurumuUygunsaKitapEkle();
    }
}


//    //5) Test whether the Home page has Three Arrivals only
//    int arrivals = driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")).size();
//        System.out.println("arrivals = " + arrivals);
//
//                //6) The Home page must contains only three Arrivals
//                Assert.assertTrue(arrivals == 3);