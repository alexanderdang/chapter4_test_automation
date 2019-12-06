package forgotpassword;

import base.BaseTests;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testEmailPasswordRetrieval(){
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();

        /*forgotPasswordPage.enterEmailAddress("tau@example.ca");
        EmailSentPage emailSentPage = forgotPasswordPage.clickRetrievePasswordButton();*/

        var emailSentPage = forgotPasswordPage.retrievePassword("tau@example.ca"); //Instructor's code
        assertEquals(emailSentPage.getAlertText(),"Your e-mail's been sent!", "Confirmation text is incorrect");
    }
}
