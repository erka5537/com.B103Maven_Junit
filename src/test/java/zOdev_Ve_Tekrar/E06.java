package zOdev_Ve_Tekrar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class E06 {
    /*
    1. Bir class oluşturun : CheckBoxTest
2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
a. Verilen web sayfasına gidin.
https://the-internet.herokuapp.com/checkboxes
b. Checkbox1 ve checkbox2 elementlerini locate edin.
c. Checkbox1 seçili değilse onay kutusunu tıklayın
d. Checkbox2 seçili değilse onay kutusunu tıklayın
     */
    static WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
    @Test
    public void test01() {
        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1 =driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox2 =driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }else {System.out.println("Checkbox1 kutusu isaretli");}
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkbox2.isSelected()){
            checkbox1.click();
        }else System.out.println("Checkbox2 kutusu isaretli");
    }
    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }
}
