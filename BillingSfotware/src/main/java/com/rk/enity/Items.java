package com.rk.enity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection  = "items")
public class Items {
	
	@Id
	private String id;
	
	@Indexed
	private String name;
		
	@Indexed
	private String isPizza;
	
	private String smallPizzaPrice;
	
	private String mediumPizzaPrice;
	
	private String largePizzaPrice;
	
	private String price;
	

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

	public String getIsPizza() {
		return isPizza;
	}

	public void setIsPizza(String isPizza) {
		this.isPizza = isPizza;
	}

	public String getSmallPizzaPrice() {
		return smallPizzaPrice;
	}

	public void setSmallPizzaPrice(String smallPizzaPrice) {
		this.smallPizzaPrice = smallPizzaPrice;
	}

	public String getMediumPizzaPrice() {
		return mediumPizzaPrice;
	}

	public void setMediumPizzaPrice(String mediumPizzaPrice) {
		this.mediumPizzaPrice = mediumPizzaPrice;
	}

	public String getLargePizzaPrice() {
		return largePizzaPrice;
	}

	public void setLargePizzaPrice(String largePizzaPrice) {
		this.largePizzaPrice = largePizzaPrice;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	




}
