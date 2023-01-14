package practice.erol_hoca.practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P05 extends TestBase {
    @Test
    public void test01() throws InterruptedException {


//        -http://spicejet.com/ sayfasına gidelim
        driver.get("http://spicejet.com/");

//        -Sayfanın altındaki about us bölümü altındaki fleet linkine tıklayalım
        WebElement element = driver.findElement(By.xpath("//*[.='About Us']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

//        -Sayfa başlığının Fleet içerdiğini test edelim

    }
}
