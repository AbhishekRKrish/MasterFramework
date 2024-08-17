package com.abhi.factories;

import com.abhi.constants.FrameworkConstants;
import com.abhi.driver.DriverManager;
import com.abhi.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class ExplicitWaitFactory {
    /**
     * Private constructor to avoid external instantiation
     */
    private ExplicitWaitFactory() {}

    /**
     *
     * @param by By locator of the webelement
     * @return webelement Locates and return the webelement
     */
    public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) {
        WebElement element = null;
        if(waitstrategy == WaitStrategy.CLICKABLE) {
            element = 	new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
                    .until(ExpectedConditions.elementToBeClickable(by));
        }
        else if(waitstrategy == WaitStrategy.PRESENCE) {
            element =	new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else if(waitstrategy == WaitStrategy.VISIBLE) {
            element =new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        else if(waitstrategy == WaitStrategy.NONE) {
            element = DriverManager.getDriver().findElement(by);
        }
        return element;
    }

}