package com.example.comparejson.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product{

	@JsonProperty("discountPercentage")
	private Object discountPercentage;

	@JsonProperty("thumbnail")
	private String thumbnail;

	@JsonProperty("images")
	private List<String> images;

	@JsonProperty("price")
	private int price;

	@JsonProperty("rating")
	private Object rating;

	@JsonProperty("description")
	private String description;

	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("stock")
	private int stock;

	@JsonProperty("category")
	private String category;

	@JsonProperty("brand")
	private String brand;

	public Object getDiscountPercentage(){
		return discountPercentage;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public List<String> getImages(){
		return images;
	}

	public int getPrice(){
		return price;
	}

	public Object getRating(){
		return rating;
	}

	public String getDescription(){
		return description;
	}

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public int getStock(){
		return stock;
	}

	public String getCategory(){
		return category;
	}

	public String getBrand(){
		return brand;
	}

	@Override
 	public String toString(){
		return 
			"Product{" + 
			"discountPercentage = '" + discountPercentage + '\'' + 
			",thumbnail = '" + thumbnail + '\'' + 
			",images = '" + images + '\'' + 
			",price = '" + price + '\'' + 
			",rating = '" + rating + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",stock = '" + stock + '\'' + 
			",category = '" + category + '\'' + 
			",brand = '" + brand + '\'' + 
			"}";
		}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Product)) return false;
		Product product = (Product) o;
		return getPrice() == product.getPrice() && getId() == product.getId() && getStock() == product.getStock() && Objects.equals(getDiscountPercentage(), product.getDiscountPercentage()) && Objects.equals(getThumbnail(), product.getThumbnail()) && Objects.equals(getImages(), product.getImages()) && Objects.equals(getRating(), product.getRating()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getTitle(), product.getTitle()) && Objects.equals(getCategory(), product.getCategory()) && Objects.equals(getBrand(), product.getBrand());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getDiscountPercentage(), getThumbnail(), getImages(), getPrice(), getRating(), getDescription(), getId(), getTitle(), getStock(), getCategory(), getBrand());
	}
}