package net.kzn.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
	
	//Private FIleds
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY )
	private int id;
	private String name;
	private String description;
	@Column(name="image_url")
	private String imageurl;
	@Column(name="is_active")
	private boolean active = true;
	
	// add toString Method
	
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description="
				+ description + ", imageurl=" + imageurl + ", active=" + active
				+ "]";
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	

}
