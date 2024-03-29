package com.neurio.tests.shared;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Robert on 2016-05-18.
 * Class to navigate through the Login Page
 */
public class LoginPage extends Browser{

    /**
     * Implicitly wait for the login page to appear
     */
    private static void waitForLoginPage(){
        Common.waitForElement(StringRef.LOGIN_SIGN_IN_CSS_SELECTOR);
    }

    /**
     * Load the login page
     */
    public static void loadLoginPage(){
        String mode = Common.getPropertyValue("mode", "staging");
        String HOME_PAGE;
        if (mode.contains("staging")){
            HOME_PAGE = StringRef.STAGING_HOME_PAGE;
        } else {
            HOME_PAGE = StringRef.PRODUCTION_HOME_PAGE;
        }

        //Go to the home page
        driver.get(HOME_PAGE);
        waitForLoginPage();
    }

    /**
     * Enter username and password on the Login Page
     * @param userName - The Username used
     * @param password - The Password used
     */
    public static void enterFields(String userName, String password){
        // Find the text input element by its name
        WebElement emailElement = driver.findElement(By.name(StringRef.EMAIL));
        WebElement passwordElement = driver.findElement(By.name(StringRef.PASSWORD));

        // Enter something
        emailElement.sendKeys(userName);
        passwordElement.sendKeys(password);

        WebElement signInElement = driver.findElement(By.cssSelector(StringRef.SIGN_IN_BUTTON_CSS_SELECTOR));
        // Now submit the form
        signInElement.click();
    }

    /**
     * Sign in successfully with a correct username and password
     * @param userName - The Username used
     * @param password - The Password used
     */
    public static void signIn(String userName, String password){
        enterFields(userName, password);
        HomePage.waitForHomePage();
    }

    /**
     * Clear the username and password fields on the login page
     */
    public static void clearFields(){
        WebElement emailElement = driver.findElement(By.name(StringRef.EMAIL));
        WebElement passwordElement = driver.findElement(By.name(StringRef.PASSWORD));

        emailElement.clear();
        passwordElement.clear();
    }

    /**
     * Click on link
     * @param name - Name of the link
     */
    public static void clickOnLink(String name){
        getElementByLinkText(name).click();
    }
}
