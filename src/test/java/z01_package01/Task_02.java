package z01_package01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Task_02 extends TestBase {

    @Test
    public void sortingFunctionality()  {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //3) Mağaza Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();

        //4) Varsayılan sıralama açılır menüsünde Popülerliğe Göre Sırala öğesine tıklayın
        WebElement ddm = driver.findElement(By.xpath("//select[@name='orderby']"));
        Select select = new Select(ddm);
        String actualYazi = select.getFirstSelectedOption().getText();
        System.out.println(actualYazi);
        String expectedDefaultYazisi = "Default sorting";
        Assert.assertEquals(expectedDefaultYazisi, actualYazi);

        //populerlige gore siralamak icin

        select.selectByVisibleText("Sort by popularity");

        WebElement ddm1 = driver.findElement(By.xpath("//select[@name='orderby']"));
        Select select1 = new Select(ddm1);

        System.out.println(select1.getFirstSelectedOption().getText());
        String populartYazisi = driver.findElement(By.xpath("//*[@id=\"content\"]/form/select/option[2]")).getText();
        System.out.println("populartYazisi = " + populartYazisi);

        //5) Artık kullanıcı yalnızca popüler ürünleri görüntüleyebilir
        String expectedPopulerYazisi = "Sort by popularity";
        Assert.assertEquals(expectedPopulerYazisi, populartYazisi);
    }
}
