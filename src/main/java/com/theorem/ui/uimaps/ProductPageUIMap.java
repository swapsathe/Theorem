package com.theorem.ui.uimaps;

import org.openqa.selenium.By;

/**
 * This is data file to include all locators to elements on Product page.
 */
public class ProductPageUIMap {

    public static By addToCartBtn = By.cssSelector("#add_to_cart button");
    public static By productAddedToCartTitle = By.cssSelector("div#layer_cart h2");
    public static By proceedToCheckoutBtn = By.xpath("//div[@id='layer_cart']//a[@title='Proceed to checkout']");
    public static By shareToTwitterBtn = By.cssSelector("button.btn-twitter");
    public static By shareToFacebookBtn = By.cssSelector("button.btn-facebook");
    public static By shareToPinterestBtn = By.cssSelector("button.btn-pinterest");
    public static By shareToGooglePlusBtn = By.cssSelector("button.btn-google-plus");
}
