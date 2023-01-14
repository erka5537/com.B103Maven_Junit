package zOdev_Ve_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Sil {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://automationexercise.com/payment");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class=\"grippy-host\"]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("a");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("a");
        driver.findElement(By.xpath("//input[@placeholder='ex. 311']")).sendKeys("a");
        driver.findElement(By.xpath("//input[@placeholder='MM']")).sendKeys("a");
        driver.findElement(By.xpath("//input[@placeholder='YYYY']")).sendKeys("a");

        //findElement(By.xpath("//button[@id='submit']"));

        WebElement buton = driver.findElement(By.xpath("//button[@id='submit']"));
        buton.click();

        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().sendKeys(Keys.ESCAPE);



        //driver.findElement(By.tagName("html")).sendKeys(Keys.ESCAPE);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);




//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        ((JavascriptExecutor) driver).executeScript("return window.stop");


//        WebElement myDynamicElement = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"col-md-12 form-group\"]/div")));

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"col-md-12 form-group\"]/div")));


        WebElement yazi = driver.findElement(By.xpath("//*[@class=\"col-md-12 form-group\"]/div"));
        System.out.println("yazi.getText() = " + yazi.getText());

    }

    public static void findElement(By by) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(by);
    }

    public static void clickElement(WebElement element) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        element.click();
    }

    public static void clickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }
}
