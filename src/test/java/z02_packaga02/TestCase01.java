package z02_packaga02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TestCase01 {

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
/*
​
Test Case 1: Register User
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
11. Select checkbox 'Receive special offers from our partners!'
12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
******************************************************
​
 */

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        2. Navigate to url 'http://automationexercise.com'

        driver.navigate().to("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement anaSayfaTusuGorunuyorMu= driver.findElement(By.cssSelector("body[style]"));
        if (anaSayfaTusuGorunuyorMu.isDisplayed()){
            System.out.println("anaSayfaTusuGorunuyorMu Testi PASSED");
        }else  System.out.println("anaSayfaTusuGorunuyorMu Testi FAILED");

//        4. Click on 'Signup / Login' button

        driver.findElement(By.cssSelector("a[href='/login']")).click();

//        5. Verify 'New User Signup!' is visible
        WebElement NewUserSignupGorunuyorMu = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        if (NewUserSignupGorunuyorMu.isDisplayed()) {
            System.out.println("New User Signup Testi PASSED");
        } else System.out.println("New User Signup Testi FAILED");

        //   6. Enter name and email address
        WebElement nameKutusuVeriGir = driver.findElement(By.cssSelector("input[data-qa='signup-name']"));
        nameKutusuVeriGir.sendKeys("Mustafa");

        WebElement eMailKutusuVeriGir = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
        eMailKutusuVeriGir.sendKeys("kusulua@gmail.com");

        //VEYA
        // driver.findElement(By.cssSelector("input[data-qa='signup-name']")).sendKeys("Mustafa", Keys.TAB,"kusuluabc@gmail.com", Keys.TAB;

//        7. Click 'Signup' button
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();

//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccountInferGorunuyorMu = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        if (enterAccountInferGorunuyorMu.isDisplayed()) {
            System.out.println("ENTER ACCOUNT INFORMATION Testi PASSED");
        } else System.out.println("ENTER ACCOUNT INFORMATION Testi FAILED");

//        9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.cssSelector("input[id='id_gender1']")).click();

        WebElement passwordGir = driver.findElement(By.cssSelector("input[id='password']"));
        passwordGir.sendKeys("014036");

        WebElement gunGir = driver.findElement(By.cssSelector("select[id='days']"));
        gunGir.sendKeys("26");

        WebElement ayGir = driver.findElement(By.cssSelector("select[id='months']"));
        ayGir.sendKeys("August");

        WebElement yilGir = driver.findElement(By.cssSelector("select[id='years']"));
        yilGir.sendKeys("1978");


//        10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.cssSelector("input[id='newsletter']")).click();

//        11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.cssSelector("input[id='optin']")).click();

//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.cssSelector("input[id='first_name']")).sendKeys("Ali");
        driver.findElement(By.cssSelector("input[id='last_name']")).sendKeys("Veli");
        driver.findElement(By.cssSelector("input[id='company']")).sendKeys("Turkiye");
        driver.findElement(By.cssSelector("input[id='address1']")).sendKeys("Kutahya");
        driver.findElement(By.cssSelector("input[id='address2']")).sendKeys("Kusu");
        driver.findElement(By.cssSelector("select[id='country']")).sendKeys("India");
        driver.findElement(By.cssSelector("input[id='state']")).sendKeys("Simav");
        driver.findElement(By.cssSelector("input[id='city']")).sendKeys("Simav");
        driver.findElement(By.cssSelector("input[id='city']")).sendKeys("Simav");
        driver.findElement(By.cssSelector("input[id='zipcode']")).sendKeys("43500");
        driver.findElement(By.cssSelector("input[id='mobile_number']")).sendKeys("+905515464350");

//        13. Click 'Create Account button'
        driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();

//        14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreatedYazisiGorunurMu=   driver.findElement(By.cssSelector("h2[data-qa='account-created']"));

        if (accountCreatedYazisiGorunurMu.isDisplayed()){
            System.out.println("accountCreatedYazisiGorunurMu Testi PASSED");
        }else System.out.println("accountCreatedYazisiGorunurMu Testi FAILED");

//        15. Click 'Continue' button

        driver.findElement(By.cssSelector("a[data-qa='continue-button']")).click();
        Thread.sleep(3000);

        //clickOutside();//Acilan Reklami kapatmak icin

//        16. Verify that 'Logged in as username' is visible
        WebElement basariliGirisYazisiGorunuyorMu= driver.findElement(By.cssSelector("i[class='fa fa-user']"));
        if (basariliGirisYazisiGorunuyorMu.isDisplayed()){
            System.out.println("basariliGirisYazisiGorunuyorMu Testi PASSED");
        }else  System.out.println("basariliGirisYazisiGorunuyorMu Testi FAILED");

//        //  17. Click 'Delete Account' button
//        driver.findElement(By.cssSelector("a[href='/delete_account']")).click();
//        Thread.sleep(3000);
////        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
//        WebElement sonucYazisi= driver.findElement(By.cssSelector("h2[data-qa='account-deleted']"));
//        System.out.println("sonucYazisi.getTagName() = " + sonucYazisi.getText());
//
//        if (sonucYazisi.getText().equals("ACCOUNT DELETED!")){
//            System.out.println("sonucYazisi Testi PASSED");
//        }else System.out.println("sonucYazisi Testi FAILED");
//
////click 'Continue' button
//
//        driver.findElement(By.cssSelector("a[class='btn btn-primary']")).click();
//
//    }
//
//    public static void clickOutside() {
//        Actions action = new Actions(driver);
//        action.moveByOffset(0, 0).click().build().perform();
    }
}