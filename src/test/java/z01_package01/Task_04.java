package z01_package01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task_04 extends TestBase {

    @Test
    public void basketFunctionality() throws InterruptedException {

        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //3) Mağaza Menüsüne tıklayın
        driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();

        //4) O kitabı sepetinize ekleyen Sepete Ekle düğmesini tıklayın.
        driver.findElement(By.xpath("(//a[.='Add to basket'])[1]")).click();

        //5) Kullanıcı o Kitabı Menü öğesinde fiyatla görüntüleyebilir.
        WebElement fiyatGorunurMu= driver.findElement(By.xpath("//a[@href='https://practice.automationtesting.in/product/html5-webapp-develpment/']"));
        Assert.assertTrue(fiyatGorunurMu.isDisplayed());

        //6) Şimdi ödeme sayfasına ilerlemek için gezinen Sepeti Görüntüle bağlantısını tıklayın.
        driver.findElement(By.xpath("//a[@title='View Basket']")).click();

        //7) Artık kullanıcı, Ödeme İşlemine Geç düğmesinin hemen üzerinde toplam ve alt toplam değerleri bulabilir.
        String subTotal = driver.findElement(By.xpath("//td[@data-title='Subtotal']")).getText().replace("₹", "");
        System.out.println("subTotal = " + subTotal);
        int subTotalInt = Integer.parseInt(subTotal.replaceAll("\\D", ""));
        System.out.println("subTotalInt = " + subTotalInt);
        String totalPrice = driver.findElement(By.xpath("//strong//span[@class='woocommerce-Price-amount amount']")).getText().replace("₹", "");
        System.out.println("totalPrice = " + totalPrice);
        int totalPriceInt = Integer.parseInt(totalPrice.replaceAll("\\D", ""));
        System.out.println("totalPriceInt = " + totalPriceInt);

        //8) Toplam her zaman > alt toplam çünkü vergiler ara toplama eklenir
        Assert.assertTrue(totalPriceInt > subTotalInt);

        //9) Hindistan için vergi oranı diğer ülkelere göre farklılık gösteriyor

        //10) Vergi oranı Hindistan için %2, yurt dışı için %5 olmalıdır.

    }
}