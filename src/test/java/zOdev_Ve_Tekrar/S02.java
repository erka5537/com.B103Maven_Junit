package zOdev_Ve_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class S02 {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {



//        1-https://books-pwakit.appspot.com/ adresine gidin.
        driver.get("https://books-pwakit.appspot.com/");

//        2-"BOOKS" başlığının görünür olduğunu doğrulayın
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String str = "return document.querySelector('body > book-app').shadowRoot.querySelector('#input')";
        WebElement el = (WebElement) ((JavascriptExecutor) driver).executeScript(str);
        el.sendKeys("gönderilecek yazı");

        Thread.sleep(1000);
        SearchContext shadow1 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        Thread.sleep(1000);
        WebElement book = shadow1.findElement(By.cssSelector("a[href='/']"));
        Assert.assertTrue(book.isDisplayed());

//        3-Arama çubuğunda "Selenium" u aratın.
        Thread.sleep(1000);
        SearchContext shadow2 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        Thread.sleep(1000);
        shadow2.findElement(By.cssSelector("#input")).sendKeys("Selenium", Keys.ENTER);

//        4-Arama sonuçlarındaki ilk ürün isminin "Selenium" içerdiğini doğrulayın.
        Thread.sleep(1000);
        SearchContext shadow3 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow4 = shadow3.findElement(By.cssSelector("book-explore[class='_page']")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow5 = shadow4.findElement(By.cssSelector(" section:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > book-item:nth-child(1)")).getShadowRoot();
        Thread.sleep(1000);
        WebElement product1 = shadow5.findElement(By.cssSelector(".title"));
        Assert.assertTrue(product1.getText().contains("Selenium"));
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
