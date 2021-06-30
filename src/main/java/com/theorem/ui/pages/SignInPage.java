package com.theorem.ui.pages;

import com.theorem.ui.uimaps.CheckoutAddressesPageUIMap;
import com.theorem.ui.uimaps.CreateAccountPageUIMap;
import com.theorem.ui.uimaps.MyAccountPageUIMap;
import com.theorem.ui.uimaps.SignInPageUIMap;
import org.openqa.selenium.WebDriver;

/**
 * Sign in Page related actions
 */
public class SignInPage extends BasePage{
    private WebDriver driver;
    public SignInPage(WebDriver driver) {this.driver = driver;}

    /**
     * Navigate to Sign up page and wait for it to load
     * @param emailId Email id we want to use for registering account
     */
    public void navigateToCreateAccount(String emailId)
    {
        //wait for element to load
        waitForElementToShow(driver, SignInPageUIMap.createAccEmailInput);
        driver.findElement(SignInPageUIMap.createAccEmailInput).sendKeys(emailId);
        driver.findElement(SignInPageUIMap.createAccBtn).click();
        waitForElementToShow(driver, CreateAccountPageUIMap.pageHeader);
    }

    /**
     * Log in with already registered user
     * @param emailId Email id of the user
     * @param password Password of the user
     * @param cartLogin boolean value to indicate if we are initiating the login from cart(checkout process)
     */
    public void signInWithRegisteredUser(String emailId, String password, boolean cartLogin)
    {
        //wait for element to load
        waitForElementToShow(driver, SignInPageUIMap.registeredEmailInput);
        driver.findElement(SignInPageUIMap.registeredEmailInput).sendKeys(emailId);
        driver.findElement(SignInPageUIMap.registeredPasswordInput).sendKeys(password);
        driver.findElement(SignInPageUIMap.signInBtn).click();
        if (cartLogin){ // depending on if we are in checkout process, we will end up on different page
            waitForElementToShow(driver, CheckoutAddressesPageUIMap.proceedToCheckoutBtn);
        } else {
            waitForElementToShow(driver, MyAccountPageUIMap.myAccountLink);
        }
    }
}
