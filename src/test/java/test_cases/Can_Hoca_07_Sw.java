package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Can_Hoca_07_Sw extends TestBase {

    @Test
    public void test01(){

//      1-https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

//      2-Dropdown Example menüsünün görünür olduğunu doğrulayın.
        WebElement example = driver.findElement(By.id("dropdown-class-example"));
        Assert.assertTrue(example.isDisplayed());

//      3-Option3 ü seçin.
        Select select = new Select(example);
        select.selectByIndex(3);

//      4-Option3 ün seçili olduğunu doğrulayın.
        String selected = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selected,"Option3");
    }
}
