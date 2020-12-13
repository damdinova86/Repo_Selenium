package Pages;

import DriverWrapper.Web;
import org.openqa.selenium.By;

public class BasePage {
    public void clickThis(By locator){
        Web.getDriver().findElement(locator).click();
    }
}
