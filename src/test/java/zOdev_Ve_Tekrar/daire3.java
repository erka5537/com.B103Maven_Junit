package zOdev_Ve_Tekrar;

import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class daire3 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

//    - http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");

//    - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        new Actions(driver).moveByOffset(0,0).click().build().perform();

        Actions actions = new Actions(driver);
        actions.moveByOffset(660,345).build().perform();

        int y = 13;
        actions.clickAndHold().build().perform();
        for (int i=1; i<14; i++){
            actions.moveByOffset(i,-y).build().perform();
            y--;
        }
        for (int i=14; i>-1; i--){
            actions.moveByOffset(i,-y).build().perform();
            y--;
        }
        for (int i=0; i>-19; i--){
            actions.moveByOffset(i,-y).build().perform();
            y++;
        }
        for (int i=-9; i<3; i++){
            actions.moveByOffset(i,-y).build().perform();
            y++;
        }






//        for (int i=12; i>2; i++){
//            actions.moveByOffset(i,-y).build().perform();
//            y--;
//        }
//        for (int i=2; i>-8; i--){
//            actions.moveByOffset(i,-y).build().perform();
//            y++;
//        }
//        for (int i=-8; i<2; i++){
//            actions.moveByOffset(i,-y).build().perform();
//            y++;
//        }

//        int x=615;
//        for (int y=340; y<350; y++){
//            actions.moveByOffset(x,y).build().perform();
//            x++;
//        }
//        actions.release().perform();


//    - Son olarak sayfayı temizleyiniz

    }
}
