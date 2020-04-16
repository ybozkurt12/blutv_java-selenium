package common;

import org.apache.log4j.Logger;
import org.testng.*;


public class TestListener implements ITestListener,ISuiteListener {

    private static Logger logger = Logger.getLogger(TestListener.class);

    public TestListener(){

    }

    public void onFinish(ISuite suite) {
        DriverProperties.getChromeDriverInstance().quit();

    }

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {

    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {


    }

    public void onStart(ISuite suite) {

        ReadFileData readFileData = new ReadFileData();
        String url = readFileData.readData("URL");
        DriverProperties.getChromeDriverInstance().get(url);


    }
}
