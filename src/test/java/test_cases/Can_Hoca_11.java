package test_cases;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class Can_Hoca_11 extends TestBase {

    @Test
    public void q(){

//  #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

// #Fill in capitals by country
        Actions actions = new Actions(driver);
        List<WebElement> countries = driver.findElements(By.xpath("//*[@id='countries']/div"));
        for(int i=1; i<=countries.size(); i++){
            WebElement capital = driver.findElement(By.xpath("//*[@id='box"+i+"']"));
            switch (capital.getText()){
                case "Oslo":actions.dragAndDrop(capital,countries.stream().filter(t->t.getText().equals("Norway")).findFirst().get()).build().perform();break;
                case "Stockholm":actions.dragAndDrop(capital,countries.stream().filter(t->t.getText().equals("Sweden")).findFirst().get()).build().perform();break;
                case "Washington":actions.dragAndDrop(capital,countries.stream().filter(t->t.getText().equals("United States")).findFirst().get()).build().perform();break;
                case "Copenhagen":actions.dragAndDrop(capital,countries.stream().filter(t->t.getText().equals("Denmark")).findFirst().get()).build().perform();break;
                case "Seoul":actions.dragAndDrop(capital,countries.stream().filter(t->t.getText().equals("South Korea")).findFirst().get()).build().perform();break;
                case "Rome":actions.dragAndDrop(capital,countries.stream().filter(t->t.getText().equals("Italy")).findFirst().get()).build().perform();break;
                case "Madrid":actions.dragAndDrop(capital,countries.stream().filter(t->t.getText().equals("Spain")).findFirst().get()).build().perform();break;
            }
        }
    }
}


/*
@Test
    public void test01() {

//  #go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
// #Fill in capitals by country
        for(int i =1 ; i<8 ; i++){
            WebElement source = driver.findElement(By.id("box"+i));
            WebElement target = driver.findElement(By.id("box"+(100+i)));
            Actions actions = new Actions(driver);
            actions.dragAndDrop(source,target).perform();
        }

    }
 */