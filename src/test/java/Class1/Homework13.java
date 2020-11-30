package Class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework13 {

    /**
     * Testcase: User should be able to click on the yahoo notification
     * 1.Launch yahoo.com
     * 2.Move mouse to bell icon
     * 3. User should be able to click the first notification
     */
    @Test
    public void yahooNotification() {

        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver 5");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.yahoo.com");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {

        }

        WebElement bellIcon = driver.findElement(By.xpath("//label[@for='ybarNotificationMenu']"));
        Actions act = new Actions(driver);
        act.moveToElement(bellIcon).build().perform();

        WebElement notification = driver.findElement(By.xpath("//span[@class='yns-time']/preceding-sibling::span[@class='yns-title']"));
        act.moveToElement(notification).click().build().perform();
    }

    @Test
    public void invalidDateOfBirth() {

//        Testcase-2: User should get error on invalid date of birth
//                * 1. Launch facebook.com
//                * 2. Click 'Create new Account' button
//                * 3. Enter fname as Firstname
//                  4. Enter lname as Lastname
//                  5. "abcd@test.com" as email address
//                * 6. "abcd@1234" as New Password
//                * 7. Enter your "Jan 4 1998" as birth date
//                * 8. Click the 'Sign Up' button
//                * 9. Verify user see the error msg for gender. (Please choose a gender. You can change who can see this later.)
//
//

        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver 5");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        WebElement createAcct = driver.findElement(By.xpath("//a[text()='Create New Account']"));
        createAcct.click();

        try{
            Thread.sleep(4000);
        }catch(InterruptedException e){

        }

        WebElement fname= driver.findElement(By.xpath("//input[@placeholder='First name']"));
        fname.sendKeys("fname");


        WebElement lname= driver.findElement(By.xpath("//input[@name='lastname']"));
        lname.sendKeys("lname");

        WebElement email= driver.findElement(By.xpath("//input[@name='reg_email__']"));
        email.sendKeys("abcd@test.com");

        WebElement reenterEmail= driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        reenterEmail.sendKeys("abcd@test.com");

        WebElement password= driver.findElement(By.xpath("//input[@data-type='password']"));
        password.sendKeys("abcd@1234");


        WebElement monthElem= driver.findElement(By.id("month"));
        Select month = new Select(monthElem);
        month.selectByVisibleText("Jan");

        WebElement date= driver.findElement(By.id("day"));
        Select day= new Select(date);
        day.selectByValue("4");

        WebElement year= driver.findElement(By.id("year"));
        Select yearSelect= new Select(year);
        yearSelect.selectByVisibleText("1998");


        WebElement clickSignUp= driver.findElement(By.xpath("//button[@name='websubmit']"));
        clickSignUp.click();

        WebElement message = driver.findElement(By.xpath("//div[text()='Please choose a gender. You can change who can see this later.']"));
        boolean messIsDisp = message.isDisplayed();
        Assert.assertTrue(messIsDisp,"The message is not displayed");



    }


}
