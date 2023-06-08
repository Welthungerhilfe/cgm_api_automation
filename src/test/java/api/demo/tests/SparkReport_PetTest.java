package api.demo.tests;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.javafaker.Faker;
import api.endpoints.PetEndPoints2;
import api.payloads.Pet;
import api.utils.FakerUtils;
import api.utils.RandomGen;
import io.restassured.response.Response;

public class SparkReport_PetTest {

	Faker faker;
	Pet Payload;
	public Logger logs;
	RandomGen msr = new RandomGen();
	FakerUtils fu = new FakerUtils();
	public ExtentReports extent;
	public ExtentTest test;
	public ExtentSparkReporter spark;

	@BeforeTest
	public void setExtent() {
		// specify location of the report
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/ExtentSparkReport/API Automation ExtentSpark Reports.html");
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
	}


	@BeforeClass
	public void setup() {
		faker = new Faker();
		Payload = new Pet();

		Payload.setId(msr.getRandomNumber());
		Payload.setName(fu.getAnimalName());

		logs = LogManager.getLogger(this.getClass());
		logs.debug("Debugging...");
	}

	@Test
	public void TestPostPet() {

		logs.info("***Creating New Pets***");
		test = extent.createTest("Creating pet user");
		// ExtentTestManager.startTest("Creating pet user", "To verify that pet is able
		// to create in system through API");
		Response res = PetEndPoints2.CreatePet(Payload);

		System.out.println("Post Response Body= " + res.asPrettyString());
		System.out.println("ContentType= " + res.getContentType());
		System.out.println("Response Time= " + res.getTime());
		System.out.println("Status Code= " + res.getStatusCode());

		// Validation 1
		Assert.assertEquals(res.getStatusCode(), 200);
		// Another way of Validation 1
		// Assert.assertEquals(res.getStatusCode(), HttpStatus.OK_CODE_200.getCode());

		// Validation 2
		Assert.assertEquals(res.header("Content-Type"), "application/json");
		logs.info("***New Pets are Created***");
		// ExtentTestManager.getTest().log(Status.INFO, "");
	}

	@Test(priority = 1)
	public void TestGetpet() {

		logs.info("***Fetching Pets Info***");
		test = extent.createTest("Getting pet user");
		Response res = PetEndPoints2.GetPet(this.Payload.getId());

		System.out.println("\n" + "Get Response Body= " + res.asPrettyString());
		System.out.println("ContentType= " + res.getContentType());
		System.out.println("Status Code= " + res.getStatusCode());
		System.out.println("Response Time= " + res.getTime());
		logs.info("***Pets Info Shown***");

		// Validation 1
		Assert.assertEquals(res.getStatusCode(), 200);

		// Validation 2
		Assert.assertEquals(res.header("Content-Type"), "application/json");

		// Validation 3
		/*
		 * String petname = res.jsonPath().get("x.name").toString();
		 * Assert.assertEquals(petname, "dogeii");
		 */

		// Validation 4
		// Search for all petnames in a tags object
		/*
		 * JSONObject jo=new JSONObject(res.asString()); for(int
		 * i=0;i<=jo.getJSONArray("tags").length();i++) { String petname=
		 * jo.getJSONArray("tags").getJSONObject(i).get("name").toString();
		 * System.out.println(petname); }
		 */

		// Validation 5
		// Search for specific petname of Tags object in a json
		/*
		 * JSONObject jo=new JSONObject(res.asString()); boolean status=false; for(int
		 * i=0;i<=jo.getJSONArray("tags").length();i++) { String petname=
		 * jo.getJSONArray("tags").getJSONObject(i).get("name").toString(); {
		 * if(petname.equals("dogeii")) { status=true; break; } }
		 * Assert.assertEquals(status, true); }
		 */
	}

	@Test(priority = 2)
	public void TestPutPet() {

		logs.info("***Updating Pet Info***");
		test = extent.createTest("Updating pet user");
		Payload.setName(fu.getAnimalName());

		Response resbeforeupdate = PetEndPoints2.GetPet(this.Payload.getId());

		System.out.println("\n" + "Before Update Response Body= " + resbeforeupdate.asPrettyString());

		// Validation 1
		Assert.assertEquals(resbeforeupdate.getStatusCode(), 200);

		// Validation 2
		Assert.assertEquals(resbeforeupdate.header("Content-Type"), "application/json");
		logs.info("***Pet Info Updated***");

		Response resafterupdate = PetEndPoints2.UpdatePet(Payload);
		System.out.println("\n" + "After Update Response Body= " + resafterupdate.asPrettyString());
		System.out.println("ContentType= " + resafterupdate.getContentType());
		System.out.println("Status Code= " + resafterupdate.getStatusCode());
		System.out.println("Response Time= " + resafterupdate.getTime());

		// Validation 1
		Assert.assertEquals(resafterupdate.getStatusCode(), 200);
		// Validation 2
		Assert.assertEquals(resafterupdate.header("Content-Type"), "application/json");
		logs.info("***Pet Info Updated***");

	}

	@Test(priority = 3)
	public void TestDeletePet() {

		logs.info("***Deleting Pet Info***");
		test = extent.createTest("Deleting pet user");
		Response res = PetEndPoints2.DeletePet(this.Payload.getId());

		System.out.println("\n" + "Delete Response Body= " + res.asPrettyString());
		System.out.println("ContentType= " + res.getContentType());
		System.out.println("Status Code= " + res.getStatusCode());
		System.out.println("Response Time= " + res.getTime());

		// Validation 1
		Assert.assertEquals(res.getStatusCode(), 200);
		// Validation 2
		Assert.assertEquals(res.header("Content-Type"), "application/json");
		logs.info("***Pet Info Deleted***");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case FAILED & Method is " + result.getName()); // to add name in extent report
			test.log(Status.FAIL, "Test Case FAILED & Exception is " + result.getThrowable()); // to add error/exception in
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED & Method is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED & Method is " + result.getName());
		}
	}
	
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
}
