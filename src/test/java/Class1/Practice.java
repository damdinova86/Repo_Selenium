package Class1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Practice {
    @Test
    public void practice() {
        System.setProperty("webdriver.chrome.driver", "./DriverExe/chromedriver 5");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.hotels.com");

        driver.findElement(By.id("qf-0q-destination")).sendKeys("time square");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String toSelect = "Time Square,New York,New York, USA";
        By autoSuggestionLocator = By.xpath("//div[@class='autosuggest-category-result']");
        List<WebElement> suggestions= driver.findElements(autoSuggestionLocator);
        for(WebElement suggestion: suggestions){
            String suggestionText= suggestion.getText();
            if(toSelect.equalsIgnoreCase(suggestionText)){
                suggestion.click();
                break;
            }
        }
    }


}

