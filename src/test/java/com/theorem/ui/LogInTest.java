package com.theorem.ui;

import com.theorem.ui.pages.SignInPage;
import com.theorem.ui.uimaps.MyAccountPageUIMap;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for Log in to the account
 */
public class LogInTest extends BaseTest{

    SignInPage signInPage;

    //Registered User Details
    String firstName = "Momo";
    String lastName = "Lemur";
    String email = "momo@airnomad.com";
    String password = "MomoLovesFood";

    @BeforeMethod(alwaysRun = true)
    public void navigateToSignInPage() {
        String signInPageURL = BASE_URL + "?controller=authentication&back=my-account";
        driver.get(signInPageURL);
    }

    @Test
    public void logInWithRegisteredUserTest() {
        signInPage = new SignInPage(driver);
        //Enter already registered user details
        signInPage.signInWithRegisteredUser(email, password, false);
        //Verify user name on My Account page is same as user data provided above
        Assert.assertEquals(driver.findElement(MyAccountPageUIMap.myAccountLink).getText(),
                firstName+" "+lastName,
                "Registered user sign in was not successful");
    }
}