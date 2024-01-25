package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	User userPayload;
	
	public Logger logger; //for logs

	
	@BeforeClass
	public void setup() {
		
		faker = new Faker();
		userPayload = new User();
			
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		logger = LogManager.getLogger(this.getClass());
	
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("-----------creating user--------------");
		
		Response response=userEndpoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("-----------user is created--------------");

		
	}
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		
		logger.info("-----------getting user info--------------");

		Response response=userEndpoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("-----------user info is displayed--------------");

		
	}
	
	@Test(priority=3)
	public void testUpdatetUserByName()
	{
		
		logger.info("-----------updating user info--------------");

		//update data using payload.
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=userEndpoints.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("-----------user is updated--------------");

		
		//checking data after update.
		Response responseAfterUpdate=userEndpoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		
		
	}
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		
		logger.info("-----------deleting user--------------");

		Response response=userEndpoints.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("-----------user is deleted--------------");

		
	}


}
