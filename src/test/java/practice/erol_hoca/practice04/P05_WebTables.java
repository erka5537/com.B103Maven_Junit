package practice.erol_hoca.practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.concurrent.atomic.AtomicInteger;

public class P05_WebTables extends TestBase {

    @Test
    public void test01(){
        //https://www.techlistic.com/p/demo-selenium-practice.html adresine gidelim
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        //Demo Table altındaki tablodaki otel bilgilerini yazdırınız

        //driver.findElements(By.xpath("//*[@border='1']//tbody/tr")).forEach(t-> System.out.println(t.getText()));

        //Demo Table altındaki otel bilgileri olan tablodan Height değeri 601m olan otelin bilgilerini yazdırınız
        //System.out.println(driver.findElements(By.xpath("//*[@border='1']//tbody/tr")).stream().filter(t -> t.getText().contains("601m")).findFirst().get().getText());

        //Bütün Height bilgilerini yazdırınız
        //driver.findElements(By.xpath("//*[@border='1']//tbody//tr//td[3]")).forEach(t-> System.out.println(t.getText()));

        //Otel uzunluklarının hepsini toplayınız
        AtomicInteger sum = new AtomicInteger();
        driver.findElements(By.xpath("//*[@border='1']//tbody//tr//td[3]")).forEach(t-> sum.addAndGet(Integer.parseInt(t.getText().replaceAll("m", ""))));
        System.out.println(sum);

        //Bir method ile satır ve sutun bilgilerini çağıralım
        tabloSatirSutun(3, 4);

    }
    private void tabloSatirSutun(int satir, int sutun) {
        System.out.println(satir +" . satir "+sutun+" . sutun bilgisi : "+
                driver.findElement(By.xpath("//*[@class='tsc_table_s13']//tbody//tr["+satir+"]//td["+sutun+"]")).getText());
    }
}
