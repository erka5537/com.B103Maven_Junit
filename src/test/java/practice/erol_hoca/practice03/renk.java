package practice.erol_hoca.practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class renk extends TestBase {

    @Test
    public void renk(){


//     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

//     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        driver.switchTo().frame(0);
        WebElement kirmizi = driver.findElement(By.xpath("//*[@id='red']/span"));
        WebElement yesil = driver.findElement(By.xpath("//*[@id='green']/span"));
        WebElement mavi = driver.findElement(By.xpath("//*[@id='blue']/span"));

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(yesil,-170,0).build().perform();
        actions.dragAndDropBy(mavi,-70,0).build().perform();
        waitFor(3);
        actions.dragAndDropBy(yesil,310,0).build().perform();

    }
}
