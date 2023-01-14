package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Sahibinden_Test extends TestBase {

    /*
//sahibinden.com a gidin
//anasayfada oldugunuzu dogrulayin
//detayli arama tiklayin
//detayli arama sayfasina geldiginizi dogrulatin
//emlak-konut-satilik seceneklerini secip
//altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
//filtreler için sağıdakilere benzer methodlar oluşturun
detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");
detayli_Arama_Fiyat("4.000","4.000.000","USD");
detayli_Arama_Brut("180","400");
detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi
.
.
...
//cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin
*/
    @Test
    public void sahibinden() {
//sahibinden.com a gidin
        driver.get("https://www.sahibinden.com/");
        waitFor(1);
//anasayfada oldugunuzu dogrulayin
        WebElement homePage = driver.findElement(By.xpath("//body[@class='desktop win']"));
        Assert.assertTrue(homePage.isDisplayed());
        waitFor(1);
//butun cookies'leri kabul et
//        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
//        waitFor(4);
//detayli arama tiklayin
        WebElement detailedSearch = driver.findElement(By.xpath("//a[@title='Detaylı Arama']"));
        detailedSearch.click();
//detayli arama sayfasina geldiginizi dogrulatin
        WebElement detailedSearchPage = driver.findElement(By.xpath("//h2[.='Detaylı Arama']"));
        Assert.assertTrue(detailedSearchPage.isDisplayed());
//emlak-konut-satilik seceneklerini secip
        WebElement emlak = driver.findElement(By.xpath("//span[@href='/arama/detayli?category=3518']"));
        emlak.click();
        waitFor(1);
        WebElement konut = driver.findElement(By.xpath("//span[@href='/arama/detayli?category=3613']"));
        konut.click();
        waitFor(1);
        WebElement satilik = driver.findElement(By.xpath("//span[@href='/arama/detayli?category=16623']"));
        satilik.click();
//altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
//once sag taraftaki ok'a tiklayalim
        WebElement ilAramaKutusunaGir = driver.findElement(By.xpath("//a[@class='faceted-select']"));
        ilAramaKutusunaGir.click();

        //li[@data-address="city"]//div[@class="group-container"]/ul/li
        //li[@data-address="town"]//div[@class="group-container"]/ul/li
        //li[@data-address="quarter"]//div[@class="group-container"]/ul/li

        List<WebElement> allCity = driver.findElements(By.xpath("//*[@id=\"categoryMeta\"]/div/table[1]/tbody/tr[1]/td[2]/ul/li[2]/div/div[3]/div/div[1]/ul/div"));
        List<String> iller = new ArrayList<>();
        allCity.forEach(t -> iller.add(t.getText()));
        System.out.println("iller = " + iller);
        for (int i = 0; i < iller.size(); i++) {
            if (iller.get(i).equals("Adana")) {
                return;
            }
        }
//        WebElement ilTextBox= driver.findElement(By.xpath("//input[@placeholder='İl']")); //-- //li[@data-address='city']
//        ilTextBox.sendKeys("İzmir", Keys.ENTER);
//        waitFor(2);
//        WebElement ilXtusunaBas= driver.findElement(By.xpath("(//a[@class='collapse-pane'])[2]"));
//        ilXtusunaBas.click();
//        WebElement ilceAramaKutusunaGir= driver.findElement(By.xpath("//li[@data-address='town']"));
//        ilceAramaKutusunaGir.click();
//        WebElement ilceTextBox= driver.findElement(By.xpath("//input[@placeholder='İlçe']"));
//        ilceTextBox.sendKeys("Bayraklı");
//
//        WebElement ilceXtusunaBas= driver.findElement(By.xpath("//a[@class='collapse-pane']"));
//        ilceXtusunaBas.click();
//
//        WebElement mahalleAramatusunaBas= driver.findElement(By.xpath("//a[@title='Semt']"));
//        mahalleAramatusunaBas.click();
//        WebElement mahalleTextBox= driver.findElement(By.xpath("//input[@placeholder='Semt / Mahalle']"));
//filtreler için sağıdakilere benzer methodlar oluşturun
//detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");
// detayli_Arama_Fiyat("4.000","4.000.000","USD");
// detayli_Arama_Brut("180","400");
//detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi
//cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin
    }
}
