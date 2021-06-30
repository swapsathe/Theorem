package com.theorem.ui;

import com.theorem.testdata.CreateAccountTestData;
import com.theorem.ui.pages.CreateAccountPage;
import com.theorem.ui.pages.SignInPage;
import com.theorem.ui.uimaps.MyAccountPageUIMap;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for Account Creation
 */
public class CreateAccountTest extends BaseTest{

    SignInPage signInPage;
    CreateAccountPage createAccountPage;
    CreateAccountTestData testData = new CreateAccountTestData();

    @BeforeMethod(alwaysRun = true)
    public void navigateToSignInPage() {
        String signInPageURL = BASE_URL + "?controller=authentication&back=my-account";
        driver.get(signInPageURL);
    }

    @Test
    public void createNewAccount() {
        signInPage = new SignInPage(driver);
        //Navigate to Create Account using Email from test data
        signInPage.navigateToCreateAccount(testData.userInfo.getString("Email"));
        createAccountPage = new CreateAccountPage(driver);
        //Register new user with details provided in test dada
        createAccountPage.registerAccount(testData.userInfo);
        //Verify newly user details from newly created account are same as test data provided
        Assert.assertEquals(driver.findElement(MyAccountPageUIMap.myAccountLink).getText(),
                testData.userInfo.getString("FirstName")+" "+testData.userInfo.getString("LastName"),
                "Account creation was not successful");
    }
}