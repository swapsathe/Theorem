package com.theorem.ui.testng;

import com.aventstack.extentreports.Status;
import com.theorem.ui.extent.ExtentManager;
import com.theorem.ui.extent.ExtentTestManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * This listner class enables us manage lifecycle of extent report, and report test pass/fail to it
 */
public class TestNGCustomListener implements ITestListener  {

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "SUCCESS: Test case passed: " +result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().log(Status.FAIL, "FAILURE: Test case failed: " +result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().log(Status.SKIP, "SKIPPED: Test case skipped: " +result.getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }
}