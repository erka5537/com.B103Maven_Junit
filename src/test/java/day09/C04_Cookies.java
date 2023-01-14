package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {

    @Test
    public void handleCookiesTest(){
        //Class: Cookies
        //Method: handleCookies
        //Amazona git
        driver.get("https://www.amazon.com");

        //1.toplam cookie sayisini bul
        Set<Cookie> allCookies = driver.manage().getCookies();
        int cookieSayisi = allCookies.size();
        System.out.println("Sayfada " +cookieSayisi+ " adet cookie var");

        //3. Bir Cookie yi ismiyle bul

        //tüm cookie'leri yazdıralım
        //allCookies.forEach(t->t.getName());
        for (Cookie eachCookie : allCookies){
            System.out.println("COOKIE : "+eachCookie);//COOKIE NIN TAMAMINI YAZDIK
            System.out.println("COOKIE ISIMLERI : " + eachCookie.getName());
        }

        System.out.println(driver.manage().getCookieNamed("COOKİE'yi ismiyle çağırıyorum : "+"sp-cdn"));

        //4. Yeni bir cookie ekle
        Cookie favoriCookiem=new Cookie("Cikolatam","antep-fistikli-cikolata");//cookie oluştur
        driver.manage().addCookie(favoriCookiem); // sayfaya yeni cookie ekle
        waitFor(3);
        System.out.println("Yeni Cookie Sayısı : "+driver.manage().getCookies().size());// cookie sayısı arttı

        //5. Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("i18n-prefs");

        //6. Tum cookie leri sil
        driver.manage().deleteAllCookies();
        System.out.println("TUM COOKIES LERI SILDIM. YENI COOKIE SAYISI : "+driver.manage().getCookies().size());
    }
}
