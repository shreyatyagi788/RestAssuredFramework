package api.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.storeEndpoints;
import api.payload.Store;
import api.utilities.DataProvidersForStoreData;
import io.restassured.response.Response;

public class DataDrivenTestsStore {
	
	@Test(priority=1, dataProvider = "Data", dataProviderClass=DataProvidersForStoreData.class)
	public void testPostOrder(String orderId, String petId, String quantity) {
		
		Store payload = new Store();
		
		payload.setId(Integer.parseInt(orderId));
		payload.setPetId(Integer.parseInt(petId));
		payload.setQuantity(Integer.parseInt(quantity));
		
		String formattedDate = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        payload.setShipDate(formattedDate);
		
		Response response=storeEndpoints.createOrder(payload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=2,dataProvider = "OrderId", dataProviderClass=DataProvidersForStoreData.class)
	public void testGetOderByOrderId(String orderId)
	{
		
		Response response=storeEndpoints.getOrder(Integer.parseInt(orderId));
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	@Test(priority=3,dataProvider = "OrderId", dataProviderClass=DataProvidersForStoreData.class)
	public void testDeleteOrderByOrderId(String orderId)
	{
		
		Response response=storeEndpoints.deleteOrder(Integer.parseInt(orderId));
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}