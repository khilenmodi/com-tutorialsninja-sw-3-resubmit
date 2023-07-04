package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utility.Utility;

public class LaptopsAndNotebooksTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        // 1.1 Mouse hover on Laptops & Notebooks Tab.and click
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"))).click().build().perform();
        // 1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        // 1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        // 1.4 Verify the Product price will arrange in High to Low order.
        String expectedResult = "Price (High > Low)";
        String actualResult = driver.findElement(By.xpath("//option[contains(text(),'Price (High > Low)')]")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"))).click().build().perform();
        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook Pro']"));
        //2.5 Verify the text “MacBook”
        String verifyText = "MacBook Pro";
        String actualVerifyText = driver.findElement(By.xpath("//h1[normalize-space()='MacBook Pro']")).getText();
        Assert.assertEquals(verifyText, actualVerifyText);
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //Verify the message “Success: You have added MacBook to your shopping cart!”
        String verifyMessage = "Success: You have added MacBook Pro to your shopping cart!\n" +
                "×";
        String actualMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        Assert.assertEquals(verifyMessage, actualMessage);
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        //2.9 Verify the text "Shopping Cart"
        String expectedCart = "Shopping Cart  (0.00kg)";
        String actualCart = driver.findElement(By.xpath("//h1[contains(text(),'Shopping Cart')]")).getText();
        Assert.assertEquals(expectedCart, actualCart);
        //2.10 Verify the Product name "MacBook"
        String verifyProductName = "MacBook Pro";
        String actualName = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]")).getText();
        Assert.assertEquals(verifyProductName, actualName);
        //2.11 Change Quantity "2"
        clearTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        String verifyExpectedMessage = "Success: You have modified your shopping cart!\n" +
                "×";
        String actualVerifyMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
        Assert.assertEquals(verifyExpectedMessage, actualVerifyMessage);
        //2.14 Verify the Total $4,000.00
        String totalPrice = "$4,000.00";
        String actualPrice = driver.findElement(By.xpath("//tbody//tr//td[6]")).getText();
        Assert.assertEquals(totalPrice, actualPrice);
        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        //2.16 Verify the text “Checkout”
        String textVerify = "Checkout";
        String actualTextVerify = driver.findElement(By.xpath("//h1[normalize-space()='Checkout']")).getText();
        Assert.assertEquals(textVerify, actualTextVerify);
        //2.17 Verify the Text “New Customer”
        String textVerify1 = "New Customer";
        String actualTextVerify1 = driver.findElement(By.xpath("//h2[normalize-space()='New Customer']")).getText();
        Assert.assertEquals(textVerify1, actualTextVerify1);
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.name("account"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.id("button-account"));
        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("input-payment-firstname"), "khilen");
        sendTextToElement(By.id("input-payment-lastname"), "pancholi");
        sendTextToElement(By.id("input-payment-email"), "pancholi1234@yahoo.com");
        sendTextToElement(By.id("input-payment-telephone"), "07904513705");
        sendTextToElement(By.id("input-payment-address-1"), "20, Tudor avanue");
        sendTextToElement(By.id("input-payment-city"), "london");
        sendTextToElement(By.id("input-payment-postcode"), "HA2 8XY");
        selectByValueFromDropDown(By.id("input-payment-country"), "222");
        selectByValueFromDropDown(By.id("input-payment-zone"), "3558");
        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        //2.22 Add Comments About your order into text area
        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Please Deliver As Early As Possible");
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        //2.25 Verify the message “Warning: Payment method required!”
        String actualText = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        String expectedText = "Warning: Payment method required!\n×";
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown() {
        // closBrowser();
    }

}
