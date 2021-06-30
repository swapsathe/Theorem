package com.theorem.ui.extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;

/**
 * Helper class to setup extent reports, sets up location of reports, etc
 */
public class ExtentManager {
    private static ExtentReports extent;
    private static String reportFileName = "Test-Automaton-Report"+".html";
    private static String fileSeparator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") +fileSeparator+ "reports";
    private static String reportFileLocation =  reportFilepath +fileSeparator+ reportFileName;

    /**
     * return current report instance, if one does not exist, create one
     */
    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    /**
     * Setup config of extent report and create it
     */
    public static ExtentReports createInstance() {
        String fileName = getReportPath(reportFilepath);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        //Set environment details
        String os = System.getProperty("os.name");
        extent.setSystemInfo("OS", os);
        extent.setSystemInfo("AUT", "Theorem Automation");
        return extent;
    }

    /**
     * Create report path, if directory does not exist, create it
     */
    private static String getReportPath (String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                return reportFileLocation;
            } else {
                return System.getProperty("user.dir");
            }
        }
        return reportFileLocation;
    }

}
