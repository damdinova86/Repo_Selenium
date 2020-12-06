package Class1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.channels.SelectableChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Homework14 {
    @Test
    public void lowHighTemp() {
        //Testcase-1: Verify low/high temp on Today timeline

        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver 5");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.darksky.net");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,700)");

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//a[@data-day='0']//span[@class='toggle']//span[@class='open']")).click();
//first min Temp
        WebElement getTemp = driver.findElement(By.xpath("//a[@data-day='0']//span[@class='minTemp']"));
        String tempMinText = getTemp.getText();
        String[] tempMin = tempMinText.split("˚");
        String minTemp = tempMin[0];
//second min Temp
        driver.findElement(By.xpath("//a[@data-day='1']/preceding::span[@class='arrow']/preceding::span[@class='temp']"));
        String secTempMinText = getTemp.getText();
        String[] SecTempMin = secTempMinText.split("˚");
        String SecMinTemp = SecTempMin[0];

        Assert.assertEquals(minTemp, SecMinTemp, "Two temperatures are different");
//first max temp
        WebElement getMaxTemp = driver.findElement(By.xpath("//a[@data-day='0']//span[@class='maxTemp']"));
        String firstMaxTemp = getMaxTemp.getText();
        String[] firstMax = firstMaxTemp.split("˚");
        String firstMaxT = firstMax[0];
//second max temp
        WebElement secMaxTemp = driver.findElement(By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']"));
        String secMax = secMaxTemp.getText();
        String[] secMaxT = secMax.split("˚");
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
        int checkOutDate = tomorrowDate + 7;

        driver.findElement(By.xpath("//div[@class='widget-query-date']//label[@data-input='qf-0q-localised-check-in']")).click();
        List<WebElement> dates = driver.findElements(By.xpath("//td[starts-with(@data-date,'2020-11')]"));
        int checkInNum = 0;
        for (WebElement date1 : dates) {
            String dat = date1.getText();
            int da = Integer.valueOf(dat);
            if (da == tomorrowDate) {
                date1.click();
                checkInNum = da;
                break;
            }
        }

        driver.findElement(By.id("qf-0q-localised-check-out")).click();
        dates = driver.findElements(By.xpath("//td[starts-with(@data-date,'2020-11')]"));
        int checkOutNum = 0;
        for (WebElement date1 : dates) {
            String dat = date1.getText();
            int da = Integer.valueOf(dat);
            if (da == checkOutDate) {
                date1.click();
                checkOutNum = da;
                break;
            }

        }

        String num = driver.findElement(By.xpath("//span[@class='widget-query-num-nights']")).getText();
        int numconvert = Integer.valueOf(num);
        int verNum = checkOutNum - checkInNum;
        System.out.println(verNum);
        Assert.assertEquals(numconvert, verNum, "Two numbers are not match");

    }

    @Test
    public void verifyNums() {
        //Testcase-3: Enter the user details as mentioned
        //rooms -1, adults-1,children-2 (ages:1,2)
        //Verify user details on Search page as entered/selected on home page

        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver 5");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hotels.com");

        driver.findElement(By.id("qf-0q-destination")).sendKeys("Miami");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String toSelect = "Miami Beach, Florida, United States of America";
        By autoSuggestion = By.xpath("//div[@class='autosuggest-category-result']");
        List<WebElement> suggestions = driver.findElements(autoSuggestion);
        for (WebElement suggestion : suggestions) {
            String suggestionText = suggestion.getText();
            if (toSelect.equalsIgnoreCase(suggestionText)) {
                suggestion.click();
                break;
            }
        }


        driver.findElement(By.xpath("//div[@class='widget-query-date']//label[@data-input='qf-0q-localised-check-in']")).click();
        List<WebElement> dates = driver.findElements(By.xpath("//td[starts-with(@data-date,'2020-11')]"));
        SimpleDateFormat formatter = new SimpleDateFormat("d");
        Date date = new Date();
        String actualDate = formatter.format(date);
        int tomorrowDate = Integer.valueOf(actualDate) + 1;
        int checkOutDate = tomorrowDate + 7;

        for (WebElement date1 : dates) {
            String dat = date1.getText();
            int da = Integer.valueOf(dat);
            if (da == tomorrowDate) {
                date1.click();
                break;
            }
        }

        driver.findElement(By.id("qf-0q-localised-check-out")).click();
        dates = driver.findElements(By.xpath("//td[starts-with(@data-date,'2020-11')]"));

        for (WebElement date1 : dates) {
            String dat = date1.getText();
            int da = Integer.valueOf(dat);
            if (da == checkOutDate) {
                date1.click();
                break;
            }
        }
        WebElement roomsClick = driver.findElement(By.id("qf-0q-rooms"));
        Select room = new Select(roomsClick);
        room.selectByVisibleText("1");


        WebElement adultsClick = driver.findElement(By.id("qf-0q-room-0-adults"));
        Select adults = new Select(adultsClick);
        adults.selectByVisibleText("1");


        WebElement childrenClick = driver.findElement(By.id("qf-0q-room-0-children"));
        Select children = new Select(childrenClick);
        children.selectByVisibleText("2");


        WebElement children1Age = driver.findElement(By.id("qf-0q-room-0-child-0-age"));
        Select children1 = new Select(children1Age);
        children1.selectByVisibleText("1");

        WebElement children2Age = driver.findElement(By.id("qf-0q-room-0-child-1-age"));
        Select children2 = new Select(children2Age);
        children2.selectByVisibleText("2");

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String textRoom = driver.findElement(By.xpath("//select[@id='q-rooms']//option[@selected='selected']")).getText();
        String adultNun = driver.findElement(By.xpath("//select[@id='q-room-0-adults']//option[@selected='selected']")).getText();
        String childrenNum = driver.findElement(By.xpath("//select[@id='q-room-0-children']//option[@selected='selected']")).getText();
        String childrenAge = driver.findElement(By.xpath("//select[@id='q-room-0-child-0-age']//option[@selected='selected']")).getText();
        String childrenAge2 = driver.findElement(By.xpath("//select[@id='q-room-0-child-1-age']//option[@selected='selected']")).getText();

        driver.navigate().back();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }

        driver.findElement(By.xpath("//button[text()='Edit or add rooms']")).click();

        String roomVer = driver.findElement(By.xpath("//select[@id='qf-0q-rooms']//option[@selected='selected']")).getText();
        String adultsVer = driver.findElement(By.xpath("//select[@id='qf-0q-room-0-adults']//option[@selected='selected']")).getText();
        String childrenVer = driver.findElement(By.xpath("//select[@id='qf-0q-room-0-children']//option[@selected='selected']")).getText();
        String childAgeVer = driver.findElement(By.xpath("//select[@id='qf-0q-room-0-child-0-age']//option[@selected='selected']")).getText();
        String childAgeVer2 = driver.findElement(By.xpath("//select[@id='qf-0q-room-0-child-1-age']//option[@selected='selected']")).getText();


        Assert.assertEquals(textRoom, roomVer, "Two numbers are different-room");
        Assert.assertEquals(adultNun, adultsVer, "Two numbers are different-adults");
        Assert.assertEquals(childrenNum, childrenVer, "Two numbers are different-children");
        Assert.assertEquals(childrenAge, childAgeVer, "Two numbers are different-age1");
        Assert.assertEquals(childrenAge2, childAgeVer2, "Two numbers are different-age2");


    }
}
