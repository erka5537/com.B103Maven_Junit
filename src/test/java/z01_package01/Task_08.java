package z01_package01;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Task_08 extends TestBase {

    @Test
    public void test01() throws InterruptedException {


//        ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

//        ~ click on Phones & PDAs
        driver.findElement(By.xpath("//a[.='Phones & PDAs']")).click();

//        ~ get the brandName of phones
        List<WebElement> brandNames = driver.findElements(By.xpath("//h4"));
        System.out.println(brandNames);

        List<String> list = new ArrayList<>();
        brandNames.forEach(t->list.add(t.getText()));
        System.out.println(list);

//        ~ click on add to button for all elements
        List<WebElement> addCartButton = driver.findElements(By.xpath("//*[.='Add to Cart']"));
        addCartButton.forEach(t->t.click());

//        ~ click on black total added cart button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class=\"btn btn-inverse btn-block btn-lg dropdown-toggle\"]")).click();

//        ~ get the names of list from the cart


//        ~ compare the names from displaying list and cart list


    }
}
