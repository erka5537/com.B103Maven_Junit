package z01_package01;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Task_05 extends TestBase {

    @Test
    public void test01(){

        driver.get("https://letcode.in/dropable");
        Actions actions = new Actions(driver);
        WebElement kutu = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        actions.dragAndDrop(kutu,target).perform();

        //    TEST CASE 1
        //TC001
        //Login Positive & Negative
        //Login Positive:
        //Navigate to your service now instance
        //Verify title is ServiceNow
        //Verify username text field has label of User name
        //Enter username (admin)
        //Verify passowrd text field has label of Password
        //Enter password (instance password)
        //Verify language dropdown has label of Language
        //Verify language is selected as English by default
        //Verify forgot password is visible to the user
        //Verify user can see the login button
        //As user clicks on the login button
        //Verify the title as ServiceNow
        //Login Negative:
        //Navigate to your service now instance
        //Verify title is ServiceNow
        //User clicks on the login button
        //Verify the error message as Invalid input in user name!
        //Enter the username as admin
        //User clicks on the login button
        //Verify the error message contains User name or password invalid

        //TEST CASE 1
        //TC001
        //Giriş Olumlu & Olumsuz
        //Giriş Olumlu:
        //Şimdi hizmet örneğinize gidin
        //Başlığın ServiceNow olduğunu doğrulayın
        //Kullanıcı adı metin alanının Kullanıcı adı etiketine sahip olduğunu doğrulayın
        //Kullanıcı adını girin (yönetici)
        //Parola metin alanının Parola etiketine sahip olduğunu doğrulayın
        //Parolayı girin (örnek parolası)
        //Dil açılır listesinin Dil etiketine sahip olduğunu doğrulayın
        //Dilin varsayılan olarak İngilizce olarak seçildiğini doğrulayın
        //Unutulan parolanın kullanıcı tarafından görülebildiğini doğrulayın
        //Kullanıcının oturum açma düğmesini görebildiğini doğrulayın
        //Kullanıcı giriş düğmesine tıkladığında
        //Başlığı ServiceNow olarak doğrulayın
        //Giriş Negatif:
        //Şimdi hizmet örneğinize gidin
        //Başlığın ServiceNow olduğunu doğrulayın
        //Kullanıcı giriş düğmesine tıklar
        //Hata mesajını kullanıcı adında geçersiz giriş olarak doğrulayın!
        //Kullanıcı adını yönetici olarak girin
        //Kullanıcı giriş düğmesine tıklar
        //Hata mesajının geçersiz Kullanıcı adı veya parola içerdiğini doğrulayın

    }
}
