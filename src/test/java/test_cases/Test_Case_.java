package test_cases;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Test_Case_ extends TestBase {

    @Test
    public void filterByPriceFunctionality() throws InterruptedException {

        //2) Enter the URL "http://practice.automationtesting.in/"
        driver.get("http://practice.automationtesting.in/");

        //3) Mağaza Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();

        //4) Filtreyi fiyata göre 150 ila 450 rps arasında ayarlayın
//
        WebElement slidersol = driver.findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[1]"));
        WebElement slidersag = driver.findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[2]"));

        JavascriptExecutor j = (JavascriptExecutor) driver;
        WebElement ads = driver.findElement(By.xpath("//*[@id=\"max_price\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('style')", ads);
        ads.clear();
        ads.sendKeys("300");

        Thread.sleep(5000);

//        identify element and click
//        driver.findElement(By.id("max_price")).click();
//        // identify element and set value
//        j.executeScript("document.getElementById('displayed-text').value='450';");
//        String s = (String) j.executeScript("return document.getElementById('displayed-text').value");
//        System.out.print("Value entered in hidden field: " +s);

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        WebElement a = driver.findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[2]"));
//        js.executeScript("arguments[0].setAttribute('style', 'left: 30%;')",a);

//        String to = "";
//        while(!to.equals("450")){
//            slidersag.sendKeys(Keys.ARROW_LEFT);
//            to = driver.findElement(By.xpath("//*[@class=\"to\"]")).getText().replaceAll("[^0-9]","");
//        }




        //5) Şimdi Filtre düğmesine tıklayın
        driver.findElement(By.xpath("//button[@class='button']")).click();


        //6) Kullanıcı sadece 150 ila 450 rps fiyatı arasındaki kitapları görüntüleyebilir.
        List<WebElement> price=driver.findElements(By.xpath("//*[@class=\"price\"]/*"));
        price.stream().filter(t-> !t.getTagName().equals("del")).forEach(t-> System.out.println(t.getText()));
    }
}
