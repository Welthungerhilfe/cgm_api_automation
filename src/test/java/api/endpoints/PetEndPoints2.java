package api.endpoints;

import java.util.ResourceBundle;

import api.payloads.Pet;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints2 {

	// Getting URL's from properties file
	static ResourceBundle getAllURL() { 
		// Load properties file
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}

	public static Response CreatePet(Pet jsonString) {
		String PostURL = getAllURL().getString("post_url");

		Response res = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(jsonString)
				.when().post(PostURL);

		return res;
	}
	

	public static Response GetPet(Integer petID) {
		String GetURL = getAllURL().getString("get_url");

		Response res = RestAssured.given().pathParam("petid", petID).when().get(GetURL);

		return res;
	}

	public static Response UpdatePet(Pet jsonString) {
		String PutURL = getAllURL().getString("update_url");

		Response res = RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(jsonString)
				.when().put(PutURL);

		return res;
	}

	public static Response DeletePet(Integer petID) {
		String DeleteURL = getAllURL().getString("delete_url");

		Response res = RestAssured.given().pathParam("petid", petID).when().delete(DeleteURL);

		return res;
	}
}
