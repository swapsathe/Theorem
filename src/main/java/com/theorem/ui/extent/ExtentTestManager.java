package com.theorem.ui.extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.util.HashMap;
import java.util.Map;

/**
 * Helper class to which provides the methods needed to manage lifecycle of extent report
 */
public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ExtentManager.getInstance();

    /**
     * Returns the ExtentTest instance of currently executing test
     */
    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    /**
     * Flushes the extent report and writes to file
     */
    public static synchronized void endTest() {
        extent.flush();
    }

    /**
     * Start the extent test instance and put it in hashmap for retrieval
     */
    public static synchronized ExtentTest startTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        return test;
    }
}