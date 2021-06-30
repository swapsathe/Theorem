package com.theorem.ui.pages;

import com.theorem.ui.uimaps.CheckoutPaymentConfirmationPageUIMap;
import com.theorem.ui.uimaps.CheckoutPaymentPageUIMap;
import org.openqa.selenium.WebDriver;

/**
 * Payment Page related actions
 */
public class CheckoutPaymentPage extends BasePage{

    private WebDriver driver;
    public CheckoutPaymentPage(WebDriver driver) {this.driver = driver;}

    /**
     * Select payment method as per parameter provided wait for next confirmation page to show
     * @param  paymentMethod String providing payment type
     */
    public void selectPaymentMethod(String paymentMethod) {
        waitForElementToShow(driver, CheckoutPaymentPageUIMap.payByChequeBtn);
        if (paymentMethod.equalsIgnoreCase("cheque")){
            driver.findElement(CheckoutPaymentPageUIMap.payByChequeBtn).click();
        } else {
            driver.findElement(CheckoutPaymentPageUIMap.payByBankWireBtn).click();
        }
        waitForElementToShow(driver, CheckoutPaymentConfirmationPageUIMap.confirmOrderBtn);
    }
}
