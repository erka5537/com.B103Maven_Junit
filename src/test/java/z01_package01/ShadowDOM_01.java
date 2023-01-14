package z01_package01;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class ShadowDOM_01 extends TestBase {

    @Test
    public void test01() throws InterruptedException {


        driver.get("https://letcode.in/shadow");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        String str = "return document.querySelector('#open-shadow').shadowRoot.querySelector('#fname')";
        WebElement fname = (WebElement) ((JavascriptExecutor) driver).executeScript(str);
        fname.sendKeys("erkam");

        ((JavascriptExecutor) driver).executeScript("document.querySelector('my-web-component').myRoot.querySelector('#lname').value = 'erkam'");

        /*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list
        */

    }
}
