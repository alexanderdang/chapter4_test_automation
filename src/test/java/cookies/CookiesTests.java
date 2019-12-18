package cookies;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.*;

public class CookiesTests extends BaseTests {

    @Test
    public void deleteCookie(){
        getCookieManager().deleteCookieByName("optimizelyBuckets");
        assertFalse(getCookieManager().isCookiePresentByName("optimizelyBuckets"), "Cookie not deleted");

        /* Instructor's solution
        @Test
        public void testDeleteCookie(){
        var cookieManager = getCookieManager();
        Cookie cookie = cookieManager.buildCookie("optimizelyBuckets", "%7B%TD");
        cookieManager.deleteCookie(cookie);
        assertFalse(cookieManager.isCookiePresent(cookie), "Cookie was not deleted");
    }
         */
    }
}
