package practice.erol_hoca.practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class P06 extends TestBase {

    @Test
    public void test01() throws AWTException {
        //https://demoqa.com/ url'ine gidin.
        driver.get("https://demoqa.com/");

        //Alerts, Frame & Windows Butonuna click yap
        WebElement element = driver.findElement(By.xpath("//*[@class='category-cards']/div[3]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        waitFor(1);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_F4);

        //clickWithText("div.card-body>h5","Alerts, Frame & Windows");
        //""Please select an item from left to start practice."" yazısının görünür olduğunu doğrula
        //Sol'da açılan Menu den ""Browser Windows"" butonuna click yap
        //New Tab butonunun görünür olduğunu doğrula
        //New Tab butonuna click yap
        //Açılan yeni Tab da ""This is a sample page"" yazısının görünür olduğunu doğrula
        //İlk Tab'a geri dön
        ////New Tab butonunun görünür olduğunu doğrula
    }
}
