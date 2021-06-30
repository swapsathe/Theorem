package com.theorem.ui.uimaps;

import org.openqa.selenium.By;

/**
 * This is data file to include all locators to elements on Shopping Cart page.
 */
public class ShoppingCartPageUIMap {

    public static By cartTitle = By.id("cart_title");
    public static By cartProductNames = By.cssSelector("table p.product-name a");
    public static By cartDeleteProducts = By.cssSelector("td.cart_delete a");
    public static By emptyCartAlert = By.cssSelector("p.alert");
    public static By proceedToCheckoutBtn = By.cssSelector("p.cart_navigation a.standard-checkout");

}
