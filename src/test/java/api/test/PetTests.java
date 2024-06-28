package api.test;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.petEndpoints;
import api.payload.Category;
import api.payload.Pet;
import api.payload.Tag;
import io.restassured.response.Response;

public class PetTests {
	
	Faker faker;
	Pet petPayload;
	Category category;
	Tag tag;
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		faker = new Faker();
		petPayload = new Pet();
		category = new Category();
		tag = new Tag();
		
		category.setId(faker.idNumber().hashCode());
		category.setName(faker.animal().name());
		tag.setId(faker.idNumber().hashCode());
		
		petPayload.setId(faker.idNumber().hashCode());
		petPayload.setPhotoUrls(Arrays.asList("String"));
		petPayload.setCategory(category);
		petPayload.setTags(Arrays.asList(tag));
		petPayload.setName(faker.name().firstName());
		
		//logs
		logger=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testPostPet()
	{
		logger.info("************* Creating pet ****************");
		Response response = petEndpoints.createPet(petPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************* Pet is created ****************");

			
	}
	
	@Test(priority=2)
	public void testGetPetById()
	{
		logger.info("************* Reading the pet details ****************");
		Response response = petEndpoints.getPet(this.petPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************* Pet details are displayed ****************");

			
	}
	
	@Test(priority=3)
	public void testUpdatePet()
	{
		
		logger.info("************* Updating the pet details ****************");

		//update data using petPayload.
		petPayload.setName(faker.name().firstName());

		Response response = petEndpoints.updatePet(petPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************* Pet details are updated ****************");

		
		//checking data after update.
		Response responseAfterUpdate = petEndpoints.getPet(this.petPayload.getId());
		responseAfterUpdate.then().log().all();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		

			
	}
	
	@Test(priority=4)
	public void testDeletePetById()
	{
		logger.info("************* Deleting the pet ****************");

		Response response = petEndpoints.deletePet(this.petPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("************* Pet is deleted ****************");

			
	}

}
