package api.listeners;

import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class Listeners implements ITestListener {

	/**
	 * This filename generates report with date & time
	 */
	static Date d = new Date();
	static String fileName = "Listener_Report_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	//static String fileName = "Listener_Report_" + ".html";

	private static ExtentReports extent = ListenersManager.createInstance(System.getProperty("user.dir")+"/TestNGListenersReport/"+fileName);
	
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	
	
	public void onTestStart(ITestResult result) {
	
		ExtentTest test = extent.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
        testReport.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		String passlog="<b>"+"TEST CASE PASSED :- "+ methodName.toUpperCase() +"</b>";		
		Markup m=MarkupHelper.createLabel(passlog, ExtentColor.GREEN);
		testReport.get().pass(m);
	}

	public void onTestFailure(ITestResult result) {
	
		String excepionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured: Click to see"
		+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
		
		String methodName = result.getMethod().getMethodName();
		String failLog = "<b>" + "TEST CASE FAILED : - " + methodName.toUpperCase() + "</b>";		
		Markup m = MarkupHelper.createLabel(failLog, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);
	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String skiplog="<b>"+"Test Case Skipped :- "+ methodName +"</b>";		
		Markup m=MarkupHelper.createLabel(skiplog, ExtentColor.YELLOW);
		testReport.get().skip(m);
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {

		if (extent != null) {
			extent.flush();
		}

	}

}
