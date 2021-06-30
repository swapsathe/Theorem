package com.theorem.ui.pages;

import com.theorem.ui.uimaps.CheckoutPaymentConfirmationPageUIMap;
import com.theorem.ui.uimaps.OrderConfirmationPageUIMap;
import org.openqa.selenium.WebDriver;

/**
 * Payment Confirmation Page related actions
 */
public class CheckoutPaymentConfirmationPage extends BasePage{

    private WebDriver driver;
    public CheckoutPaymentConfirmationPage(WebDriver driver) {this.driver = driver;}

    /**
     * Press confirm order button and wait for order confirmation to show
     */
    public void confirmOrder()
    {
        //wait for element to load
        waitForElementToShow(driver, CheckoutPaymentConfirmationPageUIMap.confirmOrderBtn);
        driver.findElement(CheckoutPaymentConfirmationPageUIMap.confirmOrderBtn).click();
        waitForElementToShow(driver, OrderConfirmationPageUIMap.orderConfirmationAlert);
    }
}
