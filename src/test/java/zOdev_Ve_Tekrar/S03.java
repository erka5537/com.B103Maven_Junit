package zOdev_Ve_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class S03 {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement anaSayfaTusuGorunuyorMu = driver.findElement(By.cssSelector("body[style]"));
        if (anaSayfaTusuGorunuyorMu.isDisplayed()) {
            System.out.println("anaSayfaTusuGorunuyorMu Testi PASSED");
        } else System.out.println("anaSayfaTusuGorunuyorMu Testi FAILED");

        //4. Click 'Products' button
        driver.findElement(By.cssSelector("a[href=\"/products\"]")).click();
        clickOutside();
        //driver.findElement(By.xpath("//*[@style=\"top: 0px;\"]")).click();//reklami kapat  ===>> // ❌ÇALIŞMIYOR❌

        //5. Hover over first product and click 'Add to cart'
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//*[@data-product-id=\"1\"])[1]")).click();

        // 6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[@class=\"btn btn-success close-modal btn-block\"]")).click();

        //7. Hover over second product and click 'Add to cart'
        driver.findElement(By.xpath("(//*[@data-product-id=\"2\"])[1]")).click();

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("(//*[@href=\"/view_cart\"])[2]")).click();

        //9. Verify both products are added to Cart

    }
    public static void clickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }
}
