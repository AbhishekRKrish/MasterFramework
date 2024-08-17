package com.abhi.driver;

import java.net.MalformedURLException;
import java.util.Objects;




import com.abhi.enums.ConfigProperties;
import com.abhi.exceptions.BrowserInvocationFailedException;
import com.abhi.factories.DriverFactory;
import com.abhi.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;


public final class Driver {

    /**
     * Private constructor to avoid external instantiation
     */
    private Driver() {}

    /**
     * Gets the browser value and initialise the browser based on that
     *
     *
     */
    public static void initDriver(String browser,String version)  {


        if(Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser,version));

            } catch (MalformedURLException e) {
                throw new BrowserInvocationFailedException("Please check the capabilities of browser");
            }
            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }
    }

    /**
     * Terminates the browser instance.
     * Sets the threadlocal to default value, i.e null.
     */
    public static void quitDriver() {
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}