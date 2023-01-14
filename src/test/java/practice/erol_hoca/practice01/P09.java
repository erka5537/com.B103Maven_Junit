package practice.erol_hoca.practice01;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P09 extends TestBase {

    @Test
    public void test01(){

      // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

      // ikinci emojiye tıklayın
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("*[href=\"#nature\"]")).click();

      // tüm ikinci emoji öğelerini tıklayın
        List<WebElement> emojiler = driver.findElements(By.xpath("//*[@id=\"nature\"]/div/img"));
        emojiler.forEach(WebElement::click);

      // parent iframe e geri donun
        driver.switchTo().defaultContent();

      // formu doldurun,(Formu istediğiniz metinlerle doldurun)
        List<WebElement> textBoxes = driver.findElements(By.xpath("//input[@class=\"mdl-textfield__input\"]"));
        textBoxes.forEach(t->t.sendKeys(RandomStringUtils.random(10, true, true)));

      //  apply button a basin
        driver.findElement(By.id("send")).click();
    }
}
