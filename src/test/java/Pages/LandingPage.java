package Pages;

import DriverWrapper.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage {
    //Locators
    By searchButton = By.xpath("//button[@type='submit']");
    By checkingCalender= By.id("qf-0q-localised-check-in");
    By checkouCalender = By.id("qf-0q-localised-check-out");
    By allCalenderDates= By.xpath("");

    //Method to interact with webElement (represent by above locators)
    public void clickSearch() {
        Web.getDriver().findElement(searchButton).click();
    }

    public boolean isSearchButtonEnabled() {
        return Web.getDriver().findElement(searchButton).isEnabled();
    }

    public void selectCheckInDate(String CheckIndate){
        Web.getDriver().findElement(checkingCalender).click();
        List<WebElement> dates= Web.getDriver().findElements(allCalenderDates);
        for(WebElement date: dates){
            if(date.getText().equalsIgnoreCase((CheckIndate))){
                date.click();
                break;
            }
        }

    }

    public void selectCheckOutDate(String CheckOutdate){
        Web.getDriver().findElement(checkouCalender).click();
        List<WebElement> dates= Web.getDriver().findElements(allCalenderDates);
        for(WebElement date: dates){
            if(date.getText().equalsIgnoreCase((CheckOutdate))){
                date.click();
                break;
            }
        }

    }

}
