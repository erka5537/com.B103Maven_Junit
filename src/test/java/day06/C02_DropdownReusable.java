package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropdownReusable {
//    REUSABLE METHOD: Dropdown için tekrar tekrar kullanabileceğimiz bir method oluşturalım.

    WebDriver driver;
    //Eger test sinifinda birden fazla method olusturulmussa @Before kullanilir
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01(){
        selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")), "2005");
        selectFromDropdown(driver.findElement(By.id("month")), "November");
        selectFromDropdown(driver.findElement(By.id("day")), "10");
        selectFromDropdown(driver.findElement(By.xpath("//select[@id='state']")),"Texas");
    }

    public void selectFromDropdown(WebElement dropdown, String secenek){
//        selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")), "2005"); --> year'dan
//        selectFromDropdown(driver.findElement(By.xpath("//select[@id='month']")), "January"); --> month'dan January
//        selectFromDropdown(driver.findElement(By.id("day")), "12"); --> day'den 12

//        Gonderilen dropdown elementinin tüm options'ları alınır
        List<WebElement> options = dropdown.findElements(By.tagName("option")); //Tüm option tagli elementleri alıyorum
        for(WebElement w : options){
            if(w.getText().equals(secenek)){
                w.click();
                break;
            }
        }
    }
}