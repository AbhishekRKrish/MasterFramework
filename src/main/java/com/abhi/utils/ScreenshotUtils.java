package com.abhi.utils;

import com.abhi.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtils {

    /**
     * Private constructor to avoid external instantiation
     */
    private ScreenshotUtils() {}

    /**
     * Captures screenshot of the current page, constructs a base64 string from the image and return to the caller.
     * There is no temporary screenshot image generated here. If user needs separate screenshot image, they can construct
     * a new method. It is advisable to use this method for many reasons.
     *
     */
    public static String getBase64Image() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

}
