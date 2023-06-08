package api.demo.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.PetEndPoints;
import api.payloads.Pet;
import api.utils.RandomGen;
import io.restassured.response.Response;

public class PetTest {

	Faker faker;
	Pet Payload;
	public Logger logs;

	@BeforeClass
	public void setup() {
		faker = new Faker();
		Payload = new Pet();

		RandomGen msr = new RandomGen();
		Payload.setId(msr.getRandomNumber());
		Payload.setName(faker.animal().name());

		logs = LogManager.getLogger(this.getClass());
		logs.debug("Debugging...");
	}

	@Test
	public void TestPostPet() {
		logs.info("***Creating New Pets***");
		Response res = PetEndPoints.CreatePet(Payload);

		System.out.println("Post Response Body= " + res.asPrettyString());
		System.out.println("ContentType= " + res.getContentType());
		System.out.println("Response Time= " + res.getTime());
		System.out.println("Status Code= " + res.getStatusCode());
		
		// Validation 1
		Assert.assertEquals(res.getStatusCode(), 200);

		// Validation 2
		Assert.assertEquals(res.header("Content-Type"), "application/json");
		logs.info("***New Pets are Created***");
	}

	@Test(priority = 1)
	public void TestGetpet() {
		logs.info("***Fetching Pets Info***");
		Response res = PetEndPoints.GetPet(this.Payload.getId());

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
		 * Assert.assertEquals(petname, "doggie");
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
		Payload.setName(faker.name().name());

		Response resbeforeupdate = PetEndPoints.GetPet(this.Payload.getId());
		System.out.println("\n" + "Before Update Response Body= " + resbeforeupdate.asPrettyString());
		
		// Validation 1
		Assert.assertEquals(resbeforeupdate.getStatusCode(), 200);

		// Validation 2
		Assert.assertEquals(resbeforeupdate.header("Content-Type"), "application/json");
		logs.info("***Pet Info Updated***");

		Response resafterupdate = PetEndPoints.UpdatePet(Payload);
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
		Response res = PetEndPoints.DeletePet(this.Payload.getId());

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

}
