package zOdev_Ve_Tekrar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class daire extends TestBase {

    @Test
    public void test01() throws InterruptedException {

//    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

//    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz

        Actions actions = new Actions(driver);
        actions.moveByOffset(660,345).build().perform();

        int y= 10;
        for (int i=1; i<11; i++){
            actions.clickAndHold().build().perform();
            actions.moveByOffset(i,-y).build().perform();
            actions.moveByOffset(-i,y).build().perform();
            actions.moveByOffset(i,-y).build().perform();actions.release().perform();
            y--;
        }
        for (int i=11; i>0; i--){
            actions.clickAndHold().build().perform();
            actions.moveByOffset(i,-y).build().perform();
            actions.moveByOffset(-i,y).build().perform();
            actions.moveByOffset(i,-y).build().perform();actions.release().perform();
            y--;
        }
        for (int i=0; i>-11; i--){
            actions.clickAndHold().build().perform();
            actions.moveByOffset(i,-y).build().perform();
            actions.moveByOffset(-i,y).build().perform();
            actions.moveByOffset(i,-y).build().perform();actions.release().perform();
            y++;
        }
        for (int i=-11; i<1; i++){
            actions.clickAndHold().build().perform();
            actions.moveByOffset(i,-y).build().perform();
            actions.moveByOffset(-i,y).build().perform();
            actions.moveByOffset(i,-y).build().perform();actions.release().perform();
            y++;
        }

//        int x=615;
//        for (int y=340; y<350; y++){
//            actions.moveByOffset(x,y).build().perform();
//            x++;
//        }
//        actions.release().perform();


//    - Son olarak sayfayı temizleyiniz

    }
}
