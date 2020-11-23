package Class1;

import jdk.nashorn.internal.objects.NativeError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Homework12 {
    private Object ParseException;

    @Test
    public void feelsLike() {

        /**
         * Testcase 1: Verify the feels-like temp value is between low and high temp values for any zip code
         * Plan:
         * 1. Get locator for feel-like temp
         * 2.Capture temp value using getText()
         * 3. Use substring to get number
         * 4. convert to integer
         *
         */
        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver 5");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.darksky.net");

        //1 Feels-like temp
        WebElement locator = driver.findElement(By.xpath("//span[@class='feels-like-text']"));
        String textFromWeb = locator.getText();
        String[] stringIntoArray = textFromWeb.split((""));
        String store = "";
        for (int i = 0; i <= stringIntoArray.length - 1; i++) {
            store += stringIntoArray[i];
        }
        String newStringTemp = store.substring(0, stringIntoArray.length - 1);
        int temFeelsLike = Integer.parseInt(newStringTemp);


        //2 Low temp
        WebElement locatorLowTem = driver.findElement(By.xpath("//span[@class='low-temp-text']"));
        String textForLowTemp = locatorLowTem.getText();
        String[] stringIntoArrayLowTemp = textForLowTemp.split((""));
        String storeLowTemp = "";
        for (int i = 0; i <= stringIntoArrayLowTemp.length - 1; i++) {
            storeLowTemp += stringIntoArrayLowTemp[i];
        }
        String newStringLowTemp = storeLowTemp.substring(0, stringIntoArray.length - 1);
        int lowTemp = Integer.parseInt(newStringLowTemp);


        //3 High Temp

        WebElement locatorHighTem = driver.findElement(By.xpath("//span[@class='high-temp-text']"));
        String textForHighTemp = locatorHighTem.getText();
        String[] stringIntoArrayHighTemp = textForHighTemp.split((""));
        String storeHighTemp = "";
        for (int i = 0; i <= stringIntoArrayHighTemp.length - 1; i++) {
            storeHighTemp += stringIntoArrayHighTemp[i];
        }
        String newStringHighTemp = storeHighTemp.substring(0, stringIntoArray.length - 1);
        int highTemp = Integer.parseInt(newStringHighTemp);


        if (temFeelsLike > lowTemp && temFeelsLike < highTemp) {
            System.out.println("Feels-like temperature " + temFeelsLike + " is between low " + lowTemp + " and high " + highTemp + " temperature");
        } else System.out.println("Feels-like temperature is not between low and high temperature");

    }

    /**
     * Testcase 2: Verify the dates on the Blog Page appears in reverse chronological order
     */
    @Test
    public void reverseChronologicalOrder() throws java.text.ParseException {
        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver 5");
        WebDriver driver = new ChromeDriver();
        driver.get("https://blog.darksky.net");

        try {
            Thread.sleep(1000);     // 2000milliseconds = 2seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement locator = driver.findElement(By.xpath("//time[contains(text(),'August')]"));
        String dateInStringAugust = locator.getText();


        Date myParseDate = null;
        String dateText = dateInStringAugust;
        SimpleDateFormat df1 = new SimpleDateFormat("MMM dd, yyyy");
        try {
            myParseDate = df1.parse(dateText);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        //Second date July
        WebElement locator2 = driver.findElement(By.xpath("//time[contains(text(),'July')]"));
        String dateInStringJuly = locator2.getText();


        Date myParseDateJuly = null;
        String dateTextJuly = dateInStringJuly;
        SimpleDateFormat df2 = new SimpleDateFormat("MMM dd, yyyy");
        try {
            myParseDateJuly = df2.parse(dateTextJuly);

        } catch (ParseException e) {
            e.printStackTrace();
        }


        //Third date March
        WebElement locator3 = driver.findElement(By.xpath("//time[contains(text(),'March')]"));
        String dateInStringMarch = locator3.getText();


        Date myParseDateMarch = null;

        SimpleDateFormat df3 = new SimpleDateFormat("MMM dd, yyyy");
        try {
            myParseDateMarch = df3.parse(dateInStringMarch);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        boolean firstAndSec = myParseDate.after(myParseDateJuly);
        boolean SecandThird = myParseDateJuly.after(myParseDateMarch);
        System.out.println("The first date comes after the second: " + firstAndSec);
        System.out.println("The second date comes after the third date: " + SecandThird);


    }

    /**
     * Testcase 3: Verify the temperature value converts as expected as the unit selected
     * 1. Get locators
     * 2.Capture temp value using getText()
     * 3. Use substring to get number
     * 4. convert to integer
     * 5. get formula for temperature
     * 6. compare from webpage to formula
     */
    @Test
    public void convertTemp() {
        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver 5");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.darksky.net");

        WebElement locator = driver.findElement(By.xpath("//span[@class='summary swap']"));
        String temp = locator.getText();
        String[] stringIntoArray = temp.split((""));
        String store = "";
        for (int i = 0; i <= stringIntoArray.length - 11; i++) {
            store += stringIntoArray[i];
        }
        String newStringTemp = store.substring(0, stringIntoArray.length - 11);
        int temInF = Integer.parseInt(newStringTemp);


// convert from F to C' by formula

        double cTemp = (temInF - 32) * 5 / 9;
        System.out.println(temInF + " F = " + cTemp + " C'");

        try {
            Thread.sleep(2000);     // 2000milliseconds = 2seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//div[@id='currentDetailsWrapper']/preceding::span[contains(text(),'F')]")).click();


        try {
            Thread.sleep(2000);     // 2000milliseconds = 2seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("(//li[@data-index='1' and contains(text(), 'm/s')])[1]")).click();


        WebElement locatorForC = driver.findElement(By.xpath("//span[@class='summary swap']"));
        String tempC = locatorForC.getText();
        String[] stringIntoArrayC = tempC.split((""));
        String storeC = "";
        for (int i = 0; i <= stringIntoArrayC.length - 11; i++) {
            storeC += stringIntoArrayC[i];
        }
        String newStringTempC = storeC.substring(0, stringIntoArray.length - 11);
        int temInC = Integer.parseInt(newStringTempC);


        //convert from C to F

        double fTemp = temInC * 9 / 5 + 32;
        System.out.println(temInC + " C' = " + fTemp + " F");


        if (temInC == cTemp) {
            System.out.println("Conversion from F to C is correct");
        } else
            System.out.println("Conversion from F to C is not correct");


        if (fTemp == temInF) {
            System.out.println("Conversion from C to F is correct");
        } else
            System.out.println("Conversion from C to F is not correct");


    }
}
