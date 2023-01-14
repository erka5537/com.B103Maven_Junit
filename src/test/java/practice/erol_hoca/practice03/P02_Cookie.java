package practice.erol_hoca.practice03;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class P02_Cookie extends TestBase {

    @Test
    public void test01(){

        //Techproeducation adresine gidiniz
        driver.get("https://techproeducation.com/");

        //Sayfadaki cookie lerin sayısını yazdırınız
        waitFor(2);
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies.size());

        //Sayfadaki cookie lerin isim ve değerlerini yazdırınız
        cookies.forEach(t-> System.out.println(t.getName()+" : "+t.getValue()));

        //Yeni bir cookie ekleyiniz
        Cookie myCookie = new Cookie("Name", "1a453");
        driver.manage().addCookie(myCookie);

        //Yeni cookie eklendikten sonra cookie sayısını ve isimlerini yazdırınız
        driver.manage().getCookies().forEach(t-> System.out.println(t.getName()+" : "+t.getValue()));

        //Oluşturduğumuz cookie'i silelim
        driver.manage().deleteCookieNamed("Name");

        //Tüm cookieleri silelim
        driver.manage().deleteAllCookies();

    /*
                                    Cookies(Çerezler)
        "Cookie" ler, bir web sitesi tarafından tarayıcıya depolanan küçük veri parçacıklarıdır.
    Tarayıcı, herhangi bir web sayfasına gittiğinde, o sayfanın cookie'lerini saklar ve
    daha sonra o sayfaya geri döndüğünde, o cookie'leri tekrar gönderir. Bu sayede, web sitesi,
    kullanıcının daha önce o sayfada ne yaptığını veya ne seçtiğini hatırlayabilir.
     */

    }
}
