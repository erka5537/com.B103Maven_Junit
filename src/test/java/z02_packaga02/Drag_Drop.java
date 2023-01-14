package z02_packaga02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Drag_Drop extends TestBase {

    @Test
    public void dropTest01() {
        //1 https://letcode.in/ adresine git
        driver.get("https://letcode.in/");

        waitFor(5);
        // 2-Work-Space yazisina tikla
        driver.findElement(By.id("testing")).click();
        //3- Click on the Drop button --Drop düğmesine tıklayın
        waitFor(3);
        driver.findElement(By.xpath("//a[@href='/dropable']")).click();

        waitFor(2);
        WebElement element = driver.findElement(By.xpath("//*[.='Source']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);


        waitFor(5);
        //  4- "Drag me to my target" yazan kutuyu "drop Here" yazan yere tasiyiniz
        WebElement source= driver.findElement(By.xpath("//*[.='Drag me to my target']"));
        WebElement target= driver.findElement(By.xpath("//*[.='Drop here']"));
        //WebElement target2= driver.findElement(By.xpath("//div/p[.='Drop here']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();
        //actions.dragAndDrop(source, target2).perform();
    }
}
