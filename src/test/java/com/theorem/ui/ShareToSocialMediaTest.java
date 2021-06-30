package com.theorem.ui;

import com.theorem.ui.pages.HomePage;
import com.theorem.ui.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for sharing products on Social Media
 */
public class ShareToSocialMediaTest extends BaseTest{

    HomePage homePage;
    ProductPage productPage;

    @Test(dataProvider="socialData")
    public void shareOnSocialMedia(String socialMedia, String siteURL) {
        homePage = new HomePage(driver);
        //Navigate to any product eg. 3
        homePage.navigateToProduct("3");
        productPage = new ProductPage(driver);
        String MainWindow = driver.getWindowHandle(); // Get handle to main window before launching the popup
        productPage.launchShareToSocialMedia(socialMedia);
        Assert.assertTrue(driver.getCurrentUrl().contains(siteURL),
                "Popup launched after clicking social media share button, does not point to right site");
        //I can check here to see if facebook/twitter post button is visible, but we would need to log into that site
        driver.switchTo().window(MainWindow); // switch back to Main window after validation
    }

    /**
     * Create data object for parameterized test point
     */
    @DataProvider(name="socialData")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]
                {
                        { "facebook", "facebook.com" },
                        { "twitter", "twitter.com" },
                        { "pinterest", "pinterest.ca" }, //I think this is coming up as .ca since I am in canada, it might fail in US
                        { "googleplus", "plus.google.com" } // this is dead page, maybe need to remove from site
                };
    }
}