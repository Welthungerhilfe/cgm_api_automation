package api.endpoints;

import api.payloads.Pet;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {

	public static Response CreatePet(Pet jsonString)
	{
		Response res= RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(jsonString)
		.when()
		.post(Routes.post_url);
		
		return res;
	}
	
	public static Response GetPet(Integer petID)
	{
		Response res= RestAssured.given()
		.pathParam("petid", petID)
		.when()
		.get(Routes.get_url);
		
		return res;
	}
	
	public static Response UpdatePet(Pet jsonString)
	{
		Response res= RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(jsonString)
		.when()
		.put(Routes.update_url);
		
		return res;
	}
	
	public static Response DeletePet(Integer petID)
	{
		Response res= RestAssured.given()
		.pathParam("petid", petID)
		.when()
		.delete(Routes.delete_url);
		
		return res;
	}
}
