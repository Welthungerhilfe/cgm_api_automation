package api.demo.tests;
//package api.tests;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import api.endpoints.PetEndPoints;
//import api.payloads.Pet;
//import api.utils.DataProviders;
//import io.restassured.response.Response;
//
//public class DDPetTest {
//	
//	@Test(priority=1,dataProvider = "PetID",dataProviderClass = DataProviders.class)
//	public void TestPostPet(Integer[] PetID) 
//	{
//		Pet Payload = new Pet();
//		for(int x=0; x<PetID.length;x++) {
//			System.out.println("pet list ids :: "+PetID[x]);
//			Payload.setId(PetID[x]);
//			 //Payload.setName(PetName);
//		}
//		
//		Response res = PetEndPoints.CreatePet(Payload);
//		System.out.println("Post Response Body= " + res.asPrettyString());
//		System.out.println("ContentType= " + res.getContentType());
//		System.out.println("Status Code= " + res.getStatusCode());
//		System.out.println("Response Time= " + res.getTime());
//		Assert.assertEquals(res.getStatusCode(), 200);
//	}
//	
//	@Test(priority=2,dataProvider = "PetID",dataProviderClass = DataProviders.class)
//	public void TestDeletePet(Integer PetID) 
//	{
//		Response res = PetEndPoints.DeletePet(PetID);
//		System.out.println("\n" + "Delete Response Body= " + res.asPrettyString());
//		System.out.println("ContentType= " + res.getContentType());
//		System.out.println("Status Code= " + res.getStatusCode());
//		System.out.println("Response Time= " + res.getTime());
//		Assert.assertEquals(res.getStatusCode(), 200);
//	}
//
//}
