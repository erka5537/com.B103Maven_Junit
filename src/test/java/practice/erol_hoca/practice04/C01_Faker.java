package practice.erol_hoca.practice04;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        /*
                               - FAKER -
        Faker class'ı, adlar, telefon numaraları, adresler, SSN vb.
    gibi gerçek görünümlü verileri dinamik olarak oluşturmanıza olanak tanır.
    Web uygulamanızın bunları doğru bir şekilde kaydedeceğini bildiğiniz sürece,
    çoğu zaman ad veya adres gibi bu değerlerin ne olduğu umurunuzda olmaz ve faker kullanmak
    bu verileri modellemenize ve bu alanlar için şimdiye kadar test çalıştırması için yeni dinamik
    değerler oluşturmanıza olanak tanır.
        Faker class'ını kullanabilmemiz için mvn repository adresinden java faker kütüphanesini
    projemize eklememiz gerekmektedir.
     */
        //"https://demoqa.com/automation-practice-form"  Adresine gidin
        driver.get("https://demoqa.com/automation-practice-form");

        // Formu doldurunuz
        Faker faker = new Faker();//647 555
        Actions actions = new Actions(driver);
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(faker.name().firstName()+
                Keys.TAB + faker.name().lastName()+
                Keys.TAB + faker.internet().emailAddress()+
                Keys.TAB + Keys.SPACE+
                Keys.TAB + faker.phoneNumber().cellPhone()+
                Keys.TAB + "20 mar 1974" + Keys.ENTER+
                Keys.TAB + "Maths");actions.moveByOffset(647,555).click().build().perform();

        waitFor(10);
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='0.8'");

        // Sayfayi kapatin
    }


    /*
                               - FAKER -
        Faker class'ı, adlar, telefon numaraları, adresler, SSN vb.
    gibi gerçek görünümlü verileri dinamik olarak oluşturmanıza olanak tanır.
    Web uygulamanızın bunları doğru bir şekilde kaydedeceğini bildiğiniz sürece,
    çoğu zaman ad veya adres gibi bu değerlerin ne olduğu umurunuzda olmaz ve faker kullanmak
    bu verileri modellemenize ve bu alanlar için şimdiye kadar test çalıştırması için yeni dinamik
    değerler oluşturmanıza olanak tanır.
        Faker class'ını kullanabilmemiz için mvn repository adresinden java faker kütüphanesini
    projemize eklememiz gerekmektedir.
     */
    //"https://demoqa.com/automation-practice-form"  Adresine gidin
    // Formu doldurunuz
    // Sayfayi kapatin
    @Test
    public void name() {
        //"https://demoqa.com/automation-practice-form"  Adresine gidin
        driver.get("https://demoqa.com/automation-practice-form");
        // Formu doldurunuz
        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,Keys.SPACE,Keys.TAB,faker.phoneNumber().cellPhone(),Keys.TAB
                ,"20 Jul 1980",Keys.ENTER,Keys.TAB,faker.shakespeare().romeoAndJulietQuote(),Keys.TAB,Keys.SPACE);
        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='uploadPicture']"));
        //String dosyaYolu = "C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\sen.txt";
        String anaYol = System.getProperty("user.home"); //C:\\Users\\Lenovo\\
        String ortakYol = "\\OneDrive\\Masaüstü\\sen.txt";
        String dosyaYolu = anaYol+ortakYol;
        dosyaSec.sendKeys(dosyaYolu);
    }
}
