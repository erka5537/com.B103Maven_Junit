package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Can_Hoca_08_Al extends TestBase {

    @Test
    public void test01(){
        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.cssSelector("*[class=\"btn btn-danger\"]")).click();

        //    accept Alert(I am an alert box!) and print alert on console
        Alert alert = driver.switchTo().alert();
        alert.getText();alert.accept();

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.cssSelector("*[href=\"#CancelTab\"]")).click();
        driver.findElement(By.cssSelector("*[class=\"btn btn-primary\"]")).click();

        //    cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();

        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("//*[@href=\"#Textbox\"]")).click();
        driver.findElement(By.xpath("//*[@class=\"btn btn-info\"]")).click();

        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();

        //    finally print on console this mesaaje "Hello TechProEducation How are you today"
        String message = driver.findElement(By.id("demo1")).getText();
        Assert.assertEquals("Hello TechProEducation How are you today", message);
    }
}
