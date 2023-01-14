package practice.erol_hoca.practice01;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.List;

public class P10 extends TestBase {

    @Test
    public void test02(){

        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframe = driver.findElements(By.xpath("//iframe"));
        System.out.println("iframe Sayisi = " + iframe.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@wmode=\"transparent\"]")));
        driver.findElement(By.xpath("//*[@aria-label=\"Oynat\"]")).click();

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html)
        //tıklayınız

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='a077aa5e']")));
        driver.findElement(By.xpath("//*[@src=\"Jmeter720.png\"]")).click();
    }

}
