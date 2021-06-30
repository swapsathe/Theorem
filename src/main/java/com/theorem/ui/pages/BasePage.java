package com.theorem.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Base Page object which contains common actions for all other pages
 */
public class BasePage {

    /**
     * Waits for the element to be visible in page
     * @param driver WebDriver object
     * @param elementLocator the locator to the element
     */
    public void waitForElementToShow(WebDriver driver, By elementLocator){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    /**
     * Waits for all the elements to exist in page
     * @param driver WebDriver object
     * @param elementsLocator the locator to the list of elements
     */
    public void waitForAllElementsToExist(WebDriver driver, By elementsLocator){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(elementsLocator));
    }

    /**
     * Waits for the element to go stale in a page
     * @param driver WebDriver object
     * @param element the element we want to check
     */
    public void waitForElementToBeStale(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.stalenessOf(element));
    }

}