package homework;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.List;
public class H01 extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //Bir class olusturun: IframeOdev
        //https://the-internet.herokuapp.com/iframe  sitesine gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        //sayfadaki toplam iframe sayısını bulunuz.
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Toplam iframe sayısı = " + iframes.size());

        //Sayfa basliginda 'Editor' yazını içerdiğini test edelim.
        driver.findElement(By.tagName("h3"));
        Thread.sleep(2000);
        //Paragrafdaki yaziyi silelim
        driver.switchTo().frame(0);
        WebElement textBox = driver.findElement(By.xpath("//body/p"));
        textBox.clear();
        Thread.sleep(2000);
        //Sonrasinda paragrafa "iframein icindeyim" yazisini yazdıralım
        textBox.sendKeys("iframein icindeyim");
        Thread.sleep(2000);
        //Alt kısımdaki yazının 'Elemental Selenium' yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
        String text = driver.findElement(By.xpath("//*[@style='text-align: center;']")).getText();
        String expectedText = "Elemental Selenium";
        Assert.assertTrue(text.contains(expectedText));
    }
}