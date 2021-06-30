package com.theorem.ui;

import com.theorem.ui.pages.*;
import com.theorem.ui.uimaps.OrderConfirmationPageUIMap;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for Checkout process
 */
public class CheckoutCartTest extends BaseTest{

    HomePage homePage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    SignInPage signInPage;
    CheckoutAddressesPage checkoutAddressesPage;
    CheckoutShippingPage checkoutShippingPage;
    CheckoutPaymentPage checkoutPaymentPage;
    CheckoutPaymentConfirmationPage checkoutPaymentConfirmationPage;

    String email = "momo@airnomad.com";
    String password = "MomoLovesFood";

    @Test
    public void checkoutCart() {
        homePage = new HomePage(driver);
        homePage.navigateToProduct("3");
        productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.proceedToCheckout();
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.proceedToCheckout(false);
        signInPage = new SignInPage(driver);
        signInPage.signInWithRegisteredUser(email, password, true);
        checkoutAddressesPage = new CheckoutAddressesPage(driver);
        checkoutAddressesPage.proceedToShipping();
        checkoutShippingPage = new CheckoutShippingPage(driver);
        checkoutShippingPage.proceedToPayment();
        checkoutPaymentPage = new CheckoutPaymentPage(driver);
        checkoutPaymentPage.selectPaymentMethod("cheque");
        checkoutPaymentConfirmationPage = new CheckoutPaymentConfirmationPage(driver);
        checkoutPaymentConfirmationPage.confirmOrder();
        Assert.assertTrue(driver.findElement(OrderConfirmationPageUIMap.orderConfirmationAlert).getText().contains("Your order on My Store is complete."));
        Assert.assertTrue(driver.findElement(OrderConfirmationPageUIMap.orderPrice).getText().contains("$28.00"));
    }
}