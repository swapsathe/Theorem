package com.theorem.ui.pages;

import com.theorem.ui.uimaps.ProductPageUIMap;
import com.theorem.ui.uimaps.ShoppingCartPageUIMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Iterator;

/**
 * Product page related actions
 */
public class ProductPage extends BasePage{

    private WebDriver driver;
    public ProductPage(WebDriver driver) {this.driver = driver;}

    /**
     * Add product to cart and wait for confirmation
     */
    public void addToCart() {
        waitForElementToShow(driver, ProductPageUIMap.addToCartBtn);
        driver.findElement(ProductPageUIMap.addToCartBtn).click();
        waitForElementToShow(driver, ProductPageUIMap.productAddedToCartTitle);
    }

    /**
     * Press proceed to checkout button on confirmation dialog, wait for cart page to load
     */
    public void proceedToCheckout() {
        waitForElementToShow(driver, ProductPageUIMap.proceedToCheckoutBtn);
        driver.findElement(ProductPageUIMap.proceedToCheckoutBtn).click();
        waitForElementToShow(driver, ShoppingCartPageUIMap.cartTitle);
    }

    /**
     * Launch share on social network popup by clicking on respective button
     * @param socialNetwork name of social network to use
     */
    public void launchShareToSocialMedia(String socialNetwork) {
        By buttonLocator;
        if (socialNetwork.equalsIgnoreCase("facebook")) {
            buttonLocator = ProductPageUIMap.shareToFacebookBtn;
        } else if (socialNetwork.equalsIgnoreCase("twitter")) {
            buttonLocator = ProductPageUIMap.shareToTwitterBtn;
        } else if (socialNetwork.equalsIgnoreCase("pinterest")) {
            buttonLocator = ProductPageUIMap.shareToPinterestBtn;
        } else {
            buttonLocator = ProductPageUIMap.shareToGooglePlusBtn;
        }
        waitForElementToShow(driver, buttonLocator);
        driver.findElement(buttonLocator).click();
        String MainWindow = driver.getWindowHandle(); // get hold of main window to check we don't switch to it
        Iterator<String> windowHandles = driver.getWindowHandles().iterator(); // gather all windows open
        while (windowHandles.hasNext()) {
            String ChildWindow = windowHandles.next();
            if (!MainWindow.equalsIgnoreCase(ChildWindow)) { //select window which is not main window
                // Switching to Child window
                driver.switchTo().window(ChildWindow);
            }
        }
    }

}
