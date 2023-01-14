package zOdev_Ve_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class E03 {
    static WebDriver driver;

    @Test
    public void test01() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        //1. Launch browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.cssSelector("body[style]"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href=\"/login\"]")).click();

        //5. Fill all details in Signup and create account
        //Name, Email address, Click 'Signup' button
        driver.findElement(By.xpath("//*[@type=\"text\"]")).sendKeys("ahmet");
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("caxzvbn_8566@gmail.com");
        driver.findElement(By.cssSelector("button[data-qa=\"signup-button\"]")).click();

        //Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@value=\"Mr\"]")).click();
        driver.findElement(By.xpath("//*[@type=\"password\"]")).sendKeys("12345");
        List<WebElement> days = driver.findElements(By.xpath("//*[@data-qa=\"days\"]/option"));
        days.get(8).click();
        driver.findElement(By.xpath("(//*[@data-qa=\"months\"]/option)[4]")).click();
        driver.findElement(By.xpath("//*[@data-qa=\"years\"]")).sendKeys("1990");

        // 🔺 Sayfanın altından kayan reklam çıkmıyorsa aşağıdaki 3 satırı yoruma alın 🔻
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class=\"grippy-host\"]")).click();
        Thread.sleep(2000);

        //Select checkboxes
        driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"optin\"]")).click();

        //First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        firstName.sendKeys("Ahmet", Keys.TAB, "Yılmaz", Keys.TAB, "company", Keys.TAB, "address", Keys.TAB, "address2", Keys.TAB, "Canada", Keys.TAB, "state", Keys.TAB, "city", Keys.TAB, "14586 ", Keys.TAB, "852");

        //Click 'Create Account button'
        driver.findElement(By.xpath("//*[@data-qa=\"create-account\"]")).click();

        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement check= driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(check.isDisplayed());
        driver.findElement(By.cssSelector("a[data-qa=\"continue-button\"]")).click();

        //🔺 Tam sayfa açılan reklamı kapatmak için kullanılan method. Reklam çıkmıyorsa aşağıdaki 1 satırı yoruma alın 🔻
        clickOutside();

        //7. Verify that 'Logged in as username' is visible
        WebElement loggedUsername = driver.findElement(By.cssSelector("i[class=\"fa fa-user\"]"));
        Assert.assertTrue(loggedUsername.isDisplayed());

        // 🔺 Sayfanın altından kayan reklam çıkmıyorsa aşağıdaki 3 satırı yoruma alın 🔻
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class=\"grippy-host\"]")).click();
        Thread.sleep(2000);

        //8. Add products to cart
        driver.findElement(By.xpath("(//*[@data-product-id=\"1\"])[1]")).click();

        //9. Click 'Cart' button
        driver.findElement(By.xpath("//*[@class='fa fa-shopping-cart']")).click();

        //10. Verify that cart page is displayed
        WebElement sepet= driver.findElement(By.xpath("//*[@class='breadcrumb']"));
        Assert.assertTrue(sepet.isDisplayed());

        //11. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[@class=\"btn btn-default check_out\"]")).click();

        //12. Verify Address Details and Review Your Order
        WebElement adresDetails=driver.findElement(By.xpath("//*[text()='Address Details']"));
        Assert.assertTrue(adresDetails.isDisplayed());
        WebElement reviewYourOrder=driver.findElement(By.xpath("//*[text()='Review Your Order']"));
        Assert.assertTrue(reviewYourOrder.isDisplayed());

        //13. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.cssSelector("textarea[class='form-control']")).sendKeys("Ürünler çok ucuz");
        driver.findElement(By.xpath("//*[@class='btn btn-default check_out']")).click();

        //14.Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//*[@name=\"name_on_card\"]")).sendKeys("muhammed",
                Keys.TAB, "1234 5285 8525 9696",Keys.TAB,"235",Keys.TAB,"05",Keys.TAB, "2025");

        //15. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//*[@id='submit']")).click();
        driver.navigate().back();

        // 🔺 Sayfanın altından kayan reklam çıkmıyorsa aşağıdaki 3 satırı yoruma alın 🔻
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class=\"grippy-host\"]")).click();
        Thread.sleep(2000);

        //16. Not Verify success message 'Your order has been placed successfully!'
        WebElement placedSuccessfulyYazisiVarmi = driver.findElement(By.xpath("//*[@class=\"col-md-12 form-group\"]/div"));
        Assert.assertEquals("Your order has been placed successfully!", placedSuccessfulyYazisiVarmi.getText());
        driver.findElement(By.xpath("//*[@id='submit']")).click();

        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement deleted = driver.findElement(By.cssSelector("h2[data-qa=\"account-deleted\"]"));
        Assert.assertTrue(deleted.isDisplayed());
        driver.findElement(By.cssSelector("a[data-qa=\"continue-button\"]")).click();
    }

    //Tam sayfa açılan reklamı kapatmak için oluşturulan method. Reklamın açıldığı yerde kapatmak methodu çağırın.
    public void clickOutside() {
        Actions action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }
}
