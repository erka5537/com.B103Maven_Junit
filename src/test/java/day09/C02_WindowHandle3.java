package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {

    @Test
    public void newWindowHandleTest(){

//      1. TechPro education sayfasinin title'inin "" metnini icerdigini test edin.
        driver.get("https://techproeducation.com/");
        String techproHandle = driver.getWindowHandle();
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));

//      2. Yeni bir pencerede Amazon sayfasini acip title'in "Amazon" metnini icerdigini test edin.
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com/");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));

//      3. Yeni bir pencerede LinkedIn sayfasini acip title'in "LinkedIn" metnini icerdigini test edin.
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com/");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));

        waitFor(3);
        //driver şuan linkedIn'de
        waitFor(3);

        driver.switchTo().window(techproHandle);
        //driver şuan techpro'da

//      3 yeni window ac ve title larini verify et




//      3 yeni tab ac ve title larini verify et
//        driver.get("https://www.google.com.tr/");
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get("https://neetcode.io/practice");
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get("http://www.sunplusdestek.com/");

    }

}
