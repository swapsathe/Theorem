package com.theorem.ui.uimaps;

import org.openqa.selenium.By;

/**
 * This is data file to include all locators to elements on Payment page.
 */
public class CheckoutPaymentPageUIMap {

    public static By payByChequeBtn = By.cssSelector("p.payment_module a.cheque");
    public static By payByBankWireBtn = By.cssSelector("p.payment_module a.bankwire");

}
