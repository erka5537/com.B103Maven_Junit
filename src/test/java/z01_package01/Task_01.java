package z01_package01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Task_01 extends TestBase {

    @Test
    public void categoriesFunctionality() {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //3) Mağaza Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();

        //4) Ürün kategorisinde bulunan ürün bağlantılarından herhangi birine tıklayın
        WebElement categorie = driver.findElement(By.xpath("//a[@href='https://practice.automationtesting.in/product-category/html/']"));
        String ctg = categorie.getText();
        categorie.click();

        //5) Artık kullanıcı yalnızca söz konusu ürünü görüntüleyebilir
        List<WebElement> elemanSayisi = driver.findElements(By.xpath("//h3"));   //h3[contains(text(),'"+ctg+"')] --> isDisplayed
        for(int i=0; i<elemanSayisi.size(); i++){
            Assert.assertTrue(elemanSayisi.get(i).getText().contains(ctg));
        }
    }
}
