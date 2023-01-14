package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {

    WebDriver driver;
    //Eger test sinifinda birden fazla method olusturulmussa @Before kullanilir
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void selectByIndexTest(){
//        1. LOCATE dropdown element
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
//        2. Select objesi olustur
        Select yearDropdown = new Select(year);
//        3. Select object i kullaarak 3 farkli sekilde secim yapabilirim
        yearDropdown.selectByIndex(22);//SECENEK SIRASI 0 DAN BASLAR. 2000 yili 23. sirada
//        Dogun yilini, ayini, ve gununu su sekilde secer : 2000, January, 10

//        Ay Secimi
        WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
        Select ayDropDown = new Select(ay);
        ayDropDown.selectByValue("0");//option in value değeri ile seçim yapılabilir. January seçeneğinin value'si 0

//        Gun Secimi
        WebElement gun = driver.findElement(By.id("day"));
        Select gunDropDpwn = new Select(gun);
        gunDropDpwn.selectByVisibleText("10");
    }

    @Test
    public void printAllTest(){
        // Tum eyalet isimlerini consola yazdıralım
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropDown = new Select(state);
        List<WebElement> stateList = stateDropDown.getOptions();
        stateList.forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void getSelectedOptionsTest(){
//        State dropdownındaki varasyılan seçili seçeneğin Select a State olduğunu verify edelim
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        String varsayilanText = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State", varsayilanText);
    }

    @After
    public void tearDown(){
        driver.close();
    }


    /*
    1. What is dropdown? Dropdown nedir?
    Dropdown liste oluşturmak için kullanılır.
    2. How to handle dropdown elements? Dropdown nasıl automate edilir?
    -dopdown ı locate ederim
    - select objesi oluştururum
    - select objesi ile istediğim seçeneği seçerim
    Not: select objesi oluşturma nedenim, dropdownların Select classı ile oluşturması
    3. Tüm dropdown seçeneklerini nasıl print ederiz?
    - tüm dropdown elementlerini getOptions() methodu ile listeye koyarız
    - sonra seçenekleri loop ile yazdırabiliriz
    4. Bir seçeneğin seçili olduğunu otomate etmek için ne yapılır?
    Ornek: Gun olarak 10 ı seçdik ama ya seçilmediyse?
    getFirstSelectedOption() seçili olan seçeneği return eder

    */
}
