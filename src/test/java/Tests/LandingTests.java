package Tests;

import DriverWrapper.Web;
import Pages.LandingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LandingTests extends Web {

    //Testcase 1: User is able to click Select button
    /*
    landing
    search
     */
    @Test
    public void verifySearchClickable() {

        LandingPage lpage = new LandingPage();
        Assert.assertTrue(lpage.isSearchButtonEnabled(), "Search button is not enabled");
    }

    //Testcase 2: Verify correct number of night displayed on briefcase
    /*
    Landing
    check-in
    check-out
    Briefcase

     */
    @Test
    public void verifyBriefCaseCount() {
        LandingPage lpage = new LandingPage();
        lpage.selectCheckOutDate("18");

    }
}
