package api.payload;

//import java.time.LocalDateTime;

//import com.github.javafaker.DateAndTime;

//import java.time.LocalDateTime;

public class Store {
	int id;
	int petId;
    int quantity;
    String shipDate;
    //System.out.println("Current date and time: " + currentDateTime);
    String status = "placed";
    boolean complete = true;
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isComplete() {
		return complete;
	}
	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
}
