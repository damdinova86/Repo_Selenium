package Class1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Homework14 {
    @Test
    public void lowHighTemp(){
        //Testcase-1: Verify low/high temp on Today timeline

        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver 5");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.darksky.net");

        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("scrollBy(0,700)");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//a[@data-day='0']//span[@class='toggle']//span[@class='open']")).click();
//first min Temp
       WebElement getTemp= driver.findElement(By.xpath("//a[@data-day='0']//span[@class='minTemp']"));
        String tempMinText= getTemp.getText();
        String[] tempMin = tempMinText.split("˚");
        String minTemp = tempMin[0];
//second min Temp
        driver.findElement(By.xpath("//a[@data-day='1']/preceding::span[@class='arrow']/preceding::span[@class='temp']"));
        String secTempMinText= getTemp.getText();
        String[] SecTempMin = secTempMinText.split("˚");
        String SecMinTemp = SecTempMin[0];

        Assert.assertEquals(minTemp,SecMinTemp, "Two temperatures are different");
//first max temp
        WebElement getMaxTemp = driver.findElement(By.xpath("//a[@data-day='0']//span[@class='maxTemp']"));
        String firstMaxTemp= getMaxTemp.getText();
        String[] firstMax = firstMaxTemp.split("˚");
        String firstMaxT= firstMax[0];
//second max temp
        WebElement secMaxTemp= driver.findElement(By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']"));
        String secMax= secMaxTemp.getText();
        String[] secMaxT= secMax.split("˚");
        String secMaxTe = secMaxT[0];

        Assert.assertEquals(firstMaxT, secMaxTe, "Max temperatures are different");
    }

    //Testcase-2: Verify the number of nights on black briefcase
    //check-in: tomorrow
    //check-out: 7 days from check-in date
    @Test
    public void blackBriefcase() {

        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver 5");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hotels.com");

        SimpleDateFormat formatter = new SimpleDateFormat("d");
        Date date = new Date();
        String actualDate = formatter.format(date);
        int tomorrowDate = Integer.valueOf(actualDate) + 1;
        int checkOutDate = tomorrowDate+7;

        driver.findElement(By.xpath("//div[@class='widget-query-date']//label[@data-input='qf-0q-localised-check-in']")).click();
        List<WebElement> dates = driver.findElements(By.xpath("//td[starts-with(@data-date,'2020-11')]"));
        int checkInNum=0;
        for (WebElement date1 : dates) {
            String dat = date1.getText();
            int da = Integer.valueOf(dat);
            if (da == tomorrowDate) {
                date1.click();
                checkInNum=da;
                break;
            }
        }

        driver.findElement(By.id("qf-0q-localised-check-out")).click();
        dates = driver.findElements(By.xpath("//td[starts-with(@data-date,'2020-11')]"));
        int checkOutNum=0;
        for (WebElement date1 : dates) {
            String dat = date1.getText();
            int da = Integer.valueOf(dat);
            if (da == checkOutDate) {
                date1.click();
                checkOutNum=da;
                break;
            }

        }

        String num= driver.findElement(By.xpath("//span[@class='widget-query-num-nights']")).getText();
        int numconvert= Integer.valueOf(num);
        int verNum = checkOutNum-checkInNum;
        System.out.println(verNum);
        Assert.assertEquals(numconvert,verNum,"Two numbers are not match");

    }

}
