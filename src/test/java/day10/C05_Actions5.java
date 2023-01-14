package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Actions5 extends TestBase {

    @Test
    public void clickAndHoldTest(){

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        WebElement kaynak = driver.findElement(By.id("draggable"));
        WebElement hedef = driver.findElement(By.id("droppable"));

        actions.
                clickAndHold(kaynak).//kaynağı tut
                moveToElement(hedef).//hedefe sürükle
                release().//serbest bırak
                build(). // önceki methodların ilişkisini kur/güçlendir. KULLANILMASI TERCİH EDİLİR
                perform();

    }
}
