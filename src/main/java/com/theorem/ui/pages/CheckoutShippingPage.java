package com.theorem.ui.pages;

import com.theorem.ui.uimaps.CheckoutPaymentPageUIMap;
import com.theorem.ui.uimaps.CheckoutShippingPageUIMap;
import org.openqa.selenium.WebDriver;

/**
 * Shipping Page related actions
 */
public class CheckoutShippingPage extends BasePage{

    private WebDriver driver;
    public CheckoutShippingPage(WebDriver driver) {this.driver = driver;}

    /**
     * Click on Proceed to Payment button and wait for payment screen to appear
     */
    public void proceedToPayment()
    {
        //wait for element to load
        waitForElementToShow(driver, CheckoutShippingPageUIMap.proceedToCheckoutBtn);
        driver.findElement(CheckoutShippingPageUIMap.tosCheckbox).click();
        driver.findElement(CheckoutShippingPageUIMap.proceedToCheckoutBtn).click();
        waitForElementToShow(driver, CheckoutPaymentPageUIMap.payByBankWireBtn);
    }
}
