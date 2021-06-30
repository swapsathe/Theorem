package com.theorem.ui.pages;

import com.theorem.ui.BaseTest;
import com.theorem.ui.uimaps.CategoryPageUIMap;
import com.theorem.ui.uimaps.HomePageUIMap;
import com.theorem.ui.uimaps.ProductPageUIMap;
import com.theorem.ui.uimaps.SearchPageUIMap;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Home page related actions
 */
public class HomePage extends BasePage{

    private WebDriver driver;
    public HomePage(WebDriver driver) {this.driver = driver;}

    /**
     * Navigate to product page by using URL
     * @param productId Product ID we can use to form URL for the product
     */
    public void navigateToProduct(String productId) {
        String productPageURL = BaseTest.BASE_URL + "?id_product="+productId+"&controller=product";
        driver.get(productPageURL);
        waitForElementToShow(driver, ProductPageUIMap.addToCartBtn);
    }

    /**
     * Search for product and wait for search results to show
     * @param searchStr Search term to input in search box
     */
    public void searchForProduct(String searchStr){
        waitForElementToShow(driver, HomePageUIMap.searchInput);
        driver.findElement(HomePageUIMap.searchInput).sendKeys(searchStr);
        driver.findElement(HomePageUIMap.searchInput).sendKeys(Keys.ENTER);
        waitForElementToShow(driver, SearchPageUIMap.searchTitle);
    }

    /**
     * Navigate to top level category using its name, then wait for the category page to load
     * @param catName Name of the category as it appears on the storefront
     */
    public void navigateToCategory(String catName){
        By locator = By.xpath(HomePageUIMap.topNavLocator.replace("%", catName));
        waitForElementToShow(driver, locator);
        driver.findElement(locator).click();
        waitForElementToShow(driver, CategoryPageUIMap.filterBlock);
    }
}
