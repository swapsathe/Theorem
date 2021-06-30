package com.theorem.ui;

import com.theorem.ui.pages.HomePage;
import com.theorem.ui.uimaps.CategoryPageUIMap;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Test class for Browsing Products
 */
public class BrowseProductTest extends BaseTest{

    HomePage homePage;

    @Test(dataProvider="categoriesData")
    public void browseMainCategories(String catName, int subCatCount, int productCount) {
        homePage = new HomePage(driver);
        //Navigate to category we want
        homePage.navigateToCategory(catName);
        //Verify the title of the page
        Assert.assertTrue(driver.findElement(CategoryPageUIMap.catPageHeader).getText().contains(catName.toUpperCase()));
        //Verify the number of subcategories on top header area
        Assert.assertTrue(driver.findElements(CategoryPageUIMap.subCatHeaderList).size() == subCatCount);
        //Verify the number of subcategories on side bar area
        Assert.assertTrue(driver.findElements(CategoryPageUIMap.subCatSideBarList).size() == subCatCount);
        //Verify filters block shows in the page
        Assert.assertTrue(driver.findElement(CategoryPageUIMap.filterBlock).isDisplayed());
        //Verify number of products shown in the category (this will not work if there are more products and pagination)
        Assert.assertTrue(driver.findElements(CategoryPageUIMap.productImgLinks).size() == productCount);
        //Verify the number of products text on top
        Assert.assertTrue(driver.findElements(CategoryPageUIMap.productCountText).get(0).getText()
                .contains(Integer.toString(productCount)));
    }

    /**
     * Create data object for parameterized test point
     */
    @DataProvider(name="categoriesData")
    public Object[][] getDataFromDataProvider(){
        return new Object[][]
                {
                        { "Women", 2, 7 },
                        { "Dresses", 3, 5 },
                        { "T-shirts", 0, 1 }
                };
    }
}