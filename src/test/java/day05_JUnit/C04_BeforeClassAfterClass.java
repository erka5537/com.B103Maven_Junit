package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {

    /*
    @BeforeClass ve @AfterClass notasyonları sadece static method'lar için çalışır.
    @BeforeClass ve @AfterClass kullanırak oluşturduğumuz @Test methodlarının hepsini aynı anda çalıştırıp
    en son @AfterClass'ı çalıştırırız.
        Ama sadece @Before ve @After kullanırsak her test için @Before ve @After'kullanır
     */

    @BeforeClass
    public static void setUp(){
        System.out.println("Bütün testlerden önce çalıştı");
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Bütün testlerden sonra çalıştı");
    }

    @Before
    public void setUp01(){
        System.out.println("Her Test'den Önce Çalışır");
    }

    @After
    public void teardown01(){
        System.out.println("Her Test'den Sonra Çalışır");
    }

    @Test
    public void test01() {
        System.out.println("İlk Test");
    }

    @Test
    public void test02() {
        System.out.println("İkinci Test");
    }

    @Test
    @Ignore // Eğer bir testi çalıştırmak istemezsek bu şekilde kullanabiliriz
    public void test03(){
        System.out.println("Çalışmasın Ke KE");
    }
}
