package api.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.storeEndpoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {
	
	Faker faker;
	Store storePayload;
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		faker = new Faker();
		storePayload = new Store();
		
		storePayload.setId(faker.number().numberBetween(1, 10));
		storePayload.setPetId(faker.number().numberBetween(1, 10));
		storePayload.setQuantity(faker.number().numberBetween(1, 10));
		
		String formattedDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        storePayload.setShipDate(formattedDate);
		System.out.println("Current date and time: " + formattedDate);
		
		//logs
		logger=LogManager.getLogger(this.getClass());

		
	}
	
	@Test(priority=1)
	public void testPostOrder() {
		logger.info("************* Creating a order for pet ****************");

		Response response = storeEndpoints.createOrder(storePayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************* Pet order is created ****************");

	}
	
	@Test(priority=2)
	public void testGetOrder() {
		
		logger.info("************* Reading the pet order details ****************");

		Response response = storeEndpoints.getOrder(this.storePayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************* Pet order details are displayed ****************");

	}
	
	@Test(priority=3)
	public void testDeleteOrder() {
		
		logger.info("************* Deleting the order ****************");

		Response response = storeEndpoints.deleteOrder(this.storePayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************* Order is deleted ****************");

		
	}

}
