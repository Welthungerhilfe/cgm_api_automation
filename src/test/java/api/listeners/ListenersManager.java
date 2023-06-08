package api.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance(String fileName) {
		
		ExtentSparkReporter spark = new ExtentSparkReporter(fileName);
		spark.config().setEncoding("utf-8");
		spark.config().setDocumentTitle("API Automation Report"); // Tile of report
		spark.config().setReportName("API Automation Test Results"); // Name of the report
		spark.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(spark);

		extent.setSystemInfo("Host Name", "https://petstore.swagger.io/");
		extent.setSystemInfo("Environment", "CGM QA-Rest Assured API Automation");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Orgainzation", "CGM");
		extent.setSystemInfo("Automation Tester", "Prasant Jena");
		extent.setSystemInfo("User Name","pjena@childgrowthmonitor.org");

		return extent;
	}

	public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
        reporter.config().setReportName("Sample Extent Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Blog Name", "SW Test Academy");
        extentReports.setSystemInfo("Author", "Onur Baskirt");
        return extentReports;
    }
}