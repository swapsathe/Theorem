package com.theorem.ui.pages;

import com.theorem.ui.uimaps.CreateAccountPageUIMap;
import com.theorem.ui.uimaps.MyAccountPageUIMap;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Create Account page related actions
 */
public class CreateAccountPage extends BasePage{
    private WebDriver driver;
    public CreateAccountPage(WebDriver driver) {this.driver = driver;}

    /**
     * Enter user details and register user, wait for next screen to appear
     * @param userData JSON data for registering user
     */
    public void registerAccount(JSONObject userData)
    {
        //wait for elements to load
        waitForAllElementsToExist(driver, By.cssSelector("input"));
        waitForElementToShow(driver, CreateAccountPageUIMap.genderRadioBtn1);
        if (userData.getString("Gender").equalsIgnoreCase("male")){
            driver.findElement(CreateAccountPageUIMap.genderRadioBtn1).click();
        } else {
            driver.findElement(CreateAccountPageUIMap.genderRadioBtn2).click();
        }
        driver.findElement(CreateAccountPageUIMap.firstNameInput).sendKeys(userData.getString("FirstName"));
        driver.findElement(CreateAccountPageUIMap.lastNameInput).sendKeys(userData.getString("LastName"));
        driver.findElement(CreateAccountPageUIMap.passwordInput).sendKeys(userData.getString("Password"));
        new Select(driver.findElement(CreateAccountPageUIMap.daysSelect)).selectByValue(userData.getString("DOB_Day"));
        new Select(driver.findElement(CreateAccountPageUIMap.monthsSelect)).selectByValue(userData.getString("DOB_Month"));
        new Select(driver.findElement(CreateAccountPageUIMap.yearsSelect)).selectByValue(userData.getString("DOB_Year"));
        driver.findElement(CreateAccountPageUIMap.companyInput).sendKeys(userData.getString("Company"));
        driver.findElement(CreateAccountPageUIMap.address1Input).sendKeys(userData.getString("Address"));
        driver.findElement(CreateAccountPageUIMap.cityInput).sendKeys(userData.getString("City"));
        new Select(driver.findElement(CreateAccountPageUIMap.stateSelect)).selectByVisibleText(userData.getString("State"));
        driver.findElement(CreateAccountPageUIMap.zipInput).sendKeys(userData.getString("ZipCode"));
        driver.findElement(CreateAccountPageUIMap.mobilePhoneInput).sendKeys(userData.getString("Mobile"));
        driver.findElement(CreateAccountPageUIMap.addressAliasInput).clear(); //existing text needs to be cleared
        driver.findElement(CreateAccountPageUIMap.addressAliasInput).sendKeys(userData.getString("AddressAlias"));
        driver.findElement(CreateAccountPageUIMap.registerBtn).click();
        waitForElementToShow(driver, MyAccountPageUIMap.pageHeader);
    }
}
