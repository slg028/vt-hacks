package vt.hacks.service.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.index.Indexed;

import vt.hacks.domain.Restaurant;

public class RestaurantDTO {
	

    private String id;
    
	@NotNull
    @Size(min = 1, max = 50)
    @Indexed
    private String name;

    @NotNull
    private String cuisine;

    private Integer bar;

    private String specials;

    private String location;

    private Integer price;
    
    public RestaurantDTO() {
        // Empty constructor needed for Jackson.
    }
    
    public RestaurantDTO(Restaurant restaurant) {
    	this.id = restaurant.getId();
    	this.name = restaurant.getName();
    	this.cuisine = restaurant.getCuisine();
    	this.bar = restaurant.getBar();
    	this.specials = restaurant.getSpecials();
    	this.location = restaurant.getLocation();
    	this.price = restaurant.getPrice();
    }
    
    public String getId() {
    	return id;
    }
    
    public void setId(String id) {
    	this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisine() {
		return cuisine;
	}

	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}

	public Integer getBar() {
		return bar;
	}

	public void setBar(Integer bar) {
		this.bar = bar;
	}

	public String getSpecials() {
		return specials;
	}

	public void setSpecials(String specials) {
		this.specials = specials;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	   @Override
	    public String toString() {
	        return "RestaurantDTO{" +
	            "Name='" + name + '\'' +
	            ", Cuisine='" + cuisine + '\'' +
	            ", specials='" + specials + '\'' +
	            ", bar='" + bar + '\'' +
	            ", location='" + location + '\'' +
	            ", price='" + price + '\'' +
	            "}";
	    }

}
