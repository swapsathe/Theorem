package com.theorem.ui.uimaps;

import org.openqa.selenium.By;

/**
 * This is data file to include all locators to elements on Search page.
 */
public class SearchPageUIMap {

    public static By searchTitle = By.cssSelector("#center_column span.lighter");
    public static By searchResultProducts = By.cssSelector("ul.product_list img");
    public static By searchHeadingCounter = By.cssSelector("h1 span.heading-counter");
}
