package com.theorem.ui;

import com.theorem.ui.pages.HomePage;
import com.theorem.ui.pages.ProductPage;
import com.theorem.ui.pages.ShoppingCartPage;
import com.theorem.ui.uimaps.ShoppingCartPageUIMap;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for Shopping Cart actions
 */
public class ShoppingCartTest extends BaseTest{

    HomePage homePage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    @Test
    public void addToCartAndRemoveFromCart() {
        homePage = new HomePage(driver);
        homePage.navigateToProduct("3");
        productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.proceedToCheckout();
        //Verify that we are on shopping cart page
        Assert.assertTrue(driver.findElement(ShoppingCartPageUIMap.cartTitle).getText().contains("SHOPPING-CART SUMMARY"));
        //Verify that there is only one product in the cart
        Assert.assertTrue(driver.findElements(ShoppingCartPageUIMap.cartProductNames).size() == 1);
        //Verify that right product got added to the cart
        Assert.assertTrue(driver.findElements(ShoppingCartPageUIMap.cartProductNames).get(0).getText().contains("Printed Dress"));
        //Remove the product from cart
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.removeFromCart(0);
        //Verify that we see empty shopping cart alert
        Assert.assertTrue(driver.findElement(ShoppingCartPageUIMap.emptyCartAlert).getText().contains("Your shopping cart is empty."));
    }
}