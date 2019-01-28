package testexecution;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.Util;

public class customListner extends Base implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Test= extent.createTest(result.getName());
		Test.info(result.getName()+" Started");		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Test.pass(result.getName()+" Success");
		
	}

	@Override
	public void onTestFailure(ITestResult result)  {
		Test.fail(result.getName()+" Fail");
		try {
			Util.captureScreenshot(result.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  Test.fail(result.getName()+" Failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		Test.info("Writing Report");
		extent.flush();
	}

}
