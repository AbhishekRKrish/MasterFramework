package com.abhi.tests;

import com.abhi.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {

    protected BaseTest() {}

    /**
     * Invokes a new browser instance and loads the respective URL.
     * @param data Have all the data feeded to the corresponding test method from data provider.In our case,it is
     * a hashmap containing all the values from the excel sheet.
     */
    @SuppressWarnings("unchecked")
    @BeforeMethod
    protected void setUp(Object[] data) { //Map<String,String>
        Map<String,String> map = (Map<String,String>)data[0];
        Driver.initDriver(map.get("browser"),map.get("version"));
    }

    /**
     * Terminates the browser instance
     */

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }

}