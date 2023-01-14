package z02_packaga02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Example_02 extends TestBase {

    @Test
    public void keyboardActions2Test() {

        //2https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        Actions actions= new Actions(driver);
        //actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        WebElement video= driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        actions.scrollToElement(video).perform();
        waitFor(5);
        WebElement iframe1= driver.findElement(By.xpath("//div[@class='render']/iframe"));
        driver.switchTo().frame(iframe1);

        //4 videoyu izlemek icin Play tusuna basin
         //driver.findElement(By.xpath("//*[@id=\"post-164\"]/div/div[3]/iframe")).click();
        WebElement playButton = driver.findElement(By.xpath("//*[@aria-label=\"Oynat\"]"));
        playButton.click();


        waitFor(6);
        System.out.println(driver.findElement(By.xpath("//*[@class=\"ytp-time-display notranslate\"]")).getText());
        // video.click();
        //5 videoyu calistirdiginizi test edin
        String videosaniyesi = driver.findElement(By.xpath("//*[@class=\"ytp-time-current\"]")).getText();
        System.out.println(videosaniyesi);

        Assert.assertFalse(playButton.isDisplayed());
    }
}
