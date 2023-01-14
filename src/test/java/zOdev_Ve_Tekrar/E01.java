package zOdev_Ve_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class E01 {

    @Test
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement anaSayfa = driver.findElement(By.cssSelector("body[style]"));
        Assert.assertTrue(anaSayfa.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();

        //5. Verify 'Login to your account' is visible
        WebElement login = driver.findElement(By.xpath("//*[@class=\"login-form\"]/h2"));
        Assert.assertTrue(login.isDisplayed());

        //6. Enter correct email address and password
        driver.findElement(By.xpath("//*[@data-qa=\"login-email\"]")).sendKeys("asdas@gmail.com");
        driver.findElement(By.xpath("//*[@data-qa=\"login-password\"]")).sendKeys("12345");

        //7. Click 'login' button
        driver.findElement(By.xpath("//*[@data-qa=\"login-button\"]")).click();

        //8. Verify that 'Logged in as username' is visible
        WebElement logged = driver.findElement(By.xpath("//*[@class=\"fa fa-user\"]"));
        Assert.assertTrue(logged.isDisplayed());

        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href=\"/delete_account\"]")).click();

        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement deleted = driver.findElement(By.xpath("//*[text()=\"Account Deleted!\"]"));
        driver.findElement(By.xpath("//*[@data-qa=\"continue-button\"]")).click();
        Assert.assertTrue(deleted.isDisplayed());
    }
}
