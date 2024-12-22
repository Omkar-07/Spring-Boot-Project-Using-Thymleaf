package Property.Property.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "properties")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String location;
	private double price;
	private String type;
	private String description;
	private String status;

	@Column(length = 1024)
	private String imageUrl;

	public Property() {
		super();
	}

	public Property(int id, String name, String location, double price, String type, String description, String status,
			String imageUrl) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.price = price;
		this.type = type;
		this.description = description;
		this.status = status;
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Property [id=" + id + ", name=" + name + ", location=" + location + ", price=" + price + ", type="
				+ type + ", description=" + description + ", status=" + status + ", imageUrl=" + imageUrl + "]";
	}

}


//@Entity
//@Table(name = "properties")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//public class Property {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private String name;
//    private String location;
//    private double price;
//    private String type;
//    private String description;
//    private String status;
//
//    @Column(length = 1024)
//    private String imageUrl;
//
//    // Manually add a setter for id if needed
//    public void setId(int id) {
//        this.id = id;
//    }
//}





