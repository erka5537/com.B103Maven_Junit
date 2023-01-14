package zOdev_Ve_Tekrar;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;
public class E04 {
    /*
    ● Bir class oluşturun: DropDown
● https://the-internet.herokuapp.com/dropdown adresine gidin.
1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
4.Tüm dropdown değerleri(value) yazdırın
5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
False yazdırın
     */
    static WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    @Test
    public void indexKullan() {
//        1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropdownList= driver.findElement(By.id("dropdown"));
        Select ddm= new Select(dropdownList);
        ddm.selectByIndex(1);
    }
    @Test
    public void valueKullan() {
        //        2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        WebElement dropdownList= driver.findElement(By.id("dropdown"));
        Select ddm= new Select(dropdownList);
        ddm.selectByValue("1");
    }
    @Test
    public void visibleTextKullan() {
//   3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropdownList= driver.findElement(By.id("dropdown"));
        Select ddm= new Select(dropdownList);
        ddm.selectByVisibleText("Option 1");
    }
    @Test
    public void dropDownlariYazdir() {
        //        4.Tüm dropdown değerleri(value) yazdırın
        List <WebElement> dropdownList= driver.findElements(By.id("dropdown"));
        dropdownList.forEach(t-> System.out.println(t.getText()));
    }
    @Test
    public void dropDownBuyutunuBul() {
//  5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın
        driver.findElements(By.xpath("//*[@id='dropdown']/option"));

        WebElement dropdownList = driver.findElement(By.id("dropdown"));
        Select ddm= new Select(dropdownList);
        List <WebElement> ddmList= ddm.getOptions();
        for (WebElement w: ddmList){
            System.out.println(w.getText());
        }
//        if (ddmList.size()==4){
//            System.out.println("True");
//        }else {System.out.println("false");}
        System.out.println("dropdownList.size() = " + ddmList.size());
        String sonuc= ddmList.size() == 4 ? "True": "False" ;
        System.out.println("sonuc = " + sonuc);
    }
    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }
}