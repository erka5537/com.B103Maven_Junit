package practice.erol_hoca.practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P03_Actions extends TestBase {

    @Test
    public void test01(){
        /*
                                            Actions
    Action sınıfı, belirli web öğelerinde bir klavyeden veya fareden giriş eylemlerini simüle etmek için kullanılır.
Örneğin, Sol Tıklama, Sağ Tıklama, Çift Tıklama, sürükleyip bırakma, bir webelementin üzerinde bekletme vb.
 */

//    http://uitestpractice.com/Students/Actions adresine gidelim
        driver.get("http://uitestpractice.com/Students/Actions");

//    Mavi kutu uzerinde 3 saniye bekleyelim ve rengin degistigini gorelim
        Actions actions = new Actions(driver);
        WebElement renkKutusu = driver.findElement(By.id("div2"));
        String oncekiRenk = renkKutusu.getCssValue("background-color");
        actions.moveToElement(driver.findElement(By.id("div2"))).perform();
        String sonrakiRenk = renkKutusu.getCssValue("background-color");
        Assert.assertNotEquals(oncekiRenk, sonrakiRenk);
        waitFor(3);


//    Double Click Me! butonuna tiklayalim ve cikan mesajin "Double Clicked !!" oldugunu dogrulayalim
        actions.doubleClick(driver.findElement(By.xpath("//*[@name='dblClick']"))).perform();
        Assert.assertEquals(driver.switchTo().alert().getText(),"Double Clicked !!");

//    Accept ile alert'ü kapatalım
        driver.switchTo().alert().accept();

//    Drag and drop kutularini kullanin ve islemi yaptiktan sonra hedef  kutuda "Dropped!" yazildigini dogrulayin
        actions.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).build().perform();
        Assert.assertEquals("Dropped!", driver.findElement(By.xpath("//*[@id='droppable']/p")));
    }
}
