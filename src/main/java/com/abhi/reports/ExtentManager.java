package com.abhi.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public class ExtentManager {

    /**
     * Private constructor to avoid external instantiation
     */
    private ExtentManager() {}

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>() ;

    static ExtentTest getExtentTest() {
        return extTest.get();
    }


    static void setExtentTest(ExtentTest test) {
        if(Objects.nonNull(test)) {
            extTest.set(test);
        }
    }


    static void unload() {
        extTest.remove();
    }
}