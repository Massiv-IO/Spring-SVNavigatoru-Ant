package inventorysystem.domain;

import inventorysystem.repository.ProductDao;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4877051545092046341L;
	
	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public void update() {
		this.productDao.update(this);
	}

	
	private int id;
	private String description;
	private Double price;

	public int getId() {
		return this.id;
	}

	public void setId(int i) {
		this.id = i;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Description: " + this.description + ";");
		buffer.append("Price: " + this.price);
		return buffer.toString();
	}
}
