package practice.erol_hoca.practice04;

import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class asd extends TestBase {

    @Test
    public void q(){

        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        waitFor(5);
        actions.scrollByAmount(0,250).perform();
        waitFor(5);
    }
}
