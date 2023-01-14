package day13;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class C01_NullPointerException{

    WebDriver driver;
    Faker faker;
    @Test
    public void nullPointerExceptionTest(){
        driver.get("https://www.techproeducation.com");//java.lang.NullPointerException
//                                                       at day13.C01_NullPointerException.nullPointerExceptionTest
//
//                              NullPointerException
//        Değişkenleri oluşturup instantiate etmediğimizde alırız(new kelimesini kullanmadığımızda)
//        örneğin WebDriver driver; deyip new ChromeDriver() demezsek null pointer exception alırız


//                              Solution
//        Değişkeni instantiate et
    }

    @Test
    public void nullPointerExceptionTest2(){
        System.out.println(faker.name().fullName());//java.lang.NullPointerException
    }
}
