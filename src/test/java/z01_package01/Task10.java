package z01_package01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.List;

public class Task10 extends TestBase {

    //TEST CASE 1
// 1. Home Page with three Sliders only
    @Test
    public void test01(){
//1) Open the browser

//2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("https://practice.automationtesting.in");

        //3) Click on Shop Menu
        WebElement shopMenu = driver.findElement(By.xpath("//a[normalize-space()='Shop']"));
        shopMenu.click();

        //4) Now click on Home menu button
        WebElement home = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
        home.click();

        //5) Test whether the Home page has Three Sliders only
        List<WebElement> slider = driver.findElements(By.xpath("//img[@style='opacity: 1; width: 100%; height: auto; margin-top: -5px; margin-left: 0px;']"));
        Assert.assertTrue(slider.get(0).isDisplayed());
        driver.findElement(By.xpath("//*[@alt='Arrow']")).click();
        waitFor(5);
        Assert.assertTrue(slider.get(1).isDisplayed());
        driver.findElement(By.xpath("//*[@alt='Arrow']")).click();
        waitFor(5);
        Assert.assertTrue(slider.get(2).isDisplayed());
//        for (int i = 0; i<slider.size(); i++){
//            List<WebElement> slider2 = driver.findElements(By.xpath("//img[@style='opacity: 1; width: 100%; height: auto; margin-top: -5px; margin-left: 0px;']"));
//            Assert.assertTrue(slider2.get(i).isDisplayed());
//
//            waitFor(8);
//        }

//6) The Home page must contains only three sliders
        Assert.assertEquals(3,slider.size());
        }
}
