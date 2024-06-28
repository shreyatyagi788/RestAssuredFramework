package api.payload;
import java.util.Collections;
import java.util.List;


public class Pet {
	 	int id;
	    Category category;
	    String name;
	    //List<String> photoUrls = Collections.<String>emptyList();
	    List<String> photoUrls;	    
	    List<Tag> tags;
	    String status = "available";

	    // Getters and Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public Category getCategory() {
	        return category;
	    }

	    public void setCategory(Category category) {
	        this.category = category;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public List<String> getPhotoUrls() {
	        return photoUrls;
	    }

	    public void setPhotoUrls(List<String> photoUrls) {
	        this.photoUrls = photoUrls;
	    }

	    public List<Tag> getTags() {
	        return tags;
	    }

	    public void setTags(List<Tag> tags) {
	        this.tags = tags;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
}
