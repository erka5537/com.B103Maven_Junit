package zOdev_Ve_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class O03 {

    public static void main(String[] args) throws InterruptedException {
        ///*

        //    Test Case 12: Add Products in Cart

        //    1. Launch browser
        //1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.cssSelector("body[style]"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click 'Products' button
        driver.findElement(By.xpath("//*[@href=\"/products\"]")).click();
        clickOutside(driver);


        //to turn off the ad --> Kayan reklam çıkmıyorsa kapalı kalsın
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@class=\"grippy-host\"]")).click();
        Thread.sleep(5000);

        //5. Hover over first product and click 'Add to cart'
        driver.findElement(By.xpath("(//*[@class=\"btn btn-default add-to-cart\"])[1]")).click();

        //            6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();

        //7. Hover over second product and click 'Add to cart'
        driver.findElement(By.xpath("(//*[@class=\"btn btn-default add-to-cart\"])[3]")).click();

        //            8. Click 'View Cart' button
        driver.findElement(By.xpath("//*[text()='View Cart']")).click();
        //(//*[@href="/view_cart"])[2]

        //9. Verify both products are added to Cart
        WebElement blueTop = driver.findElement(By.xpath("//*[text()='Blue Top']"));
        if(blueTop.isDisplayed()){
            System.out.println("Passed");
        }else System.out.println("FAILED");

        WebElement tshirt = driver.findElement(By.xpath("//*[text()='Men Tshirt']"));
        if(tshirt.isDisplayed()){
            System.out.println("Passed");
        }else System.out.println("FAILED");

        //10. Verify their prices, quantity and total price
        List<WebElement> ücretler = driver.findElements(By.xpath("//*[@class=\"cart_price\"]"));
        if(ücretler.get(0).getText().equals("Rs. 500")){
            System.out.println("Passed");
        }
        List<WebElement> adetler = driver.findElements(By.xpath("//*[@class=\"cart_quantity\"]"));
        List<WebElement> toplamlar = driver.findElements(By.xpath("//*[@class=\"cart_total\"]"));



        //  */
    }
    public static void clickOutside(WebDriver driver) {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }
}
