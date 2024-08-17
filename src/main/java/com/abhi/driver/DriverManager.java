package com.abhi.driver;

import com.abhi.config.converters.ConfigFactory;
import com.abhi.driver.manager.ChromeManager;
import com.abhi.driver.manager.FirefoxManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Objects;

public  class DriverManager {

    private DriverManager(){}

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>() ;

    public static WebDriver getDriver() {
        return dr.get();
    }

    static void setDriver(WebDriver driverref) {
        if(Objects.nonNull(driverref)) {
            dr.set(driverref);
        }
    }

    static void unload() {
        dr.remove();
    }

}
