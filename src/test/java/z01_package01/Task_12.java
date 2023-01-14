package z01_package01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task_12 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // https://letcode.in/ adresine git
        driver.get("https://letcode.in/");

        //Work-Space yazisina tikla
        driver.findElement(By.id("testing")).click();
        Thread.sleep(5000);

        //Acilan pencereden   Radio e tikla
        driver.findElement(By.xpath("//a[@href='/radio']")).click();

        //Select any one 'da "yes" sec --Herhangi birini seçin
        driver.findElement(By.xpath("//input[@id='yes']")).click();

        //Cofirm you can select only one radio button -Yalnızca bir radyo düğmesi seçebileceğinizi onaylayın
        WebElement yes = driver.findElement(By.xpath("//input[@id='one']"));
        yes.click();
        WebElement no = driver.findElement(By.xpath("//input[@id='two']"));
        no.click();
        Assert.assertTrue((yes.isSelected()) && !no.isSelected() || (!yes.isSelected() && no.isSelected()));

        //Find the bug -Hatayi bul (her iksi de tiklanabiliyor Normalde sadece bir tanesi tiklanmaliydi)
        WebElement yesBug = driver.findElement(By.xpath("//input[@id='nobug']"));
        yesBug.click();
        WebElement noBug = driver.findElement(By.xpath("//input[@id='bug']"));
        noBug.click();

        boolean bir = yesBug.isSelected() && !noBug.isSelected();
        boolean iki = noBug.isSelected() && !yesBug.isSelected();
        Assert.assertFalse("buttonların ikisi de seçili",bir || iki);



        if ((yesBug.isSelected() && noBug.isSelected())) {
            System.out.println("Bug Test PASSED");
        } else {
            System.out.println("Bug Test FAILED");
        }
        Thread.sleep(5000);

        //Find which one is selected --Hangisinin seçili olduğunu bulun
        WebElement yesFindWhich = driver.findElement(By.xpath("//input[@id='foo']"));
        WebElement noFindWhich = driver.findElement(By.xpath("//input[@id='notfoo']"));
        boolean yesFindWhichSelected= yesFindWhich.isSelected();
        System.out.println("yesFindWhichSelected = " + yesFindWhichSelected);
        boolean noFindWhichSelected= noFindWhich.isSelected();
        System.out.println("noFindWhichSelected = " + noFindWhichSelected);
        //veya
        if (yesFindWhich.isSelected()){
            System.out.println("yesFindWhich is SELECTED");
        }else {
            System.out.println("noFindWhich is SELECTED");
        }
        //Confirm last field is disabled --Son alanın devre dışı bırakıldığını onaylayın
        WebElement maybeNotIsEnable = driver.findElement(By.xpath("//input[@id='maybe']"));
        boolean mayBetNotEnable= maybeNotIsEnable.isEnabled();
        System.out.println("mayBetNotEnable = " + mayBetNotEnable);
        Assert.assertTrue(!maybeNotIsEnable.isEnabled());

        //Find if the checkbox is selected? --Onay kutusunun seçili olup olmadığını bulun?
        WebElement checkboxIsSelected  = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        boolean checkboxIsSelectedMi= checkboxIsSelected.isSelected();
        System.out.println("checkboxIsSelectedMi = " + checkboxIsSelectedMi);
        Assert.assertTrue("onay kutusu seçili", checkboxIsSelected.isSelected());

        //Accept the T&C --Şartlar ve Koşulları kabul et ( I agree to the FAKE terms and conditions)
        driver.findElement(By.xpath("(//label[@class='checkbox'])[2]")).click();
    }
}
