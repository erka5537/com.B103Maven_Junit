package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;


public class Sahibinden extends TestBase {

    @Test
    public void sahibinden() throws InterruptedException {

        //sahibinden.com a gidin
        driver.get("https://www.sahibinden.com/");

//anasayfada oldugunuzu dogrulayin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"uiBox showcase\"]/h3")).isDisplayed());

//detayli arama tiklayin
        driver.findElement(By.xpath("//*[@title=\"Detaylı Arama\"]")).click();

//detayli arama sayfasina geldiginizi dogrulatin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"categoryWrapper\"]/h2")).isDisplayed());

//emlak-konut-satilik seceneklerini secip
        driver.findElement(By.xpath("//*[.='Emlak']")).click();
        driver.findElement(By.xpath("//*[.='Konut']")).click();
        driver.findElement(By.xpath("//*[.='Satılık']")).click();

        //System.out.println("şehir: " + driver.findElement(By.xpath("(//li[@data-address=\"city\"]//div[@class=\"group-container\"]/ul/li)[5]")).getText());

//altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
//        driver.findElement(By.xpath("//*[@class=\"faceted-select\"]")).click();
        //driver.findElement(By.xpath("//a[.='İstanbul (Tümü)']")).click();

//filtreler için sağıdakilere benzer methodlar oluşturun
//        detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");
//        detayli_Arama_Fiyat("4.000","4.000.000","USD");
//        detayli_Arama_Brut("180","400");
//        detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi

//cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin


        adresSec("ısparta","merkez", "anadolu");
        fiyatSec("500000","2000000","tl");//paraBirim --> TL/USD/EUR/GBP
        metrekareSec("180", "400");
        odaSayisiSec("7+2");
        new Actions(driver).sendKeys(Keys.ENTER).build().perform();
    }

    public void adresSec(String sehir, String ilce, String mahalle) throws InterruptedException {

        String sehirSonuc = sehir.substring(0,1).toUpperCase() + sehir.substring(1).toLowerCase().split(" ")[0];
        String ilceSonuc = ilce.substring(0,1).toUpperCase() + ilce.substring(1).toLowerCase().split(" ")[0];
        String mahalleSonuc = mahalle.substring(0,1).toUpperCase() + mahalle.substring(1).toLowerCase().split(" ")[0];

        driver.findElement(By.xpath("//*[@data-address=\"city\"]/a")).click();
        WebElement secilenSehir =  driver.findElement(By.xpath("//a[.='"+sehirSonuc+"']"));////a[.='Ankara']
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", secilenSehir);
        Thread.sleep(500);
        secilenSehir.click();

        driver.findElement(By.xpath("//*[@data-address=\"town\"]/a")).click();
        WebElement secilenIlce =  driver.findElement(By.xpath("//a[.='"+ilceSonuc+"']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", secilenIlce);
        Thread.sleep(500);
        secilenIlce.click();
        driver.findElement(By.xpath("//li[@data-address=\"town\"]//a[@class=\"collapse-pane\"]")).click();

        driver.findElement(By.xpath("//*[@data-address=\"quarter\"]/a")).click();
        WebElement secilenMahalle =  driver.findElement(By.xpath("//*[contains(text(),'"+mahalleSonuc+" M')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", secilenMahalle);
        Thread.sleep(500);
        secilenMahalle.click();
        driver.findElement(By.xpath("//li[@data-address=\"quarter\"]//a[@class=\"collapse-pane\"]")).click();
        }

        public void fiyatSec(String min, String max, String paraBirim){//paraBirim --> TL/USD/EUR/GBP
            driver.findElement(By.xpath("//*[@placeholder=\"Min TL\"]")).sendKeys(min);
            driver.findElement(By.xpath("//*[@placeholder=\"Max TL\"]")).sendKeys(max);
            driver.findElement(By.xpath("//*[@name=\"price_currency\"]")).sendKeys(paraBirim);
        }

        public void metrekareSec(String min, String max){//paraBirim --> TL/USD/EUR/GBP
            driver.findElement(By.xpath("//*[@placeholder=\"Min m² (Brüt)\"]")).sendKeys(min);
            driver.findElement(By.xpath("//*[@placeholder=\"Max m² (Brüt)\"]")).sendKeys(max);
        }
        public void odaSayisiSec(String odaSayisi) throws InterruptedException {

            WebElement secenekler = driver.findElement(By.xpath("//*[@id=\"a20\"]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style')", secenekler);

            Select select = new Select(secenekler);
            select.selectByVisibleText(odaSayisi);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[contains(text(),'7+2')]")));
//            Thread.sleep(500);
//            driver.findElement(By.xpath("//*[contains(text(),'7+2')]")).click();

            //select.getOptions().forEach(t-> System.out.println(t.getText()));

            WebElement sil = driver.findElement(By.xpath("//body[1]/div[5]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/dl[1]/dd[1]/div[1]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].remove()", sil);
        }
    }