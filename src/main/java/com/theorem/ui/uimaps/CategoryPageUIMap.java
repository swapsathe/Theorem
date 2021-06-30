package com.theorem.ui.uimaps;

import org.openqa.selenium.By;

/**
 * This is data file to include all locators to elements on Category page.
 */
public class CategoryPageUIMap {

    public static By catPageHeader = By.cssSelector("h1 span.cat-name");
    public static By subCatHeaderList = By.cssSelector("div#subcategories ul li");
    public static By subCatSideBarList = By.xpath("//div[@id='categories_block_left']//ul[@style='display: block;']/li");
    public static By filterBlock = By.id("layered_block_left");
    public static By productImgLinks = By.cssSelector("a.product_img_link");
    public static By productCountText = By.cssSelector("div.product-count");
}
