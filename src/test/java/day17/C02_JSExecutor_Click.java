package day17;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

public class C02_JSExecutor_Click extends TestBase {

    @Test
    public void clickByJSTest() {

        //clickByJSTest
        //Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(3);

        //LMS LOGIN elementine tikla
        clickByJS(driver.findElement(By.linkText("LMS LOGIN")));
        waitFor(3);

        //Cikan sayfayinin URL inin “https://lms.techproeducation.com/” oldugunu test et
        Assert.assertEquals("https://lms.techproeducation.com/", driver.getCurrentUrl());
    }
}
