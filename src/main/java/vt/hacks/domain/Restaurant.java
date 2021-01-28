package vt.hacks.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * A user.
 */
@org.springframework.data.mongodb.core.mapping.Document(collection = "restaurants")
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Restaurant)) {
            return false;
        }
        return id != null && id.equals(((Restaurant) o).id);
    }


    // prettier-ignore
    @Override
    public String toString() {
        return "Restaurant{" +
            "Name='" + name + '\'' +
            ", Cuisine='" + cuisine + '\'' +
            ", specials='" + specials + '\'' +
            ", bar='" + bar + '\'' +
            ", location='" + location + '\'' +
            ", price='" + price + '\'' +
            "}";
    }
}
