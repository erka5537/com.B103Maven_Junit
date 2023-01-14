package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Set;

public class Can_Hoca_10 extends TestBase {

    @Test
    public void test01(){
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");

        //Alerts, Frame & Windows Butonuna click yap
        driver.findElement(By.xpath("//*[@class=\"category-cards\"]/div[3]")).click();

        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        WebElement text = driver.findElement(By.xpath("//*[@class='col-12 mt-4 col-md-6']"));
        Assert.assertTrue(text.isDisplayed());

        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        driver.findElement(By.xpath("//*[.='Browser Windows']")).click();

        //New Tab butonunun görünür olduğunu doğrula
        WebElement newTabButton = driver.findElement(By.id("tabButton"));
        Assert.assertTrue(newTabButton.isDisplayed());

        //New Tab butonuna click yap
        newTabButton.click();

        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula

//        driver.switchTo().window(driver.getWindowHandles().stream().filter(t->!t.equals(driver.getWindowHandle())).findFirst().get());
//        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
        String firstTab = driver.getWindowHandle();
        Set<String> tabs = driver.getWindowHandles();
        String secondTab = tabs.stream().filter(t-> !t.equals(firstTab)).findFirst().get();
        driver.switchTo().window(secondTab);
        WebElement baslik = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(baslik.isDisplayed());


        //İlk Tab'a geri dön
        driver.switchTo().window(firstTab);

        ////New Tab butonunun görünür olduğunu doğrula
        Assert.assertTrue(driver.findElement(By.id("tabButton")).isDisplayed());
    }
}
