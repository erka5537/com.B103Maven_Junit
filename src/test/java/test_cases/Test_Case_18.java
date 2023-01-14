package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Test_Case_18 extends TestBase{

    /*
TEST CASE 18
 18. Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway-Place order
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
7) Now click the image in the Arrivals
8) Test whether it is navigating to next page where the user can add that book into his basket.
9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
10) Click on the Add To Basket button which adds that book to your basket
11) User can view that Book in the Menu item with price.
12) Now click on Item link which navigates to proceed to check out page.
13) Now user can find total and subtotal values just above the Proceed to Checkout button.
14) The total always < subtotal because taxes are added in the subtotal
15) Now click on Proceed to Check out button which navigates to payment gateway page.
16) User can view Billing Details,Order Details,Additional details and Payment gateway details.
17) Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
18) Now click on Place Order button to complete process
19) On clicking place-order button user completes the process where the page navigates to Order confirmation page
with order details,bank details,customer details and billing details.
TEST VAKA 18
  18. Ev-Gelenler-Sepete Ekle-Ürünler-Ödeme-Ödeme Ağ Geçidi-Sipariş Ver
1) Tarayıcıyı açın
2) "http://practice.automationtesting.in/" URL'sini girin
3) Mağaza Menüsüne tıklayın
4) Şimdi Ana menü düğmesine tıklayın
5) Ana sayfada yalnızca Üç Varış olup olmadığını test edin
6) Ana sayfa yalnızca üç Varış içermelidir
7) Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir.
8) Şimdi Gelenler bölümündeki resme tıklayın
9) Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.
10) O kitabı sepetinize ekleyen Sepete Ekle düğmesine tıklayın
11) Kullanıcı o Kitabı Menü öğesinde fiyatla görüntüleyebilir.
13) Artık kullanıcı, Ödeme İşlemine Geç düğmesinin hemen üzerinde toplam ve ara toplam değerlerini bulabilir.
14) Toplam her zaman > alt toplam çünkü ara toplama vergiler eklenir
15) Şimdi, ödeme ağ geçidi sayfasına giden Kontrol Et düğmesine tıklayın.
16)Kullanıcı, Fatura Ayrıntılarını, Sipariş Ayrıntılarını, Ek ayrıntıları ve Ödeme ağ geçidi ayrıntılarını görüntüleyebilir.
17) Artık kullanıcı, fatura ayrıntıları formundaki ayrıntılarını doldurabilir ve Doğrudan banka havalesi, çek, nakit
veya paypal gibi ödeme ağ geçidinde herhangi bir ödemeyi seçebilir.
18) Şimdi işlemi tamamlamak için Sipariş Ver düğmesine tıklayın
19) Sipariş ver düğmesine tıklandığında kullanıcı, sayfanın Sipariş onay sayfasına gittiği süreci tamamlar.
sipariş detayları, banka detayları, müşteri detayları ve fatura detayları ile.
     */
    @Test
    public void test01() throws InterruptedException {
        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");
        //  3) Click on Shop Menu
        driver.findElement(By.xpath("(//a[@href='https://practice.automationtesting.in/shop/'])[1]")).click();
        //4) Now click on Home menu button
        driver.findElement(By.xpath("(//a[@href='https://practice.automationtesting.in'])[2]")).click();
        //5) Test whether the Home page has Three Arrivals only
        int arrivals = driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")).size();
        System.out.println("arrivals = " + arrivals);
        //6) The Home page must contains only three Arrivals
        //6-12. arasi sorulari bu methid icinde yaoiyoruz
        Assert.assertTrue(arrivals == 3);
//7) Resim tıklanabilir olmalı ve kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gitmelidir.
        WebElement resimUlasilabilirMi = driver.findElement(By.xpath("//*[@alt='Mastering JavaScript']"));
        Assert.assertTrue(resimUlasilabilirMi.isEnabled());
//8) Şimdi Gelenler bölümündeki resme tıklayın
        driver.findElement(By.xpath("//*[@alt='Mastering JavaScript']")).click();
//9) Kullanıcının o kitabı sepetine ekleyebileceği bir sonraki sayfaya gidip gitmediğini test edin.
        WebElement urunEkleMeSayfasiGorunurMu = driver.findElement(By.xpath("//*[@id='content']"));
        Assert.assertTrue(urunEkleMeSayfasiGorunurMu.isDisplayed());
//10) O kitabı sepetinize ekleyen Sepete Ekle düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()='Add to basket']")).click();
        driver.findElement(By.xpath("//a[@class='button wc-forward']")).click(); //sepete gitmek icin
//11) Kullanıcı o Kitabı Menü öğesinde fiyatla görüntüleyebilir.
        WebElement fiyatGorunurMu = driver.findElement(By.xpath("//span[@class='woocommerce-Price-amount amount']"));//sepete ekleme butonunun oldugu yerdeki fiyat
        Assert.assertTrue(fiyatGorunurMu.isDisplayed());
        //13) Artık kullanıcı, Ödeme İşlemine Geç düğmesinin hemen üzerinde toplam ve ara toplam değerlerini bulabilir.
        String subTotal = driver.findElement(By.xpath("//td[@data-title='Subtotal']")).getText().replace("₹", "");
        System.out.println("subTotal = " + subTotal);
        int subTotalInt = Integer.parseInt(subTotal.replaceAll("\\D", ""));
        System.out.println("subTotalInt = " + subTotalInt);
        String totalPrice = driver.findElement(By.xpath("//strong//span[@class='woocommerce-Price-amount amount']")).getText().replace("₹", "");
        System.out.println("totalPrice = " + totalPrice);
        int totalPriceInt = Integer.parseInt(totalPrice.replaceAll("\\D", ""));
        System.out.println("totalPriceInt = " + totalPriceInt);
        //14) Toplam her zaman > alt toplam çünkü ara toplama vergiler eklenir
        Assert.assertTrue(totalPriceInt > subTotalInt);
        // 15) Toplam
        String enSonTotal = driver.findElement(By.xpath(" //strong//span[@class='woocommerce-Price-amount amount']")).getText().replace("₹", "");
        System.out.println("enSonTotal = " + enSonTotal);
        //15) Now click on Proceed to Check out button which navigates to payment gateway page.
        //15) Şimdi, ödeme ağ geçidi sayfasına giden Kontrol Et düğmesine tıklayın.
        driver.findElement(By.xpath("//a[@href='https://practice.automationtesting.in/checkout/']")).click();
        //16)User can view Billing Details,Order Details,Additional details and Payment gateway details.
        //16)Kullanıcı, Fatura Ayrıntılarını, Sipariş Ayrıntılarını, Ek ayrıntıları ve Ödeme ağ geçidi ayrıntılarını görüntüleyebilir.
        WebElement odemeSayfasiGorunurMu= driver.findElement(By.xpath("//form[@name='checkout']"));
        Assert.assertTrue(odemeSayfasiGorunurMu.isDisplayed());
        //17)Now user can fill his details in billing details form and can opt any payment in the payment gateway like
        // Direct bank transfer,cheque,cash or paypal.
        //17) Artık kullanıcı, fatura ayrıntıları formundaki ayrıntılarını doldurabilir ve Doğrudan banka havalesi, çek,
        // nakit veya paypal gibi ödeme ağ geçidinde herhangi bir ödemeyi seçebilir.
        WebElement billingDetailsGorunurMu = driver.findElement(By.xpath("//form[@name='checkout']"));
        Assert.assertTrue(billingDetailsGorunurMu.isDisplayed());
        WebElement billingsDetailName = driver.findElement(By.id("billing_first_name"));
        billingsDetailName.sendKeys("Kemal");
        WebElement billingsDetailLastName = driver.findElement(By.id("billing_last_name"));
        billingsDetailLastName.sendKeys("Can");
        WebElement billingsDetailCompany = driver.findElement(By.id("billing_company"));
        billingsDetailCompany.sendKeys("Turkey");
        WebElement billingsDetailEmail = driver.findElement(By.id("billing_email"));
        billingsDetailEmail.sendKeys("abc@gmail.com");
        WebElement billingsDetailPhone = driver.findElement(By.id("billing_phone"));
        billingsDetailPhone.sendKeys("053615823700");

        driver.findElement(By.xpath("//*[@role='presentation']")).click();

        driver.findElement(By.xpath("//*[@id=\"s2id_autogen1_search\"]")).sendKeys("Turkey", Keys.ENTER);

        WebElement adress = driver.findElement(By.xpath("//input[@name='billing_address_1']"));
        adress.sendKeys("Kutahya");
        WebElement adress2 = driver.findElement(By.xpath("//input[@id='billing_address_2']"));
        adress2.sendKeys("Merkez");
        WebElement townCity = driver.findElement(By.xpath("//input[@id='billing_city']"));
        townCity.sendKeys("Herhangi bir yer");

//        driver.findElement(By.xpath("(//*[@role=\"presentation\"])[3]")).click();
//        driver.findElement(By.xpath("(//*[@class=\"select2-input\"])[2]")).sendKeys("Balıkesir", Keys.ENTER);
        townCity.sendKeys(Keys.TAB, Keys.ENTER, "Balıkesir", Keys.ENTER); //Province *

        WebElement postaCode = driver.findElement(By.xpath("//input[@id='billing_postcode']"));
        postaCode.sendKeys("43200");
        WebElement additionalInformation= driver.findElement(By.xpath("//textarea[@id='order_comments']"));
        additionalInformation.sendKeys("Merhaba");
        //Doğrudan banka havalesi, çek, nakit veya paypal gibi ödeme ağ geçidinde herhangi bir ödemeyi seçebilir.
        WebElement directBankTransferGorunurMu= driver.findElement(By.xpath("//ul[@class='wc_payment_methods payment_methods methods']"));
        Assert.assertTrue(directBankTransferGorunurMu.isDisplayed());
        driver.findElement(By.xpath("//input[@id='payment_method_cod']")).click();//teslimatta odeme secenegi
        //18) Şimdi işlemi tamamlamak için Sipariş Ver düğmesine tıklayın
        driver.findElement(By.xpath(" //input[@class='button alt']")).click();//siparis ver butonuna basiyoruz
        //19) Sipariş ver düğmesine tıklandığında kullanıcı, sayfanın Sipariş onay sayfasına gittiği süreci tamamlar.
        //sipariş detayları, banka detayları, müşteri detayları ve fatura detayları ile.
        WebElement orderDetailsSayfasiGorunurMu= driver.findElement(By.xpath("//div[@class='page-content entry-content']"));
        Assert.assertTrue(orderDetailsSayfasiGorunurMu.isDisplayed());
        Thread.sleep(5000);
    }
}
