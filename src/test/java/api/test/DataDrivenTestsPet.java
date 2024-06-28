package api.test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.petEndpoints;
import api.payload.Category;
import api.payload.Pet;
import api.payload.Tag;
import api.utilities.DataProvidersForPetData;
import io.restassured.response.Response;

public class DataDrivenTestsPet {
	
	@Test(priority=1, dataProvider = "Data", dataProviderClass=DataProvidersForPetData.class)
	public void testPostPet(String petId,String categoryId,String categoryName,String name,String tagId) {
		Pet payload = new Pet();
		Tag tPayload = new Tag();
		Category cPayload = new Category();
		
		payload.setId(Integer.parseInt(petId));
		payload.setName(name);
		tPayload.setId(Integer.parseInt(tagId));
		cPayload.setId(Integer.parseInt(categoryId));
		cPayload.setName(categoryName);
		
		payload.setCategory(cPayload);
		payload.setTags(Arrays.asList(tPayload));
		
		Response response=petEndpoints.createPet(payload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);

		
		
	}
	
	@Test(priority=2,dataProvider = "PetId", dataProviderClass=DataProvidersForPetData.class)
	public void testGetPetById(String petId)
	{
		
		Response response=petEndpoints.getPet(Integer.parseInt(petId));
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	@Test(priority=3,dataProvider = "PetId", dataProviderClass=DataProvidersForPetData.class)
	public void testDeletePetBy(String petId)
	{
		
		Response response=petEndpoints.deletePet(Integer.parseInt(petId));
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
}


