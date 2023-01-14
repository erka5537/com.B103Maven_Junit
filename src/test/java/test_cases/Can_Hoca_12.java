package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Can_Hoca_12 extends TestBase {

    @Test
    public void q(){
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@class=\"dropdown hover\"]/button"))).perform();

        //3. "Link 1" e tiklayin
        actions.click(driver.findElement(By.xpath("//*[@class=\"dropdown hover\"]/div/a"))).perform();

        //4. Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6. "Click and hold" kutusuna basili tutun
        WebElement box1 = driver.findElement(By.id("click-box"));
        actions.clickAndHold(box1).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(box1.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement box2 = driver.findElement(By.id("double-click"));
        String oncekiRenk = box2.getCssValue("background-color");
        System.out.println("Çift tıklamadan önceki renk: " + oncekiRenk);
        actions.doubleClick(box2).perform();

        //9. "Double click me" butonunun renk değiştridiğini doğrulayın
        String sonrakiRenk = box2.getCssValue("background-color");
        System.out.println("Çift tıkladıktan sonraki renk: " + sonrakiRenk);
        Assert.assertNotEquals(oncekiRenk,sonrakiRenk);
    }
}
