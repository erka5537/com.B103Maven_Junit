package zOdev_Ve_Tekrar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.TestBase;

import java.time.Duration;

public class E07 {

    /*
TEST CASE 1
 1. Home Page with three Sliders only
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Sliders only
6) The Home page must contains only three sliders
  1. Yalnızca üç Sürgü içeren Ana Sayfa
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Şimdi Ana menü düğmesine tıklayın
5) Ana sayfada yalnızca Üç Kaydırıcı olup olmadığını test edin
6) Ana sayfa yalnızca üç kaydırıcı içermelidir
 */
    WebDriver driver;
    @Test
    public void test01() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=C:\\Users\\ERKA55\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Extensions\\gighmmpiobklfepjocnamgkkbiglidom\\5.3.3_0");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");
//        3) Click on Shop Menu
        driver.findElement(By.xpath("(//a[@href='https://practice.automationtesting.in/shop/'])[1]")).click();
        Thread.sleep(3000);
//        4) Now click on Home menu button
        driver.findElement(By.xpath("(//a[@href='https://practice.automationtesting.in'])[2]")).click();
//        5) Test whether the Home page has Three Sliders only
//        6) The Home page must contains only three sliders
    }

}
