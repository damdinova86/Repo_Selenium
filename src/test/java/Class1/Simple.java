package Class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Simple {
    @Test
    public void launchPage(){
        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver 5");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

//        Assert.assertTrue(driver.get("https://www.facebook.com")

//        driver.close();


    }
}
