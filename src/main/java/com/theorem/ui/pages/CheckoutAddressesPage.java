package com.theorem.ui.pages;

import com.theorem.ui.uimaps.*;
import org.openqa.selenium.WebDriver;

/**
 * Address Page related actions
 */
public class CheckoutAddressesPage extends BasePage{

    private WebDriver driver;
    public CheckoutAddressesPage(WebDriver driver) {this.driver = driver;}

    /**
     * Click on proceed to checkout button
     */
    public void proceedToShipping()
    {
        //wait for element to load
        waitForElementToShow(driver, CheckoutAddressesPageUIMap.proceedToCheckoutBtn);
        driver.findElement(CheckoutAddressesPageUIMap.proceedToCheckoutBtn).click();
        waitForElementToShow(driver, CheckoutShippingPageUIMap.proceedToCheckoutBtn);
    }
}
