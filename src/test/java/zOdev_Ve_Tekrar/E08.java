package zOdev_Ve_Tekrar;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class E08 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        driver.switchTo().frame(driver.findElement(By.xpath("//*[@src='/index.php']")));

        WebElement element = driver.findElement(By.xpath("//*[@href='index.php?page=add-remove-elements']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);

        driver.findElement(By.xpath("//*[@href='index.php?page=add-remove-elements']")).click();


    }
}


// Thread.sleep(10000);