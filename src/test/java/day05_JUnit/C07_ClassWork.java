package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_ClassWork {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.youtube.com adresine gidin
        driver.get("https://www.amazon.com");

    }
    @After
    public void tearDown(){
        //driver.close();
    }


    //title Test  => Sayfa başlığının “Amazon” oldugunu testedin
    //Amazon.com. Spend less. Smile more.
    @Test
    public void test01(){
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Amazon"));
    }

    //=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
    @Test
    public void test02(){
        WebElement sayfaResmi = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(sayfaResmi.isDisplayed());
    }

    //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    @Test
    public void test03(){
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        Assert.assertTrue(aramaKutusu.isEnabled());
    }

    //wrongTitleTest  => Sayfa basliginin “Amazon” olmadigini dogrulayin
    @Test
    public void test04(){
        String title = driver.getTitle();
        Assert.assertFalse(title.contains("Amazon"));
    }
}
