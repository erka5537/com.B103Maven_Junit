package practice.erol_hoca.practice01;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Dropdown extends TestBase {

    @Test
    public void test01() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Dropdown menuden baby seçelim
        List<WebElement> dropdown = driver.findElements(By.xpath("//*[@title=\"Search in\"]"));
        //Select select = new Select(dropdown);
        dropdown.forEach(t-> System.out.println(t.getText()));

        driver.findElement(By.xpath("//*[@title=\"Search in\"]")).sendKeys("Baby"
                , Keys.TAB, "Milk", Keys.ENTER);

        //arama bölümünden milk aratalım
    }
}
