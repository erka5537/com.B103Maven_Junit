package z02_packaga02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Example_01 extends TestBase {

    @Test
    public void q(){
        // 1-https://letcode.in/ adresine git
driver.get("https://letcode.in/");

// 2-Work-Space yazisina tikla
        driver.findElement(By.id("testing")).click();

//3- Click on the Elements button --Elements düğmesine tıklayın
        driver.findElement(By.xpath("//*[@href=\"/draggable\"]")).click();

//4- Uzerinde "I can only be dragged within the dotted container" yazan kutuyu saydaya 3 farkli yere tasiyin


        Actions actions = new Actions(driver);
        actions.dragAndDropBy(driver.findElement(By.id("sample-box")),104,95).release(driver.findElement(By.id("sample-box"))).build().perform();

    }


}
