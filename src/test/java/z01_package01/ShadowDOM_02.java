package z01_package01;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class ShadowDOM_02 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

//        1-https://books-pwakit.appspot.com/ adresine gidin.
        driver.get("https://books-pwakit.appspot.com/");

//        2-"BOOKS" başlığının görünür olduğunu doğrulayın


//        3-Arama çubuğunda "Selenium" u aratın.
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement search = (WebElement) ((JavascriptExecutor) driver).executeScript("return document.querySelector('book-app').shadowRoot.querySelector('#input')");
        search.sendKeys("erkam", Keys.ENTER);

        Thread.sleep(5000);

//        4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.
        WebElement urun = (WebElement) ((JavascriptExecutor) driver).executeScript("return document.querySelector('book-app').shadowRoot.querySelector('book-explore').shadowRoot.querySelector('book-item').shadowRoot.querySelector('h2')");
        System.out.println(urun.getText());
    }
}
