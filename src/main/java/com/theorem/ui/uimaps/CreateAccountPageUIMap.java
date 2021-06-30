package com.theorem.ui.uimaps;

import org.openqa.selenium.By;

/**
 * This is data file to include all locators to elements on Create Account page.
 */
public class CreateAccountPageUIMap {

    public static By pageHeader = By.cssSelector("h1.page-heading");
    public static By genderRadioBtn1 = By.id("id_gender1");
    public static By genderRadioBtn2 = By.id("id_gender2");
    public static By firstNameInput = By.id("customer_firstname");
    public static By lastNameInput = By.id("customer_lastname");
    public static By emailInput = By.id("email");
    public static By passwordInput = By.id("passwd");
    public static By daysSelect = By.id("days");
    public static By monthsSelect = By.id("months");
    public static By yearsSelect = By.id("years");
    public static By companyInput = By.id("company");
    public static By address1Input = By.id("address1");
    public static By cityInput = By.id("city");
    public static By stateSelect = By.id("id_state");
    public static By zipInput = By.id("postcode");
    public static By countrySelect = By.id("id_country");
    public static By mobilePhoneInput = By.id("phone_mobile");
    public static By addressAliasInput = By.id("alias");
    public static By registerBtn = By.id("submitAccount");
}
