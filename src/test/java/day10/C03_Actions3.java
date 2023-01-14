package day10;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions3 extends TestBase {

    @Test
    public void scrollUpDown(){

        //Class: ActionClass3
        //Method : scrollUpDown()

        //https://techproeducation.com a git
        driver.get("https://techproeducation.com");

        //Sayfanin altına doğru gidelim
        Actions actions = new Actions(driver);

        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        waitFor(2);

        //Sonra sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(2);

        actions.sendKeys(Keys.ARROW_UP).perform();
        waitFor(2);
    }
}
