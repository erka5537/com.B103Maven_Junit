package practice.erol_hoca.practice01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P08 extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //    go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("//*[@onclick='alertbox()']")).click();

        //    accept Alert(I am an alert box!) and print alert on console
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("//*[@href='#CancelTab']")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        //    cancel Alert  (Press a Button !)
        driver.switchTo().alert().dismiss();

        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("//*[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//*[@class=\"btn btn-info\"]")).click();

        //    and then sendKeys 'TechProEducation' (Please enter your name)
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();

        //    finally print on console this message "Hello TechproEducation How are you today"
        String message = driver.findElement(By.id("demo1")).getText();
        System.out.println(message);

        //    aseertion these message
        Assert.assertEquals("Hello TechProEducation How are you today",message);
    }
}
