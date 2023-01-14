package z02_packaga02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class deneme extends TestBase {

    @Test
    public void q(){

        driver.get("https://selectorshub.com/xpath-practice-page/");

        WebElement mail = driver.findElement(By.id("userId"));
        WebElement pass = driver.findElement(By.id("pass"));

        Actions actions = new Actions(driver);

        actions.sendKeys(mail,"asd").sendKeys(pass, "qwe").build().perform();

    }
}
