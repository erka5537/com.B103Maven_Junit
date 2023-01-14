package day07;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    /*
    UTILITIES:
    -Utilities tekrar tekrar kullanacağımız class'ları koyduğumuz paketin adıdır.
        - TestBase -> Bugün
        - Driver -> Sonra
        - ExcelUtil -> Sonra
        - Configuration -> Sonra
    - Utilities paketinde Test case'ler yazılmaz
    - Sadece Tekrar kullanılabilecek destek sınıfları(support class) oluşturulur. Bu support class'lar test caselerin yazılmasını hızlandırır
    */

    @Test
    public void test01(){
//        techproeducation ana sayfasına git
        driver.get("https://www.techproeducation.com");
//        ve title'İn 'Bootcamps' kelimesini içerdiğini test edelim
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Bootcamps"));
    }
}
