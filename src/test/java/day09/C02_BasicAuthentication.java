package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {

    @Test
    public void basicAuthenticationTest(){
//        Bir class olusturun : BasicAuthentication
//        https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("//the-internet.herokuapp.com/basic_auth");

//        asagidaki yontem ve test datalarini kullanarak authentication’i yapin
//        URL              : https://username:password@URL
//        Username    : admin
//        password    : admin
//        Basarili sekilde sayfaya girin ve ‘Congratulations!’ yasizini doğrulayın
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String actualText = driver.findElement(By.xpath("//p")).getText();
        waitFor(3);
        String expectedText = "Congratulations";
        Assert.assertTrue(actualText.contains(expectedText));
    }
}
