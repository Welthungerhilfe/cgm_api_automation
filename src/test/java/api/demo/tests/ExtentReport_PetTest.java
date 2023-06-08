package api.demo.tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import api.endpoints.PetEndPoints2;
import api.payloads.Pet;
import api.utils.FakerUtils;
import api.utils.HttpStatus;
import api.utils.Log;
import api.utils.RandomGen;
import io.restassured.response.Response;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport_PetTest {

	Faker faker;
	Pet Payload;
	RandomGen msr = new RandomGen();
	FakerUtils fu = new FakerUtils();
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void startReport() {

		extent = new ExtentReports(System.getProperty("user.dir") + "/ExtentReports/API Automation Extent Reports.html", true);
		extent.addSystemInfo("Host Name", "https://petstore.swagger.io/");
		extent.addSystemInfo("Environment", "CGM QA-Rest Assured API Automation");
		extent.addSystemInfo("Orgainzation", "CGM");
		extent.addSystemInfo("Automation Tester", "Prasant Jena");
		extent.addSystemInfo("User Name","pjena@childgrowthmonitor.org");
		/*
		 * loading the external xml file (i.e., extent-config.xml) which was placed
		 * under the base directory You could find the xml file below. Create xml file
		 * in your project and copy & past the code mentioned below
		 */
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));

	}


	@BeforeClass
	public void setup() {
		faker = new Faker();
		Payload = new Pet();

		Payload.setId(msr.getRandomNumber());
		Payload.setName(fu.getAnimalName());
	}

	@Test
	public void TestPostPet() {

		Log.info("***Creating New Pets***");
		test = extent.startTest("Creating pet user", "To verify that pet is able to create in system through API");
		Response res = PetEndPoints2.CreatePet(Payload);

		System.out.println("Post Response Body= " + res.asPrettyString());
		System.out.println("ContentType= " + res.getContentType());
		System.out.println("Response Time= " + res.getTime());
		System.out.println("Status Code= " + res.getStatusCode());

		// Validation 1
		Assert.assertEquals(res.getStatusCode(), HttpStatus.OK_CODE_200.getCode());

		// Validation 2
		Assert.assertEquals(res.header("Content-Type"), "application/json");
		Log.info("***New Pets are Created***");
	}

	@Test(priority = 1)
	public void TestGetpet() {

		Log.info("***Fetching Pets Info***");
		test = extent.startTest("Getting pet user", "To verify that pet details is able to fetch from system through API");
		Response res = PetEndPoints2.GetPet(this.Payload.getId());

		System.out.println("\n" + "Get Response Body= " + res.asPrettyString());
		System.out.println("ContentType= " + res.getContentType());
		System.out.println("Status Code= " + res.getStatusCode());
		System.out.println("Response Time= " + res.getTime());
		Log.info("***Pets Info Shown***");

		// Validation 1
		Assert.assertEquals(res.getStatusCode(), HttpStatus.OK_CODE_200.getCode());

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

		Log.info("***Updating Pet Info***");
		test = extent.startTest("Updating pet user", "To verify that pet is able to update in system through API");
		Payload.setName(fu.getAnimalName());

		Response resbeforeupdate = PetEndPoints2.GetPet(this.Payload.getId());

		System.out.println("\n" + "Before Update Response Body= " + resbeforeupdate.asPrettyString());

		// Validation 1
		Assert.assertEquals(resbeforeupdate.getStatusCode(), HttpStatus.OK_CODE_200.getCode());
		// Validation 2
		Assert.assertEquals(resbeforeupdate.header("Content-Type"), "application/json");
		Log.info("***Pet Info Updated***");

		Response resafterupdate = PetEndPoints2.UpdatePet(Payload);
		System.out.println("\n" + "After Update Response Body= " + resafterupdate.asPrettyString());
		System.out.println("ContentType= " + resafterupdate.getContentType());
		System.out.println("Status Code= " + resafterupdate.getStatusCode());
		System.out.println("Response Time= " + resafterupdate.getTime());

		// Validation 1
		Assert.assertEquals(resafterupdate.getStatusCode(), HttpStatus.OK_CODE_200.getCode());
		
		// Validation 2
		Assert.assertEquals(resafterupdate.header("Content-Type"), "application/json");
		Log.info("***Pet Info Updated***");

	}

	@Test(priority = 3)
	public void TestDeletePet() {

		Log.info("***Deleting Pet Info***");
		test = extent.startTest("Deleting pet user", "To verify that pet is able to deleted in system through API");
		Response res = PetEndPoints2.DeletePet(this.Payload.getId());

		System.out.println("\n" + "Delete Response Body= " + res.asPrettyString());
		System.out.println("ContentType= " + res.getContentType());
		System.out.println("Status Code= " + res.getStatusCode());
		System.out.println("Response Time= " + res.getTime());

		// Validation 1
		Assert.assertEquals(res.getStatusCode(), HttpStatus.OK_CODE_200.getCode());
		
		// Validation 2
		Assert.assertEquals(res.header("Content-Type"), "application/json");
		Log.info("***Pet Info Deleted***");
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "Test Case FAILED & Method is " + result.getName()); // to add name in extent report
			test.log(LogStatus.FAIL, "Test Case FAILED & Exception is " + result.getThrowable()); // to add error/exception in
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test Case SKIPPED & Method is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, "Test Case PASSED & Method is " + result.getName());
		}
	}
	
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
}
