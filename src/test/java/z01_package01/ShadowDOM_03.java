package z01_package01;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class ShadowDOM_03 extends TestBase {

    @Test
    public void test01(){

        driver.get("https://letcode.in/shadow");

        //Örnek için #Step1, yani Temel Elemanı bulun:
        WebElement root1 = driver.findElement(By.cssSelector("div[id='open-shadow']"));

        //#Adım 2
        ////Get shadow root element
        SearchContext shadowRoot1 = root1.getShadowRoot();

        //#3. Adım - CSS Seçici kullanarak gölge kökü içindeki öğeleri bulmamız gerekiyor, xpath burada çalışmayacaktır
        //Here we will get Element inside Shadow Dom Element
        shadowRoot1.findElement(By.cssSelector("input[id='fname']")).sendKeys("erkam");

//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        WebElement name = (WebElement) ((JavascriptExecutor) driver).executeScript("return document.querySelector('[id=\"userName\"]').shadowRoot.querySelector('#kils')");
//        name.sendKeys("erkam");

    }
    public WebElement getShadowRootElement(WebElement element) {
        WebElement ele = (WebElement) ((JavascriptExecutor)driver)
                .executeScript("return arguments[0].shadowRoot", element);
        return ele;
    }
}
