package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_Actions6 extends TestBase {

    @Test
    public void moveByOffSetTest(){

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

//        KAYNAK VE HEDEF ELEMENTLERI IFRAMEIN ICINDE
        driver.switchTo().frame(0);

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        Actions actions = new Actions(driver);
        WebElement kaynak = driver.findElement(By.id("draggable"));
        actions.
                moveByOffset(430,30).
                release().
                build().
                perform();
    }
}
