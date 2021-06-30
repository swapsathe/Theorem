package com.theorem.ui.pages;

import com.theorem.ui.uimaps.CheckoutAddressesPageUIMap;
import com.theorem.ui.uimaps.ShoppingCartPageUIMap;
import com.theorem.ui.uimaps.SignInPageUIMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Shopping cart page related actions
 */
public class ShoppingCartPage extends BasePage{

    private WebDriver driver;
    public ShoppingCartPage(WebDriver driver) {this.driver = driver;}

    /**
     * Remove item from cart using the index in the cart table, then wait for that product to disappear
     * @param productIndex index of product to remove
     */
    public void removeFromCart(int productIndex) {
        waitForElementToShow(driver, ShoppingCartPageUIMap.cartDeleteProducts);
        WebElement deleteBtn = driver.findElements(ShoppingCartPageUIMap.cartDeleteProducts).get(productIndex);
        deleteBtn.click();
        waitForElementToBeStale(driver, deleteBtn);
    }

    /**
     * Click proceed to checkout button and wait for the next page to load
     * @param signedIn boolean value to indicate if we have already signed in or not
     */
    public void proceedToCheckout(boolean signedIn){
        waitForElementToShow(driver, ShoppingCartPageUIMap.proceedToCheckoutBtn);
        driver.findElement(ShoppingCartPageUIMap.proceedToCheckoutBtn).click();
        if (signedIn){
            waitForElementToShow(driver, CheckoutAddressesPageUIMap.addressPageTitle);
        } else {
            waitForElementToShow(driver, SignInPageUIMap.signInBtn);
        }
    }
}
