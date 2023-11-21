package testsuite;
/**
 * 3. Write down the following test into ‘LoginTest’ class 1. userSholdLoginSuccessfullyWithValid Credentials * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on  page
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //enter standard_user username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //enter secret_sauce password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click on login button
        driver.findElement(By.id("login-button")).click();
        //verify the text Products
        String expectedDisplay = "Products";
        String actualDisplay = driver.findElement(By.xpath("//span[text()='Products']")).getText();
        Assert.assertEquals("Products",expectedDisplay, actualDisplay);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //enter standard_user username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //enter secret_sauce password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click on login button
        driver.findElement(By.id("login-button")).click();
        //verify the six products are displayed on the page
        List<WebElement> productList = driver.findElements(By.className("inventory_item"));
        System.out.println("Total product: " + productList.size());
        //verify the number of products are 6
        int expectedSize = 6;
        int actualSize = productList.size();
        Assert.assertEquals("6",expectedSize, actualSize);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }




}
