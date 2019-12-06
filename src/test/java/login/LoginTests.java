package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*; //Asterisk imports all assert methods

/*
Overview
- inherits to avoid redundant set up for browser as well as creating driver and homePage fields
- Uses inherited homePage object to click the form authentication link
- Gets alert text to compare with what we think it is. Test will pass or fail based on equality
 */

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"), "Alert text is incorrect");

        /*assertEquals(secureAreaPage.getAlertText(), "You logged into a secure area! x", "Alert text is incorrect");
           This method threw AssertionError from assertion library due to spacing issues with the x close text
           Confirmed by viewing test failed panel and clicked to see difference
         */
    }
}
