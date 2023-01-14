package practice.burak_hoca.day_03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_iframe extends TestBase {

    @Test
    public void iframehandle(){
        // ...Exercise 2...
        // https://the-internet.herokuapp.com/iframe sayfasina gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 'An iFrame containing the TinyMCE WYSIWYG Editor' basliginin erisilebilir oldugunu test edin ve konsolda yazdırın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"example\"]/h3")).isEnabled());

        // TextBox'a 'Merhaba Dunya' yazin.
        driver.switchTo().frame(0);
        WebElement textBox = driver.findElement(By.xpath("//*[@id='tinymce']/p"));
        textBox.clear();
        textBox.sendKeys("Ertlkas");

        // TextBox'in altinda bulunan 'Elemental Selenium' linkinin gorunur oldugunu test edin ve konsolda yazdirin
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"large-4 large-centered columns\"]/div/a")).isDisplayed());
    }
}
