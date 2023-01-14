package z02_packaga02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class Example_04 extends TestBase {

    @Test
    public void multiSelectTest() {
        // 1-https://letcode.in/ adresine git
        driver.get("https://letcode.in/");
        // 2-Work-Space yazisina tikla
        driver.findElement(By.id("testing")).click();
        //3- Click on the Multi-Select button --Multi-Select düğmesine tıklayın
        driver.findElement(By.xpath("//a[@href='/selectable']")).click();
        //acilan ekrandan istediginiz secenekleri action objesiyle seciniz
        Actions actions = new Actions(driver);
        List<WebElement>allOptions= driver.findElements(By.xpath("//div[@id='container']//h3"));
//        for (int i=0; i< allOptions.size(); i++){
//            switch (allOptions.get(i).getText()){
//                case "Selenium":
//                case "TestNg":
//                case "Cypress":
//                    actions.keyDown(Keys.CONTROL).click(allOptions.get(i)).keyUp(Keys.CONTROL).build().perform();
//                    break;
//            }
//        }

        actions.keyDown(Keys.CONTROL);
        for (int i=0; i< allOptions.size(); i++){
            switch (allOptions.get(i).getText()){
                case "Selenium":
                case "TestNg":
                case "Appium":
                    actions.click(allOptions.get(i)).perform();
                    waitFor(1);break;
            }
        }
        actions.keyUp(Keys.CONTROL);

//        WebElement selenium= driver.findElement(By.xpath("(//div[@id='selectable'])[1]"));
//        WebElement testNG= driver.findElement(By.xpath("(//div[@id='selectable'])[4]"));
//        WebElement testPro= driver.findElement(By.xpath("(//div[@id='selectable'])[8]"));
//        actions.keyDown(Keys.CONTROL).click(selenium).click(testNG).click(testPro).build().perform();
    }
}
