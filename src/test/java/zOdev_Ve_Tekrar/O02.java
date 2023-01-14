package zOdev_Ve_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class O02 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Test Case 1: Register User
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.cssSelector("body[style]"));
        if(homePage.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href=\"/login\"]")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUser = driver.findElement(By.xpath("//*[text()=\"New User Signup!\"]"));
        if(newUser.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //6. Enter name and email address
        driver.findElement(By.xpath("//*[@type=\"text\"]")).sendKeys("ahmet", Keys.TAB);
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("ahmet_7842@gmail.com");

        //7. Click 'Signup' button
        driver.findElement(By.cssSelector("button[data-qa=\"signup-button\"]")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccount = driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        if(enterAccount.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@value=\"Mr\"]")).click();
        WebElement password = driver.findElement(By.xpath("//*[@type=\"password\"]"));
        password.sendKeys("12345", Keys.TAB, "8", Keys.TAB, "March", Keys.TAB, "1991", Keys.TAB, Keys.SPACE);


        List<WebElement> days = driver.findElements(By.xpath("//*[@data-qa=\"days\"]/option"));
        days.get(8).click();
        driver.findElement(By.xpath("(//*[@data-qa=\"months\"]/option)[4]")).click();
        driver.findElement(By.xpath("//*[@data-qa=\"years\"]")).sendKeys("1990");
        driver.findElement(By.cssSelector("body[style]")).sendKeys(Keys.PAGE_DOWN);

        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id=\"optin\"]")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        firstName.sendKeys("Ahmet", Keys.TAB, "Yılmaz", Keys.TAB, "company", Keys.TAB, "address", Keys.TAB, "address2", Keys.TAB, "Canada", Keys.TAB, "state", Keys.TAB, "city", Keys.TAB, "14586 ", Keys.TAB, "852", Keys.TAB);

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[@data-qa=\"create-account\"]")).click();

        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement created = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        if(created.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //15. Click 'Continue' button
        driver.findElement(By.cssSelector("a[data-qa=\"continue-button\"]")).click();


        //16. Verify that 'Logged in as username' is visible
        WebElement loggedUsername = driver.findElement(By.cssSelector("i[class=\"fa fa-user\"]"));
        if(loggedUsername.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //17. Click 'Delete Account' button
        driver.findElement(By.cssSelector("a[href=\"/delete_account\"]")).click();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement deleted = driver.findElement(By.cssSelector("h2[data-qa=\"account-deleted\"]"));
        if(deleted.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");
        driver.findElement(By.cssSelector("a[data-qa=\"continue-button\"]")).click();


    }
}
