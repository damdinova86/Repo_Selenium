package Class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice {
    @Test
    public void methods(){
        System.setProperty("webdriver.chrome.driver","./DriverExe/chromedriver 5");
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.facebook.com");

        WebElement createPageLink= driver.findElement(By.linkText("Create a Page"));

        createPageLink.click();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        String actualNewURL= driver.getCurrentUrl();
        String expNewUrl = createPageLink.getAttribute("href");
        Assert.assertEquals(actualNewURL,expNewUrl,"user lands on different page");



    }
}
