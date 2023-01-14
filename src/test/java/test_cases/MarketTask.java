package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class MarketTask extends TestBase {
    /*
    We expect you tu automate the following steps via Selenium Web Driver, regerdless of
    checking for expected/actual results. We prefer Chrome as the browser, but the choice
    is yours.
    Notes: It may also be necessary to write code to accept the cookies warning.
    */
    //Bütün renklerin bütün GB opsiyonlarının tüm özelliklerini yazdırmak için bu şekilde yaptım
    @Test
    public void test01() throws InterruptedException {

        //  1. Go to "https://www.amazon.com.tr/"
        driver.get("https://www.amazon.com.tr/");
        //driver.findElement(By.xpath("//*[@name=\"accept\"]")).click(); //accept cookies

        //  2. Search iPhone13 512
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone13 512", Keys.ENTER);

        //  3. Check that the result are listed
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='SONUÇLAR']")).isDisplayed());

        //  4. Click iPhone13 at the top of the list
        driver.findElement(By.xpath("//img[@class=\"s-image\"][1]")).click();

        //  5. Log the following values for each size
        //size_name_2
        //  .Size information .Price .Color .Stock status

        /*size almak için*/List<WebElement> renkler = driver.findElements(By.xpath("(//ul[@class=\"a-unordered-list a-nostyle a-button-list a-declarative a-button-toggle-group a-horizontal dimension-values-list\"])[1]/li[@data-asin]"));

        for(int i=0; i<renkler.size(); i++){
            List<WebElement> renkler1 = driver.findElements(By.xpath("(//ul[@class=\"a-unordered-list a-nostyle a-button-list a-declarative a-button-toggle-group a-horizontal dimension-values-list\"])[1]/li[@data-asin]/span/span"));

            String atr = renkler1.get(i).getAttribute("class");
            if(atr.contains("unavailable")){ // deaktif olan renk butonunu aktif hale getirip tıklamak için (if kısmı)
                //System.out.println(atr);
                renkler1.get(i).click();
            }else{
                renkler1.get(i).click();
            }

            List<WebElement> boyutlar = driver.findElements(By.xpath("(//*[@id=\"tp-inline-twister-dim-values-container\"])[2]//ul/li[@data-asin]"));

            for(int k=0; k<boyutlar.size(); k++){
                if(boyutlar.get(k).getText().contains("Mevcut")){//Stokta olmayan ürün için Mevcut seçenekleri görüntüleyin yazısı var "Mevcut" ordan geliyor
                    System.out.println(driver.findElement(By.id("productTitle")).getText().split("\\(")[0]+ " ("+ boyutlar.get(k).getText().split("\n")[0] +")" + " - " + driver.findElement(By.id("inline-twister-expanded-dimension-text-color_name")).getText());
                    System.out.println("\t\tBoyut: " + boyutlar.get(k).getText().split("\n")[0]);
                    System.out.println("\t\tRenk:  " + driver.findElement(By.id("inline-twister-expanded-dimension-text-color_name")).getText());
                    System.out.println("\t\tFiyat: " + "stokta olmadığı için fiyat bilgisi yok");
                    System.out.println("\t\tStok: " + "Stokta Yok...");//locate'e gerek kalmadı
                }else{
                    boyutlar.get(k).click();
                    Thread.sleep(2000);
                    Actions action = new Actions(driver);
                    action.moveByOffset(0, 0).click().build().perform(); // Uyarı baloncuğu bir sonraki renk'e tıklamayı engelliyor onu kapatıp beklemek için
                    Thread.sleep(2000);
                    System.out.println(driver.findElement(By.id("productTitle")).getText());
                    System.out.println("\t\tBoyut: " + boyutlar.get(k).getText().split("\n")[0]);
                    System.out.println("\t\tRenk:  " + driver.findElement(By.id("inline-twister-expanded-dimension-text-color_name")).getText());
                    System.out.println("\t\tFiyat: " + boyutlar.get(k).getText().split("\n")[1]);
                    if(driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-base a-spacing-top-micro }\"]/span")).getText().contains("kargo")){// bazı seçeneklerde stok yazısı yerine Genellikle 3 gün içinde kargoya verilir. yazıyor o varsa stokta var yazdır
                        System.out.println("\t\tStok: Stokta var...");
                    }else{
                        System.out.println("\t\tStok: " + driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-base a-spacing-top-micro }\"]/span")).getText());
                    }
                }
                System.out.println("**************************************************************************************");
            }
        }
    }
}

/*
String userProfile= "C:\\Users\\ERKA55\\AppData\\Local\\Google\\Chrome\\User Data\\Default";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir="+userProfile);
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
 */

/*
    ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:\\Users\\ERKA55\\AppData\\Local\\Google\\Chrome\\User Data");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     */

//                JavascriptExecutor js = (JavascriptExecutor) driver;
//                js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",
//                renkler1.get(i), "class", "a-button a-button-toggle image-swatch-button");

//WebElement element = driver.findElement(webelement);
//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//Thread.sleep(500);


//            JavascriptExecutor executor = (JavascriptExecutor)driver;
//            executor.executeScript("arguments[0].click();", webelement);

//            JavascriptExecutor executor = (JavascriptExecutor) driver;
//            executor.executeScript("document.getElementsById('PutYourButtonIdHere').click();", renkler1.get(i));
