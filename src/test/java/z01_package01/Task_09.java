package z01_package01;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task_09 extends TestBase {

    @Test
    public void test01(){

//        1-https://books-pwakit.appspot.com/ adresine gidin.
        driver.get("https://books-pwakit.appspot.com/");

//        2-"BOOKS" başlığının görünür olduğunu doğrulayın
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement searchBox = (WebElement) ((JavascriptExecutor) driver).executeScript("return document.querySelector('[apptitle=\"BOOKS\"]').shadowRoot.querySelector('[id=\"input\"]')");
        searchBox.sendKeys("erkam", Keys.ENTER);

//        3-Arama çubuğunda "Selenium" u aratın.


//        4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.

    }
}
