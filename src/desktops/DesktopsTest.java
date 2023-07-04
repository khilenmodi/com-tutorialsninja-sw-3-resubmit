package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
        clickOnElement(By.xpath("//span[normalize-space()='Currency']"));
        clickOnElement(By.xpath("//button[@name='GBP']"));
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //1.1 Mouse hover on Desktops Tab.and click
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']"))).build().perform();
        clickOnElement(By.xpath("//nav[@id='menu']"));
        // Thread.sleep(1000);
        //1.2 Click on “Show All Desktops”
        WebElement desktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        WebElement allDesktop = driver.findElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(desktop).moveToElement(allDesktop).click();
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");

        //1.4 Verify the Product will arrange in Descending order.
        String expectedResult = "Name (Z - A)";
        String actualResult = driver.findElement(By.xpath("//option[contains(text(),'Name (Z - A)')]")).getText();
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab. and click
        WebElement desktopsTab = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(desktopsTab).click().build().perform();

        // 2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));

        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");

        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        //2.5 Verify the Text "HP LP3065"
        String expectedText = "HP LP3065";
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'HP LP3065')]")).getText();
        Assert.assertEquals(expectedText, actualText);
        //2.6 Select Delivery Date "2022-11-30"
        clearTextToElement(By.xpath("//input[@id='input-option225']"));
        sendText(By.xpath("//input[@id='input-option225']"), "2022-11-30");
        //2.7.Enter Qty "1” using Select class.
        clearTextToElement(By.xpath("//input[@id='input-quantity']"));
        sendText(By.name("quantity"), "1");
        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        // 2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expectedMessage = "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×";
        String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.11 Verify the text "Shopping Cart"
        String expectedCart = "Shopping Cart  (1.00kg)";
        String actualCart = driver.findElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).getText();
        Assert.assertEquals(expectedCart, actualCart);
        //2.12 Verify the Product name "HP LP3065"
        String expectedName = "HP LP3065";
        String actualName = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")).getText();
        Assert.assertEquals(expectedName, actualName);
        //2.13 Verify the Delivery Date "2022-11-30"
        String verifyText2 = "Delivery Date:2022-11-30";
        String actualVerifyText2 = driver.findElement(By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]")).getText();
        Assert.assertEquals(verifyText2, actualVerifyText2);
        //2.14 Verify the Model "Product21"
        String verifyText3 = "Product 21";
        String actualVerifyText3 = driver.findElement(By.xpath("//td[contains(text(),'Product 21')]")).getText();
        Assert.assertEquals(verifyText3, actualVerifyText3);
        //2.15 Verify the Today "£74.73"
        String expectedTotal = "£74.73";
        String actualTotal = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")).getText();
        Assert.assertEquals(expectedTotal, actualTotal);

    }

    @After
    public void tearDown() {
        // closBrowser();
    }
}
