package com.theorem.ui;

import com.theorem.ui.pages.HomePage;
import com.theorem.ui.uimaps.SearchPageUIMap;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test class for Searching Products
 */
public class SearchProductTest extends BaseTest{

    HomePage homePage;

    @Test
    public void searchForProduct() {
        homePage = new HomePage(driver);
        //Search product by entering some text eg. printed dress
        String searchStr = "printed dress";
        //Search product using text provided above
        homePage.searchForProduct(searchStr);
        //Verify Search title on resultant page is same as search string provided above
        Assert.assertTrue(driver.findElement(SearchPageUIMap.searchTitle).getText().contains(searchStr.toUpperCase()));
        //Verify number of products displayed is same as number of product said on top (this will only work if the
        //number if products returned by search is less that total product that can fit on the page, otherwise we need
        //to handle pagination
        String SearchResultCount = Integer.toString(driver.findElements(SearchPageUIMap.searchResultProducts).size());
        Assert.assertTrue(driver.findElement(SearchPageUIMap.searchHeadingCounter).getText().contains(SearchResultCount));
    }
}