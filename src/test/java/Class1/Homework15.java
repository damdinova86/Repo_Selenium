package Class1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Homework15 {

    /**
     * 1. Launch facebook.com
     * 2.Click on'Facebook Pay'
     * 3.Click on 'Oculuc'
     * 4.Close Facebook Landing Page and Oculuc page
     * 5.Click on'Way to Pay'
     * 6.Verify heading 'Pay directly from your favorite  apps' appears
     */
    @Test
    public void wayToPay() {
        //1. Launch facebook.com
        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,500)");


        //2.Click on'Facebook Pay'
        driver.findElement(By.linkText("Facebook Pay")).click();


        // 3.Click on 'Oculuc'
        driver.findElement(By.linkText("Oculus")).click();

        //4.Close Facebook Landing Page and Oculuc page

        Set<String> allHandles = driver.getWindowHandles();

        for (String handle : allHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains("Sign") || driver.getTitle().contains("Oculus")) {
                driver.close();
            }
        }
        
        //5.Click on'Way to Pay'
        driver.findElement(By.xpath("//div[@class='hero-app__icon-container']/preceding::a[text()='Ways to Pay']")).click();

        //6.Verify heading 'Pay directly from your favorite  apps' appears
        String textToVer = driver.findElement(By.xpath("//h1[text()='Pay directly from your favorite apps']")).getText();
        String textToVerOrg = "Pay directly from your favorite apps";
        Assert.assertEquals(textToVerOrg, textToVer, "Text doesn't match ");


    }
}
