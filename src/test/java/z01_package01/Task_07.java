package z01_package01;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Task_07 extends TestBase {

    @Test
    public void test01(){

    //test01
    // https://the-internet.herokuapp.com/ adresine git
    driver.get("https://the-internet.herokuapp.com/");

    //Digest Authentication (user and pass: admin) yazisina tikla
        driver.findElement(By.xpath("//li/a[@href='/digest_auth']")).click();

    //Acilan ekrandaki mesaji yazdir
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

    //Kullanici Adi ve Sifreyi gir

    //oturum ac'a bas


//TEST 02
// https://the-internet.herokuapp.com/ adresine git

    //Digest Authentication (user and pass: admin) yazisina tikla
    //Acilan ekrandaki mesaji yazdir
    //iptal'e bas
    //bir onceki sayfaya geri don


    }
}
