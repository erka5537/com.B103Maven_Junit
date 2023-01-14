package z02_packaga02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Example_03 extends TestBase {

    @Test
    public void test02(){

        /*
    Test01 :
    1- amazon gidin
    2 Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
    3 dropdown menude 40 eleman olduğunu doğrulayın
    Test02
    1 dropdown menuden elektronik bölümü seçin
    2 arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
    3 sonuc sayisi bildiren yazinin iphone icerdigini test edin
    4 ikinci ürüne relative locater kullanarak tıklayin
    5 ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
    Test03
    1 yeni bir sekme açarak amazon anasayfaya gidin
    2 dropdown’dan bebek bölümüne secin
    3 bebek puset aratıp bulundan sonuç sayısını yazdırın
    4 sonuç yazsının puset içerdiğini test edin
    5-üçüncü ürüne relative locater kullanarak tıklayin
    6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
    Test 4
    1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

         */
        //1- amazon gidin https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //2 dropdown menuden elektronik bölümü seçin
        WebElement searchDropdownBox= driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(searchDropdownBox);
        select.selectByVisibleText("Electronics");

        //2 arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone", Keys.ENTER);
        String actualResult= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        System.out.println("actualResult = " + actualResult);

        //3 sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String expectedResult= "iphone";
        Assert.assertTrue(actualResult.contains(expectedResult));

        //4 ikinci ürüne relative locater kullanarak tıklayin
        WebElement secondProduct= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-base'])[2]"));
        secondProduct.click();

        //5 ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        //NOT: ACTION methodunu bilerek kulandim Konumuz genel tekrardi
        String productTitle= driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        System.out.println("productTitle = " + productTitle);

        String fiyat = driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-none aok-align-center\"]/span[@data-a-color=\"base\"]")).getText();
        String[] arr = fiyat.split("\n");
        String sonuc = arr[0].replace("$","") + "." + arr[1];
        System.out.println(sonuc);

        WebElement addToCartButton= driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
        Actions actions = new Actions(driver);
        actions.click(addToCartButton).perform();

        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        WebElement goToCart1 = driver.findElement(By.xpath("//a[@href='/gp/cart/view.html?ref_=sw_gtc']"));
        //WebElement goToCart2= driver.findElement(By.xpath("//div[@id='nav-cart-count-container']"));
        goToCart1.click();
        //String productCartTitle= driver.findElement(By.xpath("(//span[@class='a-truncate-full a-offscreen'])[5]")).getText();
        //String productCartTitle= driver.findElement(By.xpath("//a[@href='/gp/product/B0BJKYJR3L/ref=ox_sc_act_title_1?smid=A2M12OX0LY3AUJ&psc=1']")).getText();
        String productCartTitle= driver.findElement(By.xpath("(//a[@href='/gp/product/B0BJKYJR3L/ref=ox_sc_act_title_1?smid=A2M12OX0LY3AUJ&psc=1'])[4]")).getText();
        System.out.println("productCartTitle = " + productCartTitle);
        String productCartPrice= driver.findElement(By.xpath("//div[@class='sc-item-price-block']")).getText().replace("$","");
        System.out.println("productCartPrice = " + productCartPrice);
    }
}
