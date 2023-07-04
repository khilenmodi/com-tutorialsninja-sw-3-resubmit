package myaccount;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class MyAccountTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";
    String option;

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {

        if (option == "Register") ;
        WebElement select = driver.findElement(By.xpath("//a[@title='My Account']"));
        List<WebElement> options = select.findElements(By.xpath("//a[normalize-space()='Register']"));

        for (WebElement option1 : options) {

            if (option.equals(option1.getText())) {
                option1.click();
            }

        }
        if (option == "Login") ;
        WebElement select1 = driver.findElement(By.xpath("//a[@title='My Account']"));
        List<WebElement> options1 = select1.findElements(By.xpath("//a[normalize-space()='Login']"));

        for (WebElement option2 : options1) {

            if (option.equals(option2.getText())) {
                option2.click();
            }

        }
        if (option == "Logout") ;
        WebElement select2 = driver.findElement(By.xpath("//a[@title='My Account']"));
        List<WebElement> options2 = select2.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));

        for (WebElement option3 : options2) {

            if (option.equals(option3.getText())) {
                option3.click();
            }

        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        // 1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        option = "Register";
        selectMyAccountOptions(option);
        //Verify the text “Register Account”.
        String expectedText = "Register Account";
        String actualText = driver.findElement(By.xpath("//h1[contains(text(),'Register Account')]")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter Login”
        option = "Login";
        selectMyAccountOptions(option);
        //2.3 Verify the text “Returning Customer”.
        String expectedResult = "Returning Customer";
        String actualResult = driver.findElement(By.xpath("//h2[contains(text(),'Returning Customer')]")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        option = "Register";
        selectMyAccountOptions(option);
        //3.3 Enter First Name
        sendTextToElement(By.id("input-firstname"), "khilen");
        //3.4 Enter Last Name
        sendTextToElement(By.id("input-lastname"), "panchal");
        //3.5 Enter Email
        sendTextToElement(By.id("input-email"), "panchal123@yahoo.com");
        //3.6 Enter Telephone
        sendTextToElement(By.id("input-telephone"), "07901248620");
        //3.7 Enter Password
        sendTextToElement(By.id("input-password"), "khilen123");
        //3.8 Enter Password Confirm
        sendTextToElement(By.id("input-confirm"), "khilen123");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.name("newsletter"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.name("agree"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedResult = "Your Account Has Been Created!";
        String actualResult = driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]")).getText();
        Assert.assertEquals(expectedResult, actualResult);
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        option = "Logout";
        selectMyAccountOptions(option);
        //3.16 Verify the text “Account Logout”
        String expectedResult1 = "Account Logout";
        String actualResult1 = driver.findElement(By.xpath("//h1[contains(text(),'Account Logout')]")).getText();
        Assert.assertEquals(expectedResult1, actualResult1);
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        option = "Login";
        selectMyAccountOptions(option);
        //4.3 Enter Email address
        sendTextToElement(By.id("input-email"), "panchal123@yahoo.com");
        //4.5 Enter Password
        sendTextToElement(By.id("input-password"), "khilen123");
        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        //4.7 Verify text “My Account”
        String expectedResult = "My Account";
        String actualResult = driver.findElement(By.xpath("//h2[contains(text(),'My Account')]")).getText();
        Assert.assertEquals(expectedResult, actualResult);
        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        option = "Logout";
        selectMyAccountOptions(option);
        //4.10 Verify the text “Account Logout”
        String expectedResult1 = "Account Logout";
        String actualResult1 = driver.findElement(By.xpath("//h1[contains(text(),'Account Logout')]")).getText();
        Assert.assertEquals(expectedResult1, actualResult1);
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }

    @After
    public void tearDown() {
        // closBrowser();
    }
}

