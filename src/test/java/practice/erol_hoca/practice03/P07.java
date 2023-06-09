package practice.erol_hoca.practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P07 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

//    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

//    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        Actions actions = new Actions(driver);
        actions.moveByOffset(688,450).build().perform();
        actions.clickAndHold().build().perform();
        actions.moveByOffset(80,-250).build().perform();
        actions.moveByOffset(-80,+250).build().perform();
        actions.moveByOffset(80,-250).build().perform();actions.release().perform();

        actions.clickAndHold().build().perform();
        actions.moveByOffset(80,250).build().perform();
        actions.moveByOffset(-80,-250).build().perform();
        actions.moveByOffset(80,250).build().perform();actions.release().perform();

        actions.clickAndHold().build().perform();
        actions.moveByOffset(-200,-170).build().perform();
        actions.moveByOffset(+200,+170).build().perform();
        actions.moveByOffset(-200,-170).build().perform();actions.release().perform();

        actions.clickAndHold().build().perform();
        actions.moveByOffset(270,0).build().perform();
        actions.moveByOffset(-270,0).build().perform();
        actions.moveByOffset(+270,0).build().perform();actions.release().perform();

        actions.clickAndHold().build().perform();
        actions.moveByOffset(-230,170).build().perform();
        actions.moveByOffset(+230,-170).build().perform();
        actions.moveByOffset(-230,170).build().perform();actions.release().perform();

//    - Son olarak sayfayı temizleyiniz

    }
}
