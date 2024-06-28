package api.endpoints;

/*
 Swagger URI-->https://petstore.swagger.io
 
 Create user(Post):->	https://petstore.swagger.io/v2/user
 Get user(Get):->	https://petstore.swagger.io/v2/user/{username}
 Update user(Put):->	https://petstore.swagger.io/v2/user/{username}
 Delete user(Delete):->	  https://petstore.swagger.io/v2/user/{username}
 
 Add pet(Post):-> https://petstore.swagger.io/v2/pet
 Get pet(Get):-> https://petstore.swagger.io/v2/pet/{petId}
 Update pet(Put):-> https://petstore.swagger.io/v2/pet/{petId}
 Delete pet(Delete):-> https://petstore.swagger.io/v2/pet/{petId}

 Create order for a pet(Post):-> https://petstore.swagger.io/v2/store/order
 Get order(Get):-> https://petstore.swagger.io/v2/store/order/{orderId}
 Delete order(Delete):-> https://petstore.swagger.io/v2/store/order/{orderId}


 */

public class Routes {
	
	public static String base_url = "https://petstore.swagger.io/v2"; // we made the variable static so that we can access that with class name without creating the object.
	
	// USER MODULE
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{username}";
	public static String update_url = base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	//PET MODULE
	
	public static String post_url_pet = base_url+"/pet";
	public static String get_url_pet = base_url+"/pet/{petId}"; 
	public static String put_url_pet = base_url+"/pet"; 
	public static String delete_url_pet = base_url+"/pet/{petId}";
	
	//STORE MODULE
	
	public static String post_url_store = base_url+"/store/order";
	public static String get_url_store = base_url+"/store/order/{orderId}"; 
	public static String delete_url_store = base_url+"/store/order/{orderId}";
	


}
