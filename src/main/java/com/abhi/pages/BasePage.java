package com.abhi.pages;

import com.abhi.driver.DriverManager;
import com.abhi.enums.WaitStrategy;
import com.abhi.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.abhi.enums.LogType.PASS;
import static com.abhi.reports.FrameworkLogger.log;

public class BasePage {

    /**
     * Locates element by given wait strategy, performs the clicking operation on webelement and
     * writes the pass even to the extent report.
     * @param by By Locator of the webelement
     * @param elementname Name of the element that needs to be logged in the report.
     */
    protected void click(By by, WaitStrategy waitstrategy, String elementname) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        element.click();
        log(PASS,elementname+" is clicked");

    }

    /**
     * Locates element by given wait strategy, sends the value to located webelement and
     * writes the pass even to the extent report.
     * @param by By Locator of the webelement
     * @param value value to be send the text box
     * @param elementname Name of the element that needs to be logged in the report.
     */
    protected void sendKeys(By by, String value, WaitStrategy waitstrategy,String elementname) {
        WebElement element =ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
        element.sendKeys(value);
        log(PASS,value +" is entered successfully in "+elementname);
    }

    /**
     * Return page title of webpage in String
     *
     * @return Page title of the webpage where the selenium is currently interacting.
     */
    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }


}