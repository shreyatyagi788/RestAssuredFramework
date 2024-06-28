package api.endpoints;
import static io.restassured.RestAssured.*;


import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Created for CRUD operations for STORE module.

public class storeEndpoints {
	
	public static Response createOrder(Store payload) {
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
		.when()
			.post(Routes.post_url_store);
		
		return response;
		
		
	}
	
	public static Response getOrder(int id) {
		Response response = given()
			.pathParams("orderId", id)
		.when()
			.get(Routes.get_url_store);
		return response;
		
	}
	
	public static Response deleteOrder(int id) {
		
		Response response = given()
				.pathParams("orderId", id)
			.when()
				.get(Routes.delete_url_store);
		return response;
		
	}


}
