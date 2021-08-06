package com.skillstorm.beans;

public class Order {
	private int reference_id;
	private int customer_id;
	private String make;
	private String model;
	private String url;
	private float total_cost;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int reference_id, int customer_id, String make, String model, String url, float total_cost) {
		super();
		this.reference_id = reference_id;
		this.customer_id = customer_id;
		this.make = make;
		this.model = model;
		this.url = url;
		this.total_cost = total_cost;
	}

	public Order(int customer_id, String make, String model, String url, float total_cost) {
		super();
		this.customer_id = customer_id;
		this.make = make;
		this.model = model;
		this.url = url;
		this.total_cost = total_cost;
	}

	public Order(int customer_id, String make, String model, float total_cost) {
		super();
		this.customer_id = customer_id;
		this.make = make;
		this.model = model;
		this.total_cost = total_cost;
	}
	

	public int getReference_id() {
		return reference_id;
	}
	public void setReference_id(int reference_id) {
		this.reference_id = reference_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public float getTotal_cost() {
		return total_cost;
	}
	public void setTotal_cost(float total_cost) {
		this.total_cost = total_cost;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customer_id;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + reference_id;
		result = prime * result + Float.floatToIntBits(total_cost);
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customer_id != other.customer_id)
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (reference_id != other.reference_id)
			return false;
		if (Float.floatToIntBits(total_cost) != Float.floatToIntBits(other.total_cost))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [reference_id=" + reference_id + ", customer_id=" + customer_id + ", make=" + make + ", model="
				+ model + ", url=" + url + ", total_cost=" + total_cost + "]";
	}
	
	
	
	
	
}
