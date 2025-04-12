package com.rk.enity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection  = "orderHistory")
public class OrderHistory {

	@Id
	private String id;
	
	private String orderDate;
	
	//Which user placed order 
	private String orderBy;
	
	private String costumerName;
	
	@Indexed
	private String modeOfPayment;
	
	@Indexed
	private String modeOfOrder;

	@Indexed(unique = true)
	private String orderId; // (Current date +orderNumber which is start from 0 eyeryday)
	
	private Integer total;
	
	@Indexed
	private String costumerId;//(Costumer mobile number)
	
	private List<Items> items;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getCostumerId() {
		return costumerId;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public String getModeOfOrder() {
		return modeOfOrder;
	}

	public void setModeOfOrder(String modeOfOrder) {
		this.modeOfOrder = modeOfOrder;
	}

	public void setCostumerId(String costumerId) {
		this.costumerId = costumerId;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}
	public String getCostumerName() {
		return costumerName;
	}

	public void setCostumerName(String costumerName) {
		this.costumerName = costumerName;
	}
}
