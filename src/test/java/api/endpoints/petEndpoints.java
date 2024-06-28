package api.endpoints;
import static io.restassured.RestAssured.*;

//import api.payload.Category;
import api.payload.Pet;
//import api.payload.Tag;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Created for CRUD  operations for pet module.

public class petEndpoints {
	
	public static Response createPet(Pet payload) {
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url_pet);
		
		return response;
	}
	
	public static Response getPet(int id) {
		Response response=given()
			.pathParam("petId", id)
		.when()
			.get(Routes.get_url_pet);
		
		return response;
	}
	
	public static Response updatePet(Pet payload) {
		Response response=given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)	
		.when()
			.put(Routes.put_url_pet);
		
		return response;
	}
	
	public static Response deletePet(int id) {
		Response response=given()
			.pathParam("petId", id)	
		.when()
			.delete(Routes.delete_url_pet);
		
		return response;
	}

}
