package practice.erol_hoca.practice01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P13_tkr extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        // https://the-internet.herokuapp.com/iframe adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        String firstTab = driver.getWindowHandle();

        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        textBox.sendKeys("Techproeducation");

        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();
        WebElement elementalSeleniumLinki = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSeleniumLinki.isDisplayed());

        // Elemental Selenium linkine tıklayın
        elementalSeleniumLinki.click();

        // Açılan sayfada sayfa başlığını yazdırınız
        switchToWindow(2);
//        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());

        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        WebElement sauceLabs = driver.findElement(By.xpath("//*[@class=\"link\"]"));
        Assert.assertTrue(sauceLabs.isDisplayed());

        // Source labs linkine tıklayın
        sauceLabs.click();

        // Açılan sayfada sayfa başlığını yazdırınız
//        tabs.clear();
//        tabs.addAll(driver.getWindowHandles());
//        System.out.println(tabs.size());

//        List<String> newTabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(newTabs.get(2));
        switchToWindow(3);

        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        switchToWindow(1);
//        driver.switchTo().window(firstTab);
//        driver.switchTo().window(new ArrayList<String>(driver.getWindowHandles()).get(0));

        // ilk sekmeyi kapatalım
        driver.close();
    }
}
