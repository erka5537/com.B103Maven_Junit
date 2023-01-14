package test_cases;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Test_Case_12 extends TestBase {

    @Test
    public void test01(){

        //1) Open the browser

        //2) Enter the URL “http://practice.automationtesting.in/”
        driver.get("http://practice.automationtesting.in/");

        //3) Click on Shop Menu
        driver.findElement(By.xpath("//*[.='Shop']")).click();

        //4) Click on the Add To Basket button which adds that book to your basket
        driver.findElement(By.xpath("//*[@href=\"/shop/?add-to-cart=182\"]")).click();

        //5) User can view that Book in the Menu item with price .


        //6) Now click on Item link which navigates to proceed to check out page.
        //7) Now user can find total and subtotal values just above the Proceed to Checkout button.
        //8) The total always < subtotal because taxes are added in the subtotal
        //9) The tax rate variers for India compared to other countries
        //10) Tax rate for indian should be 2% and for abroad it should be 5%
    }
}
