/**
 *2. Create the package ‘testsuite’ and create the following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email or password.’
 */




package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseURL = "https://courses.ultimateqa.com/"; // set base url

    @Before
    public void setUp(){openBrowser(baseURL);}

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        String expected = "Welcome Back!";
        String actual = driver.findElement(By.xpath("//h2[contains(text(),'Welcome Back!')]")).getText();
        Assert.assertEquals("Correct Message not Displayed",expected,actual);
    }

    @Test
    public void verifyTheErrorMessage(){
        driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
        driver.findElement(By.id("user[email]")).sendKeys("123@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("123@gmail.com");
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
        String expected = "Invalid email or password.";
        // manually quickly enter captcha to get to error page
        String actual = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]")).getText();
        Assert.assertEquals("Correct Message not Displayed",expected,actual);
    }

    @After
   public void tearDown(){closeBrowser();}

}
